package com.km.rpa_control_room;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RpaControlRoomApplication {

	public static void main(String[] args) {
		SpringApplication.run(RpaControlRoomApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(String[] args){

		return runner -> {
			System.out.println("App running...");
		};
	}
}
