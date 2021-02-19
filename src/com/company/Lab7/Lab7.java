package com.company.Lab7;

import java.awt.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Lab7 {
    /** Game and Playoff Simulations
     *
     */

    public static final Scanner CONSOLE = new Scanner(System.in);
    public static int panelSize = 512;  // Panel size var, width and height
    static int Dx = UpperLeftCircleX + r;  //drunk initial position
	static int Dy = UpperLeftCircleY + r;  //at center of circle


    public static void main(String[] args) {
        /**
         * Ask the user for the radius and color of the circle (at least 2 color choices)
         */
        System.out.println("Lab 7 written by Elizabeth Graham\n");  // Output student name

        Scanner scanner = new Scanner(System.in);  // Init scanner, for input

        System.out.println("Enter circle radius: ");
        String radius = scanner.nextLine();
        System.out.println("Colors: \n1. Red\n2. Green\n3. Blue");
        System.out.println("Enter circle color's respective number (E.g. 1-3): ");
        String color = scanner.nextLine();

        System.out.println("Radius: " + radius + "\nColor: " + color);
        panelSize = Integer.parseInt(radius) + 100;
        Window.drawCircle(Integer.parseInt(radius), Integer.parseInt(color));

        scanner.close();  // Close scanner
    }


    public static boolean isOutside() {

        return false;
    }


    public static void makeStep() {
        /**
         * A random walk begins at a point and repeatedly takes a step in a randomly chosen direction. 
         * In our version, the random walk will start at the center of a circle and continue until it 
         * goes outside the circle. Each step will be randomly chosen from one pixel up, onepixel down, 
         * one pixel left, and one pixel right (this kind of random walk is called the "drunkard's walk"). 
         * Call the nextInt(...) method on a Random object to generate an integer between 0 and 3 and 
         * map each value to one of the steps. The random walk will be drawn on a Graphics object. 
         */
        Random rand = new Random();
        int randNum = rand.nextInt(3);
        int startPoint = rand.nextInt();  // 
        // directions = {0: Down, 1: Up, 2: Left, 3: Right}

        while (true) {
            
            System.out.println(randNum);
            if (randNum == 3) {
                break;
            }
            Window.panel.sleep(500);
        }
    }
}


class Window {

    public static com.company.Lab5.DrawingPanel panel = new com.company.Lab5.DrawingPanel(Lab7.panelSize, Lab7.panelSize);  // Init Panel with proper dimensions
    public static Graphics g = panel.getGraphics();  // Init graphics instance
    public static Color[] colorArray = {Color.RED,Color.GREEN,Color.BLUE};  // Color array, so user can choose circle color


    public static void drawCircle(int radius, int color) {
        /*
            Call the fillOval function using the arguments xPoint
            for coordinates and radius for radius.
        */
        double centerPoint = (Lab7.panelSize*0.5) - (radius*0.5);
        g.setColor(colorArray[color-1]);  // Set the color of the circle to the current indice
        g.drawOval((int)centerPoint, (int)centerPoint, radius, radius);
    }
}