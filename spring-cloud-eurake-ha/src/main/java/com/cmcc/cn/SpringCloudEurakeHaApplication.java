package com.cmcc.cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringCloudEurakeHaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudEurakeHaApplication.class, args);
	}
}
