package fproject;

import java.util.Scanner;

public class Fares 
{
    
/*    public class Fare extends MainFlight
    {
    int price;

    public Fare(int price) 
    {
        this.price = price;
    }
    }   */
    public Fares()
    {
        rate = 0;
        airline_name = "";
        itenary_id = "";
    }
   
    private double rate ;
    private String airline_name,itenary_id ;
    
    public void insert_new_fare()
    {
        Scanner input = new Scanner(System.in);
        
        System.out.println("************ Khushboo Airlines PVT. LTD. ************\n");
        System.out.println("********************  Insert New Fare  ***************************");
        System.out.println("\n\n");
                           
        System.out.println("Enter the Itenary ID:");
        this.itenary_id = input.nextLine();
                     
        System.out.println("Enter Airline Name:");
        this.airline_name = input.nextLine();
                            
        System.out.println("Enter New Fare :");
        this.rate  = input.nextDouble();
    }
    
    public void display_fare()
    {
        System.out.print("***********************************************");
        System.out.print("Itenary ID :" + this.itenary_id);
        System.out.print("Airline Name :" + this.airline_name);
        System.out.print("Fare :" + this.rate);                           
        System.out.print("***********************************************");
    }
    
    public double return_fare()
    {
        return this.rate;
    }
    
    public void set_fare(double input_fare)
    {
        this.rate = input_fare;
    }
}
