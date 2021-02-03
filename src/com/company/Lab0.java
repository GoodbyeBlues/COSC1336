package com.company;

import java.util.Arrays;

public class Lab0 {

    public static void main(String[] args) {
        System.out.println("Lab 0 written by Elizabeth Graham\n");  // Output student name

        printBox();  // Call the box function
        printTriangleLeetcodeEdition();  // Call the triangle function 
        // printBoxSimple();  // Call the box function, done the way the professor showed
        // printTriangleSimple();  // Call the triangle function, done the way the professor showed
    }


    public static void printBox() {
        // Could also do this in less lines with just print statements
        int rows = 4;  // This way you only need to change one number to change the size of the box

        for (int i = 0; i < rows; i++) {  // Box has 4 rows of text
            if (i == 0 | i == rows - 1) {  // If it's the first or last line, print the enclosing parts
                System.out.println("|-----------------|");
            } else {
                System.out.println("|                         | ");  // Otherwise, print the sides
            }
        }
    }


    public static void printBoxSimple() {
        System.out.println("|-----------------|");
        System.out.println("|                         | ");
        System.out.println("|                         | ");
        System.out.println("|-----------------|");
    }


    public static void printTriangleSimple() {
        System.out.println("      *       ");  // Begin printing the triangle the normal way
        System.out.println("    * * *     ");
        System.out.println("  * * * * *   ");
        System.out.println("* * * * * * * ");
    }


    public static void printTriangleLeetcodeEdition() {
        int rows = 4;  // Height of triangle. Set to 10000 if you're brave
        String line = "";  // The current line to be made

        for (int i = 0; i < rows; i++) {
            line = " ".repeat(rows - i - 1) + "*".repeat((2 * i + 1));  // (Print 3 spaces + 1 asterisk) => (Print 2 spaces + 3 asterisks) => And so forth
            String[] stringElems = line.split("");  // Split the asterisks into individual characters, cause string manipulation is wonky in Java compared to Python
            System.out.println(String.join(" ", stringElems));  // Add an extra space between the asterisks to make it really stand out
        }

        // System.out.println("       | |");  // Uncomment to make a Christmas tree :)
    }
}
