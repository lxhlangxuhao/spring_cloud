package com.lang.xu.hao.itmuch;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 14:11 2018/12/3
 */
@Configuration
public class TestConfiguration  {


	@Bean
	@ConditionalOnMissingBean
	public IRule ribbonRule() {

		return new RandomRule();

	}
}
