package BE.MyRoute.route.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "route_shop")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RouteShop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long rShopId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "route_routeId", nullable = false)
    @Column
    private Long routeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_shopId", nullable = false)
    @Column
    private Long shopId;

    @Builder
    public RouteShop(Long routeId, Long shopId) {
        this.routeId = routeId;
        this.shopId = shopId;
    }
}
