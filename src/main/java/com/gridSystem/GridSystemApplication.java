package com.gridSystem;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GridSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(GridSystemApplication.class, args);
	}
	@Bean
	public ModelMapper modelMapper(){
		// Model-mapper
		return new ModelMapper();
	}
}
