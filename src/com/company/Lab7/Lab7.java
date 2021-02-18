import java.awt.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.System;

public class Lab7 {
    /** Game and Playoff Simulations
     *
     */

    public static final Scanner CONSOLE = new Scanner(System.in);
    public static int panelSize = 512;  // Canel size var, width and height


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
        Random rand = new Random();

        while (true) {
            System.out.println(randNum);
            if (randNum == 3) {
                break;
            }
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