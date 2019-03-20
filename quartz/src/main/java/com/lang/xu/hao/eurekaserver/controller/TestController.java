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

	@Autowired
	private RestTemplate restTemplate;


	@RequestMapping("/test")
	public String test() {
		System.out.println("client1");
		return "client1";
	}


	@GetMapping(value = "/name/{name}")
	public String test33(@PathVariable String name){

		return name;
	}

}
