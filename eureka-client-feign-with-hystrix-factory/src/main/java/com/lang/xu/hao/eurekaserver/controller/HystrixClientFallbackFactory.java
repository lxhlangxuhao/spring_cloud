package com.lang.xu.hao.eurekaserver.controller;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 20:54 2019/2/1
 */
@Component
public class HystrixClientFallbackFactory implements FallbackFactory<FeignService> {

	@Override
	public FeignService create(Throwable throwable) {
		return new FeignService() {
			@Override
			public String test(Integer name) {
				return "HystrixClientFallbackFactory";
			}
		};
	}
}
