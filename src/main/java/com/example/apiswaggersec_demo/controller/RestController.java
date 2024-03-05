package com.example.apiswaggersec_demo.controller;

import com.example.apiswaggersec_demo.model.Movie;
import com.example.apiswaggersec_demo.repository.MovieRepository;
import com.example.apiswaggersec_demo.service.RepoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    final private MovieRepository movieRepository;
    final private RepoService repoService;
    public RestController(MovieRepository movieRepository, RepoService repoService) {
        this.movieRepository = movieRepository;
        this.repoService = repoService;
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

    @GetMapping("/api/v1/findMoviesByCriteria")
    public List<Movie> findMoviesByCriteria(
            @RequestParam(required = false) Boolean adult,
            @RequestParam(required = false) String backdropPath,
            @RequestParam(required = false) List<Integer> genreIds,
            @RequestParam(required = false) Integer id,
            @RequestParam(required = false) String originalLanguage,
            @RequestParam(required = false) String originalTitle,
            @RequestParam(required = false) String overview,
            @RequestParam(required = false) Double popularity,
            @RequestParam(required = false) String posterPath,
            @RequestParam(required = false) String releaseDate,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) Boolean video,
            @RequestParam(required = false) Double voteAverage,
            @RequestParam(required = false) Integer voteCount){
     return repoService.multipleQuery(adult, backdropPath, genreIds, id, originalLanguage, originalTitle, overview, popularity, posterPath, releaseDate, title, video, voteAverage, voteCount);
    }
}
