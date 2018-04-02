/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * PassengerID needs to be unique
 */
public class Passenger extends Flight{
    Integer PassengerID;
    String Identity;

    public Passenger(Integer PassengerID, String Identity, Itinerary itinerary, DepartureDate departureDate, String number, String pilotName) {
       super(itinerary, departureDate, number, pilotName);
       this.Identity = Identity;
       this.PassengerID = PassengerID;
    }
    
    //set the flight as false when all the seats are reserved
    public void bookFlight(){
        //Steps
        //1 Show the available flights. (at least one seat with 0)
        //2 User select a flight, and the system automatically set the seat with his id. he is not able to select the seat
        //3 User confirm the reservation        
        //4 Flight reserved
        
        //1
        //FlightRepository.availableFlights();
        //Scanner input = new Scanner(System.in);
        //String flightNumber = input.nextLine();
        
        //2,3 and 4
        Flight flightObject = FlightRepository.getFlight(this.number);
        if (flightObject == null){
            System.out.println("Please select a valid flight number");
        }
        flightObject.setPassengerSeat(this.PassengerID);
    }

    public void cancelFlight(){
        //Steps
        //1 Show the flights that the user has reserved
        //FlightRepository.availableFlightsForACertainPassenger(PassengerID);
        
        //2 User select a flight, and the system automatically 
        //Scanner input = new Scanner(System.in);
        //String flightNumber = input.nextLine();
        
        Flight flightObject = FlightRepository.getFlight(this.number);
        if (flightObject == null){
            System.out.println("Please select a valid flight number");
        }
        flightObject.removePassengerSeat(this.PassengerID);
    }
    
    public void makePayment(){
        FlightRepository.availableFlights();
        Scanner input = new Scanner(System.in);
        System.out.println("Select the type of your ticket");
        System.out.println("1 for Business and 2 for Economic");
        Integer flightReservation = input.nextInt();
        
        Ticket objTicket;
        
        if(flightReservation == 1){
        objTicket = new Ticket(FlightSegmentReservationEnum.BUSINESS.toString(), this.PassengerID, this.Identity, itinerary, departureDate, number, pilotName);
        }else{
        objTicket = new Ticket(FlightSegmentReservationEnum.ECONOMIC.toString(), this.PassengerID, this.Identity, itinerary, departureDate, number, pilotName);
        }
        
        List<Integer> lstInteger = FlightRepository.SeatsInAFlightReservedByAPassenger(this.number, this.PassengerID);
        
        objTicket.computePrice(lstInteger);
        
        System.out.println("Ticket paid");
    }
}
