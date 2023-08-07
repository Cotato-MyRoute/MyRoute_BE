package BE.MyRoute.route.service;

import BE.MyRoute.route.entity.Route;
import BE.MyRoute.route.repository.RouteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class RouteServiceImpl implements RouteService{
    private final RouteRepository routeRepository;

    @Override
    public void saveAllRoutes() {

    }

    @Override
    public void addShopToRoute(Long routeId, Long shopId) {

    }

    @Override
    public List<String> loadAllRouteNames(Long userId) {
        return null;
    }

    @Override
    public Route loadRouteInfo(Long routeId) {
        return null;
    }

    @Override
    public void deleteRoute(Long routeId) {

    }
}
