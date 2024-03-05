package com.example.apiswaggersec_demo.service;

import com.example.apiswaggersec_demo.DTO.ResponseMovieDTO;
import com.example.apiswaggersec_demo.model.Movie;
import com.example.apiswaggersec_demo.repository.MovieRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
@AllArgsConstructor
public class RepoService {
    private final MovieRepository movieRepository;
    private final MongoTemplate mongoTemplate;


    public void saveMovie(ResponseMovieDTO responseMovieDTO) {
        ObjectMapper objectMapper = new ObjectMapper();
        if (responseMovieDTO.getResults().isEmpty()) {
            log.info("No data to save");
        } else {
            for (int i = 0; i < responseMovieDTO.getResults().size(); i++) {
                Movie movie = objectMapper.convertValue(responseMovieDTO.getResults().get(i), Movie.class);
                movieRepository.save(movie);
            }
        }
    }

    public List<Movie> multipleQuery(
            Boolean adult,
            String backdropPath,
            List<Integer> genreIds,
            Integer id,
            String originalLanguage,
            String originalTitle,
            String overview,
            Double popularity,
            String posterPath,
            String releaseDate,
            String title,
            Boolean video,
            Double voteAverage,
            Integer voteCount) {

        Query query = new Query();
        List<Movie> movies = new ArrayList<>();

        if (adult != null) {
            query.addCriteria(Criteria.where("adult").is(adult));
        }

        if (!ObjectUtils.isEmpty(backdropPath)) {
            query.addCriteria(Criteria.where("backdrop_path").is(backdropPath));
        }

        if (genreIds != null && !genreIds.isEmpty()) {
            query.addCriteria(Criteria.where("genre_ids").in(genreIds));
        }

        if (id != null) {
            query.addCriteria(Criteria.where("idmovie").is(id));
        }

        if (!ObjectUtils.isEmpty(originalLanguage)) {
            query.addCriteria(Criteria.where("original_language").is(originalLanguage));
        }

        if (!ObjectUtils.isEmpty(originalTitle)) {
            query.addCriteria(Criteria.where("original_title").is(originalTitle));
        }

        if (!ObjectUtils.isEmpty(overview)) {
            query.addCriteria(Criteria.where("overview").is(overview));
        }

        if (popularity != null) {
            query.addCriteria(Criteria.where("popularity").is(popularity));
        }

        if (!ObjectUtils.isEmpty(posterPath)) {
            query.addCriteria(Criteria.where("poster_path").is(posterPath));
        }

        if (!ObjectUtils.isEmpty(releaseDate)) {
            query.addCriteria(Criteria.where("release_date").is(releaseDate));
        }

        if (!ObjectUtils.isEmpty(title)) {
            query.addCriteria(Criteria.where("title").is(title));
        }

        if (video != null) {
            query.addCriteria(Criteria.where("video").is(video));
        }

        if (voteAverage != null) {
            query.addCriteria(Criteria.where("vote_average").lt(voteAverage));
        }

        if (voteCount != null) {
            query.addCriteria(Criteria.where("vote_count").is(voteCount));
        }

        return movies = mongoTemplate.find(query, Movie.class);

    }


}
