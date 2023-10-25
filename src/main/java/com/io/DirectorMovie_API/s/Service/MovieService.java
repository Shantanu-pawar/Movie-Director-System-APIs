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

    public String addMovieUsingDto(MovieRequestDto requestDto) {
        // we've created new obj and pass this parameters as req
        Movie movie = new Movie(requestDto.getName(), requestDto.getDurationInMinutes(),
                requestDto.getImdbRating());

        Director director = directorRepository.findById(requestDto.getDirectorId()).get();
        movie.setDirector(director);
        movie = movieRepository.save(movie);

        director.addMovie(movie);

        director.setNumberOfMovies(director.getMovieList().size());

        directorRepository.save(director);
        return "movie added";
    }

    public List<Movie> findTop3MovieDuration(Top3MovieDurationRequestDto requestDto){
        return movieRepository.getTop3MovieDuration();
    }


}