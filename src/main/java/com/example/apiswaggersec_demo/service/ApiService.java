package com.example.apiswaggersec_demo.service;

import com.example.apiswaggersec_demo.DTO.ResponseMovieDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;

import com.example.apiswaggersec_demo.apiKey.TheMovieDB;
import com.example.apiswaggersec_demo.model.Movie;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ApiService {
    //curl --request GET --url 'https://api.themoviedb.org/3/search/movie?query=Matrix&include_adult=false&language=en-US&page=1' \

    public void findMovie(String title) {
        RestTemplate restTemplate = new RestTemplate();
        String apiKey = new TheMovieDB().getApiKey();
        HttpHeaders headers = new HttpHeaders();
        ObjectMapper objectMapper = new ObjectMapper();

        String url = ("https://api.themoviedb.org/3/search/movie?query=" + title + "&include_adult=false&language=en-US&page=1");


        headers.setBearerAuth(apiKey);
        headers.setContentType(MediaType.APPLICATION_JSON);

        String responseJSON = restTemplate.exchange(url,HttpMethod.GET, new HttpEntity<>(headers), String.class).getBody();
       try {
           ResponseMovieDTO responseMovieDTO = objectMapper.readValue(responseJSON, ResponseMovieDTO.class);
           System.out.println(responseMovieDTO);

       } catch (Exception e) {
           log.error(e.getMessage());
       }

       System.out.println(responseJSON);


    }
}
