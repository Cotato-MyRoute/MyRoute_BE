package BE.MyRoute.shop.repository;

import BE.MyRoute.shop.entity.SHashtag;
import BE.MyRoute.shop.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SHashtagRepository extends JpaRepository<SHashtag, Long> {
    List<SHashtag> findAllByShop(Shop shop);
}
