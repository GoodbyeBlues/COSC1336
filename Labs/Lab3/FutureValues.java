import java.text.*;
import java.util.Scanner;


public class FutureValues {
    public static void main(String[] args) {
        /*
            DocString:

            For each method, the main method needs to obtain input from the user, call the method
            with the input values, save the result of the method in a local variable, and print the
            inputs and the result.

            Will collect account data and output both future account value (based on interest
            and years) and future annuity value (based on interest and years)

         */
        Scanner scanner = new Scanner(System.in);  // Init scanner

        System.out.println("Lab 3 written by Elizabeth Graham\n");  // Output student name


        // Begin taking user input (Account Value)
        System.out.println("\nEnter the present account value: ");
        String value = scanner.nextLine();

        System.out.println("\nEnter the interest rate (x)%: ");
        String rate = scanner.nextLine();

        System.out.println("\nEnter the number of years: ");
        String years = scanner.nextLine();

        // Call the futureValueAccount func to calculate account value with interest, and format it using the money string func
        String accountValueFormatted = moneyString(futureValueAccount(Double.parseDouble(value), Double.parseDouble(rate), Double.parseDouble(years)));
        System.out.println(accountValueFormatted);  // Output the money-formatted string

        // Begin taking user input (Annuity)
        System.out.println("\nEnter the yearly payment amount: ");
        String annuityPayment = scanner.nextLine();

        System.out.println("\nEnter the interest rate (x)%: ");
        String annuityRate = scanner.nextLine();

        System.out.println("\nEnter the number of years: ");
        String annuityYears = scanner.nextLine();

        // Call the futureValueAnnuity func to calculate annuity, and format it using the money string func
        String annuityValueFormatted = moneyString(futureValueAnnuity(Double.parseDouble(annuityPayment), Double.parseDouble(annuityRate), Double.parseDouble(annuityYears)));
        System.out.println(annuityValueFormatted);  // Print the money-formatted annuity string
    }


    public static double futureValueAccount(double presentValue, double interestRate, double years) {
        /*
            Compute and return the future value of an account based on the present value of
            the account, the interest rate, and the number of years

            Equation:
                            future value = p * (1 + (1+r/ 100) ^y
         */

        double futureValue = (presentValue * (Math.pow((1 + (interestRate/100)), years)));
        return futureValue;
    }


    public static double futureValueAnnuity(double yearlyPayment, double interestRate, double years) {
        /*
            Compute and return the future value of an annuity based on the payment per
            year, the interest rate, and the number of years

            Equation:

                                  (1+r/100)^y -1
                            p * _______________
                                       r/100
         */

        double annuityValue = yearlyPayment * ((Math.pow((1 + interestRate / 100), years) - 1) / (interestRate / 100));
        return annuityValue;
    }



    public static String moneyString(double amount) {
        /*
            Returns a String $dollars.cents rounded to the nearest cent.
            For example, moneyString(12.3456) returns "$12.35".
         */
        DecimalFormat dollarsAndCents = new DecimalFormat("$#0.00");
        return dollarsAndCents.format(amount);
    }

}
