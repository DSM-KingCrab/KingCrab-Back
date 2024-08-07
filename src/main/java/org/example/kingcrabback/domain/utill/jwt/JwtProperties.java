package org.example.kingcrabback.domain.utill.jwt;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties("jwt")
public class JwtProperties {
    private Long accessTime;
    private String prefix;
    private String header;
    private String secretKey;
}
