package com.lang.xu.hao.eurekaserver.config;

import java.util.List;
import lombok.Data;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 11:10 2019/12/10
 */
@Data
public class RedisConfigTest {

	private String password;

	private String database;

	private String host;

	private String port;

	private List<String> testList;


}
