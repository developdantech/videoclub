/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videoclub;

import Objects.Movie;
import Objects.Rent;
import java.util.Scanner;
import services.MovieService;
import services.RentService;

/**
 *
 * @author User
 */
public class VideoClub {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        MovieService movieService = new MovieService();
        RentService rentService = new RentService(movieService);
        int option = 0;
        System.out.println("Welcome to your movie club, please select an option to start");
        
        do{
            System.out.println("1. Crete movie. \n"
                    + "2. List movies. \n"
                    + "3. Create a Rent. \n"
                    + "4. List Rented movies \n"
                    + "9. Finish");
            option = sc.nextInt();
            
            switch(option){
                case 1: 
                    movieService.createMovie(); //Test
                    break;
                case 2:
                    movieService.listMovies();
                    break;
                case 3:
                    rentService.createRent();
                    break;
                case 4:
                    rentService.listRents();
                    break;
                case 9:
                    System.out.println("Good bye!");
                    break;
                default:
                    System.out.println("Select a valid option");
                    
            }
        }while(option != 9);

    }
                                                                                         
}
