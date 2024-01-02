package com.io.DirectorMovie_API.s.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int directorId;

    @Column(name = "directorName")
    private String name;

    private String location;

    private int numberOfMovies;

    private double imdbRating;

    @JsonIgnore
    @OneToMany(mappedBy = "director", cascade = CascadeType.ALL)
    private List<Movie> movieList = new ArrayList<>();

    // when we create movie then add movie each time in list and we can get the number.
    public void addMovie(Movie movie){
        this.movieList.add(movie);
    }

    public Director(String name, int numberOfMovies, double imdbRating) {
        this.name = name;
        this.numberOfMovies = numberOfMovies;
        this.imdbRating = imdbRating;
    }
}