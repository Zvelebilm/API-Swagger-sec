package com.example.apiswaggersec_demo.controller;

import com.example.apiswaggersec_demo.model.Movie;
import com.example.apiswaggersec_demo.repository.MovieRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "Movies", description = "Post API")
public class RestPostController {
    public RestPostController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    private final MovieRepository movieRepository;
    @Operation(
            description = "Add 1 movie",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Success"
                    )
            }
    )
    @PostMapping("/api/v1/movie")
    public ResponseEntity<?> addMovie(@RequestBody Movie movie) {
        movieRepository.save(movie);
        return ResponseEntity.ok("movie created");
    }
    @Operation(
            description = "Add multiple movies",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Success"
                    )
            }
    )
    @PostMapping("/api/v1/movies")
    public ResponseEntity<?> addMovies(@RequestBody List<Movie> movies) {
        movieRepository.saveAll(movies);
        return ResponseEntity.ok("movies created");
    }
}
