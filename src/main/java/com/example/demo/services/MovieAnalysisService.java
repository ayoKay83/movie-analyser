package com.example.demo.services;

import com.example.demo.models.Movie;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class MovieAnalysisService {

    //Instantiated a file from film-new.csv
    File movieList = new File("src/main/resources/static/film-new.csv");

    public Movie getFirstMovieOfList() throws FileNotFoundException {
        Scanner sc = new Scanner(movieList);
        //Skip 2 lines
        sc.nextLine();
        sc.nextLine();
        //Split
        String[] firstMovieAsArray = sc.nextLine().split(";");
        //Created a model from data
        Movie firstMovie = new Movie( //int year, int length, String title
                Integer.parseInt(firstMovieAsArray[0]), Integer.parseInt(firstMovieAsArray[1]), firstMovieAsArray[2]
        );
        return firstMovie;
    }

    public Movie getRandomMovieOfList() throws FileNotFoundException {
        Scanner in = new Scanner(movieList);
        Random r = new Random();
        ArrayList<Movie> randomMovieArray = new ArrayList<>();
        //Skip 2 lines
        in.nextLine();
        in.nextLine();

        while (in.hasNextLine()) {
            String[] arr = in.nextLine().split(";");
            Movie m = new Movie(  //int year, int length, String title, String genre, int popularity, String award
                    Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), arr[2], arr[3], Integer.parseInt(arr[4]), arr[5]);
            randomMovieArray.add(m);

        }
        return randomMovieArray.get(r.nextInt(randomMovieArray.size()));
    }

    public ArrayList<Movie> sortetByPopularity() throws FileNotFoundException {
        ArrayList<Movie> sortetArrList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Movie m = getRandomMovieOfList();
            sortetArrList.add(m);
        }   //CompareTo annotation in Movie model compares popularity
        Collections.sort(sortetArrList);
        return sortetArrList;
    }

    public int wonAnAward() throws FileNotFoundException {
        Scanner in = new Scanner(movieList);
        ArrayList<Movie> awardArrList = new ArrayList<>();
        int nmbOfMoviesWonAward = 0;

        in.nextLine();
        in.nextLine();

        //Adding movie object to arrayList
        while (in.hasNextLine()) {
            String[] arr = in.nextLine().split(";");
            Movie m = new Movie(
                    Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), arr[2], arr[3], Integer.parseInt(arr[4]), arr[5]);
            awardArrList.add(m);
        }
        //traversing the Arraylist counting when award equals "yes"
        for (int i = 0; i < awardArrList.size() - 1; i++) {
            if (awardArrList.get(i).gotAward().equalsIgnoreCase("yes")) {
                nmbOfMoviesWonAward++;
            }
        }
        return nmbOfMoviesWonAward;
    }
}


