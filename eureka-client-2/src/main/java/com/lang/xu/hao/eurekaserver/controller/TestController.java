package com.lang.xu.hao.eurekaserver.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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

//	@Qualifier("eurekaClient")
//	@Autowired
//	private EurekaClient discoveryClient;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private DiscoveryClient discoveryClient;

	@RequestMapping("/eureka-instance")
	public String serviceUrl() {
		List<ServiceInstance> list = discoveryClient.getInstances("EUREKA-CLIENT");
		if (list != null && list.size() > 0 ) {
			return list.get(0).getUri().toString();
		}
		return null;
	}


//	@RequestMapping("/eureka-instance")
//	public String serviceUrl() {
//		InstanceInfo instance = discoveryClient.getNextServerFromEureka("EUREKA-CLIENT", false);
//
//			return instance.getHomePageUrl();
//	}

	@RequestMapping("/test")
	public String test() {
		System.out.println("client1");
		return "client1";
	}


	@RequestMapping("/test2")
	public String test2() {


		return restTemplate.getForObject("http://EUREKA-CLIENT/test",String.class);
	}


}
