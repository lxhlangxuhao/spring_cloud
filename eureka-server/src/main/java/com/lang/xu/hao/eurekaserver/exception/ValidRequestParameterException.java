package com.lang.xu.hao.eurekaserver.exception;

import org.springframework.validation.BindingResult;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 23:57 2019/11/9
 */
public class ValidRequestParameterException extends Exception {

	private BindingResult bindingResult;

	private String postBody;

	public ValidRequestParameterException(BindingResult bindingResult){
		this.bindingResult = bindingResult;
	}

	public ValidRequestParameterException(String postBody){
		super(postBody);
	}
}

