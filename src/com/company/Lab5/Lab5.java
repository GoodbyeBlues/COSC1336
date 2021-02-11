package com.company.Lab5;

import java.awt.*;
import java.util.Scanner;
import java.util.Random;


public class Lab5 {
    /*
        Ask the user for information to draw three circles in a DrawingPanel. Print information
        about the circles. Each item of information should correspond to a different static
        method.
    */
    public static final int PANEL_SIZE = 512;  // Constant panel size var, width and height
    public static DrawingPanel panel = new DrawingPanel(PANEL_SIZE, PANEL_SIZE);  // Init Panel with proper dimensions
    public static Graphics g = panel.getGraphics();  // Init graphics instance
    public static Random rand = new Random(); // Create random instance


    public static void main(String[] args) {
        /*
            Take input regarding circle center and radius, then
            draw and fill three circles with three different colors.
            Call a method to compare the sizes of the two circles.
            Call a method to determine if two circles intersect.
        */ 
        System.out.println("Lab 3 written by Elizabeth Graham\n");  // Output student name
        
        Scanner scanner = new Scanner(System.in);  // Init scanner, for input

        System.out.println("Circle Drawing Program\n");

        Color[] colorArray = {Color.RED,Color.GREEN,Color.BLUE};

        for (int i = 0; i < 3; i++) {

            System.out.println("Enter center point: ");
            String center = scanner.nextLine();

            System.out.println("Enter radius: ");
            String radius = scanner.nextLine();     

            g.setColor(colorArray[i]);


            drawCircle(findCenterPoint(Integer.parseInt(center), Integer.parseInt(radius)), Integer.parseInt(radius));
        }

        // Output: The green circle is smaller than the red circle.

        scanner.close();  // Close scanner
    }


    public static int findCenterPoint(int center, int w) {
        double xPoint = center - (0.5 * w);  // x = center - 1/2w
        return (int)xPoint;
    } 


    public static void drawCircle(int xPoint, int radius) {
        g.fillOval(xPoint, xPoint, radius, radius);
    }


    public static void compareSizes(int r1, int r2) {
        /*
            A static method named compareSizes(...) should have parameters for the radii of
            two circles (two parameters), and the method should return -1 if the first circle is
            smaller, return 0 if the two circles have the same size, or return 1 if the first circle 
            is larger. Based on the return value from this method, the main method should
            print a line of output like:
            The green circle is smaller than the red circle.
        */
    }


    public static void doesIntersect(int r1, int r2, int x1, int x2, int y1, int y2) {
        /*
            Another static method named doesIntersect(...) should have parameters for the
            radii and locations of two circles (six parameters), and the method should return 1
            if the circles intersect or return 0 if the circles do not intersect (alternatively, you
            could return true or false). If (x1,y1) and (x2,y2) are the centers of the circles and
            if r1 and r2 are their radii, then the circles intersect if the distance between the
            centers, the square root of:
            (x1 - x2)2
            + (y1 - y2)2
            is less than or equal to r1 + r2. Based on the return values from this method, the
            main method should print a line of output like:
            The blue circle intersects the red circle.
        */
    }


    public static void isCircleInWindow() {
        /*
            Given a circle, return 1if the circle is completely within the window,
            return 0 if the circle is partially within the window, or return -1 if the circle is
            completely outside the window. The program should print something appropriate. 
        */
    }
}
