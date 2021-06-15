package com.example.restservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	public static Betriebsstellen betriebsstellen = new Betriebsstellen();
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}