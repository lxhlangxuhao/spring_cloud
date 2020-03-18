package com.lang.xu.hao.eurekauser.eurekaserver.exception;

import lombok.Data;

/**
 * @Author: Xuhao
 * @Description: 业务Excel异常
 * @Date: Created in 16:48 2019/11/18
 */
@Data
public class BusinessException extends RuntimeException {

	private String describe;

	private Object resultDate;

	public BusinessException(String describe) {
		this.describe = describe;
	}

	public BusinessException(String message, String describe) {
		super(message);
		this.describe = describe;
	}
}
