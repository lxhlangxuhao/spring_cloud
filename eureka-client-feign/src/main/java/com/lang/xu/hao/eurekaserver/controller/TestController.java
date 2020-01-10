package com.lang.xu.hao.eurekaserver.controller;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 13:40 2018/12/1
 */
@RestController
public class TestController {

	@Resource
	private FeignService feignService;

	@RequestMapping(value = "/getName")
	public String test() {
		return feignService.test("lang");

	}





}
