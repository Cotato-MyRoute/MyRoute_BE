package BE.MyRoute.shop.service;

import BE.MyRoute.member.entity.Member;
import BE.MyRoute.shop.dto.ShopRequest;
import BE.MyRoute.shop.dto.ShopInfoResponse;
import BE.MyRoute.shop.entity.*;
import BE.MyRoute.shop.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShopService {

    private final ShopRepository shopRepository;
    private final BusinessHourRepository businessHourRepository;
    private final SHashtagRepository sHashtagRepository;
    private final ShopImageRepository shopImageRepository;
    private final ShopLikeRepository shopLikeRepository;

    @Transactional
    public String addNewShop(ShopRequest shopRequest, Authentication authentication) {
        PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
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

    public List<ShopInfoResponse> getNewShops() {
        return null;
    }

    public ShopInfoResponse getShopInfo(Long shopId) {
        return null;
    }

    public List<ShopInfoResponse> getShopByName(String shopName) {
        return null;
    }

    public List<ShopInfoResponse> getAllShops() {
        return null;
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
