package BE.MyRoute.route.entity;

import BE.MyRoute.member.entity.Member;
import BE.MyRoute.shop.entity.Shop;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "route")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long routeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_memberId", nullable = false)
    private Member member;

    @Column
    private String routeName;

    @Column
    private Long likeNum;

    @Builder
    public Route(Member member, String routeName) {
        this.member = member;
        this.routeName = routeName;
    }
}
