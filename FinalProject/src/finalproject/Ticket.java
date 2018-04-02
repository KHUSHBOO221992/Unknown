/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.util.List;

/*
 * Business = Great food and ipads, bigger seats
 * Economic = just bread/water and mp3
 */
public class Ticket extends Passenger implements IFlightSegmentReservation {

    String segmentSelected;

    Ticket(String SegmentSelected, Integer PassengerID, String Identity, Itinerary itinerary, DepartureDate departureDate, String number, String pilotName) {
        super(PassengerID, Identity, itinerary, departureDate, number, pilotName);
        this.segmentSelected = SegmentSelected;
    }

    @Override
    public void computePrice(List<Integer> lstSeatsReservedByPassenger) {
        //Fare
        //1 flight can have a lot of fares
        //Find all the fares, and then apply it to the price
        List<Fare> lstFares = FlightRepository.returnFares(number);
        double totalFaresAmount = 0;
        for (Fare item : lstFares) {
            totalFaresAmount = totalFaresAmount + item.price;
        }

        //number of seats * segmentSelected
        Integer numberOfReservedSeats = lstSeatsReservedByPassenger.size();
        double totalAmount = totalFaresAmount;

        if (this.segmentSelected == FlightSegmentReservationEnum.BUSINESS.toString()) {
            totalAmount = totalAmount + (numberOfReservedSeats * 8);
        } else {
            totalAmount = totalAmount + (numberOfReservedSeats * 2);
        }

        System.out.println("Payemnt details: ");
        System.out.println("Total fares amount: " + totalFaresAmount);
        System.out.println("Number of reserved seats: " + numberOfReservedSeats);
        System.out.println("Type of segment: " + this.segmentSelected);
        System.out.println("Total amount: " + totalAmount);
    }

}
