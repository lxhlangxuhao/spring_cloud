package com.lang.xu.hao.schedule;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import org.springframework.stereotype.Service;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 16:07 2019/3/20
 */
@Service
public class MyJob implements SimpleJob {

	@Override
	public void execute(ShardingContext shardingContext) {

		System.out.println("hello ");
	}
}
