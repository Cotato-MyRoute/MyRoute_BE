package BE.MyRoute.member.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {

    // security login 과정에서 왜인지 모르겠으나, '/'로 GET요청이 한번 감.
    @GetMapping("/")
    public ResponseEntity<?> loginResponse(){
        return ResponseEntity.ok("로그인 성공");
    }
}
