package fproject;

import java.util.Scanner;
//import javax.tools.DocumentationTool.Location;

public class Itenary 
{
    //Location startPoint;
    //Location endPoint;
    public String startPoint,endPoint = "";
    public double airmiles = 0;
    public int itenaryID = 0;
    
    
    public void display_itenaries()     
    {                   
                           
        System.out.print("***********************************************");
        System.out.print("Destination :" + this.itenaryID);
        System.out.print("Start Source :" + this.startPoint);
        System.out.print("Final Destination :" + this.endPoint);
        System.out.print("Airmiles :" + this.airmiles);
        System.out.print("***********************************************");
    }
    
    public void insert_new_itenary()
    {
        Scanner input = new Scanner(System.in);
        
        System.out.println("************ Khushboo Airlines PVT. LTD. ************\n");
        System.out.println("********************  Insert New Itenary  ***************************");
        System.out.println("\n\n");
                           
        System.out.println("Enter Source Point ;");
        this.startPoint = input.nextLine();
                            
        System.out.println("Enter New Final Destination ;");
        this.endPoint = input.nextLine();
                            
        System.out.println("Enter the total Airmiles between destinations :");
        this.airmiles = input.nextDouble();
    }
}
