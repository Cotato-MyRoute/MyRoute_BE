package BE.MyRoute.member.entity.type;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    ROLE_ADMIN("관리자"),
    ROLE_USER("일반사용자");

    private final String role;

    @JsonValue
    public String getRole() {
        return this.role;
    }
}
