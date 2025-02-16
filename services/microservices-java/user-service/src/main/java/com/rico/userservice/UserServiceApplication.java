package com.rico.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserServiceApplication {

	//La aplicacion se inicia con el metodo main en donde se ejecuta el metodo run de SpringApplication
	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

}
