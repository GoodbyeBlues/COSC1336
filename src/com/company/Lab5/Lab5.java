package com.company.Lab5;

import java.awt.*;
import java.util.Scanner;


public class Lab5 {
    /*
        Ask the user for information to draw three circles in a DrawingPanel. Print information
        about the circles. Each item of information should correspond to a different static
        method.
    */

    public static final int PANEL_SIZE = 512;  // Constant panel size var, width and height
    public static DrawingPanel panel = new DrawingPanel(PANEL_SIZE, PANEL_SIZE);  // Init Panel with proper dimensions
    public static Graphics g = panel.getGraphics();  // Init graphics instance


    public static void main(String[] args) {
        /*
            Take input regarding circle center and radius, then
            draw and fill three circles with three different colors.
            Call a method to compare the sizes of the two circles.
            Call a method to determine if two circles intersect.
        */ 
        System.out.println("Lab 3 written by Elizabeth Graham\n");  // Output student name
        
        Scanner scanner = new Scanner(System.in);  // Init scanner, for input

        System.out.println("Circle Drawing Program\n");  // Output the name of the program

        // Each circle will be colored in the order it's made, so R => G => B
        Color[] colorArray = {Color.RED,Color.GREEN,Color.BLUE};

        // Arrays to store the radius and center information
        // Will use when comparing sizes and determining intersections
        int[] circleRadii = new int[3];
        int[] circleCenters = new int[3];

        for (int i = 0; i < 3; i++) {

            System.out.println("Enter center point: ");
            String center = scanner.nextLine();

            System.out.println("Enter radius: ");
            String radius = scanner.nextLine();    
            
            circleRadii[i] = Integer.parseInt(radius);  // Add the current radius to the radii array
            circleCenters[i] = Integer.parseInt(center); // Add the current center point to the centers array

            g.setColor(colorArray[i]);  // Set the color of the circle to the current indice


            drawCircle(findCenterPoint(Integer.parseInt(center), Integer.parseInt(radius)), Integer.parseInt(radius));  // Call the draw circle function using center (using findCenter func) and radius
        }
        scanner.close();  // Close scanner

        // Output: The green circle is {smaller than / larger than / the same size as} the red circle.
        System.out.println("\nCompare Sizes");
        System.out.println("The red circle is " + compareSizeString(compareSizes(circleRadii[0], circleRadii[1])) + " the green circle");
        System.out.println("The red circle is " + compareSizeString(compareSizes(circleRadii[0], circleRadii[2])) + " the blue circle");
        System.out.println("The green circle is " + compareSizeString(compareSizes(circleRadii[1], circleRadii[2])) + " the blue circle");

        // Output: The green circle and the blues circle {intersect / do not intersect}.
        System.out.println("\nDo the circles intersect");
        System.out.println("The red and green circles " + doesIntersectString(doesIntersect(circleRadii[0], circleRadii[1], circleCenters[0], circleCenters[1], circleCenters[0], circleCenters[1])));
        System.out.println("The red and blue circles " + doesIntersectString(doesIntersect(circleRadii[0], circleRadii[2], circleCenters[0], circleCenters[2], circleCenters[0], circleCenters[2])));
        System.out.println("The green and blue circles" + doesIntersectString(doesIntersect(circleRadii[1], circleRadii[2], circleCenters[1], circleCenters[2], circleCenters[1], circleCenters[2])));
    }


    public static String compareSizeString(int boolVal) {
        /*
            Convert the value passed from compareSizes to english
        */
        if (boolVal == 1) {
            return "larger than";
        }

        else if (boolVal == -1) {
            return "smaller than";
        }

        else {return "the same size as";}
    }


    public static String doesIntersectString(int boolVal) {
        /*
            Convert the value passed from doesIntersect to english
        */
        if (boolVal == 1) {
            return "intersect";
        }

        else if (boolVal == -1) {
            return "do not intersect";
        }

        else {return "you broke it";}
    }


    public static int findCenterPoint(int center, int w) {
        /*  
            Find the correct x,y points to have a circle with
            the center point given by the user. 
        */
        double xPoint = center - (0.5 * w);  // x = center - 1/2w
        return (int)xPoint;
    }


    public static void drawCircle(int xPoint, int radius) {
        /* 
            Call the fillOval function using the arguments xPoint 
            for coordinates and radius for radius.
        */
        g.fillOval(xPoint, xPoint, radius, radius);
    }


    public static int compareSizes(int r1, int r2) {
        /*
            A static method named compareSizes(...) should have parameters for the radii of
            two circles (two parameters), and the method should return -1 if the first circle is
            smaller, return 0 if the two circles have the same size, or return 1 if the first circle 
            is larger. Based on the return value from this method, the main method should
            print a line of output like:
            The green circle is smaller than the red circle.
        */
        if (r1 > r2) {
            return 1;  // If r1 is larger
        }

        else if (r1 < r2) {
            return -1;  // If r1 is smaller
        } else {return 0;}  // If both are the same saze
    }


    public static int doesIntersect(int r1, int r2, int x1, int x2, int y1, int y2) {
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

        // They do intersect if the sum of the distances is less than the sum of the radii
        if ((Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2)) < Math.pow(r1+r2, 2)) {
            return 1; // Intersects
        }

        // They don't intersect if the sum of the distances is greater than the sum of the radii
        else if ((Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2)) > Math.pow(r1+r2, 2)) {
            return -1; // Doesnt intersect
        } else {return 0;}  // All code paths return value
    }


    public static void isCircleInWindow() {
        /*
            *OPTIONAL* Given a circle, return 1 if the circle is completely within the window,
            return 0 if the circle is partially within the window, or return -1 if the circle is
            completely outside the window. The program should print something appropriate. 
        */
    }
}
