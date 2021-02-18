package com.example.demo.controllers;

import com.example.demo.models.Movie;
import com.example.demo.services.MovieAnalysisService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.FileNotFoundException;
import java.util.ArrayList;

//This is a bean - it is handled by the Spring framework
@Controller
public class MovieController {
    MovieAnalysisService movieService = new MovieAnalysisService();
    //MovieAnalysisService randomMovie = new MovieAnalysisService();

    @ResponseBody
    @GetMapping("/")
    public String welcome(){
        return "Hello Friend, and welcome to this MovieAnalyzer page.";
    }

    @ResponseBody
    @GetMapping("/getFirst")
    public String getFirst() throws FileNotFoundException {
        Movie firstMovieOfList = movieService.getFirstMovieOfList();
        return firstMovieOfList.getTitle();
    }
    @ResponseBody
    @GetMapping("/getRandom")
    public String getRandom() throws FileNotFoundException {
        Movie randomMovieOfList = movieService.getRandomMovieOfList();
        return randomMovieOfList.getTitle();
    }
    @ResponseBody
    @GetMapping("/getSortedList")
    public ArrayList <Movie> getSorted() throws FileNotFoundException {
        return movieService.sortetByPopularity();

    }
    @ResponseBody
    @GetMapping("/getWonAwards")
    public String getWonAwards() throws FileNotFoundException {
        int nmbOfAwards = movieService.wonAnAward();
        return "The total amount of movies that won an award is: " + nmbOfAwards;
    }

}
