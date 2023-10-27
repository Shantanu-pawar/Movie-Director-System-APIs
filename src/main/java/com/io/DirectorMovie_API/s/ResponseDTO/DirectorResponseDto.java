package com.io.DirectorMovie_API.s.ResponseDTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DirectorResponseDto {

    private String name;
    private String location;
    private int numberOfMovies;
}
