package com.io.DirectorMovie_API.s.Controller;


import com.io.DirectorMovie_API.s.Models.Movie;
import com.io.DirectorMovie_API.s.RequestDTO.MovieRequestDto;
import com.io.DirectorMovie_API.s.ResponseDTO.DirectorResponseDto;
import com.io.DirectorMovie_API.s.ResponseDTO.TopRatedMovieResponseDto;
import com.io.DirectorMovie_API.s.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/addMovieUsingDto")
    public String addMovieUsingDto(@RequestBody MovieRequestDto requestDto) {
        return movieService.addMovieUsingDto(requestDto);
    }


    // we also want's to get director information with it
//    in return i only want movie name, rating, directorname, directorlocation

//    @GetMapping("/findTop2RatingMovie")
//    public List<Movie> findTop2RatedMovies(){
//        return movieService.findTop2RatedMovies();
//    }

    @GetMapping("/findTop2RatingMovie")
    public List<TopRatedMovieResponseDto> findTop2RatedMovies(){
        return movieService.findTop2RatedMovies();
    }


    @GetMapping("findDirectorByMovieName/{name}")
    public DirectorResponseDto findDirectorByMovieName(@PathVariable("name") String name){
        return movieService.findDirectorByMovieName(name);
    }






// here if we want to add director with movie
    @PostMapping("/null")
    public String addMovie(@RequestBody Movie movie){
        return movieService.addMovie(movie);
    }
// this is how we pass the obj in Json
//        {
//            "name" : "shreya Ghoshal",
//            "durationInMinutes" : 224,
//            "imdbRating" : 10.1,
//
//            "director" : {
//                "directorId" : 5
//            }
//        }

}
