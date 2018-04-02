package finalproject;

import java.util.List;
import java.util.Scanner;

public class Passenger extends Flight
{
    Integer PassengerID;
    String Identity;

    public Passenger(Integer PassengerID, String Identity, Itinerary itinerary, DepartureDate departureDate, String number, String pilotName) {
       super(itinerary, departureDate, number, pilotName);
       this.Identity = Identity;
       this.PassengerID = PassengerID;
    }
    
    public void bookFlight()
    {
        Flight flightObject = FlightRepository.getFlight(this.number);
        if (flightObject == null)
        {
            System.out.println("Please select a valid flight number");
        }
        flightObject.setPassengerSeat(this.PassengerID);
    }

    public void cancelFlight()
    {
        
        Flight flightObject = FlightRepository.getFlight(this.number);
        if (flightObject == null)
        {
            System.out.println("Please select a valid flight number");
        }
        flightObject.removePassengerSeat(this.PassengerID);
    }
    
    public void makePayment()
    {
        FlightRepository.availableFlights();
        Scanner input = new Scanner(System.in);
        System.out.println("Select the type of your ticket");
        System.out.println("1 for Business and 2 for Economic");
        Integer flightReservation = input.nextInt();
        
        Ticket objTicket;
        
        if(flightReservation == 1)
        {
        objTicket = new Ticket(FlightSegmentReservationEnum.BUSINESS.toString(), this.PassengerID, this.Identity, itinerary, departureDate, number, pilotName);
        }
        else
        {
        objTicket = new Ticket(FlightSegmentReservationEnum.ECONOMIC.toString(), this.PassengerID, this.Identity, itinerary, departureDate, number, pilotName);
        }
        
        List<Integer> lstInteger = FlightRepository.SeatsInAFlightReservedByAPassenger(this.number, this.PassengerID);
        
        objTicket.computePrice(lstInteger);
        
        System.out.println("Ticket paid");
    }
}
