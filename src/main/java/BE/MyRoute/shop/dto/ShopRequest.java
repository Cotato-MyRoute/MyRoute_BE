package BE.MyRoute.shop.dto;

import BE.MyRoute.member.entity.Member;
import BE.MyRoute.shop.entity.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class ShopRequest {
    private String shopName;
    private String seller;
    private Double lat;
    private Double lon;
    private String shopType;

    private String open;
    private String close;

    private String address;
    private String shopUrl;
    private String descr; // 상점 설명

    private Long likeNum;

    private List<String> days;
    private List<String> hashtags;
    private List<String> images;

    public Shop newShopEntity() {
        return Shop.builder()
                .shopName(shopName)
                .seller(seller)
                .address(address)
                .lat(lat)
                .lon(lon)
                .shopType(ShopType.toEnum(shopType))
                .shopUrl(shopUrl)
                .likeNum(0L)
                .descr(descr)
                .saveDate(new Date())
                .build();
    }

    public List<BusinessHour> newBHourEntities(Shop shop) {
        List<BusinessHour> returnDays = new ArrayList<>();
        days.forEach(d->returnDays.add(BusinessHour.builder()
                .shop(shop)
                .open(open)
                .close(close)
                .openDay(Day.toEnum(d))
                .build()));
        return returnDays;
    }

    public List<SHashtag> newSHashtagEntities(Shop shop) {
        List<SHashtag> returnSHashtags = new ArrayList<>();
        hashtags.forEach(h->returnSHashtags.add(SHashtag.builder()
                .shop(shop)
                .hashtag(h)
                .build()));
        return returnSHashtags;
    }

    public List<ShopImage> newShopImageEntity(Member member, Shop shop) {
        List<ShopImage> shopImages = new ArrayList<>();
        images.forEach(i -> ShopImage.builder()
                .member(member)
                .shop(shop)
                .imageUrl(i)
                .build());
        return shopImages;
    }
}