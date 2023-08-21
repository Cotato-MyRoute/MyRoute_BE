package BE.MyRoute.shop.repository;

import BE.MyRoute.shop.entity.BusinessHour;
import BE.MyRoute.shop.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BusinessHourRepository extends JpaRepository<BusinessHour, Long> {
    List<BusinessHour> findAllByShop(Shop shop);
}
