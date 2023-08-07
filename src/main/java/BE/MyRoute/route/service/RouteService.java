package BE.MyRoute.route.service;


import BE.MyRoute.route.entity.Route;

import java.util.List;

public interface RouteService {
    void saveAllRoutes();
    void addShopToRoute(Long routeId, Long shopId);
    List<String> loadAllRouteNames(Long userId);
    Route loadRouteInfo(Long routeId);
    void deleteRoute(Long routeId);
}
