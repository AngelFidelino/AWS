package com.aflr.controller;

import com.aflr.dto.MovieDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/api/v1/movies")
public interface MovieController {
    @GetMapping
    ResponseEntity<List<MovieDto>> getAllMovies(@RequestHeader HttpHeaders header);
}
