package com.lang.xu.hao.eurekaserver;

import com.alibaba.fastjson.JSONObject;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;

/**
 * Zuul的fallback容错处理逻辑，只针对timeout异常处理
 *
 * 如果需要在Zuul网关服务中增加容错处理fallback，需要实现接口ZuulFallbackProvider
 * spring-cloud框架，在Edgware版本(包括)之后，声明接口ZuulFallbackProvider过期失效，
 * 提供了新的ZuulFallbackProvider的子接口 - FallbackProvider
 * 在老版本中提供的ZuulFallbackProvider中，定义了两个方法。
 *  - String getRoute()
 *    当前的fallback容错处理逻辑处理的是哪一个服务。可以使用通配符‘*’代表为全部的服务提供容错处理。
 *    如果只为某一个服务提供容错，返回对应服务的spring.application.name值。
 *  - ClientHttpResponse fallbackResponse()
 *    当服务发生错误的时候，如何容错。
 * 新版本中提供的FallbackProvider提供了新的方法。
 *  - ClientHttpResponse fallbackResponse(Throwable cause)
 *    如果使用新版本中定义的接口来做容错处理，容错处理逻辑，只运行子接口中定义的新方法。也就是有参方法。
 *    是为远程服务发生异常的时候，通过异常的类型来运行不同的容错逻辑。
 */
@Configuration
public class IZuulFallbackProvider implements FallbackProvider {


	/**
	 * return - 返回fallback处理哪一个服务。返回的是服务的名称
	 * 推荐 - 为指定的服务定义特性化的fallback逻辑。
	 * 推荐 - 提供一个处理所有服务的fallback逻辑。
	 * 好处 - 服务某个服务发生超时，那么指定的fallback逻辑执行。如果有新服务上线，未提供fallback逻辑，有一个通用的。
	 */
	@Override
	public String getRoute() {
		return "*";
	}


	@Override
	public ClientHttpResponse fallbackResponse(String route, Throwable cause) {

		return new ClientHttpResponse() {

			@Override
			public HttpStatus getStatusCode() {

				return HttpStatus.OK;
			}


			/**
			 * ClientHttpResponse的fallback的状态码 返回int
			 */
			@Override
			public int getRawStatusCode() {

				return HttpStatus.OK.value();
			}

			@Override
			public String getStatusText() {

				return HttpStatus.OK.getReasonPhrase();
			}



			/**
			 * 回收资源方法
			 * 用于回收当前fallback逻辑开启的资源对象的。
			 * 不要关闭getBody方法返回的那个输入流对象。
			 */
			@Override
			public void close() {

			}


			/**
			 * 设置响应体
			 */
			@Override
			public InputStream getBody() {

				JSONObject jsonObject = new JSONObject();
				jsonObject.put("state","501");
				jsonObject.put("msg","网关超时，请稍后重试");
				return new ByteArrayInputStream(jsonObject.toJSONString().getBytes(StandardCharsets.UTF_8)); //返回前端的内容
			}


			/**
			 * 设置响应的头信息
			 */
			@Override
			public HttpHeaders getHeaders() {

				HttpHeaders httpHeaders = new HttpHeaders();
				httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8); //设置头
				return httpHeaders;
			}
		};
	}
}
