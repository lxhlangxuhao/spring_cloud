package com.lang.xu.hao.eurekauser.eurekaserver.config;

import com.lang.xu.hao.basic.BaseJunitTest;
import com.lang.xu.hao.eurekauser.eurekaserver.lock.RedissonLock;
import java.util.Date;
import javax.annotation.Resource;
import org.junit.Test;

/**
 * @Author: Xuhao
 * @Description: 分布式redis锁
 * @Date: Created in 14:49 2019/12/30
 */
public class RedissonConfigTest extends BaseJunitTest {

	@Resource
	private RedissonLock redissonLock;


	@Test
	public void test() throws InterruptedException {

		boolean name = redissonLock.getLock("name");
		if (name) {
			System.out.println(new Date() + "user1");
			Thread.sleep(10000);
		}
		redissonLock.freedLock("name");
		System.out.println("freedLock_user1");
	}

}
