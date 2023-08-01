package BE.MyRoute.route.entity;

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
    @JoinColumn(name = "member_memberId", nullable = false)
    @Column
    private Long memberId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "route_routeId", nullable = false)
    @Column
    private Long routeId;

    @Column
    private String imageUrl;

    @Builder
    public RouteImage(Long memberId, Long routeId, String imageUrl) {
        this.memberId = memberId;
        this.routeId = routeId;
        this.imageUrl = imageUrl;
    }
}
