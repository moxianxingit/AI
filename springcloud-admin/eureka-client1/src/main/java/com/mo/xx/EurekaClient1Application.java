package com.mo.xx;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 莫现新123
 *莫现新123莫现新123
 * 日期：2019.04.26反反复复付付付付付付付
 * */
@EnableEurekaServer

@SpringBootApplication
@RestController
public class EurekaClient1Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClient1Application.class, args);
	}
	@Value("${server.port}")
	String port;
	@RequestMapping("/hi")
    public String hi(){

    	return "ip"+port;
	}
}
