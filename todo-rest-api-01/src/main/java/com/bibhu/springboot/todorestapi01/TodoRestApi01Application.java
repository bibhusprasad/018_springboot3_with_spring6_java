package com.bibhu.springboot.todorestapi01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class TodoRestApi01Application {

	public static void main(String[] args) {
		SpringApplication.run(TodoRestApi01Application.class, args);
	}

	//http://localhost:3000 to http://localhost:8000
	//CROS Origin request
	//Allow all request only from http://localhost:3000
	@Bean
	public WebMvcConfigurer crosConfigured() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry
						.addMapping("/**")
						.allowedMethods("*")
						.allowedOrigins("http://localhost:3000");
			}
		};
	}

}
