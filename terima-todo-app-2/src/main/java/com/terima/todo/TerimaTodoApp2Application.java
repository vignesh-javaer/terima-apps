package com.terima.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="com.terima.todo")
public class TerimaTodoApp2Application {

	public static void main(String[] args) {
		SpringApplication.run(TerimaTodoApp2Application.class, args);
	}
}
