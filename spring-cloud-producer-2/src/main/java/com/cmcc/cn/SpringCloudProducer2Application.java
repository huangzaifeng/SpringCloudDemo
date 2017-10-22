package com.cmcc.cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//@EnableEurekaClient
public class SpringCloudProducer2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudProducer2Application.class, args);
	}
}
