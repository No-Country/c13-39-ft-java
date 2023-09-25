package com.nicoz.NZWanderlust;

import java.time.LocalTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class NzWanderlustApplication {

	public static void main(String[] args) {
		SpringApplication.run(NzWanderlustApplication.class, args);
		System.out.println("La hora es: " + LocalTime.now());
	}

}

