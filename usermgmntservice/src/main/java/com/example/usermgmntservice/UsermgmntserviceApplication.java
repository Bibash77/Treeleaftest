package com.example.usermgmntservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCaching
public class UsermgmntserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsermgmntserviceApplication.class, args);
	}

}
