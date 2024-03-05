package com.example.apiswaggersec_demo.DTO;

import com.example.apiswaggersec_demo.model.Movie;
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
public class MovieDTO  {
        @JsonProperty("adult")
        public boolean adult;
        @JsonProperty("backdrop_path")
        public String backdrop_path;
        @JsonProperty("genre_ids")
        public List<Integer> genre_ids;
        @JsonProperty("id")
        public int id;
        @JsonProperty("original_language")
        public String original_language;
        @JsonProperty("original_title")
        public String original_title;
        @JsonProperty("overview")
        public String overview;
        @JsonProperty("popularity")
        public double popularity;
        @JsonProperty("poster_path")
        public String poster_path;
        @JsonProperty("release_date")
        public String release_date;
        @JsonProperty("title")
        public String title;
        @JsonProperty("video")
        public boolean video;
        @JsonProperty("vote_average")
        public double vote_average;
        @JsonProperty("vote_count")
        public int vote_count;
}
