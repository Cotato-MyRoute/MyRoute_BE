package BE.MyRoute.route.entity;

import BE.MyRoute.member.entity.Member;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "route")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long routeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Column
    private String routeName;

    @Column
    private Long likeNum;

    @OneToMany(mappedBy = "route", cascade = CascadeType.ALL)
    private List<RHashtag> rHashtagList = new ArrayList<>();

    @OneToMany(mappedBy = "route", cascade = CascadeType.ALL)
    private List<RouteLike> routeLikeList = new ArrayList<>();

    @OneToMany(mappedBy = "route", cascade = CascadeType.ALL)
    private List<RouteImage> routeImageList = new ArrayList<>();

    @OneToMany(mappedBy = "route", cascade = CascadeType.ALL)
    private List<RouteShop> routeShopList = new ArrayList<>();

    @Builder
    public Route(Member member,
                 String routeName,
                 Long likeNum,
                 List<RHashtag> rHashtagList,
                 List<RouteImage> routeImageList,
                 List<RouteShop> routeShopList) {
        this.member = member;
        this.routeName = routeName;
        this.likeNum = likeNum;
        this.rHashtagList = rHashtagList;
        this.routeImageList = routeImageList;
        this.routeShopList = routeShopList;
    }
}
