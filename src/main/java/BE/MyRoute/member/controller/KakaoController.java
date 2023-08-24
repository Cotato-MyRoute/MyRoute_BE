package BE.MyRoute.member.controller;

import BE.MyRoute.member.service.KakaoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequiredArgsConstructor
@Slf4j
public class KakaoController {


    private final KakaoService kakaoService;

    @ResponseBody
    @GetMapping("/login/oauth2/kakao")
    public void login(@RequestParam String code) {
        String access_Token = kakaoService.getAccessToken(code);
        kakaoService.getUserInfo(access_Token);
    }


    @RequestMapping(value="/logout")
    public String logout(HttpSession session) {
        kakaoService.kakaoLogout((String)session.getAttribute("access_Token"));
        session.removeAttribute("access_Token");
        session.removeAttribute("userId");
        return "index";
    }



}
