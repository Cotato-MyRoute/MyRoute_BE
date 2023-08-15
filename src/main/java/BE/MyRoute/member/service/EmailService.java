package BE.MyRoute.member.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

public interface EmailService {

    // 인증 코드 랜덤 생성
    public void createCode();

    // 전송할 email 정보 세팅
    public MimeMessage createEmailForm(String email) throws MessagingException, UnsupportedEncodingException;

    // 실제 메일을 전송하는 기능
    public String sendEmail(String toEmail) throws MessagingException, UnsupportedEncodingException ;

    // 인증코드 검증
    public boolean verifyEmailCode(String email,String code);

    //

}
