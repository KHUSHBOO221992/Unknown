package fproject;

//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Date;

public class DepartureDate 
{
    String date,time;
/*  Date date;
    String Time;
    public String getTime() 
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        return (dateFormat.format(this.date));
    }  */
    
    public DepartureDate()    
    {
        date = "";
        time = "";
    }
 
    public String get_date()
    {
        return this.date;
    }
    
    public String get_time()
    {
        return this.time;
    }  
}
