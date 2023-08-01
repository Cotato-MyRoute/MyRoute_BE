package BE.MyRoute.shop.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShopInfo implements Serializable {

    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_shopId")
    private Shop shop;

    @Column(nullable = false)
    private String address;

    private String shopUrl;

    @Column(nullable = false)
    private String descr; // 상점 설명
}
