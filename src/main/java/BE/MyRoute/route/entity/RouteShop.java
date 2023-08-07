package BE.MyRoute.route.entity;

import BE.MyRoute.shop.entity.Shop;
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
    @JoinColumn(name = "route_id", nullable = false)
    private Route route;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id", nullable = false)
    private Shop shop;

    @Builder
    public RouteShop(Route route, Shop shop) {
        this.route = route;
        this.shop = shop;
    }
}
