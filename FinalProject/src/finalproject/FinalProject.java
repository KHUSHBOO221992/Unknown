/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Created flight as abstract class because every class is using it, and the
 * flight is just to display some values
 *
 * @author macstudent
 */
public class FinalProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Steps
        // 1 Create the flight
        // 2 Create the passanger

        //In order to test the output, you must create at least 2 objects of each
        //non_abstract class.
        ShowMenu();
    }

    public static Date ConvertToDate(String dateInput) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date2 = null;

        try {
            //Parsing the String
            date2 = dateFormat.parse(dateInput);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return date2;
    }

    public static void AddFlight() {

        System.out.println("Steps to create a flight: ");
        System.out.println("1: Create the Itinerary");
        System.out.println("2: Create the Departure date");
        System.out.println("3: Type the number and pilotName");
        System.out.println("");

        //1 Itinerary itinerary, DepartureDate departureDate, String number, String pilotName
        Scanner input = new Scanner(System.in);
        System.out.println("Starting step 1: Creation of itinerary");
        System.out.println("Type startPoint of itinerary");
        String startPoint = input.nextLine();
        System.out.println("Type endPoint of itinerary");
        String endPoint = input.nextLine();
        Itinerary objItinerary = new Itinerary(startPoint, endPoint);
        System.out.println("Itinerary created");
        System.out.println("");

        System.out.println("Starting step 2: Creation of Departure date");
        System.out.println("Type the departureDate (dd-MM-yyyy)");
        String dateInput = input.nextLine();
        System.out.println("Type the timeDeparture (hh-mm-ss)");
        String departureTime = input.nextLine();
        DepartureDate objDeparture = new DepartureDate(ConvertToDate(dateInput), departureTime);
        System.out.println("Departure date created");
        System.out.println("");

        System.out.println("Starting step 3");
        System.out.println("Type the number flight");
        String numberFlight = input.nextLine();
        System.out.println("Type the pilot Name");
        String pilotName = input.nextLine();
        Flight objFlight = new Flight(objItinerary, objDeparture, numberFlight, pilotName);
        System.out.println("Flight created");
        System.out.println("");
        FlightRepository.listFlights.add(objFlight);

        ShowMenu();
    }

    public static void AddPassenger() {

        System.out.println("Steps to create a passenger: ");
        System.out.println("1: Insert a valid flight number");
        System.out.println("2: Provide the passenger details");
        System.out.println("");

        //Integer PassengerID, String Identity, Itinerary itinerary, DepartureDate departureDate, String number, String pilotName
        //1 Itinerary itinerary, DepartureDate departureDate, String number, String pilotName
        Scanner input = new Scanner(System.in);
        System.out.println("Starting step 1:");
        System.out.println("Type a valid flight number");
        String flightNumber = input.nextLine();
        Flight objFlight = FlightRepository.getFlight(flightNumber);

        if (objFlight == null) {
            System.out.println("You inserted a non valid flight number");
            System.out.println("");
        } else {

            System.out.println("Starting step 2");
            System.out.println("Type the PassengerID (int)");
            Integer passengerID = input.nextInt();
            //The problem about nextLine teacher taught us
            input.nextLine();
            System.out.println("Type the Identity (name)");
            String passengerIdentity = input.nextLine();

            Passenger objPassenger = new Passenger(passengerID, passengerIdentity, objFlight.itinerary, objFlight.departureDate, objFlight.number, objFlight.pilotName);
            FlightRepository.lstPassengers.add(objPassenger);

            System.out.println("Passenger created");
            System.out.println("");

        }

        ShowMenu();
    }

    public static void AddFare() {
        System.out.println("Steps to create a fare: ");
        System.out.println("1: Insert a valid flight number");
        System.out.println("2: Provide the fare details");
        System.out.println("");

        //Integer PassengerID, String Identity, Itinerary itinerary, DepartureDate departureDate, String number, String pilotName
        //1 Itinerary itinerary, DepartureDate departureDate, String number, String pilotName
        Scanner input = new Scanner(System.in);
        System.out.println("Starting step 1:");
        System.out.println("Type a valid flight number");
        String flightNumber = input.nextLine();
        Flight objFlight = FlightRepository.getFlight(flightNumber);

        if (objFlight == null) {
            System.out.println("You inserted a non valid flight number");
            System.out.println("");
        } else {

            System.out.println("Starting step 2");
            System.out.println("Type the Fare price (int)");
            Double farePrice = input.nextDouble();
            //The problem about nextLine teacher taught us

            Fare objFare = new Fare(farePrice, objFlight.itinerary, objFlight.departureDate, objFlight.number, objFlight.pilotName);
            FlightRepository.lstFares.add(objFare);

            System.out.println("Fare created");
            System.out.println("");
        }

        ShowMenu();
    }

    public static void ListFlights() {
        FlightRepository.listFlights();
        System.out.println("");

        ShowMenu();
    }

    public static void ListPassengers() {
        FlightRepository.lstPassengers();
        System.out.println("");

        ShowMenu();
    }

    public static void ListFares() {
        FlightRepository.lstFares();
        System.out.println("");

        ShowMenu();
    }

    public static void SetPassengerSeat() {
        Scanner input = new Scanner(System.in);

        System.out.println("Type a valid flight number");
        String flightNumber = input.nextLine();
        Flight objFlight = FlightRepository.getFlight(flightNumber);

        if (objFlight == null) {
            System.out.println("You inserted a non valid flight number");
            System.out.println("");
        } else {

            System.out.println("Type a valid passengerID");
            Integer passengerID = input.nextInt();
            Passenger objPassenger = FlightRepository.getPassenger(passengerID);

            if (objPassenger == null) {
                System.out.println("You inserted a non valid passengerID");
                System.out.println("");
            } else {
                objPassenger.bookFlight();
                objFlight.showSeatsStatus();
            }

        }
        ShowMenu();
    }
    
    public static void MakeThePayment() {
        Scanner input = new Scanner(System.in);

        System.out.println("Type a valid flight number");
        String flightNumber = input.nextLine();
        Flight objFlight = FlightRepository.getFlight(flightNumber);

        if (objFlight == null) {
            System.out.println("You inserted a non valid flight number");
            System.out.println("");
        } else {

            System.out.println("Type a valid passengerID");
            Integer passengerID = input.nextInt();
            Passenger objPassenger = FlightRepository.getPassenger(passengerID);

            if (objPassenger == null) {
                System.out.println("You inserted a non valid passengerID");
                System.out.println("");
            } else {
                objPassenger.makePayment();
            }

        }
        ShowMenu();
    }

    public static void ShowMenu() {
        Scanner input = new Scanner(System.in);
        System.out.println("Menus: ");
        System.out.println("1: Add flight");
        System.out.println("2: Add passenger");
        System.out.println("3: Add fare");
        System.out.println("4: List flights");
        System.out.println("5: List passengers");
        System.out.println("6: List fares");
        System.out.println("7: Set passanger seat");
        System.out.println("8: Make the payment");
        System.out.println("9: Exit");

        String inputUser = input.next();

        switch (inputUser) {
            case "1":
                AddFlight();
                break;
            case "2":
                AddPassenger();
                break;
            case "3":
                AddFare();
                break;
            case "4":
                ListFlights();
                break;
            case "5":
                ListPassengers();
                break;
            case "6":
                ListFares();
                break;
            case "7":
                SetPassengerSeat();
                break;
            case "8":
                MakeThePayment();
                break;
            case "0":
                System.out.println("Thanks for using the software");
                break;
            default:
                System.out.println("Thanks for using the software");
                break;
        }
    }

}
