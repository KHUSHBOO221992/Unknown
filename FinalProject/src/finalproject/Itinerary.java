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
public class Itinerary{
    String startPoint;
    String endPoint;
    
    Itinerary(String startPoint, String endPoint){
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }
    
    //get and setters
   public String getStartPoint(){
       return this.startPoint;
   } 
   
   public void setStartPoint(String startPoint){
       this.startPoint = startPoint;
   } 
   
     public String getEndPoint(){
       return this.endPoint;
   } 
   
   public void setEndPoint(String endPoint){
       this.endPoint = endPoint;
   }
}
