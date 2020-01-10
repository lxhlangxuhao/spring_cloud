package com.lang.xu.hao.eurekaserver.controller;

import org.springframework.stereotype.Component;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 21:57 2019/1/31
 */
@Component
public class HystrixClientFallback implements FeignService {

	@Override
	public String test(String name) {
		return "我挂掉了";
	}
}
