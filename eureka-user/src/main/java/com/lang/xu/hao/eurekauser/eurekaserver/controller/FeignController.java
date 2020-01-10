package com.lang.xu.hao.eurekauser.eurekaserver.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 10:00 2020/1/10
 */
@RestController
@RequestMapping(value = "/feign")
public class FeignController {


	@RequestMapping(value = "/getName/{name}",method = RequestMethod.GET)
	public String getName(@PathVariable("name") String name) {

		return "eureka-user:" + name;
	}

}
