package com.aflr.service;

import com.aflr.dto.MovieDto;

import java.util.List;

public interface MovieService {
    List<MovieDto> getAllMovies();

    MovieDto getMovieById();
}
