package com.lang.xu.hao.quartz.config;

import com.lang.xu.hao.quartz.TestJob2;
import com.lang.xu.hao.quartz.listener.QuartzListener;
import java.io.IOException;
import java.util.Properties;
import javax.annotation.Resource;
import javax.sql.DataSource;
import org.quartz.JobDetail;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.spi.JobFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 21:09 2019/11/23
 */
@Configuration
public class QuartzConfig {

	public static final String QUARTZ_PROPERTIES_PATH = "quartz.properties";

	@Resource
	private DataSource dataSource;

	/**
	 * 这个就是 AutowiringSpringBeanJobFactory
	 *
	 * @param applicationContext
	 * @return
	 */
	@Bean
	public JobFactory jobFactory(ApplicationContext applicationContext) {
		AutowiringSpringBeanJobFactory jobFactory = new AutowiringSpringBeanJobFactory();
		jobFactory.setApplicationContext(applicationContext);
		return jobFactory;
	}

	/**
	 * 是Quartz为我们提供的一个生成Scheduler实例Bean的工厂类
	 *
	 * @param jobFactory
	 * @param simpleJobTrigger
	 * @return
	 * @throws IOException
	 */
	@Bean
	public SchedulerFactoryBean schedulerFactoryBean(JobFactory jobFactory, Trigger simpleJobTrigger) throws IOException, SchedulerException {
		SchedulerFactoryBean factory = new SchedulerFactoryBean();

		factory.setJobFactory(jobFactory);
		factory.setQuartzProperties(quartzProperties());
		factory.setTriggers(simpleJobTrigger);
		factory.setDataSource(dataSource);
		//这样当spring关闭时，会等待所有已经启动的quartz job结束后spring才能完全shutdown。
		factory.setWaitForJobsToCompleteOnShutdown(true);
		factory.setOverwriteExistingJobs(false);
		factory.setStartupDelay(1);
		//设置调度器自动运行
		factory.setAutoStartup(true);
		//设置上下文spring bean name
		factory.setApplicationContextSchedulerContextKey("applicationContext");
		//配置任务监听
		factory.setGlobalJobListeners(new QuartzListener());

		return factory;
	}


	/**
	 * Properties属性基本配置参数
	 *
	 * @return
	 * @throws IOException
	 */
	@Bean
	public Properties quartzProperties()
			throws IOException {
		PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
		propertiesFactoryBean.setLocation(new ClassPathResource(QUARTZ_PROPERTIES_PATH));
		propertiesFactoryBean.afterPropertiesSet();
		return propertiesFactoryBean.getObject();
	}



	/**
	 * 静态方式配置定时任务
	 * 提供了执行任务的触发器，通过静态方式配置了一个调度任务
	 *
	 * @param jobDetail
	 * @return
	 */
	@Bean
	public CronTriggerFactoryBean simpleJobTrigger(@Qualifier("simpleJobDetail") JobDetail jobDetail) {
		CronTriggerFactoryBean factoryBean = new CronTriggerFactoryBean();
		//设置JobDetail
		factoryBean.setJobDetail(jobDetail);
		factoryBean.setStartDelay(1000L);
		factoryBean.setName("trigger2");
		factoryBean.setGroup("group2");
		//每1分钟触发一次
		factoryBean.setCronExpression("/5 * * * * ? *");

		return factoryBean;
	}

	/**
	 * 创建一个job
	 *
	 * @return
	 */
	@Bean
	JobDetailFactoryBean simpleJobDetail() {
		JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();

		factoryBean.setJobClass(TestJob2.class);
		factoryBean.setGroup("group2");
		factoryBean.setName("TestJob2");

		return factoryBean;
	}

}
