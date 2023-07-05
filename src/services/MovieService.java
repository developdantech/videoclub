/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Objects.Movie;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class MovieService {
    private Scanner sc = new Scanner(System.in).useDelimiter("\n");
    
    private List<Movie> movies = new ArrayList<>();
    
    public void createMovie(){
        System.out.println("Please enter the title for the new movie: ");
        String title = sc.next();
        
        System.out.println("Please enter the genre for the new movie: ");
        String genre = sc.next();
        
        System.out.println("Please enter the premier year: ");
        int year = sc.nextInt();
        
        System.out.println("Please enter the duration in format HH:MM:ss ");
        String duration = sc.next();
        Movie newMovie = new Movie(title, genre, year, duration);
        this.movies.add(newMovie);
    }
    
    public void listMovies(){
        System.out.println("This is the entire movie list: ");
        if(movies.isEmpty()){
            System.out.println("The movies list is empty, you can create a new one.");
        }
        int index = 1;
        for(Movie movie : this.movies){
            System.out.println(index);
            System.out.println("Title: " + movie.getTitle() + ", " + "Genre: " + movie.getGenre() + ", " + "Year: " + movie.getYear() + ", " + "Duration: " + movie.getDuration().toString());
            index++;
        }
    }
    
    public boolean isEmptyMovieList(){
        if (this.movies.size() == 0) {
            return true;
        }else{
            return false;
        }
    }
    public Movie findMovieById(int index){
        if(!this.movies.isEmpty() && this.movies.size() <= index){
            return this.movies.get(index-1);
        }
        return new Movie();
    }
            
}
