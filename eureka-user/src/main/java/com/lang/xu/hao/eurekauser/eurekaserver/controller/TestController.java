package com.lang.xu.hao.eurekauser.eurekaserver.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 13:40 2018/12/1
 */
@RestController
public class TestController {

	@Qualifier("eurekaClient")
	@Resource
	private EurekaClient discoveryClient;

	@Resource
	private LoadBalancerClient loadBalancerClient;



	@RequestMapping("/eureka-instance")
	public String serviceUrl() {
		InstanceInfo instance = discoveryClient.getNextServerFromEureka("EUREKA-CLIENT", false);

		return instance.getHomePageUrl();
	}


	@RequestMapping("/test3")
	public void test3(){
		//查看调用的 EUREKA-CLIENT 哪个服务
		ServiceInstance choose = loadBalancerClient.choose("EUREKA-CLIENT");
		System.out.println(choose.getHost()+":"+choose.getPort()+":"+choose.getServiceId());
	}


	@RequestMapping("/setKey")
	public Object setKey(HttpServletRequest request,HttpSession session) {
		String name = request.getParameter("name");
		session.setAttribute("name", name);
		return request.getSession().getId();
	}


	@RequestMapping("/getKey")
	public Object getKey2(HttpServletRequest request) {
		HttpSession session = request.getSession();
		return session.getAttribute("name");
	}

}
