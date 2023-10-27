package com.io.DirectorMovie_API.s.Controller;

import com.io.DirectorMovie_API.s.Models.Director;
import com.io.DirectorMovie_API.s.Models.Movie;
import com.io.DirectorMovie_API.s.RequestDTO.DirectorRequestDto;
import com.io.DirectorMovie_API.s.ResponseDTO.DirectorFindByNameResponse;
import com.io.DirectorMovie_API.s.Service.DirectorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/director")
@Slf4j
public class DirectorController {

    @Autowired
    DirectorService directorService;

    @PostMapping("/add")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        try{
            String response = directorService.addDirector(director);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            log.error("Can't able to add director.{}", e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteDirectorById/{id}")
    public ResponseEntity<String> deleteDirectorById(@PathVariable("id") Integer id){
        boolean check = directorService.deleteDirectorById(id);
        if(check){
            return new ResponseEntity<>("director delete successful response", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("invalid ID :: please enter correct id", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAllDirectors")
    public List<Director> getAllDirectors(){
        return directorService.getAllDirectors();
    }

    @PutMapping("/update")
    // we actually taken director
    public String updateDirector(@RequestBody DirectorRequestDto directorRequestDto){
        try{
            return directorService.updateDirector(directorRequestDto);
        }
        catch (Exception e){
            return "not able to update cause ID is invalid" + e.getMessage();
        }
    }


    @GetMapping("/getDirectorByLocation/{location}")
    public ResponseEntity<String> getDirectorByLocation(@PathVariable("location") String location){

        List<DirectorFindByNameResponse> responseList = directorService.getDirectorByLocation(location);
        return new ResponseEntity(responseList, HttpStatus.OK);
    }


    @DeleteMapping("/deleteAllDirector")
    public ResponseEntity<String> deleteAllDirector(){
        String response = directorService.deleteAllDirector();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getLocationById/{id}")
    public ResponseEntity<String> getLocationById(@PathVariable("id") int directorId){
        try{
            String response = directorService.getLocationById(directorId);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e){
            log.error("location not found for the given request.{}" , e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

 // delete director by name [all same name director should be deleted]
    @DeleteMapping("/deleteDirectorByName/{name}")
    public ResponseEntity<String> deleteDirectorByName(@PathVariable("name") String name){
        String response = directorService.deleteDirectorByName(name);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping("getAllMoviesUsingDirectorName/{name}")
    public List<Movie> getAllMoviesUsingDirectorName(@PathVariable("name") String name){
         List<Movie> list = directorService.getAllMoviesUsingDirectorName(name);
         return list;
    }


//    get all movies from particular director name;
    @GetMapping("getOnlyMovieNamesUsingDirector/{name}")
    public List<String> getOnlyMovieNamesUsingDirector(@PathVariable("name") String name){
        List<String> moviesList = directorService.getOnlyMovieNamesUsingDirector(name);
        return moviesList;
    }

    @GetMapping("countMoviesCreatedByDirector/{id}")
    public int  countMoviesCreatedByDirector(@PathVariable("id") int directorId){
        return directorService.countMoviesCreatedByDirector(directorId);
    }


    @DeleteMapping("deleteMoviesWithDirectorId/{id}")
    public ResponseEntity<String> deleteMoviesWithDirector(@PathVariable("id") int directorId){
        String response = directorService.deleteMoviesWithDirector(directorId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
