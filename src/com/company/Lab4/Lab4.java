package com.company.Lab4;

import java.awt.*;
import java.util.Scanner;


public class Lab4 {
    public static final int PANEL_SIZE = 512;  // Constant panel size var, width and height
    public static DrawingPanel panel = new DrawingPanel(PANEL_SIZE, PANEL_SIZE);  // Init Panel with proper dimensions
    public static Graphics g = panel.getGraphics();  // Init graphics instance


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Init scanner, for input

        drawHyperbolaLeft();  // Call left hyperbola func
        drawHyperbolaRight();  // Call right hyperbola func

        // Uncomment to make an eye ^_^
        // g.fillOval(256, 256, 100, 100);
        // g.drawOval(230, 230, 150, 150);


        // Begin ingesting star wars input from user
        System.out.println("Star Wars Name Generator \n(totally not a personal info phishing program)\n");
        System.out.println("Enter your first name: ");
        String firstName = scanner.nextLine();

        System.out.println("Enter your last name: ");
        String lastName = scanner.nextLine();

        System.out.println("Enter your mother's maiden name: ");
        String maidenName = scanner.nextLine();

        System.out.println("Enter your city of birth: ");
        String birthCity = scanner.nextLine();

        System.out.println("Enter the brand of the first care you drove: ");
        String carBrand = scanner.nextLine();

        scanner.close();  // Close scanner

        System.out.println();  // Give some space between the input and the output 

        // Output the star wars names and planet name
        System.out.println(String.format("You are %s %s of %s", firstNameGenerator(firstName, lastName).toUpperCase(), lastNameGenerator(maidenName, birthCity).toUpperCase(), planetNameGenerator(lastName, carBrand).toUpperCase()));
    }


    public static void drawHyperbolaLeft() {
        /*
            Draw the bottom left hyperbola (32px between each line)

            Every 32 px from the 0 px, draw a line from 0, i, to i, PanelSize
         */
        for (int i = 0; i < PANEL_SIZE; i += 32) {
            g.drawLine(0, i, i, PANEL_SIZE);
        }
    }


    public static void drawHyperbolaRight() {
        /*
            Draw the upper right hyperbola (8px between each line)
            oh boy doe
            Every 8 px starting at the max coordinate, draw a line from the max coordinate, i, to i, 0 (minimum coordinate)
         */
        for (int i = 0; i < PANEL_SIZE; i += 8) {
            g.drawLine(PANEL_SIZE, i, i, 0);
        }
    }

    
    public static String firstNameGenerator(String firstName, String lastName) {
        // First 3 chars of first name + first 2 chars of last name
        return (firstName.substring(0,3) + lastName.toLowerCase().substring(0,2));
    }


    public static String lastNameGenerator(String maidenName, String birthCity) {
        // First 2 chars of maiden name + first 3 chars of birth city
        return (maidenName.substring(0,2) + birthCity.toLowerCase().substring(0,3)); 
    }


    public static String planetNameGenerator(String lastName, String carBrand) {
        // Last 2 chars of users name + full car name
        return (Character.toUpperCase(lastName.charAt(lastName.length() - 2)) + lastName.substring(lastName.length() - 1) + carBrand.toLowerCase());
    }
}
