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
    public void initialMovie(){
        this.movies.add(new Movie("Titanic","Drama", 1984,"03:03:03"));
    }
    public void findByTitle(){
        System.out.println("Enter the title:");
        String titleToFind = sc.next();
        boolean found = false;
        int index = 0;
        for(Movie movie : this.movies){
            if(movie.getTitle().toLowerCase().contains(titleToFind.toLowerCase())){
                if(index == 0){
                    System.out.println("Movie(s) found:");
                }
                System.out.println("Title: " + movie.getTitle() + ", " + "Genre: " + movie.getGenre() + ", " + "Year: " + movie.getYear() + ", " + "Duration: " + movie.getDuration());
                found = true;
                index++;
            }
        }
        if(!found){
            System.out.println("Movie not found");
        }
    }       
    public void findByGenre(){
        System.out.println("Enter the genre:");
        String genreToFind = sc.next();
        boolean found = false;
        int index = 0;
        for(Movie movie : this.movies){
            if(movie.getGenre().toLowerCase().contains(genreToFind.toLowerCase())){
                if(index == 0){
                    System.out.println("Movie(s) found:");
                }
                System.out.println("Title: " + movie.getTitle() + ", " + "Genre: " + movie.getGenre() + ", " + "Year: " + movie.getYear() + ", " + "Duration: " + movie.getDuration());
                found = true;
                index++;
            }
        }
        if(!found){
            System.out.println("Movie not found");
        }
    } 
    
}
