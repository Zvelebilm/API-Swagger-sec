package com.example.apiswaggersec_demo.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Movies", description = "Post API")
public class RestPostController {

    @PostMapping("/api/v1/movie")
    public String createMovie() {
        return "create movie"; //todo create movie
    }

    @PostMapping("/api/v1/movies")
    public String createMovies() {
        return "create movies"; //todo create movies
    }
}
