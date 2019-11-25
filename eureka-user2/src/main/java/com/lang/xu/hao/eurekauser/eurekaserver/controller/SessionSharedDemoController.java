package com.lang.xu.hao.eurekauser.eurekaserver.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 18:02 2019/11/25
 */

@RestController
public class SessionSharedDemoController {

	@RequestMapping(value = "/getValue")
	public Object getValue(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Object name = session.getAttribute("name");

		return name;
	}

	@RequestMapping(value = "/setValue")
	public Object setValue(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("name", "小驴");

		return "success";
	}
}
