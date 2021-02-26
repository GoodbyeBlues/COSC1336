
public class Logical {

	public static void main(String[] args) 
    { 
        // initializing variables 
        int a = 10, b = 20, c = 20;

        System.out.println("Lab 11 written by Elizabeth Graham"); 
  
        // Displaying a, b, c 
        System.out.println("Var1 = " + a); 
        System.out.println("Var2 = " + b); 
        System.out.println("Var3 = " + c); 
         
  
        // using logical AND to verify 
        // two constraints that a < b AND b = c
        // use if-else to print condition is True or False 
        if (a < b && b == c) { 
            System.out.println("True conditions:  a < b AND b = c");
        } 
        else
            System.out.println("False conditions"); 
        
        // using logical AND to verify 
        // two constraints that a > b AND b = c
        // use if-else to print condition is True or False 
        if (a > b && b == c) { 
            System.out.println("True conditions"); 
        } 
        else
            System.out.println("False conditions: a > b AND b = c");
         // using logical OR to verify 
        // two constraints that a > b OR b = c
        // use if-else to print condition is True or False 
        if (a > b || b == c) { 
            System.out.println("True conditions:  a > b OR b = c"); 
        } 
        else
            System.out.println("False conditions: a > b OR b = c");  
    }

}
