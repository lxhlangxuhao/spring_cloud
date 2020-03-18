package com.lang.xu.hao.eurekauser.eurekaserver.server.impl;

import com.lang.xu.hao.basic.BaseJunitTest;
import com.lang.xu.hao.eurekauser.eurekaserver.server.TestServer;
import javax.annotation.Resource;
import org.junit.Test;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 16:37 2020/3/18
 */
public class TestServerImplTest extends BaseJunitTest {

	@Resource
	private TestServer testServer;

	@Test
	public void test() {


		testServer.test();

	}

}
