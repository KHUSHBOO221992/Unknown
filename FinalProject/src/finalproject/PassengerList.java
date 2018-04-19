/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

/**
 *
 * @author macstudent
 */
public abstract class PassengerList {
    int[] listOfPassengers;
    
    //Flight -> setPassengerSeat
   public abstract int setPassengerSeat(Integer passengerID);
    
    //Flight -> removePassengerSeat
   public abstract int removePassengerSeat(Integer passengerID);
      
    
    }
