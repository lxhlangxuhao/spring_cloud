package com.lang.xu.hao.eurekauser.eurekaserver.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 21:33 2019/8/13
 */

@Configuration
@ConfigurationProperties(prefix = "spring.redis.cluster")
@Data
public class RedisConfig {


	private String[] nodes;
}