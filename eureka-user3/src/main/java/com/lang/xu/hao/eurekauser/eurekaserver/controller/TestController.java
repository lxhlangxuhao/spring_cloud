package com.lang.xu.hao.eurekauser.eurekaserver.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;
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


	@RequestMapping("/test2")
	public String test2() {

		return restTemplate.getForObject("http://EUREKA-CLIENT/test",String.class);
	}

	@RequestMapping("/test3")
	public void test3(){
		//查看调用的 EUREKA-CLIENT 哪个服务
		ServiceInstance choose = loadBalancerClient.choose("EUREKA-CLIENT");
		System.out.println(choose.getHost()+":"+choose.getPort()+":"+choose.getServiceId());

	}


	public static void main(String[] args) {

		ArrayList<String> strings = new ArrayList<String>(){
			{
				add("aaa");
				add("bbb");
				add("ccc");
				add("ccc");
			}
		};

		List<Integer> integers = Collections.nCopies(5, 0);
		for (Integer i : integers) {
			System.out.println(i);
		}

	}





}
