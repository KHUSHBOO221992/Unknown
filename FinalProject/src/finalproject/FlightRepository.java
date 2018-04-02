package finalproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FlightRepository 
{

    public static List<Flight> listFlights = new ArrayList<Flight>();
    public static List<Fare> lstFares = new ArrayList<Fare>();
    public static List<Passenger> lstPassengers = new ArrayList<Passenger>();
    

    public void addFlight(Itinerary itinerary, DepartureDate departureDate, String number, String pilotName) 
    {

        Flight newFlight = new Flight(itinerary, departureDate, number, pilotName);
        System.out.println("Flight added");
    }

    public void removeFlight(String flightNumber) 
    {
        Flight flightToremove = null;

        for (Flight item : FlightRepository.listFlights) 
        {

            if (item.number == flightNumber) 
            {
                flightToremove = item;
                break;
            }
        }

        FlightRepository.listFlights.remove(flightToremove);

        System.out.println("Flight removed");
    }

    public static Flight getFlight(String number) 
    {
        for (Flight item : FlightRepository.listFlights) 
        {
            if (item.number.equals(number)) 
            {
                return item;
            }
        }
        return null;
    }
    
     public static Passenger getPassenger(Integer passengerID) 
     {
        for (Passenger item : FlightRepository.lstPassengers) 
        {
            if (item.PassengerID == passengerID) 
            {
                return item;
            }
        }
        return null;
    }

    public static void listFlights() 
    {
        System.out.println("All flights");
        for (Flight item : FlightRepository.listFlights) 
        {
            System.out.println("Flight number: " + item.number);
        }
    }
    
        public static void lstPassengers() 
        {
        System.out.println("All passengers");
        for (Passenger item : FlightRepository.lstPassengers) 
        {
            System.out.println("PassengerID: "+ item.PassengerID + " Flight number: " + item.number + " Passenger name: " + item.Identity);
        }
    }
        
        public static void lstFares() 
        {
        System.out.println("All fares");
        for (Fare item : FlightRepository.lstFares) 
        {
            System.out.println("Flight number: " + item.number + " Fare: " + item.price);
        }
    }

    public static void availableFlights() 
    {
        System.out.println("Available flights");

        for (Flight item : FlightRepository.listFlights) 
        {
            if (item.isAvailable) 
            {
                System.out.println("Flight number: " + item.number);
            }
        }
    }

    public static void FlightsOfACertainPassenger(Integer passengerID) 
    {
        System.out.println("Available flights");
        for (Flight item : FlightRepository.listFlights) 
        {

            for (Map.Entry<Seat, Integer> itemList : item.passengerList.entrySet()) 
            {

                if (itemList.getValue() == passengerID) 
                {
                    System.out.println("Flight number: " + item.number);
                    break;
                }
            }
        }
    }
    
    
    public static List<Fare> returnFares(String flightNumber)
    {
        List<Fare> lstFares = new ArrayList<Fare>();
        
        for(Fare item: FlightRepository.lstFares)
        {
            if(item.number == flightNumber)
            {
                lstFares.add(item);
            }
        };
        
        return lstFares;
    }

   
    public static List<Integer> SeatsInAFlightReservedByAPassenger(String flightNumber, Integer passengerID) 
    {

        List<Integer> listSeats = new ArrayList<Integer>();


        for (Flight item : FlightRepository.listFlights) 
        {

            for (Map.Entry<Seat, Integer> itemList : item.passengerList.entrySet()) 
            {

                if (itemList.getValue() == passengerID) 
                {
                    Seat objSeat = new Seat();
                    objSeat.Number = itemList.getKey().Number;
                    listSeats.add(objSeat.Number);
                }
            }
        }
        return listSeats;
    }

    public static void notAvailableFlights() 
    {
        System.out.println("Not available flights");

        for (Flight item : FlightRepository.listFlights) 
        {
            if (!item.isAvailable) 
            {
                System.out.println("Flight number: " + item.number);
            }
        }
    }
}
