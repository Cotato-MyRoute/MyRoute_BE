package BE.MyRoute.shop.repository;

import BE.MyRoute.member.entity.Member;
import BE.MyRoute.shop.entity.Shop;
import BE.MyRoute.shop.entity.ShopLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopLikeRepository extends JpaRepository<ShopLike, Long> {
    void deleteByMemberAndShop(Member targetMember, Shop targetShop);
    boolean existsByMemberAndShop(Member member, Shop shop);
}
