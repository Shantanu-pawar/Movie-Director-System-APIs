package com.io.DirectorMovie_API.s.ResponseDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DirectorFindByNameResponse {

    private String name;
    private String location;

    private int numberOfMovies;
    private double imdbRating;

    public DirectorFindByNameResponse(String name, String location, int numberOfMovies, double imdbRating) {
        this.name = name;
        this.location = location;
        this.numberOfMovies = numberOfMovies;
        this.imdbRating = imdbRating;
    }
}
