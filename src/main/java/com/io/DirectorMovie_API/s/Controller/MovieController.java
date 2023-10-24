package com.io.DirectorMovie_API.s.Controller;


import com.io.DirectorMovie_API.s.Models.Movie;
import com.io.DirectorMovie_API.s.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    MovieService movieService;



    @PostMapping("/add")
    public String addMovie(@RequestBody Movie movie){
        return movieService.addMovie(movie);
    }

//
//    @PostMapping("/addMovieWithDirectorId")
//    public String addMovie(@RequestBody Movie movie, int directorId){
//        return movieService.addMovie(movie);
//    }


//    @PostMapping("/add")
//    public String addMovie(@RequestBody MovieRequestDto requestDto){
//        return movieService.addMovie(requestDto);
//    }


}
