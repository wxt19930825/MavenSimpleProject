package com.SpringBootProject.study;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringBootMainApplication {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SpringBootMainApplication.class);
		app.setShowBanner(false);
		app.run(args);
	}
}
