package com.lang.xu.hao.eurekauser.eurekaserver.controller;

import com.lang.xu.hao.eurekauser.eurekaserver.lock.RedisLock;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import java.util.UUID;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
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
	@Autowired
	private EurekaClient discoveryClient;

	@Autowired
	private LoadBalancerClient loadBalancerClient;


	@Resource
	private RedisLock redisLock;



	@RequestMapping("/eureka-instance")
	public String serviceUrl() {
		InstanceInfo instance = discoveryClient.getNextServerFromEureka("EUREKA-CLIENT", false);

		return instance.getHomePageUrl();
	}

	@RequestMapping("/test")
	public Object test() throws InterruptedException {
		// 获取锁
		boolean lock = redisLock.lock("testKey", UUID.randomUUID().toString(), 50000, 2000);
		if (lock) {
			System.out.println("执行业务开始");
			Thread.sleep(5000);
			System.out.println("执行业务结束");
			System.out.println(redisLock.unlock("testKey") ? "已解锁" : "未解锁");
			return "已执行";
		}
		return "未执行";
	}

	public String hystrixFallbackMethod() {
		System.out.println("hystrixFallbackMethod");
		return "000";
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
