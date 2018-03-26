package fproject;

import java.util.Scanner;

public class FProject 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        String User_name,Password;
        int Main_Menu = 0;
        Boolean flag = true;
        
        System.out.println("************ Khushboo Airlines PVT. LTD. ************ \n");
        System.out.println("**************** Login ********************");
        
        System.out.println("********* Please Enter Username & Password for Authorization***********");
        System.out.println("USER NAME :");
        User_name = input.nextLine();
        
        System.out.println("PASSWORD :");
        Password = input.nextLine();
        
        System.out.println("Login successful..... ");
        
        while (flag == true) {
            System.out.println("\n\n\n\n\n\n\n");
            System.out.println("************ Khushboo Airlines PVT. LTD. ************\n");
            System.out.println("Choose the following operations to continue:\n");
            System.out.println("1. Reservation");
            System.out.println("2. Itenary");
            System.out.println("3. Flight Repository");
            System.out.println("4. List of Passenger");
            System.out.println("5. Reservation Counter");

            System.out.println("Option : ");
            Main_Menu = input.nextInt();

            switch (Main_Menu) {
                case 1: {
                            System.out.println("************ Khushboo Airlines PVT. LTD. ************\n");
                            System.out.println("**************** Reservation ********************");
                            flag = false;
                            break;
                            
                }
                 case 2: {
                            System.out.println("************ Khushboo Airlines PVT. LTD. ************\n");
                            System.out.println("**************** Itenary ********************");
                            flag = false;
                            break;
                }

                case 3: {
                            System.out.println("************ Khushboo Airlines PVT. LTD. ************\n");
                            System.out.println("**************** Flight Repository ********************");
                            flag = false;
                            break;
                }

                case 4: {
                            System.out.println("************ Khushboo Airlines PVT. LTD. ************\n");
                            System.out.println("**************** List of Passenger ********************");
                            flag = false;
                            break;
                }
                case 5: {
                            System.out.println("************ Khushboo Airlines PVT. LTD. ************\n");
                            System.out.println("**************** Reservation Counter ********************");
                            flag = false;
                            break;

                }
                default: {
                    System.out.println("Result not found.......???");
                    break;
                }
            }

        }
    }
}
