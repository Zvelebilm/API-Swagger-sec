package com.example.apiswaggersec_demo.repository;

import com.example.apiswaggersec_demo.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepositor extends MongoRepository<Movie, String> {
}
