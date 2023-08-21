package BE.MyRoute.shop.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shopId;

    @Column(nullable = false)
    private String shopName;

    @Column(nullable = false)
    private String seller;

    @Column(nullable = false)
    private String address;
    private Double lat;
    private Double lon;
    private Date current;

    @Enumerated
    private ShopType shopType;
    private String shopUrl;
    private Long likeNum;

    @Column(nullable = false)
    private String descr; // 상점 설명

    public void like() {
        this.likeNum++;
    }

    public void dislike(){
        this.likeNum--;
    }
}
