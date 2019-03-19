package com.lang.xu.feignConfig;

import feign.Contract;
import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 17:00 2018/12/5
 */
//@Configuration  可以不加此标签
public class EurekaClientConfiguration {

	//使用feign风格调用接口
	@Bean
	public Contract feignContract() {
		return new feign.Contract.Default();
	}

	//feign 日志
	@Bean
	Logger.Level feignLoggerLevel() {
		return Logger.Level.FULL;
	}

	//feign 认证用户密码
//	@Bean
//	public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
//		return new BasicAuthRequestInterceptor("user", "password");
//	}


	public static void main(String[] args) {

		int test = test();
		System.out.println("11111"+test);
	}

	public static int test() {

		try {
//			Integer n = null;
//			n.hashCode()
			System.out.println(1);
			return 1;
		} catch (Exception e) {
			System.out.println(2);
		}finally {
			System.out.println(3);
			return 3;
		}
	}
}
