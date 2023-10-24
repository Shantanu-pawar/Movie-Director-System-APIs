package com.io.DirectorMovie_API.s.Service;

import com.io.DirectorMovie_API.s.Models.Director;
import com.io.DirectorMovie_API.s.Repository.DirectorRepository;
import com.io.DirectorMovie_API.s.RequestDTO.DirectorRequestDto;
import com.io.DirectorMovie_API.s.ResponseDTO.DirectorFindByNameResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DirectorService {

    @Autowired
    DirectorRepository directorRepository;

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

//
//    public String deleteDirectorByName(String name){
//
////        Optional<Director> optionalDirector = directorRepository.deleteby(name);
////        return "director deleted successfully";
//    }

}
