package com.lang.xu.hao.eurekaserver.SpringBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 0:02 2019/1/27
 */
@Configuration
public class BeanContainer {

//	@Autowired
//	private UserMy user;

	@Bean(name = "user")
	public User user() {
//		System.out.println("UserMy 创建完成");
		return new User();
	}

}
