package com.lang.xu.hao.eurekaserver.controller;

import com.lang.xu.hao.eurekaserver.entity.ResponseEntityBase;
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
@Api(value = "哈哈哈哈")
@RestController
public class TestController {


	@Resource
	private RedisTemplate redisTemplate;

	@RequestMapping(value = "/test")
	public ResponseEntityBase test() {


		return null;
	}






}
