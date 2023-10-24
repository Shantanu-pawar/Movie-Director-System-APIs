package com.io.DirectorMovie_API.s.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int MovieId;

    @Column(name = "Movie name",unique = true)
    private String name;

    private int durationInMinutes;

    private double imdbRating;

    @ManyToOne
    @JoinColumn
    private Director director;


    public Movie() {
    }

    public Movie(String name, int durationInMinutes, double imdbRating) {
        this.name = name;
        this.durationInMinutes = durationInMinutes;
        this.imdbRating = imdbRating;
    }
}