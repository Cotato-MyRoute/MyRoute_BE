package BE.MyRoute.member.entity;

import BE.MyRoute.member.entity.type.Role;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "member")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long memberId;

    @Column
    private Long snsId;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String nickname;

    @Column
    @Enumerated(EnumType.STRING)
    private Role role;

    @Builder
    public Member(Long snsId, String email, String password, String nickname, Role role) {
        this.snsId = snsId;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.role = role;
    }

    public Member update(String nickname) {
        this.nickname = nickname;
        return this;
    }


}
