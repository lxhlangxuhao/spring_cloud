package com.lang.xu.hao;

import com.lang.xu.hao.eurekaserver.SpringBean.User;
import com.sun.glass.ui.Application;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class EurekaServerApplicationTests {

	@Resource
	private User user;

	@Test
	public void contextLoads() {

		System.out.println(user);
	}

}
