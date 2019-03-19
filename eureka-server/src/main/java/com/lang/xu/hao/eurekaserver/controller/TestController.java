package com.lang.xu.hao.eurekaserver.controller;

import com.lang.xu.hao.eurekaserver.SpringBean.BeanContainer;
import com.lang.xu.hao.eurekaserver.SpringBean.User;
import com.lang.xu.hao.eurekaserver.entity.UserMy;
import com.whalin.MemCached.MemCachedClient;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
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


	@RequestMapping("/test2")
	public String test2() {


		return restTemplate.getForObject("http://EUREKA-CLIENT/test", String.class);

	}

	@RequestMapping("/test")
	public List<UserMy> test() {

		UserMy name = new UserMy("name", "01", 0.5D);
		UserMy name2 = new UserMy("name2", "01", 0.5D);
		UserMy name3 = new UserMy("name3", "01", 0.5D);
		ArrayList<UserMy> userMIES = new ArrayList<UserMy>(){
			{
				add(name);
				add(name2);
				add(name3);
			}
		};

		return userMIES;
	}

	@RequestMapping(value = "/head", method = RequestMethod.HEAD)
	public String head() {


		return "aaaaaaaaa";
	}


	@RequestMapping("/getKey")
	public Object getKey() {

		memCachedClient.set("memcachaKey", "hello Memcached");
		return memCachedClient.get("memcachaKey");
	}


}
