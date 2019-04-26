package com.mo.xx;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 梦想爱你心
 */
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