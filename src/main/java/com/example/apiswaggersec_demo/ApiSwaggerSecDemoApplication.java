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
    //movieRepository.save(new Movie(true, "backdrop_path", List.of(1, 2, 3), 1, "original_language", "original_title", "overview", 1.0, "poster_path", "release_date", "title", true, 1.0, 1));

    }
}
