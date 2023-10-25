package com.io.DirectorMovie_API.s.Service;

import com.io.DirectorMovie_API.s.Models.Director;
import com.io.DirectorMovie_API.s.Models.Movie;
import com.io.DirectorMovie_API.s.Repository.DirectorRepository;
import com.io.DirectorMovie_API.s.Repository.MovieRepository;
import com.io.DirectorMovie_API.s.RequestDTO.DirectorRequestDto;
import com.io.DirectorMovie_API.s.ResponseDTO.DirectorFindByNameResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
public class DirectorService {

    @Autowired
    DirectorRepository directorRepository;

    @Autowired
    MovieRepository movieRepository;

    public String addDirector(Director director){
        directorRepository.save(director);
        return "director added successfully";
    }

    public boolean deleteDirectorById(Integer id){
        Optional<Director> directorOptional = directorRepository.findById(id);

        if(directorOptional.isPresent()){
            directorRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Director> getAllDirectors (){
        return directorRepository.findAll();
    }

    public String updateDirector(DirectorRequestDto reqDto) throws Exception {
        // we just taken id from request DTO
        Optional<Director> directorOptional = directorRepository.findById(reqDto.getDirectorId());

        if(!directorOptional.isPresent()){
            throw new Exception("author id is invalid Enter valid one");
        }

        // if it's present then we simply set the parameters and saved it again into our repo layer
        Director director = directorOptional.get();
        director.setName(reqDto.getName());
        director.setNumberOfMovies(reqDto.getNumberOfMovies());
        director.setImdbRating(reqDto.getImdbRating());

        directorRepository.save(director);
        return "Director updated successfully";
    }


    public List<DirectorFindByNameResponse> getDirectorByLocation(String location){

        List<DirectorFindByNameResponse> requestList = new ArrayList<>();
        List<Director> directorList = directorRepository.findByLocation(location);

        for(Director director : directorList){
            DirectorFindByNameResponse directorFindByNameResponse =
                    new DirectorFindByNameResponse(director.getName(), director.getLocation(),
                            director.getNumberOfMovies(), director.getImdbRating());

            requestList.add(directorFindByNameResponse);
        }
        return requestList;
    }

    public String deleteAllDirector(){
        directorRepository.deleteAll();
        return "all directors deleted successfully";
    }


    public String getLocationById(int directorId){
        Optional<Director> directorOptional = directorRepository.findById(directorId);
        if(!directorOptional.isPresent()){
            return "id is not valid";
        }
        Director director = directorOptional.get();
        return director.getLocation();
    }

    public String deleteDirectorByName(String name){
        List<Director> directorList =  directorRepository.findAll();

        for(Director director : directorList){
            if(Objects.equals(director.getName(), name)){
                directorRepository.deleteById(director.getDirectorId());
            }
        }
        return "director deleted successfully";
    }


    public List<Movie> getAllMoviesUsingDirectorName(String name){
        List<Movie> movieList = movieRepository.findAll();
        List<Movie> movies = new ArrayList<>();

        for(Movie movie : movieList){
            // we're just checking the name of requested director == name
            if(Objects.equals(movie.getDirector().getName(), name)){
                movies.add(movie);
            }
        }
        return movies;
    }


    public List<String> getOnlyMovieNamesUsingDirector(String name){
        List<Movie> movieList = movieRepository.findAll();
        List<String> movies = new ArrayList<>();

        for(Movie movie : movieList){
//            if(movie.getDirector().getName() == name){ this is the method and below is advance one
            if(Objects.equals(movie.getDirector().getName(), name)){
                movies.add(movie.getName());
            }
        }
        return movies;
    }


    public int countMoviesCreatedByDirector(int directorId){

        int count = directorRepository.findById(directorId).get().getNumberOfMovies();
        return count;
    }

}
