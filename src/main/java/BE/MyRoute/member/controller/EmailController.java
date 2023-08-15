package BE.MyRoute.member.controller;

import BE.MyRoute.member.dto.EmailDto;
import BE.MyRoute.member.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/login")
@Slf4j
public class EmailController {

    private final EmailService emailService;

    @GetMapping("/sendMail")
    public ResponseEntity<?> sendEmailPath(@RequestBody EmailDto.sendEmailRequest request) throws MessagingException,UnsupportedEncodingException {
        log.info("이메일 전송 요청 : {}", request);
        /*이메일 주소를 받아 EmailService의 sendEmail메소드로 연결*/
        emailService.sendEmail(request.getEmail());
        return ResponseEntity.ok("이메일을 확인하세요.");
    }

    @PostMapping("/mailConfirm")
    public ResponseEntity<?> mailConfirm(@RequestBody EmailDto.mailConfirmRequest request) throws MessagingException, UnsupportedEncodingException {

        if(emailService.verifyEmailCode(request.getEmail(),request.getCode())){
            return ResponseEntity.ok("인증 성공");
        }
        return ResponseEntity.notFound().build();
    }
}
