/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

/**
 *
 * @author macstudent
 */
public class Fare extends Flight{
    double price;
    
    public Fare(Double price, Itinerary itinerary, DepartureDate departureDate, String number, String pilotName) {
        super(itinerary, departureDate, number, pilotName);
        this.price = price;
    }
    
    public double getPrice(){
        return this.price;
    }
    
    public void setPrice(double price){
        this.price = price;
    }
}
