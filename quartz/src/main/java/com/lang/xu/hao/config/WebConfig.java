package com.lang.xu.hao.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: Xuhao
 * @Date: Created in 9:54 2019/3/27
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {


	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {


		resolvers.add(new UserHandlerMethodArgumentResolver());

	}


	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		configurer.setUseRegisteredSuffixPatternMatch(true);
	}

	@Bean
	public ServletRegistrationBean servletRegistrationBean(DispatcherServlet dispatcherServlet) {
		ServletRegistrationBean<DispatcherServlet> servletServletRegistrationBean = new ServletRegistrationBean<>(dispatcherServlet);
		servletServletRegistrationBean.addUrlMappings("*.do");
		servletServletRegistrationBean.addUrlMappings("*.html");
		servletServletRegistrationBean.addUrlMappings("*.css");
		servletServletRegistrationBean.addUrlMappings("*.js");
		servletServletRegistrationBean.addUrlMappings("*.png");
		servletServletRegistrationBean.addUrlMappings("*.gif");
		servletServletRegistrationBean.addUrlMappings("*.ico");
		servletServletRegistrationBean.addUrlMappings("*.jpeg");
		servletServletRegistrationBean.addUrlMappings("*.jpg");
		return servletServletRegistrationBean;
	}



}
