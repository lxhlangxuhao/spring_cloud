package com.lang.xu.hao.quartz;

import java.util.Date;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 22:55 2019/11/23
 */
public class TestJob implements Job {


	@Override
	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

		System.out.println(new Date());

//		try {
//			int i = 1 / 0;
//		} catch (Exception e) {
//			JobExecutionException e2 = new JobExecutionException(e);
//			// true 表示 Quartz 会自动取消所有与这个 job 有关的 trigger，从而避免再次运行 job
////			e2.setUnscheduleAllTriggers(true);
//
//			// true 表示立即重新执行作业
//			e2.setRefireImmediately(true);
//			throw e2;
//		}

	}
}
