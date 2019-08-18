package com.lang.xu.hao.config;

import com.lang.xu.hao.eurekaserver.controller.UserMy;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * @Author: Xuhao
 * @Description: 自定义注 方法参数解析器  @RequestUser
 * @Date: Created in 10:04 2019/3/27
 */
public class UserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

	@Override
	public boolean supportsParameter(MethodParameter methodParameter) {

		//接受的参数类型是否为 UserMy,(@RequestUser UserMy userMy)
		boolean isUserMyType = methodParameter.getParameterType().isAssignableFrom(UserMy.class);
		//方法上是否有@RequestUser注解
		boolean isAnnotation = methodParameter.hasParameterAnnotation(RequestUser.class);

		return isUserMyType && isAnnotation;
	}

	@Override
	public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {

		UserMy userMy = new UserMy();
		userMy.setName(nativeWebRequest.getParameter("name"));

		return userMy;
	}
}
