package com.lang.xu.hao.interceptor;

import javax.annotation.Resource;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 23:22 2018/12/13
 */
@Configuration
public class MyAdapter implements WebMvcConfigurer {

	@Resource
	private MyInterceptor myInterceptor;

	@Resource
	private UserInterceptor userInterceptor;

	@Resource
	private StudentInterceptor studentInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		registry.addInterceptor(studentInterceptor).addPathPatterns("/**");
		registry.addInterceptor(myInterceptor).addPathPatterns("/**");
		registry.addInterceptor(userInterceptor).addPathPatterns("/**");

	}
}
