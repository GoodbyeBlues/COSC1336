import java.util.*;
import java.io.*;

// class

public class lab8 {

     public static void main(String args[]) throws IOException {

          // scanner class
          Scanner sc = new Scanner(System.in);

          // variables
          int decimal;
          String query;

          while (true) {

               decimal = getInt(sc, "Enter a positive integer: ");0,63

               if (decimal > 0) {

                    int binary[] = convertToBinary(decimal);

                    System.out.print(" decimal is equal to " + decimal);

                    printBinaryArray(binary);

                    System.out.print("Do you want to continue(yes or no):");

                    query = sc.next();

                    if (query.equals("no")) {

                         System.out.println("\nYou answered 'no'. Bye");
                         break; // exit loop
                    }

               } else if (decimal <= 0) {

                    System.out.println("Not positive; try again.");

               }

          } // while

     } // main

     // follow algorithm in PDF
     public static void printBinaryArray(int[] binary) {

     } // method

     // follow algorithm in PDF
     public static int[] convertToBinary(int decimal) {

          // replace, just here to shut-up compiler
          return new int[2];

     } // method

     private static int getInt(Scanner sc, String string) {

          boolean flag = false;
          int i = 0;

          while (!flag) {

               System.out.print(string);

               if (sc.hasNextInt()) {

                    i = sc.nextInt();
                    flag = true;
               } else {

                    System.out.println("Not an integer; try again");
                    // sc.next();

               }

          } // while

          return i;

     } // method

} // class
