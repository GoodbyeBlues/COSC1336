package com.company;

import java.awt.*;
import java.util.Scanner;


public class Lab5 {
    /*
        Ask the user for information to draw three circles in a DrawingPanel. Print information
        about the circles. Each item of information should correspond to a different static
        method.
    */

    public static final int PANEL_SIZE = 444;  // Constant panel size var, width and height
    public static DrawingPanel panel = new DrawingPanel(PANEL_SIZE, PANEL_SIZE);  // Init Panel with proper dimensions
    public static Graphics g = panel.getGraphics();  // Init graphics instance


    public static void main(String[] args) {
        /*
            Take input regarding circle center and radius, then
            draw and fill three circles with three different colors.
            Call a method to compare the sizes of the two circles.
            Call a method to determine if two circles intersect.
        */ 
        
        Scanner scanner = new Scanner(System.in);  // Init scanner, for input

        System.out.println("Circle Drawing Program\n");

        System.out.println("Enter center point: ");
        String center = scanner.nextLine();

        System.out.println("Enter radius: ");
        String radius = scanner.nextLine();

        g.fillOval(256, 256, 100, 100);
        g.drawOval(230, 230, 150, 150);
    }
}
