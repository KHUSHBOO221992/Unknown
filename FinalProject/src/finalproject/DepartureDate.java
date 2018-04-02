/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author macstudent
 */
public class DepartureDate {
    Date date;
    String time;
    
    DepartureDate(Date date, String time){
        this.date = date;
        this.time = time;
    }
    
 public Date getDate() { return this.date; }
 public void setDate(Date date) { this.date = date; }
 
 //gets
public String getTime() {
DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
Date date = new Date();
return (dateFormat.format(this.date));
}
 
}
