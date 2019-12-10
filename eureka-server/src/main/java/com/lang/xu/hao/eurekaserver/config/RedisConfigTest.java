package com.lang.xu.hao.eurekaserver.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

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



}
