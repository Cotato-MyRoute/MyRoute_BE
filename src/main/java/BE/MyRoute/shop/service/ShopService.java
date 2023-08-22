package BE.MyRoute.shop.service;

import BE.MyRoute.config.auth.PrincipalDetails;
import BE.MyRoute.member.entity.Member;
import BE.MyRoute.shop.dto.ShopRequest;
import BE.MyRoute.shop.dto.ShopInfoResponse;
import BE.MyRoute.shop.dto.ShopResponse;
import BE.MyRoute.shop.dto.SimpleShopResponse;
import BE.MyRoute.shop.entity.*;
import BE.MyRoute.shop.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShopService {

    private final ShopRepository shopRepository;
    private final BusinessHourRepository businessHourRepository;
    private final SHashtagRepository sHashtagRepository;
    private final ShopImageRepository shopImageRepository;
    private final ShopLikeRepository shopLikeRepository;

    @Transactional
    public String addNewShop(ShopRequest shopRequest, Authentication auth) {
        PrincipalDetails principalDetails = (PrincipalDetails) auth.getPrincipal();
        Member savedMember = principalDetails.getMember();

        Shop savedShop = shopRepository.save(shopRequest.newShopEntity());
        businessHourRepository.saveAll(shopRequest.newBHourEntities(savedShop));
        sHashtagRepository.saveAll(shopRequest.newSHashtagEntities(savedShop));
        shopImageRepository.saveAll(shopRequest.newShopImageEntity(savedMember, savedShop));

        return "상점 등록 완료: shopId =" + savedShop.getShopId();
    }

    @Transactional
    public String likeShop(Long shopId, Authentication auth){
        PrincipalDetails principalDetails = (PrincipalDetails) auth.getPrincipal();
        Member targetMember = principalDetails.getMember();

        Shop targetShop = shopRepository.findById(shopId).get();
        ShopLike shopLike = ShopLike.builder()
                .member(targetMember)
                .shop(targetShop)
                .build();
        shopLikeRepository.save(shopLike);

        targetShop.like();

        return "상점 좋아요 완료: sLikeId =" + shopLike.getSLikeId();
    }

    public List<ShopResponse> getNewShops(Authentication auth) {
        List<ShopResponse> result = new ArrayList<>();

        PrincipalDetails principalDetails = (PrincipalDetails) auth.getPrincipal();
        Member member = principalDetails.getMember();

        List<Shop> shops = shopRepository.findTop10BySaveDateAsc();

        shops.forEach(shop -> {
            boolean isLiked = shopLikeRepository.existsByMemberAndShop(member, shop);
            result.add(new ShopResponse(shop, isLiked));
        });
        return result;
    }

    public ShopInfoResponse getShopInfo(Long shopId) {
        Shop shop = shopRepository.findById(shopId).get();

        List<String> hashtags = new ArrayList<>();
        List<SHashtag> sHashtags = sHashtagRepository.findAllByShop(shop);
        sHashtags.forEach(h -> hashtags.add(h.getHashtag()));


        List<String> days = new ArrayList<>();
        List<BusinessHour> businessHours = businessHourRepository.findAllByShop(shop);
        businessHours.forEach(b -> days.add(b.getOpenDay().getDay()));

        List<String> images = new ArrayList<>();
        List<ShopImage> shopImages = shopImageRepository.findAllByShop(shop);
        shopImages.forEach(i -> images.add(i.getImageUrl()));

        return new ShopInfoResponse(shop, businessHours.get(0), hashtags, days, images);
    }

    public List<ShopResponse> getShopByName(String shopName, Authentication auth) {
        List<ShopResponse> result = new ArrayList<>();

        PrincipalDetails principalDetails = (PrincipalDetails) auth.getPrincipal();
        Member member = principalDetails.getMember();

        List<Shop> shops = shopRepository.findByShopNameContaining(shopName);
        shops.forEach(shop -> {
            boolean isLiked = shopLikeRepository.existsByMemberAndShop(member, shop);
            result.add(new ShopResponse(shop, isLiked));
        });

        return result;
    }

    public List<SimpleShopResponse> getAllShops() {
        List<Shop> shops = shopRepository.findAll();
        return shops.stream().map(SimpleShopResponse::new).collect(Collectors.toList());
    }

    @Transactional
    public String deleteShop(Long shopId) {
        shopRepository.deleteById(shopId);
        return "상점 삭제 완료: shopId =" + shopId;
    }

    @Transactional
    public String dislikeShop(Long shopId, Authentication auth) {
        PrincipalDetails principalDetails = (PrincipalDetails) auth.getPrincipal();
        Member targetMember = principalDetails.getMember();

        Shop targetShop = shopRepository.findById(shopId).get();

        shopLikeRepository.deleteByMemberAndShop(targetMember, targetShop);

        targetShop.dislike();

        return "상점 좋아요 취소 완료: shopId =" + shopId;
    }
}
