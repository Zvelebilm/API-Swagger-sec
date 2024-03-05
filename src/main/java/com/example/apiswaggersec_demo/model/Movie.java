package com.example.apiswaggersec_demo.model;

import com.example.apiswaggersec_demo.DTO.MovieDTO;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Movie {
    public boolean adult;
    public String backdrop_path;
    public List<Integer> genre_ids;
    @Field("idmovie")
    public int id;
    public String original_language;
    public String original_title;
    public String overview;
    public double popularity;
    public String poster_path;
    public String release_date;
    public String title;
    public boolean video;
    @DecimalMin(value="0.0", message = "vote_average should not be less than 0")
    @DecimalMax(value="10.0", message = "vote_average should not be greater than 10")
    public double vote_average;
    @Min(value = 0, message = "vote_count should not be less than 0")
    public int vote_count;

    public Movie(MovieDTO movieDTO) {
        this.adult = movieDTO.isAdult();
        this.backdrop_path = movieDTO.getBackdrop_path();
        this.genre_ids = movieDTO.getGenre_ids();
        this.id = movieDTO.getId();
        this.original_language = movieDTO.getOriginal_language();
        this.original_title = movieDTO.getOriginal_title();
        this.overview = movieDTO.getOverview();
        this.popularity = movieDTO.getPopularity();
        this.poster_path = movieDTO.getPoster_path();
        this.release_date = movieDTO.getRelease_date();
        this.title = movieDTO.getTitle();
        this.video = movieDTO.isVideo();
        this.vote_average = movieDTO.getVote_average();
        this.vote_count = movieDTO.getVote_count();
    }

}
