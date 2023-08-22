package BE.MyRoute.shop.dto;

import BE.MyRoute.shop.entity.Shop;
import lombok.Data;

@Data
public class SimpleShopResponse {
    private Long shopId;
    private String shopName;
    private String address;
    private Double lat;
    private Double lon;

    public SimpleShopResponse(Shop shop){
        this.shopId = shop.getShopId();
        this.shopName = shop.getShopName();
        this.address = shop.getAddress();
        this.lat = shop.getLat();
        this.lon = shop.getLon();
    }
}
