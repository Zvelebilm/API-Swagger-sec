package com.example.apiswaggersec_demo;

import com.example.apiswaggersec_demo.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AllArgsConstructor
public class ApiSwaggerSecDemoApplication implements CommandLineRunner {
    private MovieRepository movieRepository;

    public static void main(String[] args) {
        SpringApplication.run(ApiSwaggerSecDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        movieRepositor.save(new Movie("The Godfather"));

    }
}
