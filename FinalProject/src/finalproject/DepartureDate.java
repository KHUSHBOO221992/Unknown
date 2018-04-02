package finalproject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DepartureDate 
{
    Date date;
    String time;
    
    DepartureDate(Date date, String time)
    {
        this.date = date;
        this.time = time;
    }
    
 public Date getDate() 
 { 
     return this.date; 
 }
 public void setDate(Date date) 
 { 
     this.date = date; 
 }
 
 
public String getTime() 
{
DateFormat dateFormat = new SimpleDateFormat("HH:MM:SS");
Date date = new Date();
return (dateFormat.format(this.date));
}
 
}
