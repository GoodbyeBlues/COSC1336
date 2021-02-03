package com.company;

public class Poems {
    public static void main(String[] args) {
        /*
            Poem Printer:
            This program prints the first verse of 'Mary Had a Little Lamb", line by line,
            and the first three verses of 'This old man' verse by verse.
         */
        System.out.println("Lab 1 written by Elizabeth Graham\n\n");  // Output student name

        printMaryPoem();  // Call the method to print 'Mary Had a Little Lamb' poem
        System.out.println();  // Give some extra spacing
        printOldMan();  // Print 'This Old Man' poem
    }


    public static void printMaryPoem() {
        /*
            The method to print the first verse of "Mary Had a Little Lamb" should print the title of
            the poem and call a method for each line in the verse. One of these methods should be
            called twice.

            Verse:
            "Mary had a little lamb,
             Little lamb, little lamb,
             Mary had a little lamb,
             Its fleece was white as snow"
         */
        System.out.println("Mary Had a Little Lamb\n");  // Print the title

        printLineOne();  // Begin printing lines
        printLineTwo();
        printLineOne();  // Reuse first method since they're the same text
        printLineFour();
    }


    public static void printLineOne() {
        /*
            Prints the first (and third) line of Mary Had a Little Lamb
         */
        System.out.println("Mary had a little lamb,");
    }


    public static void printLineTwo() {
        /*
            Prints the second line of Mary Had a Little Lamb
         */
        System.out.println("Little lamb, little lamb,");
    }


    public static void printLineFour() {
        /*
            Prints the fourth line of Mary Had a Little Lamb
         */
        System.out.println("Its fleece was white as snow.\n");
    }


    public static void printOldMan() {
        /*
           The method to print the first three verses of "This Old Man". Prints the title and
           calls a method for each verse. Each verse method calls the refrain
           method to print the refrain text.

            Verses:
           "This old man, he played one
             He played knick-knack on my thumb [some versions use "drum" here]
             With a knick-knack patty-whack, give a dog a bone
             This old man came rolling home

             This old man, he played two
             He played knick-knack on my shoe
             With a knick-knack patty-whack, give a dog a bone
             This old man came rolling home

             This old man, he played three
             He played knick-knack on my knee
             With a knick-knack patty-whack, give a dog a bone
             This old man came rolling home"
         */
        System.out.println("This Old Man\n");
        printVerseOne();
        printVerseTwo();
        printVerseThree();
    }


    public static void printVerseOne() {
        /*
            Prints the first verse of This Old Man, and calls the refrain method
         */
        System.out.println("This old man, he played one\n" +
                "He played knick-knack on my thumb\n" +
                "With a knick-knack patty-whack, give a dog a bone");
        printRefrain();
    }


    public static void printVerseTwo() {
        /*
            Prints the second verse of This Old Man, and calls the refrain method
         */
        System.out.println("This old man, he played two\n" +
                "He played knick-knack on my shoe\n" +
                "With a knick-knack patty-whack, give a dog a bone");
        printRefrain();
    }


    public static void printVerseThree() {
        /*
            Prints the third verse of This Old Man, and calls the refrain method
         */
        System.out.println("This old man, he played three\n" +
                "He played knick-knack on my knee\n" +
                "With a knick-knack patty-whack, give a dog a bone");
        printRefrain();
    }


    public static void printRefrain() {
        /*
            Print the poem's refrain, common in all verses: ""This old man came rolling home"
         */
        System.out.println("This old man came rolling home\n");
    }
}
