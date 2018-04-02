package finalproject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class FinalProject 
{
    public static void main(String[] args) 
    {
        ShowMenu();
    }

    public static Date ConvertToDate(String dateInput) 
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("DD-MM-YYYY");
        Date date2 = null;

        try 
        {
          date2 = dateFormat.parse(dateInput);
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return date2;
    }

    public static void AddFlight() 
    {
        Scanner input = new Scanner(System.in);
        System.out.println("*************** Create Itinerary ***************");
        System.out.println("Start-Point:");
        String startPoint = input.nextLine();
        System.out.println("End-Point:");
        String endPoint = input.nextLine();
        Itinerary objItinerary = new Itinerary(startPoint, endPoint);
        System.out.println("Itinerary Created.");
        System.out.println("");

        System.out.println("*************** Create Departure Details ***************");
        System.out.println("Departure-Date (DD-MM-YYYY):");
        String dateInput = input.nextLine();
        System.out.println("Departure-Time (HH-MM-SS):");
        String departureTime = input.nextLine();
        DepartureDate objDeparture = new DepartureDate(ConvertToDate(dateInput), departureTime);
        System.out.println("Departure Date Created.");
        System.out.println("");

        System.out.println("*************** Flight Details *************** ");
        System.out.println("Flight Number:");
        String numberFlight = input.nextLine();
        System.out.println("Pilot Name:");
        String pilotName = input.nextLine();
        Flight objFlight = new Flight(objItinerary, objDeparture, numberFlight, pilotName);
        System.out.println("Flight Created.");
        System.out.println("");
        FlightRepository.listFlights.add(objFlight);

        ShowMenu();
    }

    public static void AddPassenger() 
    {
        Scanner input = new Scanner(System.in);
        System.out.println("*************** Flight Details  ***************");
        System.out.println(" Valid Flight Number: ");
        String flightNumber = input.nextLine();
        Flight objFlight = FlightRepository.getFlight(flightNumber);

        if (objFlight == null) 
        {
            System.out.println("Sorry....Invalid Flight Number??....");
            System.out.println("");
        } 
        else 
        {

            System.out.println("*************** Passenger Details  ***************");
            System.out.println("PassengerID(No.):");
            Integer passengerID = input.nextInt();
            input.nextLine();
            System.out.println("Passenger(Name):");
            String passengerIdentity = input.nextLine();

            Passenger objPassenger = new Passenger(passengerID, passengerIdentity, objFlight.itinerary, objFlight.departureDate, objFlight.number, objFlight.pilotName);
            FlightRepository.lstPassengers.add(objPassenger);

            System.out.println("Passenger Created.");
            System.out.println("");

        }

        ShowMenu();
    }

    public static void AddFare() 
    {
        Scanner input = new Scanner(System.in);
        System.out.println("*************** Flight Details  ***************");
        System.out.println("Valid Flight Number:");
        String flightNumber = input.nextLine();
        Flight objFlight = FlightRepository.getFlight(flightNumber);

        if (objFlight == null) 
        {
            System.out.println("Sorry....Invalid Flight Number??....");
            System.out.println("");
        } else 
        {

            System.out.println("*************** Fare Details  ***************");
            System.out.println("Fare (int):");
            Double farePrice = input.nextDouble();

            Fare objFare = new Fare(farePrice, objFlight.itinerary, objFlight.departureDate, objFlight.number, objFlight.pilotName);
            FlightRepository.lstFares.add(objFare);

            System.out.println("Fare Created.");
            System.out.println("");
        }

        ShowMenu();
    }

    public static void ListFlights() 
    {
        FlightRepository.listFlights();
        System.out.println("");

        ShowMenu();
    }

    public static void ListPassengers() 
    {
        FlightRepository.lstPassengers();
        System.out.println("");

        ShowMenu();
    }

    public static void ListFares() 
    {
        FlightRepository.lstFares();
        System.out.println("");

        ShowMenu();
    }

    public static void SetPassengerSeat() 
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter Valid Flight Number:");
        String flightNumber = input.nextLine();
        Flight objFlight = FlightRepository.getFlight(flightNumber);

        if (objFlight == null) 
        {
            System.out.println("Sorry....Invalid Flight Number??....");
            System.out.println("");
        } 
        else 
        {

            System.out.println("Enter Valid PassengerID:");
            Integer passengerID = input.nextInt();
            Passenger objPassenger = FlightRepository.getPassenger(passengerID);

            if (objPassenger == null) 
            {
                System.out.println("Sorry....Invalid Passenger ID ??....");
                System.out.println("");
            } 
            else 
            {
                objPassenger.bookFlight();
                objFlight.showSeatsStatus();
            }

        }
        ShowMenu();
    }
    
    public static void MakeThePayment() 
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter Valid Flight Number:");
        String flightNumber = input.nextLine();
        Flight objFlight = FlightRepository.getFlight(flightNumber);

        if (objFlight == null) 
        {
            System.out.println("Sorry....Invalid Flight Number??....");
            System.out.println("");
        } 
        else 
        {

            System.out.println("Type a valid passengerID");
            Integer passengerID = input.nextInt();
            Passenger objPassenger = FlightRepository.getPassenger(passengerID);

            if (objPassenger == null) 
            {
                System.out.println("Sorry....Invalid Passenger ID ??....");
                System.out.println("");
            } else 
            {
                objPassenger.makePayment();
            }

        }
        ShowMenu();
    }

    public static void ShowMenu() 
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Main Menu: ");
        System.out.println("A. Add A New Flight");
        System.out.println("B. Add A New Passenger");
        System.out.println("C. Add Fare To Flight");
        System.out.println("D. List Of All Flights");
        System.out.println("E. List Of All Passengers");
        System.out.println("F. List Of All Fares");
        System.out.println("G. Set A Seat To Passanger");
        System.out.println("H. Make Payment For Reservation");
        System.out.println("I. Quit");

        String inputUser = input.next();

        switch (inputUser) 
        {
            case "A":
            {
                System.out.println("^^^^^^^^^^^^^^   Add A Flight   ^^^^^^^^^^^^");
                System.out.println("A. Create Itinerary.");
                System.out.println("B. Create Departure Date.");
                System.out.println("C. Create Flight Details.");
                System.out.println("");
                AddFlight();
                break;
            }    
            case "B":
            {
                System.out.println("^^^^^^^^^^^^  Add A Passenger  ^^^^^^^^^^^^^^");
                System.out.println("A. Give Valid Flight Number.");
                System.out.println("B. Enter Passenger Details.");
                System.out.println("");
                AddPassenger();
                break;
            }
            case "C":
            {
                System.out.println("^^^^^^^^^^^^^^^^^ Adding Fare ^^^^^^^^^^^^^^^^^^^^ ");
                System.out.println("A. Give Valid Flight Number.");
                System.out.println("B. Enter Fare Details.");
                System.out.println("");
                AddFare();
                break;
            }
            case "D":
                ListFlights();
                break;
            case "E":
                ListPassengers();
                break;
            case "F":
                ListFares();
                break;
            case "G":
                SetPassengerSeat();
                break;
            case "H":
                MakeThePayment();
                break;
            case "I":
                System.out.println("Invalid Entry");
                break;
            default:
                System.out.println("$$$$$-----Presented By : Khushboo(C0684620)-----$$$$$");
                break;
        }
    }

}
