package com.example.apiswaggersec_demo.service;

import com.example.apiswaggersec_demo.repository.MovieRepository;
import org.springframework.stereotype.Service;

@Service
public class RepoService {
    private final MovieRepository movieRepository;
    public RepoService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }





}
