package BE.MyRoute.member.service;

import BE.MyRoute.member.entity.Member;
import BE.MyRoute.member.entity.type.Role;
import BE.MyRoute.member.repository.MemberRepository;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Service
@Slf4j
public class GoogleService {

    private final Environment env;
    private final RestTemplate restTemplate = new RestTemplate();
    private final MemberRepository memberRepository;

    @Autowired
    public GoogleService(Environment env, MemberRepository memberRepository) {
        this.env = env;
        this.memberRepository = memberRepository;
    }

    @Transactional
    public void GoogleCallback(String code, String registrationId) {
        String accessToken = getAccessToken(code, registrationId);
        JsonNode userResourceNode = getUserResource(accessToken, registrationId);
        log.info("userResourceNode = " + userResourceNode);

        String id = userResourceNode.get("id").asText();
        String email = userResourceNode.get("email").asText();
        String nickname = userResourceNode.get("name").asText();
        log.info("id = " + id, "email = " + email, "nickname = "  + nickname);

        Member member = Member.builder()
                .snsId(Long.valueOf(id))
                .email(email)
                .role(Role.USER)
                .build();
        memberRepository.save(member);

//        // 사용자 정보를 세션에 저장
//        UserDetails userDetails = new User(email, "", new ArrayList<>());
//        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private String getAccessToken(String authorizationCode, String registrationId) {
        String clientId = env.getProperty("oauth2." + registrationId + ".client-id");
        String clientSecret = env.getProperty("oauth2." + registrationId + ".client-secret");
        String redirectUri = env.getProperty("oauth2." + registrationId + ".redirect-uri");
        String tokenUri = env.getProperty("oauth2." + registrationId + ".token-uri");

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("code", authorizationCode);
        params.add("client_id", clientId);
        params.add("client_secret", clientSecret);
        params.add("redirect_uri", redirectUri);
        params.add("grant_type", "authorization_code");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity entity = new HttpEntity(params, headers);

        ResponseEntity<JsonNode> responseNode = restTemplate.exchange(tokenUri, HttpMethod.POST, entity, JsonNode.class);
        JsonNode accessTokenNode = responseNode.getBody();
        return accessTokenNode.get("access_token").asText();
    }

    private JsonNode getUserResource(String accessToken, String registrationId) {
        String resourceUri = env.getProperty("oauth2."+registrationId+".resource-uri");

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);
        HttpEntity entity = new HttpEntity(headers);
        return restTemplate.exchange(resourceUri, HttpMethod.GET, entity, JsonNode.class).getBody();
    }
}
