package BE.MyRoute.shop.repository;

import BE.MyRoute.shop.entity.ShopInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopInfoRepository extends JpaRepository<ShopInfo, Long> {
}
