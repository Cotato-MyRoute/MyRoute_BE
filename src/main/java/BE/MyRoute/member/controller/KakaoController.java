package BE.MyRoute.member.controller;

import BE.MyRoute.member.service.KakaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/login/oauth2")
public class KakaoController {

    private final KakaoService kakaoService;

    @GetMapping("/kakao/callback")
    public void kakaoCallback(@RequestParam String code) {
        kakaoService.createKakaoUser(code);
    }

}
