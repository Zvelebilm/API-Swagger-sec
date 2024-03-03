package com.example.apiswaggersec_demo.controller;

import com.example.apiswaggersec_demo.model.Movie;
import com.example.apiswaggersec_demo.repository.MovieRepositor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    final private MovieRepositor movieRepository;

    public RestController(MovieRepositor movieRepository) {
        this.movieRepository = movieRepository;
    }
    @GetMapping("/api/movies")
    public ResponseEntity<?> getEvents() {
        List<Movie> movies = movieRepository.findAll();
        return ResponseEntity.ok(movies);
    }
}
