package com.io.DirectorMovie_API.s.Service;


import com.io.DirectorMovie_API.s.Models.Movie;
import com.io.DirectorMovie_API.s.Repository.DirectorRepository;
import com.io.DirectorMovie_API.s.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    DirectorRepository directorRepository;

    public String addMovie(Movie movie){
        movieRepository.save(movie);
        return "Movie added successfully";
    }


/*
  public String addMovie(MovieRequestDto requestDto) {
    Movie movie = new Movie();
        movie.setName(requestDto.getName());
        movie.setImdbRating(requestDto.getImdbRating());
        movie.setDurationInMinutes(requestDto.getDurationInMinutes());

    Director director = directorRepository.getById(requestDto.getDirectorId());
        movie.setDirector(director);
    movie = movieRepository.save(movie);

        director.addMovie(movie);
        directorRepository.save(director);
        return "movie added";
    }
        */

}