package com.io.DirectorMovie_API.s.Controller;


import com.io.DirectorMovie_API.s.Models.Movie;
import com.io.DirectorMovie_API.s.RequestDTO.MovieRequestDto;
import com.io.DirectorMovie_API.s.RequestDTO.Top3MovieDurationRequestDto;
import com.io.DirectorMovie_API.s.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/add")
    public String addMovieUsingDto(@RequestBody MovieRequestDto requestDto) {
        return movieService.addMovieUsingDto(requestDto);
    }

    @GetMapping("/findTop3MovieDuration")
    public List<Movie> findTop3MovieDuration (@RequestBody Top3MovieDurationRequestDto requestDto){
        return movieService.findTop3MovieDuration(requestDto);
    }


// here if we want to add director with movie
    @PostMapping("/addMovieWithDirectorId")
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
