package com.lang.xu.hao.quartz.config;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;

/**
 * @Description: 1、定义job工厂 实现任务实例化方式
 * @Author: lirongchao
 * @CreateDate: 2019/11/21
 * @UpdateDate: 2019/11/21
 * @Version: 0.0.1-SHAPSHOI
 */
public class AutowiringSpringBeanJobFactory extends SpringBeanJobFactory implements ApplicationContextAware {

    private transient AutowireCapableBeanFactory beanFactory;

    /**
     * 获取 AutowireCapableBeanFactory
     * ApplicationContextAware作用：得到Spring容器中的Bean / 将该bean所属上下文传递给它
     *
     * @param context
     */
    @Override
    public void setApplicationContext(final ApplicationContext context) {
        beanFactory = context.getAutowireCapableBeanFactory();
    }

    /**
     * SpringBeanJobFactory
     * 创建作业实例，并使用从调度程序上下文，作业数据映射和触发器数据映射中获取的属性值填充该作业实例
     *
     * @param bundle
     * @return
     * @throws Exception
     */
    @Override
    protected Object createJobInstance(final TriggerFiredBundle bundle) throws Exception {
        final Object job = super.createJobInstance(bundle);
        beanFactory.autowireBean(job);
        return job;
    }
}
