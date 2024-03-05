package com.example.apiswaggersec_demo.model;

import com.example.apiswaggersec_demo.DTO.MovieDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Movie {
@Field("adultboolean")
    public boolean adult;
@Field("backdroppath")
    public String backdrop_path;
@Field("genreids")
    public List<Integer> genre_ids;
@Field("idmovie")
    public int id;
@Field("originallanguage")
    public String original_language;
@Field("originaltitle")
    public String original_title;
    public String overview;
    public double popularity;
    public String poster_path;
    public String release_date;
    public String title;
    public boolean video;
    public double vote_average;
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
