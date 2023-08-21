package BE.MyRoute.shop.dto;

import BE.MyRoute.shop.entity.BusinessHour;
import BE.MyRoute.shop.entity.Day;
import BE.MyRoute.shop.entity.Shop;
import BE.MyRoute.shop.entity.ShopType;
import lombok.Data;

import java.util.List;

@Data
public class ShopInfoResponse {

    private Long shopId;
    private String shopName;
    private String address;
    private String seller;
    private Double lat;
    private Double lon;
    private ShopType shopType;

    private String shopUrl;
    private String descr; // 상점 설명
    private Long likeNum;

    private List<String> hashtags;

    private String open;
    private String close;

    private List<Day> days;
    private List<String> images;

    public ShopInfoResponse(Shop shop, BusinessHour businessHour, List<String> hashtags, List<Day> days, List<String> images) {
        this.shopId = shop.getShopId();
        this.shopName = shop.getShopName();
        this.address = shop.getAddress();
        this.seller = shop.getSeller();
        this.lat = shop.getLat();
        this.lon = shop.getLon();
        this.shopType = shop.getShopType();
        this.shopUrl = shop.getShopUrl();
        this.descr = shop.getDescr();
        this.likeNum = shop.getLikeNum();

        this.open = businessHour.getOpen();
        this.close = businessHour.getClose();
        this.days = days;

        this.hashtags = hashtags;

        this.images = images;
    }
}
