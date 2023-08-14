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
    private Long rHashtagId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "route_id", nullable = false)
    private Route route;

    @Column
    private String hashtag;

    @Builder
    public RHashtag(Route route, String hashtag) {
        this.route = route;
        this.hashtag = hashtag;
    }
}
