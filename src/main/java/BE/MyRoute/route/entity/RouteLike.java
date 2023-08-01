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
    @JoinColumn(name = "member_memberId", nullable = false)
    @Column
    private Member memberId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "route_routeId", nullable = false)
    @Column
    private Route routeId;

    @Builder
    public RouteLike(Member memberId, Route routeId) {
        this.memberId = memberId;
        this.routeId = routeId;
    }
}
