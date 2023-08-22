package BE.MyRoute.route.entity;

import BE.MyRoute.member.entity.Member;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "route_image")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RouteImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long rImageId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "route_id", nullable = false)
    private Route route;

    @Column
    private String imageUrl;

    @Builder
    public RouteImage(Member member, Route route, String imageUrl) {
        this.member = member;
        this.route = route;
        this.imageUrl = imageUrl;
    }
}
