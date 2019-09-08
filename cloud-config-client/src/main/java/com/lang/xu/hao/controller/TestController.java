package com.lang.xu.hao.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 12:18 2019/9/7
 */
@RestController
@RequestMapping(value = "/testController")
public class TestController {

	@Value("${foo}")
	private String foo;

	@Value("${name}")
	private String name;

	@RequestMapping(value = "/hi")
	public String test() {

		return name;
	}

}
