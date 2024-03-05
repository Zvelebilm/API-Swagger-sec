package com.example.apiswaggersec_demo.controller;

import com.example.apiswaggersec_demo.model.Movie;
import com.example.apiswaggersec_demo.repository.MovieRepository;
import com.example.apiswaggersec_demo.service.RepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    final private MovieRepository movieRepository;

    public RestController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    @GetMapping("/api/v1/movies")
    public ResponseEntity<?> getMovies() {
        List<Movie> movies = movieRepository.findAll();
        return ResponseEntity.ok(movies);
    }
    @GetMapping("/api/v1/movies/{title}")
    public ResponseEntity<?> getMoviesByTitle(@PathVariable(value = "title" ) String title) {
        List<Movie> movies = movieRepository.findByTitle(title);
        return ResponseEntity.ok(movies);
    }
    @GetMapping("/api/v1/moviesByRateGreater/{vote_average}")
    public ResponseEntity<?> getMoviesByRateGreater(@PathVariable(value = "vote_average" ) Double vote_average) {
        List<Movie> movies = movieRepository.findByVote_averageGreaterThan(vote_average);
        return ResponseEntity.ok(movies);
    }
    @GetMapping("/api/v1/moviesByRateLess/{vote_average}")
    public ResponseEntity<?> getMoviesByRateLess(@PathVariable(value = "vote_average" ) Double vote_average) {
        List<Movie> movies = movieRepository.findByVote_averageLessThan(vote_average);
        return ResponseEntity.ok(movies);
    }



//    @GetMapping("/api/movies/") //todo -fixme
//    public ResponseEntity<?> getEventById(Double vote_average) {
//
//        return ResponseEntity.ok(repoService.findMoviesWIthRateGreater(vote_average));
//    }
}
