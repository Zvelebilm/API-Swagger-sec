package com.example.apiswaggersec_demo.controller;

import com.example.apiswaggersec_demo.model.Movie;
import com.example.apiswaggersec_demo.repository.MovieRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    final private MovieRepository movieRepository;

    public RestController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    @GetMapping("/api/movies")
    public ResponseEntity<?> getEvents() {
        List<Movie> movies = movieRepository.findAll();
        return ResponseEntity.ok(movies);
    }
}
