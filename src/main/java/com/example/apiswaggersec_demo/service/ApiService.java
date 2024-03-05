package com.example.apiswaggersec_demo.service;

import com.example.apiswaggersec_demo.DTO.ResponseMovieDTO;
import com.example.apiswaggersec_demo.apiKey.TheMovieDB;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
@Slf4j
public class ApiService {
    //curl --request GET --url 'https://api.themoviedb.org/3/search/movie?query=Matrix&include_adult=false&language=en-US&page=1' \
    private final RepoService repoService;
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
           repoService.saveMovie(responseMovieDTO);

       } catch (Exception e) {
           log.error(e.getMessage());
       }
    }
}
