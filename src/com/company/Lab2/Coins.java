package com.company.Lab2;

import java.util.*;
import java.text.MessageFormat;

public class Coins {
    public static final Scanner CONSOLE = new Scanner(System.in);


    public static void main(String[] args) {
            /*
                    Coin and Dollar calculation program:
                    InputCoinsAmount():
                        Given amounts of coins (Quarters, dimes, nickels, pennies), this method
                        will return the dollar amount of the sum of the values of these coins
                    InputDollarAmount():
                        Given a total dollar amount, this method will return the max
                        amount of each denomination that can sum to the dollar total.
             */

        System.out.println("Lab 2 written by Elizabeth Graham\n");  // Output student name

        inputCoinsAmount();
        System.out.println("\n");  // Give some space between the functions outpouts
        inputDollarAmount();
    }


    public static void inputCoinsAmount() {
            /*
                Input: Ask the user how many quarters, dimes, nickels, and pennies they have.
                Return: Amount of each denomination + total value in dollars
             */

        System.out.print("Enter the number of quarters: ");
        int quarterAmount = CONSOLE.nextInt();  // Store the quantity of quarters as an int

        System.out.print("Enter the number of dimes: ");
        int dimeAmount = CONSOLE.nextInt();  // Store the quantity of quarters as an int

        System.out.print("Enter the number of nickels: ");
        int nickelAmount = CONSOLE.nextInt();  // Store the quantity of quarters as an int

        System.out.print("Enter the number of pennies: ");
        int pennyAmount = CONSOLE.nextInt();  // Store the quantity of quarters as an int

        // Multiply all the amounts by their respective values
        double dollarAmount = ((quarterAmount * 0.25) + (dimeAmount * 0.10) + (nickelAmount * 0.05) + (pennyAmount * 0.01));

        System.out.println(dollarAmount);  // Print out the dollar total
    }


    public static void inputDollarAmount() {
            /*
                Input: Ask the user how much money (in dollars) they have.
                Return: The quantity of each denomination that will add up to that
                             dollar amount.

                Notes; I would normally have this broken into two functions: one that
                gathers the relevant user input and one that does the calculations,
                with the main method printing the returned values.
             */
        Double[] coinsValues = new Double[]{0.25, 0.1, 0.05, 0.01};  // Array where we hold the coin denominations values
        List<String> coinNames = new ArrayList<String>() {{     // The coin denominations we'll be using
            add("Quarters: ");
            add("Dimes: ");
            add("Nickels: ");
            add("Pennies: ");
        }};
        List<Integer> coinAmounts = new ArrayList<Integer>();   // Where we'll how much of each coin can go into the total dollar amount

        System.out.print("Enter the total dollar amount (x.xx): ");
        double userFunds = CONSOLE.nextDouble();  // Store the users amount of money in a double

        for (int i = 0; i < 4; i++) {
            if (0 < ((int) (Math.floor(userFunds / coinsValues[i])))) {  // Ensure the current coin can actually go into the current amount
                coinAmounts.add(i, (int) (Math.floor(userFunds / coinsValues[i])));  // User's money divided by the value of the coin equals the amount of the coin. Add the amount to the coinAmounts list
                userFunds = (userFunds - (Math.floor(userFunds / coinsValues[i]) * coinsValues[i]));  // Multiply the coin value by the coin amount, then subtract it fro the user's money so we can continue to the other coins
            } else {
                coinAmounts.add(i, 0);  // Add the current coin to the list with 0 amount. Keeps the order in sync with the names list.
            }
        }

        for (int i = 0; i < coinNames.size(); i++) {
            // For each coin denomination: Print "Coin: Amount" (from biggest denomination to smallest)
            System.out.println(coinNames.get(i) + coinAmounts.get(i));
        }
    }
}
