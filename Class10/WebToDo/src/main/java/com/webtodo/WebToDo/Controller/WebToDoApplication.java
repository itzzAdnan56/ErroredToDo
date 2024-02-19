package com.webtodo.WebToDo.Controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com/webtodo/WebToDo")
public class WebToDoApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebToDoApplication.class, args);
	}

}
