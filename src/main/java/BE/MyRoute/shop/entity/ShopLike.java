package BE.MyRoute.shop.entity;

import BE.MyRoute.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShopLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sLikeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_memberId", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_shopId", nullable = false)
    private Shop shop;
}
