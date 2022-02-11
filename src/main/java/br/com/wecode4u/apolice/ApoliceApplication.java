package br.com.wecode4u.apolice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApoliceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApoliceApplication.class, args);
		System.out.println("Apolice running now...");
	}

}
