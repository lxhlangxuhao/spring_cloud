package com.lang.xu.hao.eurekaserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
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

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/test2")
	public String test2() {


		return restTemplate.getForObject("localhost:7081/test",String.class);
	}

	@RequestMapping("/test")
	public String test() {


		return "aaaaaaaaa";
	}
}
