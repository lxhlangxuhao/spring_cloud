package com.lang.xu.hao.eurekaserver.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: Xuhao
 * @Description: 自动加载配置文件：把配置文件中spring.redis开头的配置自动加载到 RedisConfigTest对象中
 * @Date: Created in 17:40 2018/12/2
 */
@Configuration
public class RestTemplateConfig {

//	@LoadBalanced
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	@ConfigurationProperties(prefix = "spring.redis", ignoreUnknownFields = false)
	public RedisConfigTest redisConfigTest() {

		return new RedisConfigTest();
	}
}
