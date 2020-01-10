package com.lang.xu.hao.eurekauser.eurekaserver.lock;

import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.stereotype.Component;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 15:21 2019/12/30
 */
@Component
public class RedissonLock {

	@Resource
	private Redisson redisson;

	private static final String LOCK_TITLE = "redisLock_";


	// 加锁
	public boolean getLock(String ulock) {

		String key = LOCK_TITLE + ulock;
		//获取锁对象
		RLock lock = redisson.getLock(key);
		//加锁，并且设置锁过期时间，防止死锁的产生
		lock.lock(2, TimeUnit.MINUTES);
		//加锁成功
		return true;
	}

	// 释放锁
	public boolean freedLock(String ulock) {

		//必须是和加锁时的同一个key
		String key = LOCK_TITLE + ulock;
		//获取所对象
		RLock mylock = redisson.getLock(key);
		//释放锁（解锁）
		mylock.unlock();
		return true;
	}


}
