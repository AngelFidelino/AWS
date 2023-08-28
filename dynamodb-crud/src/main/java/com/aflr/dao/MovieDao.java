package com.aflr.dao;

import com.aflr.entity.MovieEntity;

import java.util.List;

public interface MovieDao {
    List<MovieEntity> getAllMovies();

    MovieEntity getMovieById();
}
