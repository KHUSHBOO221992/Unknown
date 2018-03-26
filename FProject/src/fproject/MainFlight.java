package fproject;

//import java.util.Date;
//import javax.tools.DocumentationTool.Location;

public class MainFlight extends Fares implements DepartingDate
{
    @Override
    public String get_date() 
    {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public String get_time() 
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

/*public class MainFlight            this is what teacher wants....
{
    Itinerary itinerary;
    DepartureDate departureDate;
    
    String number;
    String pilotName;
    
    public void getItinerary()
    {
        
    }
    
    //gets and setters
    public String getNumber() 
    { 
        return this.number; 
    }
    public void setNumber(String name)
    { 
        this.number = number; 
    }
}
*/
