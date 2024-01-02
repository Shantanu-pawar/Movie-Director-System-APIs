package com.io.DirectorMovie_API.s.Service;


import com.io.DirectorMovie_API.s.Models.Director;
import com.io.DirectorMovie_API.s.Models.Movie;
import com.io.DirectorMovie_API.s.Repository.DirectorRepository;
import com.io.DirectorMovie_API.s.Repository.MovieRepository;
import com.io.DirectorMovie_API.s.RequestDTO.MovieRequestDto;
import com.io.DirectorMovie_API.s.ResponseDTO.DirectorResponseDto;
import com.io.DirectorMovie_API.s.ResponseDTO.TopRatedMovieResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    DirectorRepository directorRepository;

    public String addMovieUsingDto(MovieRequestDto requestDto) throws Exception {

        // we've created new obj and pass this parameters as req
        Movie movie = new Movie(requestDto.getName(),
                                requestDto.getDurationInMinutes(),
                                requestDto.getImdbRating());

        // we just set the director and save movie in repo
        int id = requestDto.getDirectorId();
        Optional<Director> directorOptional = directorRepository.findById(id);
        if(!directorOptional.isPresent()){
            throw new Exception("Director is not present so cannot set");
        }

        Director director = directorRepository.findById(id).get();
        movie.setDirector(director);
        movie = movieRepository.save(movie);

        // since it's biDirectional mapping so we've to also set into director to update info.
        director.addMovie(movie);
        director.setNumberOfMovies(director.getMovieList().size());

        // this is for setting movies number each time in director
        directorRepository.save(director);
        return "movie added";
    }

//    public List<Movie> findTop2RatedMovies(){
//        return movieRepository.getTopRatedMovies();
//    }

    public List<TopRatedMovieResponseDto> findTop2RatedMovies(){

        List<Movie> movieList = movieRepository.getTopRatedMovies();
        List<TopRatedMovieResponseDto> dtoList = new ArrayList<>();

        for(Movie movie : movieList){
            Director director = movie.getDirector();

            TopRatedMovieResponseDto topRatedMovieResponseDto = new TopRatedMovieResponseDto();
            topRatedMovieResponseDto.setName(movie.getName());
            topRatedMovieResponseDto.setDurationInMinutes(movie.getDurationInMinutes());
            topRatedMovieResponseDto.setLocation(director.getLocation());

            dtoList.add(topRatedMovieResponseDto);
        }
        return dtoList;
    }

    public DirectorResponseDto findDirectorByMovieName(String name){
        Movie movie = movieRepository.findByName(name);

        Director director = movie.getDirector();

        DirectorResponseDto directorResponseDto = new DirectorResponseDto();
        directorResponseDto.setName(director.getName());
        directorResponseDto.setLocation(director.getLocation());
        directorResponseDto.setNumberOfMovies(director.getNumberOfMovies());

        return directorResponseDto;
    }

    public String addMovie(Movie movie){
        movieRepository.save(movie); return "Movie added successfully";
    }
}