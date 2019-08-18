package com.lang.xu.hao;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 11:38 2019/3/21
 */
public class CalllableTest implements Callable<UserMy> {


	@Override
	public UserMy call() throws Exception {

		UserMy userMy = new UserMy();
		userMy.setCount(100);

		return userMy;
	}


	public static void main(String[] args) {
		CalllableTest calllableTest = new CalllableTest();
		ExecutorService executorService = Executors.newFixedThreadPool(2);
//		Future<UserMy> userMyFutureTask = executorService.submit(calllableTest);
//
//		executorService.execute();
		FutureTask<UserMy> userMyFutureTask = new FutureTask<>(calllableTest);
		new Thread(userMyFutureTask,"ssss").start();

//		UserMy userMy = userMyFutureTask.get();
//		System.out.println(userMy.getCount());









	}




}
