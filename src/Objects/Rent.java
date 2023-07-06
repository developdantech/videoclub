/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.*;
import java.time.format.*;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author User
 */
public class Rent {
    public Movie movie;
    private LocalDate startDate;
    private LocalDate endDate;
    private double price;
    private int dailyPrice = 10;
    private int defaultDays = 3;
    
    public Rent(Movie movie, String startDate, String endDate){
       
        this.movie = movie;
        this.startDate = calculateDate(startDate);
        this.endDate = calculateDate(endDate);
        this.price = calculatePrice(); 
    }
    
    private double calculatePrice(){
          // Calcular la diferencia en días
        long days = ChronoUnit.DAYS.between(this.startDate, this.endDate);
        double price = 0;
        if(days <= this.defaultDays){
            price = this.dailyPrice;
            return price;
        }else{
            for(int i = 1; i <= (days - this.defaultDays); i++){
                if(i == 1){
                    price = this.dailyPrice;
                }
                price += price * 0.1;
            }
            return price;
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
    public double getPrice(){
        return this.price;
    }
    public long getDays(){
        return ChronoUnit.DAYS.between(this.startDate, this.endDate);
    }
    public LocalDate getStartDate(){
        return this.startDate;
    }
    public LocalDate getEndDate(){
        return this.endDate;
    }
}
