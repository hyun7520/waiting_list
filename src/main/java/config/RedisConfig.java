package config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
@ConfigurationProperties(prefix = "spring.data.redis")
public class RedisConfig {

    @Value("${spring.data.redis.host}")
    private String host;

    @Value("${spring.data.redis.port}")
    private int port;

    @Bean
    public RedisConnectionFactory redisConnectFactory() {
//        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration();
        // redis 서버 주소 설정
//        config.setHostName(host);
        // 포트 번호 설정
//        config.setPort(port);
        // setPassword - 비밀번호 설정
        // setDatabase - 여러 DB 존재 시 접근할 DB의 인덱스를 설정
        // setTimeout - 연결 타임아웃을 설정
        return new LettuceConnectionFactory(host, port);
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectFactory());
        return template;
    }
}
