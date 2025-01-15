package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDateTime;

@Getter
@RedisHash(value = "Restaurant", timeToLive = 300)
public class Restaurant {

    @Id
    @GeneratedValue
    @Column(name = "RESTAURANT_ID")
    private long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

    @Builder
    public Restaurant(long id, String name) {
        this.id = id;
        this.name = name;
        this.createdAt = LocalDateTime.now();
    }
}
