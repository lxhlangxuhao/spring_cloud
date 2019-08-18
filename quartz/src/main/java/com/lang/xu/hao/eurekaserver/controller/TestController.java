package com.lang.xu.hao.eurekaserver.controller;

import com.lang.xu.hao.config.RequestUser;
import java.io.IOException;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 13:40 2018/12/1
 */
@RestController
public class TestController {

//	@Autowired
//	private RestTemplate restTemplate;


	@RequestMapping("/test")
	public String test() {
		System.out.println("client1");
		return "client1";
	}


	@GetMapping(value = "/name/{name}")
	public String test33(@PathVariable String name){

		try {
			ZooKeeper zooKeeper = new ZooKeeper("39.105.147.99:2181", 2000, (Watcher) this);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return name;
	}

	@GetMapping(value = "/getUser")
	public void test44(@RequestUser UserMy userMy) {

		System.out.println();



	}

	@GetMapping(value = "/lang")
	public String test55(String name) {

		return name;
	}







//	@Resource
//	private ZookeeperRegistryCenter registryCenter;

}
