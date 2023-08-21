package BE.MyRoute.shop.dto;

import BE.MyRoute.shop.entity.Shop;
import lombok.Data;

@Data
public class ShopResponse {
    private Long shopId;
    private String shopName;
    private String address;
    private Double lat;
    private Double lon;
    private Long likeNum;
    private boolean isLiked;

    public ShopResponse(Shop shop, Boolean isLiked){
        this.shopId = shop.getShopId();
        this.shopName = shop.getShopName();
        this.address = shop.getAddress();
        this.lat = shop.getLat();
        this.lon = shop.getLon();
        this.likeNum = shop.getLikeNum();
        this.isLiked = isLiked;
    }
}
