package com.lang.xu.hao.eurekauser.eurekaserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 13:40 2018/12/1
 */
@RestController
public class HiController {

	@RequestMapping("/hi")
	public String hi() {

		return "hi";
	}

	@RequestMapping("/hi2")
	public String hi2() throws InterruptedException {

		Thread.sleep(2000);
		return "hi2";
	}

}
