package com.io.DirectorMovie_API.s.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
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

    public Movie(String name, int durationInMinutes, double imdbRating) {
        this.name = name;
        this.durationInMinutes = durationInMinutes;
        this.imdbRating = imdbRating;
    }
}