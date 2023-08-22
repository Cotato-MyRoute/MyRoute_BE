package BE.MyRoute.member.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class EmailDto {

    @Data
    public static class sendEmailRequest{
        @NotEmpty(message = "이메일을 입력해주세요.")
        private String email;
    }

    @Data
    public static class mailConfirmRequest{
        @NotEmpty(message = "이메일을 입력해주세요.")
        private String email;
        @NotEmpty(message = "인증번호를 입력해주세요.")
        private String code;
    }
}
