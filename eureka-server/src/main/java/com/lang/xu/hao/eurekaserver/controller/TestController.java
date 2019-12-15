package com.lang.xu.hao.eurekaserver.controller;

import io.swagger.annotations.Api;
import javax.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 13:40 2018/12/1
 */
@RestController
public class TestController {

	@RequestMapping(value = "/test")
	public Object test() {


		return null;
	}






}
