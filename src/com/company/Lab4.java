package com.company;

import java.awt.*;
import java.util.Scanner;


public class Lab4 {
    public static final int PANEL_SIZE = 444;  // Constant panel size var, width and height
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

        // Call the star wars name functions, concat to a string, and output string
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


    public static String swNameGenerator(String firstName, String lastName, String maidenName, String birthCity, String carBrand) {
        // Break up into multiple functions
        String swFirstName = firstName + lastName;  // First 3 chars of first name, first 2 chars of last name
        String swLastName = maidenName + birthCity;  // First 2 chars of maiden name, first 3 chars of birth city
        String swPlanet = lastName + carBrand;  // last 2 chars of last name, full car name
        return "";
    }
}
