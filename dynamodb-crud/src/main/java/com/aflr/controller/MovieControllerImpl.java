package com.aflr.controller;

import com.aflr.dto.MovieDto;
import com.aflr.service.MovieService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieControllerImpl implements MovieController {
    private MovieService movieService;

    public MovieControllerImpl(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    public ResponseEntity<List<MovieDto>> getAllMovies(HttpHeaders header) {
        return new ResponseEntity<>(movieService.getAllMovies(), HttpStatus.OK);
    }
}
