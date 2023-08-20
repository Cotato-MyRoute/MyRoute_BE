package BE.MyRoute.shop.dto;

import BE.MyRoute.shop.entity.Day;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ShopAddRequest {
    private String shopName;
    private Double lat;
    private Double lon;
    private String shopType;
    private Long likeNum;

    private String address;
    private String shopUrl;
    private String descr; // 상점 설명

    private List<Day> days;
    private List<String> hashtags;
    private List<String> images;
}
