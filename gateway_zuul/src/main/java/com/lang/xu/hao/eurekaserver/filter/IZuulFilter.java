package com.lang.xu.hao.eurekaserver.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 17:33 2020/1/10
 *
 * pre - 前置过滤器，在请求被路由前执行，通常用于处理身份认证，日志记录等；
 *
 * route - 在路由执行后，服务调用前被调用；
 *
 * error - 任意一个filter发生异常的时候执行或远程服务调用没有反馈的时候执行（超时），通常用于处理异常；
 *
 * post - 在route或error执行后被调用，一般用于收集服务信息，统计服务性能指标等，也可以对response结果做特殊处理。
 */
@Configuration
public class IZuulFilter extends ZuulFilter {

	private static final Logger logger = LoggerFactory.getLogger(ZuulFilter.class);



	/**
	 * 过滤器的类型 这里用pre，代表会再请求被路由之前执行
	 */
	@Override
	public String filterType() {

		return "pre";
	}

	@Override
	public int filterOrder() {
		return 0;
	}


	/**
	 * 判断该过滤器是否要被执行
	 */
	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		// 通过zuul，获取请求上下文
		RequestContext rc = RequestContext.getCurrentContext();
		HttpServletRequest request = rc.getRequest();

		logger.info("ZuulFilter.....method={},url={}",
				request.getMethod(),request.getRequestURL().toString());
		// 可以记录日志、鉴权，给维护人员记录提供定位协助、统计性能
		return true;
	}
}
