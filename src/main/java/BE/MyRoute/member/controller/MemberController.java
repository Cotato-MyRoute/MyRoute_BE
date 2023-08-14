package BE.MyRoute.member.controller;

import BE.MyRoute.config.auth.PrincipalDetails;
import BE.MyRoute.member.dto.MemberDto;
import BE.MyRoute.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/member/register")
    public ResponseEntity<?> memberRegister(@RequestBody MemberDto.SignUpRequest request) {
        log.info("회원가입 요청 : {}", request.getEmail());
        memberService.memberRegister(request);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/test/login")
    public ResponseEntity<?> memberLogin(@RequestParam("email") String email, @RequestParam("password") String password
            , Authentication authentication
            , @AuthenticationPrincipal PrincipalDetails userDetails) {

//        log.info("로그인 요청 : {}", request.getEmail());

        // TODO: authentication, userDetails 확인. 현재 null값이 들어옴.
        PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
        log.info("authentication:" + principalDetails.getMember());

        return ResponseEntity.ok(principalDetails.getMember());
    }

}