package com.lang.xu.hao.eurekauser.eurekaserver.config;

import javax.annotation.Resource;
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

	@Resource
	private RedisConfig redisConfig;

	@Value("${spring.redis.password}")
	private String password;

	@Bean
	public Redisson getRedisson() {

		// use "rediss://" for SSL connection
		// redisson版本是3.5，集群的ip前面要加上“redis://”，不然会报错，3.2版本可不加
		for (int i = 0; i < redisConfig.getNodes().length; i++) {
			redisConfig.getNodes()[i] = "redis://" + redisConfig.getNodes()[i];
		}
		Config config = new Config();
		config.useClusterServers()
				.addNodeAddress(redisConfig.getNodes())
				.setPassword(password)
				.setMasterConnectionMinimumIdleSize(10)
				.setMasterConnectionPoolSize(64)
				.setSlaveConnectionMinimumIdleSize(10)
				.setSlaveConnectionPoolSize(64);
		return (Redisson) Redisson.create(config);
	}
}
