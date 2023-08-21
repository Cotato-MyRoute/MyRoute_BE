package BE.MyRoute.shop.dto;

import BE.MyRoute.shop.entity.Day;
import BE.MyRoute.shop.entity.ShopType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public class ShopResponse {

    private Long shopId;
    private String shopName;
    private String address;
    private String seller;
    private Double lat;
    private Double lon;
    private ShopType shopType;

    private String open;
    private String close;

    private String shopUrl;
    private String descr; // 상점 설명
    private Long likeNum;
    private List<String> hashtags;

    private List<Day> days;
    private List<String> images;
}
