package com.cecgw.cq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaReceiveApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaReceiveApplication.class, args);
	}
}
