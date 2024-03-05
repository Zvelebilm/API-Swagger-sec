package com.example.apiswaggersec_demo.service;

import com.example.apiswaggersec_demo.DTO.ResponseMovieDTO;
import com.example.apiswaggersec_demo.model.Movie;
import com.example.apiswaggersec_demo.repository.MovieRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@AllArgsConstructor
public class RepoService {
    private final MovieRepository movieRepository;



    public void saveMovie(ResponseMovieDTO responseMovieDTO) {
        Movie movie = new Movie();
        ObjectMapper objectMapper = new ObjectMapper();
        if (responseMovieDTO.getResults().isEmpty()) {
            log.info("No data to save");
        } else {
            for (int i = 0; i < responseMovieDTO.getResults().size(); i++) {
                movie = objectMapper.convertValue(responseMovieDTO.getResults().get(i), Movie.class);
                movieRepository.save(movie);
            }
        }
    }

    public List<Movie> custumQuery() {


        return null;
    }


}
