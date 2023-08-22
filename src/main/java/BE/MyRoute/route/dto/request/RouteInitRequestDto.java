package BE.MyRoute.route.dto.request;

import lombok.Data;
import lombok.Getter;
import org.springframework.lang.Nullable;

import java.util.ArrayList;
import java.util.List;

@Getter
public class RouteInitRequestDto {

    private Long memberId;
    private String routeName;
    private List<Long> routeShopIdList = new ArrayList<>();
    @Nullable
    private List<String> hashtagList = new ArrayList<>();
    @Nullable
    private List<String> routeImageList = new ArrayList<>();
}
