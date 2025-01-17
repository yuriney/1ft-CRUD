package com.example.crud;
import com.example.crud.entity.Customer;
import com.example.crud.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudApplication {


	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class);
	}

}