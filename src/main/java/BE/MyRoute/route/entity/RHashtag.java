package BE.MyRoute.route.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "r_hashtag")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RHashtag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long rHashTagId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "route_routeId", nullable = false)
    @Column
    private Route routeId;

    @Column
    private String hashtag;

    @Builder
    public RHashtag(Route routeId, String hashtag) {
        this.routeId = routeId;
        this.hashtag = hashtag;
    }
}
