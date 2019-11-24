package com.lang.xu.hao.controller;

import com.lang.xu.hao.quartz.config.QuartzManager;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 20:27 2019/11/24
 */
@RestController
@RequestMapping(value = "quartzController")
public class QuartzController {

	@Resource
	private QuartzManager quartzManager;


	@RequestMapping(value = "/removeJob")
	public void removeJob() {
/*factoryBean.setGroup("group2");
		factoryBean.setName("TestJob2");

		factoryBean.setName("trigger2");
		factoryBean.setGroup("group2");*/
		quartzManager.removeJob("TestJob2","group2","trigger2","group2");

	}
}
