package com.io.DirectorMovie_API.s.RequestDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DirectorRequestDto {

    private int directorId;
    private String name;
    private int numberOfMovies;
    private double imdbRating;

}
