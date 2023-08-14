package BE.MyRoute.route.service;

import BE.MyRoute.member.entity.Member;
import BE.MyRoute.member.repository.MemberRepository;
import BE.MyRoute.route.dto.request.RouteInitRequestDto;
import BE.MyRoute.route.dto.response.RouteResponseDto;
import BE.MyRoute.route.entity.RHashtag;
import BE.MyRoute.route.entity.Route;
import BE.MyRoute.route.entity.RouteImage;
import BE.MyRoute.route.entity.RouteShop;
import BE.MyRoute.route.repository.RHashtagRepository;
import BE.MyRoute.route.repository.RouteImageRepository;
import BE.MyRoute.route.repository.RouteRepository;
import BE.MyRoute.route.repository.RouteShopRepository;
import BE.MyRoute.shop.entity.Shop;
import BE.MyRoute.shop.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class RouteServiceImpl implements RouteService{
    private final RouteRepository routeRepository;
    private final ShopRepository shopRepository;
    private final MemberRepository memberRepository;
    private final RHashtagRepository rHashtagRepository;
    private final RouteImageRepository routeImageRepository;
    private final RouteShopRepository routeShopRepository;

    @Override
    public boolean saveRoute(RouteInitRequestDto requestDto) {

        Member member = memberRepository.findById(requestDto.getMemberId()).get();

        Route route = Route.builder()
                .routeName(requestDto.getRouteName())
                .member(member)
                .likeNum((long)0)
                .build();

        routeRepository.save(route);

        log.info("RHashtagList:{}", requestDto.getHashtagList());
        log.info("RouteShopIdList:{}", requestDto.getRouteShopIdList());

        requestDto.getHashtagList()
                .forEach(hashtag -> rHashtagRepository.save(RHashtag.builder()
                        .route(route)
                        .hashtag(hashtag)
                        .build()));

        requestDto.getRouteImageList()
                .forEach(routeImageUrl -> routeImageRepository.save(RouteImage.builder()
                        .imageUrl(routeImageUrl)
                        .route(route)
                        .member(member)
                        .build()));

        requestDto.getRouteShopIdList()
                .forEach(shopId -> routeShopRepository.save(RouteShop.builder()
                        .shop(shopRepository.findById(shopId).get())
                        .route(route)
                        .build()));

        return true;
    }

    @Override
    public void addShopToRoute(Long routeId, Long shopId) {

        Route route = routeRepository.findById(routeId).get();
        Shop shop = shopRepository.findById(shopId).get();

        RouteShop routeShop = RouteShop.builder()
                                    .shop(shop)
                                    .route(route)
                                    .build();

        route.getRouteShopList().add(routeShop);

        routeRepository.save(route);
    }

    @Override
    public List<String> loadAllRouteNames(Long userId) {
        return routeRepository.findAll()
                .stream()
                .filter(route -> route.getMember().getMemberId().equals(userId))
                .map(Route::getRouteName)
                .collect(Collectors.toList());
    }

    @Override
    public RouteResponseDto loadRouteInfo(Long routeId) {

        Route route = routeRepository.findById(routeId).get();

        List<Long> routeShopIdList = route.getRouteShopList()
                .stream()
                .map(RouteShop::getRShopId)
                .collect(Collectors.toList());
        List<String> routeImageUrlList = route.getRouteImageList()
                .stream()
                .map(RouteImage::getImageUrl)
                .collect(Collectors.toList());
        List<String> rHashtagList = route.getRHashtagList()
                .stream()
                .map(RHashtag::getHashtag)
                .collect(Collectors.toList());

        return RouteResponseDto.builder()
                .routeId(route.getRouteId())
                .routeName(route.getRouteName())
                .userId(route.getMember().getMemberId())
                .likeNum(route.getLikeNum())
                .routeShopIdList(routeShopIdList)
                .routeImageUrlList(routeImageUrlList)
                .rHashtagList(rHashtagList)
                .build();
    }

    @Override
    public void deleteRoute(Long routeId) {
        routeRepository.delete(routeRepository.findById(routeId).get());
    }
}
