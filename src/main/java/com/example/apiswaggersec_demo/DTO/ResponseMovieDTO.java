package com.example.apiswaggersec_demo.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
