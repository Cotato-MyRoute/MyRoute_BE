package BE.MyRoute.shop.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    private Date saveDate;

    @Enumerated(EnumType.STRING)
    private ShopType shopType;
    private String shopUrl;
    private Long likeNum;

    @Column(nullable = false)
    private String descr; // 상점 설명

    @OneToMany(mappedBy = "shop", cascade = CascadeType.REMOVE)
    private List<BusinessHour> businessHours = new ArrayList<>();

    @OneToMany(mappedBy = "shop", cascade = CascadeType.REMOVE)
    private List<SHashtag> sHashtags = new ArrayList<>();

    @OneToMany(mappedBy = "shop", cascade = CascadeType.REMOVE)
    private List<ShopImage> shopImages = new ArrayList<>();

    @OneToMany(mappedBy = "shop", cascade = CascadeType.REMOVE)
    private List<ShopLike> shopLikes = new ArrayList<>();

    public void like() {
        this.likeNum++;
    }

    public void dislike(){
        this.likeNum--;
    }
}
