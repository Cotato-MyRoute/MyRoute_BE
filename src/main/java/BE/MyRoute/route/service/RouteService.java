package BE.MyRoute.route.service;


import BE.MyRoute.route.dto.request.RouteInitRequestDto;
import BE.MyRoute.route.dto.response.RouteResponseDto;

import java.util.List;

public interface RouteService {

    boolean saveRoute(RouteInitRequestDto requestDto);
    void addShopToRoute(Long routeId, Long shopId);
    List<String> loadAllRouteNames(Long userId);
    RouteResponseDto loadRouteInfo(Long routeId);
    void deleteRoute(Long routeId);
}
