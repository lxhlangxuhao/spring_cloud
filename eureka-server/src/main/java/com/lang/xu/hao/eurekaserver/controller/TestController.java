package com.lang.xu.hao.eurekaserver.controller;

import com.lang.xu.hao.eurekaserver.SpringBean.BeanContainer;
import com.lang.xu.hao.eurekaserver.SpringBean.User;
import com.whalin.MemCached.MemCachedClient;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 13:40 2018/12/1
 */
@RestController
public class TestController {

	@Autowired
	private RestTemplate restTemplate;

	@Resource
	private BeanContainer beanContainer;

	@Resource
	private MemCachedClient memCachedClient;

	@Autowired
	private User user;

	@Resource
	private RedisTemplate redisTemplate;

	@RequestMapping("/test2")
	public String test2() {


		return restTemplate.getForObject("http://EUREKA-CLIENT/test", String.class);

	}

	@RequestMapping("/setKey")
	public Object setKey(HttpServletRequest request, String key, String value) {

		ValueOperations valueOperations = redisTemplate.opsForValue();
		valueOperations.set(key,value);

		HttpSession session = request.getSession();
		session.setAttribute(key, value);
		return request.getSession().getId();
	}

	@RequestMapping("/getKey")
	public Object getKey(HttpServletRequest request,String key) {

		Object value = redisTemplate.opsForValue().get(key);
		if (Objects.nonNull(value)) {
			return value;
		}
		System.out.println("数据库中取值");

		redisTemplate.opsForValue().set(key, "null", 30, TimeUnit.SECONDS);

		return null;
	}

	@RequestMapping(value = "/head", method = RequestMethod.HEAD)
	public String head() {


		return "aaaaaaaaa";
	}


}
