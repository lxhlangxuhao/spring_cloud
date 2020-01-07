package com.lang.xu.hao.eurekaserver.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 13:40 2018/12/1
 */
@RestController
@Api(value = "测试接口")
public class HiController {

	@ApiOperation(value = "测试接口", httpMethod = "GET", notes = "测试接口")
	@RequestMapping(value = "/hi",method = RequestMethod.GET)
	public String test() {

		return "hi";
	}






}
