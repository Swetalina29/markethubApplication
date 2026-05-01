package com.markethub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MarkethubApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarkethubApplication.class, args);
		System.out.println("🛒 MarketHub running at http://localhost:8080");
	}

}
