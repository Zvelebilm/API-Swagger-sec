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

    public void findMovie(String title){
        final RestTemplate restTemplate = null;
        String apiKey = new TheMovieDB().getApiKey();
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(apiKey);
        headers.setContentType(MediaType.APPLICATION_JSON);
        //curl --request GET --url 'https://api.themoviedb.org/3/search/movie?query=Matrix&include_adult=false&language=en-US&page=1' \


        try { URI uri = new URI("https://api.themoviedb.org/3/search/movie?query=" + title + "&include_adult=false&language=en-US&page=1");
            RequestEntity<Void> requestEntity = new RequestEntity<>(headers, HttpMethod.GET, uri);
            ResponseEntity<String> responseEntity = restTemplate.exchange(requestEntity, String.class);
        } catch (Exception e) {
            log.warn("error" + e);
        }


    }
}
