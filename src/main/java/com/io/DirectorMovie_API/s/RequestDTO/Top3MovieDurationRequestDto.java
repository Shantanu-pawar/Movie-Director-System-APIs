package com.io.DirectorMovie_API.s.RequestDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Top3MovieDurationRequestDto {

    private String name;
    private int durationInMinutes;
}
