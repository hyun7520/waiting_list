package controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/redis")
public class Controller {

    private final RedisTemplate<String, String> redisTemplate;

    @PostMapping("/save/{key}")
    public ResponseEntity<?> redisTest(@PathVariable String key) {

        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        ops.set(key, "Hello");

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/get/{key}")
    public String getRedisTest(@PathVariable String key) {
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        return ops.get(key);
    }

}
