package BE.MyRoute.shop.repository;

import BE.MyRoute.shop.entity.Shop;
import BE.MyRoute.shop.entity.ShopImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShopImageRepository extends JpaRepository<ShopImage, Long> {
    List<ShopImage> findAllByShop(Shop shop);
}
