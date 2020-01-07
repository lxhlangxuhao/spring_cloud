package com.lang.xu.hao.eurekauser.eurekaserver.config;

import org.redisson.Redisson;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 11:58 2019/12/30
 */
@Configuration
public class RedissonConfig {

	@Value("${spring.redis.host}")
	private String redisHost;

	@Value("${spring.redis.port}")
	private String redisPort;

	@Value("${spring.redis.password}")
	private String redisPassword;

	@Bean
	public Redisson getRedisson() {

		// use "rediss://" for SSL connection
		String address = "redis://" + redisHost + ":" + redisPort;
		Config config = new Config();
		config.useSingleServer().setAddress(address).setPassword(redisPassword);

		return (Redisson) Redisson.create(config);
	}
}
