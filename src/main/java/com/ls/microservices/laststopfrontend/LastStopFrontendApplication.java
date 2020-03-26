package com.ls.microservices.laststopfrontend;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import com.ls.microservices.laststopfrontend.bean.Question;

@SpringBootApplication
public class LastStopFrontendApplication {

	@Bean
	@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Question newQuestion() {
		return new Question();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(LastStopFrontendApplication.class, args);
	}

}
