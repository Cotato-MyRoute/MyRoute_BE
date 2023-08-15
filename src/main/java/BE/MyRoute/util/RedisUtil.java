package BE.MyRoute.util;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.time.Duration;

@RequiredArgsConstructor
@Service
public class RedisUtil {

    @Autowired
    private StringRedisTemplate template;

    public String getData(String key) {
        // key로 value를 가져오는 메소드
        ValueOperations<String, String> valueOperations = template.opsForValue();
        return valueOperations.get(key);
    }

    public boolean existData(String key) {
        // 해당 key에 해당하는 value가 존재하는지 확인하는 메소드
        return Boolean.TRUE.equals(template.hasKey(key));
    }

    public void setDataExpire(String key, String value, long duration) {
        // key-value 쌍으로 데이터를 저장하는 메소드(만료 시간 정할 수있다.)
        ValueOperations<String, String> valueOperations = template.opsForValue();
        Duration expireDuration = Duration.ofSeconds(duration);
        valueOperations.set(key, value, expireDuration);
    }

    public void deleteData(String key) {
        // key에 해당하는 데이터를 삭제하는 메소드
        template.delete(key);
    }
}
