package fproject;

public class Ticket extends Passenger implements FlightSegmentReservation
{
    @Override
    public void computePrice() 
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
