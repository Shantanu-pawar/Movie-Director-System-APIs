package com.io.DirectorMovie_API.s.ResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TopRatedMovieResponseDto {

    private String name;
    private int durationInMinutes;
    private String location;
}
