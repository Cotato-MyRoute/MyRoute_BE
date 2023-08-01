package BE.MyRoute.shop.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShopInfo {

    @Id
    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "shopId")
    private Shop shop;

    @Column(nullable = false)
    private String address;

    private String shopUrl;

    @Column(nullable = false)
    private String descr; // 상점 설명
}
