package com.lang.xu.hao.eurekauser.eurekaserver.aspect;

import com.lang.xu.hao.eurekauser.eurekaserver.exception.TryAgainException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 10:52 2020/3/18
 */
@Aspect
@Configuration
public class TryAgainAspect implements Ordered {


	@Override
	public int getOrder() {
		return 0;
	}


	@Pointcut("@annotation(com.lang.xu.hao.eurekauser.eurekaserver.annotation.IsTryAgain)")
	public void isTryAgaiPointcut() {
		// pointcut mark
	}


	@Around("isTryAgaiPointcut()")
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {

		for (int i = 0; i < 3; i++) {
			try {
				return pjp.proceed();
			} catch (TryAgainException e) {
				System.out.println("正在重试："+i+"次");
			}

		}
		return null;
	}
}
