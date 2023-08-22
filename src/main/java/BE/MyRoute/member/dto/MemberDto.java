package BE.MyRoute.member.dto;

import BE.MyRoute.member.entity.type.Role;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class MemberDto {

    @Getter
    @AllArgsConstructor
    public static class LoginRequest {

        private String email;
        private String password;
    }

    @Getter
    @AllArgsConstructor
    public static class SignUpRequest {

        private String nickname;
        private String profileImage;
        private String email;
        private String password;
        private String role; // String으로 받고 Role로 변환할 예정
    }
}
