package com.example.apiswaggersec_demo.repository;

import com.example.apiswaggersec_demo.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends MongoRepository<Movie, Integer> {
//List<Movie> findByVote_averageGreaterThan(Double vote_average);

    @Query("findByTitle")
    List<Movie> findByTitle(String title);

    @Query("{'vote_average': {$gt: ?0}}")
    List<Movie> findByVote_averageGreaterThan(Double vote_average);
    @Query("{'vote_average': {$lt: ?0}}")
    List<Movie> findByVote_averageLessThan(Double vote_average);

}
