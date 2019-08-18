package com.lang.xu.hao.util;

import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 16:26 2019/3/20
 */
@Configuration
@ConditionalOnExpression("'${regCenter.serverList}'.length() > 0")
public class ZookeeperInstance {

	@Value("${regCenter.serverList}")
	String ss;


	@Bean
	public ZookeeperRegistryCenter registryCenter(
			@Value("${regCenter.serverList}") final String serverList,
			@Value("${regCenter.nameSpace}") final String nameSpace) {

		ZookeeperConfiguration zoo=new ZookeeperConfiguration(serverList, nameSpace);
		zoo.setMaxRetries(4);
		zoo.setBaseSleepTimeMilliseconds(1000);
		zoo.setMaxSleepTimeMilliseconds(6000);

		return new ZookeeperRegistryCenter(zoo);
	}




}
