package finalproject;

import java.util.List;

interface IFlightSegmentReservation
{
    
    String[] FlightSegmentReservationTypes = {FlightSegmentReservationEnum.BUSINESS.toString(),FlightSegmentReservationEnum.ECONOMIC.toString() };
    
     void computePrice(List<Integer> lstSeatsReservedByPassenger);
}
