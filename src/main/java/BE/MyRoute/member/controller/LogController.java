package BE.MyRoute.member.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {

    @GetMapping("/")
    public ResponseEntity<?> loginResponse(){
        return ResponseEntity.ok("로그인 성공");
    }
}
