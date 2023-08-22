package BE.MyRoute.shop.repository;

import BE.MyRoute.member.entity.Member;
import BE.MyRoute.shop.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShopRepository extends JpaRepository<Shop, Long> {
    @Query("SELECT s FROM Shop s ORDER BY s.saveDate ASC")
    List<Shop> findTop10BySaveDateAsc();

    List<Shop> findByShopNameContaining(String searchShopName);
}
