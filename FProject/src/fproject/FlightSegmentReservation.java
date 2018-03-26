package fproject;

interface FlightSegmentReservation 
{
    String[] FlightSegmentReservationTypes = {FlightSegmentReservationEnum.BUSINESS.toString(),FlightSegmentReservationEnum.ECONOMIC.toString() };
    
    
    void computePrice();
}
