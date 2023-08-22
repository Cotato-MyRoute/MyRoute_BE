package BE.MyRoute.shop.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ShopType {
    ANTIQUE("골동품"),
    HOUSEWARES("생활용품"),
    ARTS_AND_CRAFTS("미술공예"),
    STATIONERY("문구"),
    SOUVENIR_SHOP("기념품샵"),
    TOYS("장난감/완구"),
    DECOR("소품샵"),
    ACCESSORIES_WORKSHOP("액세서리공방"),
    BAKERY("베이킹"),
    PERFUME("향수"),
    ZERO_WASTE("제로웨이스트"),
    INTERIOR("인테리어"),
    POTTERY("도자기"),
    RING("반지"),
    SHOWROOM("쇼룸"),
    VINTAGE("빈티지"),
    BOUTIQUE("편집샵"),
    ACCESSORIES("액세서리");

    private final String description;
    public static ShopType toEnum(String description) {
        for (ShopType shopType : values()) {
            if (shopType.getDescription().equals(description)) {
                return shopType;
            }
        }
        throw new IllegalArgumentException("Invalid description: " + description);
    }
}
