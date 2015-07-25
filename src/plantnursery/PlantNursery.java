/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package plantnursery;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author KCISCisco
 */
public class PlantNursery {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArrayList<Plant> pAL = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        String common;
        String scientific;
        double height;
        double price;
        boolean fragile;
        boolean goAgain;
        int choice;
        
        // Loop will continue to ask user for plants until the user is finished
        do
        {
        System.out.println("Enter the common name of the plant: ");
        common = in.nextLine();
        
        System.out.println("Now enter the scientific name of the plant: ");
        scientific = in.nextLine();
        
        System.out.println("What's the maximum height of this plant in feet: ");
        height = in.nextDouble();
        
        System.out.println("What's the price of the plant: ");
        price = in.nextDouble();
        
        System.out.println("Is this plant fragile: (true for yes and false for no): ");
        fragile = in.nextBoolean();
        
        Plant pO = new Plant(common, scientific, height, price, fragile);   // Creating new Plant object
        
        pAL.add(pO);    // Adding new object into the ArrayList
        
        // Ask user if they would like to enter another plant
        System.out.println("Would you like to add another plant? (true for yes and false for no)");
        goAgain = in.nextBoolean();
        
        // Clear keyboard buffer from newline character
        in.nextLine();
        
        }while(goAgain);
        
        // This loop will ask the user if they want to change any information of their plants
        for (Plant pO : pAL) {
           
           pO.changeInfo(); // See method description in the Plant.java file
        }
        
        // Ask the user if they would like to see the plants in the order they want or quit
        System.out.println("Would you like to view your plants?\n\n"
                + "1. Sorted by price(lowest to highest)\n"
                + "2. Scientific name\n"
                + "3. Common name\n"
                + "4. Quit\n"
                + "Choice: ");
        choice = in.nextInt();
        
        // Input validation
        while (choice < 1 || choice > 4)
        {
            System.out.println("Please enter a valid choice");
            choice = in.nextInt();
        }
        
        //Sorting by the price of the plant
        if (choice == 1) {
            Collections.sort(pAL, new Plant.OrderByPrice());
            for (Plant pO : pAL) {
                System.out.println(pO);
                System.out.println(pO.isTall());
            }
        }
            
        // Sorting by the scientific name of the plant            
        else if (choice == 2) {
            Collections.sort(pAL, new Plant.OrderByScientificName());
            for (Plant pO : pAL) {
                System.out.println(pO);
                System.out.println(pO.isTall());
            }
        }
        
        // Sorting by the name of the common name of the plant
        else if(choice == 3) {
            Collections.sort(pAL, new Plant.OrderByCommonName());
            for (Plant pO : pAL) {
                System.out.println(pO);
                System.out.println(pO.isTall());
            }
        }
               
        // Let the user quit and warn them to water the plants
        else if (choice == 4) {
            System.out.println("You can atleast water the plants...");
                  for (Plant pO : pAL) {
                      pO.needWater();
                      System.out.println("It's like they're speaking to you...");
            }
        }
            }
  
        }
          
         
        
        
        
        
        
        
        
  
        
     
        
  
        
       
       


