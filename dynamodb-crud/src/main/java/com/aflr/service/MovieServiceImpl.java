package com.aflr.service;

import com.aflr.dao.MovieDao;
import com.aflr.dto.MovieDto;
import com.aflr.entity.MovieEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {
    private MovieDao movieDao;

    public MovieServiceImpl(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @Override
    public List<MovieDto> getAllMovies() {
        return movieDao.getAllMovies().stream().map(movieEntity -> {
            MovieDto movieDto = new MovieDto();
            BeanUtils.copyProperties(movieDto, movieEntity);
            return movieDto;
        }).collect(Collectors.toList());
    }

    @Override
    public MovieDto getMovieById() {
        final MovieEntity movieEntity = movieDao.getMovieById();
        MovieDto movieDto = new MovieDto();
        BeanUtils.copyProperties(movieDto, movieEntity);
        return movieDto;
    }
}