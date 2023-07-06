/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Objects.Movie;
import Objects.Rent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
            boolean isValidRent = true;
            Movie movie = movieService.findMovieById(movieIndex);
            if(movie.getTitle() == null){
                System.out.println("The movie list is empty");
            }else{
                System.out.println("Please enter the start date for the rental service: (format YYYY/MM/dd)");
                String startDate = sc.next();
                System.out.println("Please enter the end date for the rental service: (format YYYY/MM/dd)");
                String endDate = sc.next();
                if(!validateDates(startDate, endDate)){
                    System.out.println("The end date should be greater than start date");
                }else{
                    if(!validateExistingDates(movie, startDate) || !validateExistingDates(movie, endDate)){
                       System.out.println("The Movie is rented in the selected dates");
                   }else{
                       Rent newRent = new Rent(movie, startDate, endDate);
                       rentList.add(newRent);
                   }
                }
               
            }
        }
    }
    
    public void listRents(){
         System.out.println("This is the entire movie rent list: ");
        if(this.rentList.isEmpty()){
            System.out.println("The movies rent list is empty, you can create a new one.");
        }
        int index = 1;
        for(Rent rent : this.rentList){
            System.out.println(index);
            System.out.println("Movie: " + rent.movie.getTitle() + ", " + "Duration: " + rent.getDays() + ", " + "Price: " + rent.getPrice() + ", " + "StartDate: " + rent.getStartDate() + ", " + "EndDate: " + rent.getEndDate());
            index++;
        }
    }
    private LocalDate calculateDate(String dateToConvert){
         try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

            // Convertir las cadenas de fecha a objetos LocalDate
            LocalDate date = LocalDate.parse(dateToConvert, formatter);
            return date;
             
         }catch (Exception e) {
            e.printStackTrace();
                    return null;
         } 
    }
    private boolean validateExistingDates(Movie movie, String date){
        LocalDate initialDate = calculateDate(date);
        for(Rent rent : this.rentList){
            if(movie.getTitle().equals(rent.movie.getTitle()) && (initialDate.isAfter(rent.getStartDate()) && initialDate.isBefore(rent.getEndDate()) || initialDate.isEqual(rent.getStartDate()) || initialDate.isEqual(rent.getEndDate()))){
                return false;
            }
        }  
        return true;
    }
    private List<Rent> validateExistingDates(String date){
        LocalDate initialDate = calculateDate(date);
        List<Rent> rentsFound = new ArrayList<>();
        for(Rent rent : this.rentList){
            if((initialDate.isAfter(rent.getStartDate()) && initialDate.isBefore(rent.getEndDate()) || initialDate.isEqual(rent.getStartDate()) || initialDate.isEqual(rent.getEndDate()))){
                rentsFound.add(rent);
            }
        }  
        return rentsFound;
    }
    private boolean validateDates(String startDate, String endDate){
        LocalDate initialDate = calculateDate(startDate);        
        LocalDate finalDate = calculateDate(endDate);
        if(finalDate.isBefore(initialDate)){
            return false;
        }
        return true;
    }
    public void findByDate(){
        System.out.println("Enter a date in format yyyy/MM/dd");
        String date = sc.next();
        List<Rent> rents = validateExistingDates(date);
        if(rents.size() == 0){
            System.out.println("No rents were found");
        }else{
            for(Rent rent: rents){
                System.out.println("Movie: " + rent.movie.getTitle() + ", " + "Duration: " + rent.getDays() + ", " + "Price: " + rent.getPrice() + ", " + "StartDate: " + rent.getStartDate() + ", " + "EndDate: " + rent.getEndDate());
            }
        }
    }
}
