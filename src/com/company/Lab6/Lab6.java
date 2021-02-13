package com.company.Lab6;

import java.util.*;

public class Lab6 {
    /** Game and Playoff Simulations
     * 
     */

    public static final Scanner CONSOLE = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Lab 2 written by Elizabeth Graham\n");  // Output student name

        // Begin taking the single-game input
        int gameWinChance;
        System.out.println("One Game Simulation");
        do {
            System.out.println("Enter the win percent chance for Team 1: ");
            while (!CONSOLE.hasNextInt()) {
                System.out.println("Not a valid integer");
                CONSOLE.next();
            }
            gameWinChance = CONSOLE.nextInt();  // Store the percent win chance as an int

            if (0 > gameWinChance || gameWinChance > 100) {
                System.out.println("Integer must be between 0 and 100");
            }
        } while (0 > gameWinChance || gameWinChance > 100);


        // Begin taking the playoff input
        int fourGameWinChance;
        System.out.println();
        System.out.println("4 Game Playoff Simulation");
        do {
            System.out.println("Enter the win percent chance for Team 1: ");
            while (!CONSOLE.hasNextInt()) {
                System.out.println("Not a valid integer");
                CONSOLE.next();
            }
            fourGameWinChance = CONSOLE.nextInt();  // Store the percent win chance as an int

            if (0 > fourGameWinChance || fourGameWinChance > 100) {
                System.out.println("Integer must be between 0 and 100");
            }
        } while (0 > fourGameWinChance || fourGameWinChance > 100);
        
        
        // Begin taking the 10-game win advantage playoffs input
        int tenGameWinChance;
        System.out.println();
        System.out.println("10 More Wins Playoff Simulation");
        do {
            System.out.println("Enter the win percent chance for Team 1: ");
            while (!CONSOLE.hasNextInt()) {
                System.out.println("Not a valid integer");
                CONSOLE.next();
            }
            tenGameWinChance = CONSOLE.nextInt();  // Store the percent win chance as an int

            if (0 > tenGameWinChance| tenGameWinChance > 100) {
                System.out.println("Integer must be between 0 and 100");
            }
        } while (0 > tenGameWinChance || tenGameWinChance > 100);
            

        // Run the functions using the user input from above
        System.out.println("\nTeam " + boolToTeam(gameSimulation(gameWinChance)) + " won the game\n");
        System.out.println("Team " + boolToTeam(playoffSimulation(fourGameWinChance)) + " won 4 games to clinch the playoffs\n");
        System.out.println("Team " + boolToTeam(playoffSimulationCont(tenGameWinChance)) + " has won 10 more games than the other team");
    }


    public static String boolToTeam(boolean bool) {
        /** Boolean Value To Team Number
         * Using the boolean values returned by the functions 
         * below, return the string value of the corresponding
         * winning team.
         */
        if (bool == true) {
            return "1";
        } else {return "2";}
    }


    public static boolean gameSimulation(int percentChance) {
        /** Game Simulator
         * Using the Random class simulate a game where one team
         * has a 51% chance of winning and return true or false
         * depending on whether team 1 or team 2 respectively won
         */
        Random rand = new Random();
        int randNum = rand.nextInt(100);

        if (randNum < percentChance) {
            return true;
        } 
        else {
            return false;
        }
    }


    public static boolean playoffSimulation(int percentChance) {
        /** Playoff Simulator (4 game)
         * Using the gameSimulation() func to simulate a game where one team
         * has a 51% chance of winning and return true or false depending on
         * whether team 1 or team 2 respectively won the 4 game series
         */
        int teamOneWins = 0;
        int teamTwoWins = 0;

        while (true) {
            if (teamOneWins == 4) {
                return true;
            } 
            else if (teamTwoWins == 4){
                return false;
            }

            if (gameSimulation(percentChance)) {
                teamOneWins++;
            } else {teamTwoWins++;}
        }
    }


    public static boolean playoffSimulationCont(int percentChance) {
        /** 10 Game Playoff Simulator
         * Same principle as playoffSimulation(), but instead run the series
         * to 10 wins and return the winner.
         */
        int teamOneWins = 0;
        int teamTwoWins = 0;
        String winNumbers = "";

        while (true) {
            if (teamOneWins-teamTwoWins == 10) {
                System.out.println("Team 1 has won " + teamOneWins + " and Team 2 has won " + teamTwoWins);
                System.out.println(winNumbers);
                return true;
            } 
            else if (teamTwoWins-teamOneWins == 10){
                System.out.println("Team 2 has won " + teamTwoWins + " and Team 1 has won " + teamOneWins);
                System.out.println(winNumbers);
                return false;
            }

            if (gameSimulation(percentChance)) {
                winNumbers += "1";
                teamOneWins++;
            } else {winNumbers += "2";teamTwoWins++;}
        }
    }
}
