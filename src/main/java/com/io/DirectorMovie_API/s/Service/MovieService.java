package com.io.DirectorMovie_API.s.Service;


import com.io.DirectorMovie_API.s.Models.Director;
import com.io.DirectorMovie_API.s.Models.Movie;
import com.io.DirectorMovie_API.s.Repository.DirectorRepository;
import com.io.DirectorMovie_API.s.Repository.MovieRepository;
import com.io.DirectorMovie_API.s.RequestDTO.MovieRequestDto;
import com.io.DirectorMovie_API.s.RequestDTO.Top3MovieDurationRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    DirectorRepository directorRepository;

    public String addMovieUsingDto(MovieRequestDto requestDto) {

        // we've created new obj and pass this parameters as req
        Movie movie = new Movie(requestDto.getName(), requestDto.getDurationInMinutes(),
                requestDto.getImdbRating());

        // we just set the director and save it in repo
        Director director = directorRepository.findById(requestDto.getDirectorId()).get();
        movie.setDirector(director);
        movie = movieRepository.save(movie);

        // since it's bi-directional mapping so we've to also set into director to update info.
        director.addMovie(movie);

        director.setNumberOfMovies(director.getMovieList().size());

        // this is for setting movies number each time in director
        directorRepository.save(director);
        return "movie added";
    }

    // NOT WORKIG : not able to fetch the data from db


    public List<Movie> findTop2RatedMovies(){
        return movieRepository.getTopRatedMovies();
    }

    public Director findDirectorByMovieName(String name){
        Optional<Movie> movieOptional = directorRepository.;
    }

    public String addMovie(Movie movie){
        movieRepository.save(movie); return "Movie added successfully";
    }
}