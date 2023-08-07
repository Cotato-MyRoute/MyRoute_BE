package BE.MyRoute.route.entity;

import BE.MyRoute.member.entity.Member;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "route_like")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RouteLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long sLikeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "route_id", nullable = false)
    private Route route;

    @Builder
    public RouteLike(Member member, Route route) {
        this.member = member;
        this.route = route;
    }
}
