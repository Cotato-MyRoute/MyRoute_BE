package BE.MyRoute.route.dto.response;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;
import org.springframework.lang.Nullable;

import java.util.List;

@Getter
@Builder
public class RouteResponseDto {

    private Long routeId;
    private String routeName;
    private Long userId;
    private Long likeNum;
    private List<Long> routeShopIdList;
    @Nullable
    private List<String> rHashtagList;
    @Nullable
    private List<String> routeImageUrlList;
}
