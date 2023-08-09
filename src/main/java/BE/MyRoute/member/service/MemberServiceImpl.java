package BE.MyRoute.member.service;

import BE.MyRoute.member.dto.MemberDto;
import BE.MyRoute.member.entity.Member;
import BE.MyRoute.member.entity.type.Role;
import BE.MyRoute.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bcryptPasswordEncoder;

    // 일반 사용자 회원가입
    @Override
    public void memberRegister(MemberDto.SignUpRequest request) {

        String nickname = request.getNickname();
        String email = request.getEmail();
        Optional<String> profileImage = Optional.ofNullable(request.getProfileImage());
        Optional<String> role = Optional.ofNullable(request.getRole());

        String password = request.getPassword();
        String encPassword = bcryptPasswordEncoder.encode(password); // 비밀번호 암호화

        // TODO: 이메일 인증

        memberRepository.save(Member.builder()
                .email(email)
                .nickname(nickname)
                .password(encPassword)
                .profileImage(profileImage == null ? "기본이미지URL" : profileImage.get())
                .role(role.isEmpty() ? Role.ROLE_USER: Role.valueOf(role.get())) // 기본값 ROLE_USER(일반사용자). (ADMIN등록 시, ROLE_ADMIN으로 등록)
                .build());
    }
}
