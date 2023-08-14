package BE.MyRoute.route.controller;

import BE.MyRoute.route.dto.request.RouteInitRequestDto;
import BE.MyRoute.route.dto.response.RouteResponseDto;
import BE.MyRoute.route.service.RouteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/route")
public class RouteController {

    private final RouteService routeService;

    @PostMapping
    public ResponseEntity<String> saveRoute(@RequestBody RouteInitRequestDto requestDto){

        routeService.saveRoute(requestDto);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body("route is saved");
    }

    @PostMapping("/shop/{routeId}/{shopId}")
    public ResponseEntity<String> addShopToRoute(@PathVariable Long routeId,
                                                 @PathVariable Long shopId){

        routeService.addShopToRoute(routeId, shopId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body("shop is added to route");
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<List<String>> loadAllRouteNameByMemberId(@PathVariable Long memberId){

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(routeService.loadAllRouteNames(memberId));
    }

    @GetMapping("/info/{routeId}")
    public ResponseEntity<RouteResponseDto> loadRouteInfo(@PathVariable Long routeId){

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(routeService.loadRouteInfo(routeId));
    }

    @DeleteMapping("/{routeId}")
    public ResponseEntity<String> deleteRoute(@PathVariable Long routeId){

        routeService.deleteRoute(routeId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body("route is deleted");
    }
}
