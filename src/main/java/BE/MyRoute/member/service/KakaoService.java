package BE.MyRoute.member.service;

import BE.MyRoute.member.entity.Member;
import BE.MyRoute.member.entity.type.Role;
import BE.MyRoute.member.repository.MemberRepository;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
@Slf4j
public class KakaoService {

    private final MemberRepository memberRepository;

    @Transactional
    public void createKakaoUser(String authorize_code) {

        String reqURL = "https://kauth.kakao.com/oauth/token";

        try {
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization", "Bearer " + authorize_code);

            int responseCode = conn.getResponseCode();
            log.info("responseCode : " + responseCode);

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            StringBuilder result = new StringBuilder();

            while ((line = br.readLine()) != null) {
                result.append(line);
            }
            log.info("response body : " + result);

            JsonElement element = JsonParser.parseString(result.toString());
            JsonObject properties = element.getAsJsonObject().get("properties").getAsJsonObject();

            Long id = element.getAsJsonObject().get("id").getAsLong();
            boolean hasEmail = element.getAsJsonObject().get("kakao_account").getAsJsonObject().get("has_email").getAsBoolean();
            String email = "";
            if (hasEmail) {
                email = element.getAsJsonObject().get("kakao_account").getAsJsonObject().get("email").getAsString();
            }

            log.info("id : " + id);
            log.info("email : " + email);

            Member member = Member.builder()
                    .snsId(id)
                    .email(email)
                    .role(Role.USER)
                    .build();

            memberRepository.save(member);

//            // 사용자 정보를 세션에 저장
//            UserDetails userDetails = new User(email, "", new ArrayList<>());
//            Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//            SecurityContextHolder.getContext().setAuthentication(authentication);


            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
