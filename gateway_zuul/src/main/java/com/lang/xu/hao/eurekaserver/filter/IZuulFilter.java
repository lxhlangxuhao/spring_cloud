package com.lang.xu.hao.eurekaserver.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 17:33 2020/1/10
 */
public class IZuulFilter extends ZuulFilter {

	@Override
	public String filterType() {

		return null;
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public boolean shouldFilter() {
		return false;
	}

	@Override
	public Object run() throws ZuulException {
		return null;
	}
}
