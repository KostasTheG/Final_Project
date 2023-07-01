package com.techpro.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

public class ProjectApplication {

//	@Bean
//	public Dotenv dotenv() {
//		return Dotenv.configure().load();
//	}


	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

}
