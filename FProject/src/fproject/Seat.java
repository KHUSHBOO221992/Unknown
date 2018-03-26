package fproject;

import java.util.Scanner;

public class Seat 
{
   // int Number;
    boolean[] seats = new boolean[11];
    Scanner input = new Scanner(System.in);
    
    public void start()
    {       
        while ( true )
        {
            makeReservation();
        }   
    }
    
    public void makeReservation()
    {
        System.out.println("Please type 1 for Business or 2 for Economy: ");
        int section = input.nextInt();
        if ( section == 1 )
        {
            Business();
        }
        else
        {
            Economy();
        }
    }
    public void Economy()
    {
        for ( int count = 6; count <= 10; count++ )
        {
            if ( seats[count] == false )
            {
                seats[count] = true; // assign seat
                System.out.printf("Economy Seats. Seat# %d\n", count);
                break;
            }
            else if ( seats[10] == true )
            {
                if ( seats[5] == true)
                {
                    System.out.println("Sorry, Flight fully booked...Wait for next Available Flight.");
                    System.exit(0);
                }
                else // ask if passenger would like a first class ticket instead
                {
                    System.out.println("Economy is fully booked. Would you like First Class? 1 for Yes 2 for No");
                    int choice = input.nextInt();
                    if ( choice == 1 )
                    {
                        Business();
                        start();
                    }
                    else
                    {
                        System.out.println("Next flight is in 5 hours");
                        System.exit(0);
                    }
                }
            }
        }
    }
    public void Business()
    {
        for ( int count = 1; count <= 5; count++ )
        {
            if ( seats[count] == false )
            {
                seats[count] = true; 
                System.out.printf("Business Seats. Seat# %d\n", count);
                break;
            }
            else if ( seats[5] == true ) 
            {
                if ( seats[10] == true) 
                {
                    System.out.println("Sorry, flight fully booked. Wait for next Available Flight.");
                }
                else
                {
                    System.out.println("Business is fully booked. Would you like Economy? 1 for Yes 2 for No");
                    int choice = input.nextInt();
                    if ( choice == 1 )
                    {
                        Economy();
                        start();
                    }
                    else
                    {
                        System.out.println("Next flight is in 5 hours.");
                        System.exit(0);
                    }
                }
            }
        }
    }
}


// in the public static void main method of mainflight write this code 

//Seat s = new Seat();
//s.makeReservation();