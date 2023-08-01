package BE.MyRoute.shop.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BusinessHour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "business_hour_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "shopId", nullable = false)
    private Shop shop;

    @Column(nullable = false)
    private String open; // 시작 시간

    @Column(nullable = false)
    private String close; // 종료 시간

    @Enumerated(value = EnumType.STRING)
    @Column (nullable = false)
    private Day openDay; // 오픈 요일
}
