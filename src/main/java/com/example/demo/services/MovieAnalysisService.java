package com.example.demo.services;

import com.example.demo.models.Movie;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MovieAnalysisService {

    public Movie getFirstMovieOfList() throws FileNotFoundException {
        //Instantiated a file from film-new.csv
        File movieList = new File("src/main/resources/static/film-new.csv");
        //Scanner
        Scanner sc = new Scanner(movieList);
        //Skip 2 lines
        sc.nextLine();
        sc.nextLine();
        //Split
        String[] firstMovieAsArray = sc.nextLine().split(";");
        //Created a model from data
        Movie firstMovie = new Movie(
                Integer.parseInt(firstMovieAsArray[0]),Integer.parseInt(firstMovieAsArray[1]),firstMovieAsArray[2]
        );
        return firstMovie;
    }
}
