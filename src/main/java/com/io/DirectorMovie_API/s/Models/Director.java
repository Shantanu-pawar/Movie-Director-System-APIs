package com.io.DirectorMovie_API.s.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int directorId;

    @Column(name = "directorName")
    private String name;
    private String location;

    private int numberOfMovies;
    private double imdbRating;


    @OneToMany(mappedBy = "director", cascade = CascadeType.ALL)
    private List<Movie> movieList = new ArrayList<>();


    public void addMovie(Movie movie){
        this.movieList.add(movie);
    }

    public Director() {
    }


    public Director(String name, int numberOfMovies, double imdbRating) {
        this.name = name;
        this.numberOfMovies = numberOfMovies;
        this.imdbRating = imdbRating;
    }
}