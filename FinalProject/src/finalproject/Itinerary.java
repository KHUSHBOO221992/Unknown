package finalproject;

public class Itinerary
{
    String startPoint;
    String endPoint;
    
    Itinerary(String startPoint, String endPoint)
    {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }
    
   public String getStartPoint()
   {
       return this.startPoint;
   } 
   
   public void setStartPoint(String startPoint)
   {
       this.startPoint = startPoint;
   } 
   
     public String getEndPoint()
     {
       return this.endPoint;
   } 
   
   public void setEndPoint(String endPoint)
   {
       this.endPoint = endPoint;
   }
}
