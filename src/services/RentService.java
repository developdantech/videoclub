/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Objects.Movie;
import Objects.Rent;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class RentService {
    private Scanner sc = new Scanner(System.in);
    private MovieService movieService;
    
    private List<Rent> rentList = new ArrayList<>();
    
    public RentService(MovieService movieService){
        this.movieService = movieService;
    }
    
    public void createRent(){
        if (movieService.isEmptyMovieList()) {
            System.out.println("The movie list is empty, please select another option.");
        }else{
            System.out.println("Select a movie from the list");
            movieService.listMovies();
            int movieIndex = sc.nextInt();
            Movie movie = movieService.findMovieById(movieIndex);
            if(movie.getTitle() == null){
                System.out.println("The movie list is empty");
            }else{
                System.out.println("Please enter the start date for the rental service: (format YYYY/MM/dd)");
                String startDate = sc.next();
                System.out.println("Please enter the end date for the rental service: (format YYYY/MM/dd)");
                String endDate = sc.next();
                Rent newRent = new Rent(movie, startDate, endDate);
                rentList.add(newRent);
            }
        }
    }
    
    public void listRents(){
         System.out.println("This is the entire movie list: ");
        if(this.rentList.isEmpty()){
            System.out.println("The movies list is empty, you can create a new one.");
        }
        int index = 1;
        for(Rent rent : this.rentList){
            System.out.println(index);
            System.out.println("Movie: " + rent.movie.getTitle() + ", " + "Duration: " + rent.getDays() + ", " + "Price: " + rent.getPrice());
            index++;
        }
    }
}
