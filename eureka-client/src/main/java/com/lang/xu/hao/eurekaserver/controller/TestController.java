package com.lang.xu.hao.eurekaserver.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import java.util.List;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 13:40 2018/12/1
 */
@RestController
public class TestController {

	@Qualifier("eurekaClient")
	@Autowired
	private EurekaClient discoveryClient;

	@Autowired
	private RestTemplate restTemplate;


	@RequestMapping("/eureka-instance")
	public String serviceUrl() {
		InstanceInfo instance = discoveryClient.getNextServerFromEureka("EUREKA-CLIENT", false);

		return instance.getHomePageUrl();
	}

	@RequestMapping("/test")
	public String test() {
		System.out.println("client1");
		return "client1";
	}


	@RequestMapping("/test2")
	public String test2() {

		//		UserMy[] forObject = restTemplate.getForObject("http://127.0.0.1:7080/test", UserMy[].class);
		List<UserMy> forObject = restTemplate.getForObject("http://127.0.0.1:7080/test", List.class);
		for (UserMy userMy : forObject) {
			System.out.println(userMy);

		}
		System.out.println();
		return "";
	}


	@GetMapping(value = "/name/{name}")
	public String test33(@PathVariable String name){

		return name;
	}

}
