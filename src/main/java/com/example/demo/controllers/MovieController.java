package com.example.demo.controllers;

import com.example.demo.models.Movie;
import com.example.demo.services.MovieAnalysisService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.FileNotFoundException;

//This is a bean - it is handled by the Spring framework
@Controller
public class MovieController {
    MovieAnalysisService movieService = new MovieAnalysisService();

    @ResponseBody
    @GetMapping("/")
    public String helloWorld(){
        return "Friendly Message";
    }

    @ResponseBody
    @GetMapping("/getFirst")
    public String getFirst() throws FileNotFoundException {
        Movie firstMovieOfList = movieService.getFirstMovieOfList();
        return firstMovieOfList.getTitle();
    }
}
