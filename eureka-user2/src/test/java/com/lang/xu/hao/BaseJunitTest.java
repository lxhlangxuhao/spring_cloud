package com.lang.xu.hao;

import com.lang.xu.hao.eurekauser.EurekaUser_2Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 14:50 2019/12/30
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = EurekaUser_2Application.class)
@WebAppConfiguration
public class BaseJunitTest {

	@Test
	public void test() throws InterruptedException {

	}
}
