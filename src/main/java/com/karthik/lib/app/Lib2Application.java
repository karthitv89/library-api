package com.karthik.lib.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.karthik.lib.app")
public class Lib2Application {

	public static void main(String[] args) {
		SpringApplication.run(Lib2Application.class, args);
	}
}
