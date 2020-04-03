package com.lang.xu.hao.eurekauser.eurekaserver.config;


/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 15:57 2019/8/17
 */
//@Configuration
public class JedisPoolConfig {

//	@Value("${spring.redis.host}")
//	private String host;
//
//	@Value("${spring.redis.port}")
//	private int port;
//
//	@Value("${spring.redis.password}")
//	private String password;
//
//	@Value("${spring.redis.timeout}")
//	private int timeout;
//
//	@Value("${spring.redis.jedis.pool.max-idle}")
//	private int maxIdle;
//
//	@Value("${spring.redis.jedis.pool.min-idle}")
//	private int minIdle;
//
//	@Value("${spring.redis.jedis.pool.max-wait}")
//	private long maxWaitMillis;

//	@Value("${spring.redis.block-when-exhausted}")
//	private boolean  blockWhenExhausted;

//	@Bean
//	public JedisPool redisPoolFactory() {
//
//		GenericObjectPoolConfig jedisPoolConfig = new GenericObjectPoolConfig();
//		jedisPoolConfig.setMaxIdle(maxIdle);
//		jedisPoolConfig.setMinIdle(minIdle);
//		jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
//		// 连接耗尽时是否阻塞, false报异常,ture阻塞直到超时, 默认true
////		jedisPoolConfig.setBlockWhenExhausted(blockWhenExhausted);
//		// 是否启用pool的jmx管理功能, 默认true
//		jedisPoolConfig.setJmxEnabled(true);
//		return new JedisPool(jedisPoolConfig, host, port, timeout, password);
//	}
}
