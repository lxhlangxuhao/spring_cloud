package com.lang.xu.hao.eurekauser;

import com.lang.xu.hao.eurekauser.eurekaserver.annotation.ExcludeFormComponent;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Xuhao
 * FooConfiguration必须是@Configuration，但请注意，它不在主应用程序上下文的@ComponentScan中，否则将由所有@RibbonClients共享
 * @Date: Created in 14:11 2018/12/3
 */
@Configuration
@ExcludeFormComponent
//@SuppressWarnings("all")
public class TestConfiguration {

	@Bean
	@ConditionalOnMissingBean
	public IRule ribbonRule() {

		return new RandomRule();

	}
}
