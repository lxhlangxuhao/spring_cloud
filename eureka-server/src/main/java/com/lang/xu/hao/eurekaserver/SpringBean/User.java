package com.lang.xu.hao.eurekaserver.SpringBean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 10:34 2019/1/26
 */
public class User implements BeanNameAware,BeanFactoryAware {

	private String name;

	private Integer age;

	public User() {
		System.out.println("User构造函数");
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("BeanFactory setBeanFactory");
	}

	@Override
	public void setBeanName(String s) {
		System.out.println("BeanNameAware setBeanName");
	}

	public void initMethod() {
		System.out.println("Bean init-Method");
	}

	public void destoryMethod() {
		System.out.println("Bean destory-Method");
	}

	public static void main(String[] args) {

		User user = new User();
	}

//	@Override
//	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//		System.out.println("BeanPostProcessor postProcessBeforeInitialization");
//		return null;
//	}
//
//	@Override
//	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//		System.out.println("BeanPostProcessor postProcessAfterInitialization");
//		return null;
//	}
}
