package BE.MyRoute.shop.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Day {
    DAY_MONDAY("월요일"),
    DAY_TUESDAY("화요일"),
    DAY_WEDNESDAY("수요일"),
    DAY_THURSDAY("목요일"),
    DAY_FRIDAY("금요일"),
    DAY_SATURDAY("토요일"),
    DAY_SUNDAY("일요일");

    private final String day;

    public static Day toEnum(String day) {
        for (Day d : values()) {
            if (d.getDay().equals(day)) {
                return d;
            }
        }
        throw new IllegalArgumentException("Invalid day: " + day);
    }
}
