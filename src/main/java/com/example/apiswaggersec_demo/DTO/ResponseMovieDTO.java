package com.example.apiswaggersec_demo.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class ResponseMovieDTO {
    @JsonProperty("page")
    private int page;
    @JsonProperty("results")
    private List<MovieDTO> results;
    @JsonProperty("total_pages")
    private int total_pages;
    @JsonProperty("total_results")
    private int total_results;
}
