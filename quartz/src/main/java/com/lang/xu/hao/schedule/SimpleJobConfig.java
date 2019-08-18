package com.lang.xu.hao.schedule;

import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.lite.api.JobScheduler;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.lite.spring.api.SpringJobScheduler;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import javax.annotation.Resource;
import org.springframework.context.annotation.Bean;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 16:58 2019/3/20
 */
//@Configuration
public class SimpleJobConfig {


	@Resource
	private MyJob myJob;

	@Resource
	private ZookeeperRegistryCenter registryCenter;


	@Bean(initMethod = "init")
//	@PostConstruct
	public JobScheduler init() {

		//myjob 测试用
		return new SpringJobScheduler(myJob, registryCenter,
				getLiteJobConfiguration(MyJob.class, "0/5 0 * * * ?", 1, ""));//0=上海,1=北京,2=深圳

	}


	private LiteJobConfiguration getLiteJobConfiguration(final Class<? extends SimpleJob> jobClass, final String cron, final int defaultShardTotal, final String defaultShardPrams) {

		return LiteJobConfiguration.newBuilder(
				new SimpleJobConfiguration(
						JobCoreConfiguration.newBuilder(
				jobClass.getName(),
				cron,
				defaultShardTotal//分片数量
				).shardingItemParameters(defaultShardPrams).build(), jobClass.getCanonicalName())).overwrite(true).build();
	}

}
