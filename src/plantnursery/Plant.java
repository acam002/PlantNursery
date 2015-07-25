/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package plantnursery;
import java.util.Scanner;
import java.util.Comparator;


/**
 *
 * @author KCISCisco
 */
public class Plant {
    
    // Attributes
   
    private String commonName;
    private String scientificName;
    private double maxHeightInFeet;
    private double plantPrice;
    private boolean isFragile;
    Scanner s = new Scanner(System.in);

    // Constructor
    public Plant(String commonName, String scientificName, double maxHeightInFeet, double plantPrice, boolean isFragile) {
        this.commonName = commonName;
        this.scientificName = scientificName;
        this.maxHeightInFeet = maxHeightInFeet;
        this.plantPrice = plantPrice;
        this.isFragile = isFragile;
    }
    
    // Returns the price of a plant
    public double getPrice() {
        return plantPrice;
    }
    
    // Returns the scientific name of a plant
    public String getScientificName() {
        return scientificName;
    }
    
    // Returns the common name of a plant
    public String getCommonName() {
        return commonName;
    }
    
    
    /*
     * Comparator implementation to Sort Plant object based on plantPrice
     */
    public static class OrderByPrice implements Comparator<Plant> {

        @Override
        public int compare(Plant p1, Plant p2) {
            double x = p1.getPrice() - p2.getPrice();
    if(x > 0.00001) return 1;
    if(x < -0.00001) return -1;
    return 0;
        }
    }
    
    
    /*
     * Comparator implementation to Sort Plant object based on commonName
     */
     public static class OrderByCommonName implements Comparator<Plant> {

        @Override
        public int compare(Plant p1, Plant p2) {
            return p1.commonName.compareTo(p2.commonName);
        }
    }
    
    /*
     * Comparator implementation to Sort Plant object based on scientificName
     */
     public static class OrderByScientificName implements Comparator<Plant> {

        @Override
        public int compare(Plant p1, Plant p2) {
            return p1.scientificName.compareTo(p2.scientificName);
        }
     }
    
    // Display object information
    @Override
    public String toString() {
    
        if (isFragile) {
             return "The plant's common name is " + commonName + "; and its"
              + " scientific name is: " + scientificName + " with a maximum height of " + maxHeightInFeet +
              " feet. The price is $" + plantPrice + " and this plant is fragile";
        }
        else {
             return "The plant's common name is " + commonName + "; and its"
              + " scientific name is " + scientificName + " with a maximum height of " + maxHeightInFeet +
              " feet. The price is $" + plantPrice + " and this plant isn't fragile ";
        }
    }

    /**
     * This method allows to change the fields of each of the plants
     */
    public void changeInfo() {
       
        boolean choice;
     
        System.out.println("Enter true if the current info of your plant is correct, "
                + "enter false if you would like to change the plant information: ");
        String toString = toString();   //Assign the method text to a string object
        
        //System.out.println("\n");
        
        System.out.println(toString);   // Display current information to the user
        
        choice = s.nextBoolean();   // User will decide whether plant information is correct
        
        
        
        s.nextLine();   // Clear newline character
        
        // If the user enters false then this if statement block will execute asking the user for the 
        // information of the plant
        if (!choice) {
            System.out.println("Enter the common name of the plant: ");
            commonName = s.nextLine();
            
            System.out.println("Enter the scientific name of the plant: ");
            scientificName = s.nextLine();
            
            System.out.println("What is the maximum height of this plant: ");
            maxHeightInFeet = s.nextDouble();
            
            System.out.println("How much does this plant cost: ");
            plantPrice = s.nextDouble();
            
            System.out.println("Is this plant fragile: (true for yes and false for no: ");
            isFragile = s.nextBoolean();
            
            s.nextLine();  // Clear newline
        }          
    }   
    
    /**
     * This method will determine if the plant is tall or short
     * @param height: Maximum height of the plant
     * @return a boolean value
     */
    public String isTall() {
        String value;
        if (maxHeightInFeet >= 5) {
            value = "This plant is tall!";
        }
        
        else {
            value = "This plant isn't tall!"; 
        }
        return value;
    }
    
    /**
     * Second method of my choosing
     * Returns a string that the plant needs water
     */
    public void needWater() {
        
        System.out.println("(I need water!!!)");
    }
    
}