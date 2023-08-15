package BE.MyRoute.member.controller;

import BE.MyRoute.member.dto.EmailAuthRequestDto;
import BE.MyRoute.member.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/login")
public class EmailController {

    private final EmailService emailService;

    @PostMapping("/mailConfirm")
    public String mailConfirm(@RequestBody EmailAuthRequestDto emailDto) throws MessagingException, UnsupportedEncodingException {

        String authCode = emailService.sendEmail(emailDto.getEmail());
        return authCode;
    }
}
