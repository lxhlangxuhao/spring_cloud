package com.lang.xu.hao.eurekauser.eurekaserver.server.impl;

import com.lang.xu.hao.eurekauser.eurekaserver.annotation.IsTryAgain;
import com.lang.xu.hao.eurekauser.eurekaserver.exception.TryAgainException;
import com.lang.xu.hao.eurekauser.eurekaserver.server.TestServer;
import org.springframework.stereotype.Service;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 16:34 2020/3/18
 */
@Service
public class TestServerImpl implements TestServer {

	@Override
	@IsTryAgain
	public void test() {

		System.out.println("支付失败");
		throw new TryAgainException();

	}
}
