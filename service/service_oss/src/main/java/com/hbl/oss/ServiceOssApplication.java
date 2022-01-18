package com.hbl.oss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ServiceOssApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceOssApplication.class, args);
	}

}
