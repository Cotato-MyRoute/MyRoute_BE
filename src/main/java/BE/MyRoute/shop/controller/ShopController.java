package BE.MyRoute.shop.controller;

import BE.MyRoute.shop.dto.ShopAddRequest;
import BE.MyRoute.shop.dto.ShopResponse;
import BE.MyRoute.shop.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/shop")
public class ShopController {

    private final ShopService shopService;

    @PostMapping
    public ResponseEntity<String> addNewShop(@RequestBody ShopAddRequest shopAddRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(shopService.addNewShop(shopAddRequest));
    }

    @GetMapping("/new")
    public ResponseEntity<List<ShopResponse>> getNewShops(){
        return ResponseEntity.status(HttpStatus.OK).body(shopService.getNewShops());
    }

    @GetMapping("/info/{shopId}")
    public ResponseEntity<ShopResponse> getShopInfo(@PathVariable Long shopId){
        return ResponseEntity.status(HttpStatus.OK).body(shopService.getShopInfo(shopId));
    }

    @GetMapping
    public ResponseEntity<List<ShopResponse>> getShopByName(@RequestParam String shopName){
        return ResponseEntity.status(HttpStatus.OK).body(shopService.getShopByName(shopName));
    }

    @GetMapping
    public ResponseEntity<List<ShopResponse>> getAllShops(){
        return ResponseEntity.status(HttpStatus.OK).body(shopService.getAllShops());
    }

    @DeleteMapping("/{shopId}")
    public ResponseEntity<String> deleteShop(@PathVariable Long shopId){
        return ResponseEntity.status(HttpStatus.OK).body(shopService.deleteShop(shopId));
    }
}
