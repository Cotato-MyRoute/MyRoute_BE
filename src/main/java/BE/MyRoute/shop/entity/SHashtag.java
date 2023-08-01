package BE.MyRoute.shop.entity;

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
public class SHashtag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sHashtagId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_shopId", nullable = false)
    private Shop shop;
    private String hashtag;
}
