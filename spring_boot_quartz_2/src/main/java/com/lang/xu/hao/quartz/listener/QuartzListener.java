package com.lang.xu.hao.quartz.listener;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

/**
 * @Author: Xuhao
 * @Description: quartz 监听器
 */
public class QuartzListener implements JobListener {

	private static final String LISTENER_NAME = "QuartSchedulerListener";


	@Override
	public String getName() {
		return LISTENER_NAME;
	}

	/**
	 * 任务被调度前
	 */
	@Override
	public void jobToBeExecuted(JobExecutionContext jobExecutionContext) {
		String jobName = jobExecutionContext.getJobDetail().getKey().toString();
		System.out.println("jobToBeExecuted");
		System.out.println("Job : " + jobName + " is going to start...");
	}


	/**
	 * 任务调度被拒绝
	 */
	@Override
	public void jobExecutionVetoed(JobExecutionContext jobExecutionContext) {

	}

	/**
	 * 任务已经执行
	 */
	@Override
	public void jobWasExecuted(JobExecutionContext jobExecutionContext, JobExecutionException e) {
		System.out.println("jobWasExecuted");
	}
}
