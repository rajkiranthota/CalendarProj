package com.rajk.CalendarProj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.rajk"})
@EntityScan("com.rajk")
@EnableJpaRepositories("com.rajk")
public class CalendarProjApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalendarProjApplication.class, args);
	}
}
