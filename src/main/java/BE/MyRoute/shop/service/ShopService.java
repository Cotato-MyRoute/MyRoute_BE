package BE.MyRoute.shop.service;

import BE.MyRoute.shop.dto.ShopAddRequest;
import BE.MyRoute.shop.dto.ShopResponse;
import BE.MyRoute.shop.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShopService {

    private final ShopRepository shopRepository;
    public String addNewShop(ShopAddRequest shopAddRequest) {
        return "상점 등록 완료";
    }

    public List<ShopResponse> getNewShops() {
        return null;
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
