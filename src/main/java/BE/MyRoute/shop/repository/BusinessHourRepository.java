package BE.MyRoute.shop.repository;

import BE.MyRoute.shop.entity.BusinessHour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessHourRepository extends JpaRepository<BusinessHour, Long> {
}
