package com.lang.xu.hao;

import com.lang.xu.hao.eurekaserver.EurekaServerApplication;
import com.lang.xu.hao.eurekaserver.config.RedisConfigTest;
import com.sun.glass.ui.Application;
import java.util.List;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EurekaServerApplication.class)
@WebAppConfiguration
public class EurekaServerApplicationTests {


	@Resource
	private RedisConfigTest redisConfigTest;


	@Test
	public void test() {

		System.out.println( );
	}

}
