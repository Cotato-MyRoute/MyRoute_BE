package BE.MyRoute.shop.controller;

import BE.MyRoute.shop.dto.ShopRequest;
import BE.MyRoute.shop.dto.ShopInfoResponse;
import BE.MyRoute.shop.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/shop")
public class ShopController {

    private final ShopService shopService;

    @PostMapping
    public ResponseEntity<String> addNewShop(@RequestBody ShopRequest shopRequest, Authentication auth){
        return ResponseEntity.status(HttpStatus.CREATED).body(shopService.addNewShop(shopRequest, auth));
    }

    @PostMapping("/like/{shopId}")
    public ResponseEntity<String> likeShop(@RequestParam Long shopId, Authentication auth){
        return ResponseEntity.status(HttpStatus.CREATED).body(shopService.likeShop(shopId, auth));
    }

    @GetMapping("/new")
    public ResponseEntity<List<ShopInfoResponse>> getNewShops(){
        return ResponseEntity.status(HttpStatus.OK).body(shopService.getNewShops());
    }

    @GetMapping("/info/{shopId}")
    public ResponseEntity<ShopInfoResponse> getShopInfo(@PathVariable Long shopId){
        return ResponseEntity.status(HttpStatus.OK).body(shopService.getShopInfo(shopId));
    }

    @GetMapping
    public ResponseEntity<List<ShopInfoResponse>> getShopByName(@RequestParam String shopName){
        return ResponseEntity.status(HttpStatus.OK).body(shopService.getShopByName(shopName));
    }

    @GetMapping
    public ResponseEntity<List<ShopInfoResponse>> getAllShops(){
        return ResponseEntity.status(HttpStatus.OK).body(shopService.getAllShops());
    }

    @DeleteMapping("/{shopId}")
    public ResponseEntity<String> deleteShop(@PathVariable Long shopId){
        return ResponseEntity.status(HttpStatus.OK).body(shopService.deleteShop(shopId));
    }

    @DeleteMapping("dislike/{shopId}")
    public ResponseEntity<String> dislikeShop(@PathVariable Long shopId, Authentication auth){
        return ResponseEntity.status(HttpStatus.OK).body(shopService.dislikeShop(shopId, auth));
    }

}
