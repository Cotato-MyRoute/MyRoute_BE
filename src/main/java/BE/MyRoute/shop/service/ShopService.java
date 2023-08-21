package BE.MyRoute.shop.service;

import BE.MyRoute.member.entity.Member;
import BE.MyRoute.shop.dto.ShopRequest;
import BE.MyRoute.shop.dto.ShopResponse;
import BE.MyRoute.shop.entity.*;
import BE.MyRoute.shop.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShopService {

    private final ShopRepository shopRepository;
    private final BusinessHourRepository businessHourRepository;
    private final SHashtagRepository sHashtagRepository;
    private final ShopImageRepository shopImageRepository;
    private final ShopLikeRepository shopLikeRepository;

    public String addNewShop(ShopRequest shopRequest, Authentication authentication) {
        PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
        Member savedMember = principalDetails.getMember();

        Shop savedShop = shopRepository.save(shopRequest.newShopEntity());

        List<BusinessHour> businessHours = shopRequest.newBHourEntities(savedShop);
        businessHours.forEach(businessHour -> businessHourRepository.save(businessHour));

        List<SHashtag> sHashtags = shopRequest.newSHashtagEntities(savedShop);
        sHashtags.forEach(sHashtag->sHashtagRepository.save(sHashtag));

        List<ShopImage> shopImages = shopRequest.newShopImageEntity(savedMember, savedShop);
        shopImages.forEach(shopImage -> shopImageRepository.save(shopImage));

        return "상점 등록 완료 shopId =" + savedShop.getShopId();
    }

    public String likeShop(Long shopId, Authentication auth){
        PrincipalDetails principalDetails = (PrincipalDetails) auth.getPrincipal();
        Member targetMember = principalDetails.getMember();

        Shop targetShop = shopRepository.findById(shopId).get();
        ShopLike shopLike = ShopLike.builder()
                .member(targetMember)
                .shop(targetShop)
                .build();
        shopLikeRepository.save(shopLike);
        return "상점 좋아요 완료 sLikeId =" + shopLike.getSLikeId();
    }

    public List<ShopResponse> getNewShops() {
        return
    }

    public ShopResponse getShopInfo(Long shopId) {
        return null;
    }

    public List<ShopResponse> getShopByName(String shopName) {
        return null;
    }

    public List<ShopResponse> getAllShops() {
        return null;
    }

    public String deleteShop(Long shopId) {
        return null;
    }
}
