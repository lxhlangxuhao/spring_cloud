package com.lang.xu.hao.eurekaserver.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 13:40 2018/12/1
 */

// 支持占位符
@FeignClient(value = "${eureka.client.one}", fallbackFactory = HystrixClientFallbackFactory.class)
public interface FeignService {

	//@PathVariable 必须设置value
	@RequestMapping(value = "/feign/getName/{name}")
	String test(@PathVariable(value = "name") String name);


}
