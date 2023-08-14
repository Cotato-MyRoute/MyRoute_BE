package BE.MyRoute.config.auth;

import BE.MyRoute.member.entity.Member;
import BE.MyRoute.member.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PrincipalDetailsService implements UserDetailsService {

    @Autowired
    private MemberRepository memberRepository;

    // TODO: 여기서 member를 못 찾고 있음
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Member memberEntity = memberRepository.findByEmail(email);
        log.info("조건문 진입 전: {}", memberEntity.getClass());
        if(email != null){
            log.info("조건문 진입 후: {}", memberEntity);
            log.info(new PrincipalDetails(memberEntity).toString());

            return new PrincipalDetails(memberEntity);
        }

        return null;
    }
}
