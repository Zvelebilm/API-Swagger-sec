package com.example.apiswaggersec_demo.service;

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
        String url = ("https://api.themoviedb.org/3/search/movie?query=" + title + "&include_adult=false&language=en-US&page=1");


        headers.setBearerAuth(apiKey);
        headers.setContentType(MediaType.APPLICATION_JSON);

        Object response = restTemplate.exchange(url,HttpMethod.GET, new HttpEntity<>(headers), String.class);
        System.out.println(response);


    }
}
