package com.lang.xu.hao.eurekauser.eurekaserver.lock;

/**
 * @Author: Xuhao
 * @Description: 栩浩
 * @Date: Created in 10:02 2019/8/15
 */

import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.ReturnType;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.JedisPool;

//@Component
public class RedisLock {

//	@Resource
	private RedisTemplate redisTemplate;

//	@Resource
	private JedisPool jedisPool;

	private static final long DEFAULT_SLEEP_TIME = 100;  // 请求间隔

	public static final String UNLOCK_MSG = "1";  // 成功解锁标识

	private ThreadLocal<String> threadLocal = new ThreadLocal<>();  // 用于保存线程唯一标识

	/**
	 * @Description: 非阻断式获取redis锁
	 * @Author: LangXuhao
	 * @param key     业务id
	 * @param value   UUID或者时间戳
	 * @param expire  redis 有效时间
	 * @return: boolean
	 */
	public boolean lock(String key, String value, long expire) {
		return setLockToRedis(key, value, expire);
	}

	/**
	 * @param key     业务id
	 * @param value   UUID或者时间戳
	 * @param expire  redis 有效时间
	 * @param timeout 等待时间 期间不断获取redis锁
	 * @Author: LangXuhao
	 * @Description: 阻断式获取redis锁
	 * @return: boolean
	 */
	public boolean lock(String key, String value, long expire, int timeout) {
		while (timeout >= 0) {
			if (setLockToRedis(key, value, expire)) {
				threadLocal.set(value);
				return true;
			}
			try {
				// 每一百毫秒请求一次,直到超时等待时间
				timeout -= DEFAULT_SLEEP_TIME;
				Thread.sleep(DEFAULT_SLEEP_TIME);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return false;
	}


	// 非阻塞获取锁
	private boolean setLockToRedis(String key, String value,long expire) {
//		String result = jedis.set(key, value, "NX", "PX", expire);  // jedis 方式
//		return redisTemplate.opsForValue().setIfAbsent(key, value, expire, TimeUnit.MILLISECONDS);
		return false;
	}

	public boolean unlock(String key) {
		// 第一种方式：用jedis调用lua
//		String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
//		Jedis jedis = jedisPool.getResource();
//		Object result = jedis.eval(script, Collections.singletonList(key), Collections.singletonList(threadLocal.get()));
//		jedis.close();

		//第一种方式：这种方式会报 java.lang.IllegalStateException: null 目前不知道这么解决
//		DefaultRedisScript<String> redisScript = new DefaultRedisScript<>();
//		redisScript.setResultType(String.class);  //这个设置很重要的哦
//		redisScript.setScriptText(script);
//		List<String> strings = Collections.singletonList(key);
//		Object result = redisTemplate.execute(redisScript,strings , threadLocal.get());

		//第三种方式：可以解决上诉NPE问题
		String result = String.valueOf(redisTemplate.execute(
				(RedisConnection connection) -> connection.eval(
						"if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end".getBytes(),
						ReturnType.INTEGER,
						1,  // key的数量
						key.getBytes(),
						threadLocal.get().getBytes())
		));
		return result.equals(UNLOCK_MSG);
	}


	/**
	 * @Author: LangXuhao
	 * @Description: 是否获取了锁  以获取true/未获取false
	 * @param key redis key
	 * @param serviceId 业务id
	 * @return: boolean
	 */
	public boolean isLocked(String key, String serviceId) {
		return redisTemplate.opsForValue().get(serviceId + key) != null;
	}

}
