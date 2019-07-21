package com.callcenter.back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class CallCenterBackApplication {
	public static void main(String[] args) {
		SpringApplication.run(CallCenterBackApplication.class, args);
	}

}
