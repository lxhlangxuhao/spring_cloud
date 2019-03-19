package com.lang.xu.hao.eurekauser.eurekaserver.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
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
	private LoadBalancerClient loadBalancerClient;

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

	public String hystrixFallbackMethod() {
		System.out.println("hystrixFallbackMethod");
		return "000";
	}

	@RequestMapping("/test2")
	@HystrixCommand(fallbackMethod = "hystrixFallbackMethod")
	public String test2() {
		System.out.println("托尔斯泰");

		return restTemplate.getForObject("http://EUREKA-CLIENT/test",String.class);
	}

	@RequestMapping("/test3")
	public void test3(){
		//查看调用的 EUREKA-CLIENT 哪个服务
		ServiceInstance choose = loadBalancerClient.choose("EUREKA-CLIENT");
		System.out.println(choose.getHost()+":"+choose.getPort()+":"+choose.getServiceId());

	}


}
