package BE.MyRoute.member.controller;

import BE.MyRoute.member.dto.MemberDto;
import BE.MyRoute.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
@Slf4j
public class MemberController {

    private final MemberService memberService;
    @PostMapping("register")
    public ResponseEntity<?> memberRegister(@RequestBody MemberDto.SignUpRequest request) {
        log.info("회원가입 요청 : {}", request.getEmail());
        memberService.memberRegister(request);

        return ResponseEntity.ok().build();
    }

    @PostMapping("login")
    public ResponseEntity<?> memberLogin(@RequestBody MemberDto.LoginRequest request) {
        log.info("로그인 요청 : {}", request.getEmail());

        return ResponseEntity.ok().build();
    }
}