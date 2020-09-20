package com.example.kafkatestdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class KafkaTestDemoApplication implements CommandLineRunner {

	@Autowired
	private KafkaTemplate<String,String> kafkaTemplate ;

	public static void main(String[] args) {
		SpringApplication.run(KafkaTestDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		kafkaTemplate.send("TEST-TOPIC-1", "hello 1") ;
	}

	@KafkaListener(topics = "TEST-TOPIC-1")
	public void listenWithHeaders(String message)
	  {
		  System.out.println(
			"Received Message: " + message);
	}
}
