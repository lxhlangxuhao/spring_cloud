package com.lang.xu.hao.eurekaserver.controller;

import com.lang.xu.feignConfig.EurekaClientConfiguration;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 13:40 2018/12/1
 */
@FeignClient(name = "EUREKA-CLIENT",configuration = EurekaClientConfiguration.class)
public interface FeignService {

	@RequestLine("GET /name/{name}")
	String getName(@Param("name") String name);

}
