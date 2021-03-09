import java.util.Scanner;

public class Patterns {

    public static void main(String[] args) {
        /**
         * This program prints a box pattern, with a width variable
         * dictated by the user. It also prints a diamond pattern
         * with both the width and height dictated by the user.
         */
        Scanner scanner = new Scanner(System.in);  // Init scanner

        System.out.println("Lab 7 written by Elizabeth Graham\n"); // Output student name

        System.out.println("Enter number of boxes: ");
        String boxAmount = scanner.nextLine();
        
        printBoxes(drawBox(Integer.parseInt(boxAmount)));  // Make the string of boxes to print

        System.out.println("Width of pattern: ");
        String width = scanner.nextLine();
        System.out.println("Height of pattern: ");
        String height = scanner.nextLine();


        System.out.println(drawPattern(Integer.parseInt(width), Integer.parseInt(height)));
        scanner.close();
    }

    public static void printBoxes(String boxString) {
        /**
         * Print Boxes
         * 
         * Expected Output: +------+------+------+ 
         *                  |      |      |      | 
         *                  |      |      |      |
         *                  +------+------+------+
         * 
         */

        System.out.println(boxString);
    }

    public static String drawBox(int boxAmount) {
        /**
         * Make the Box string
         * 
         * Expected Output: +------+ 
         *                  |      | 
         *                  |      |    
         *                  +------+
         */
        String endsTemplate  = "------+";  // String necessary to complete another set of chars on the top/bottom lines
        String sidesTemplate = "      |";// String necessary to complete another set of chars on the side lines

        String endLines =   "+";
        String sideLines =   "|";

        String output;  // After endLines and sideLines are formatted, add them to output

        for (int i = 0; i < boxAmount; i++) {
            endLines += endsTemplate;
            sideLines += sidesTemplate;
        }

        output = endLines + "\n" + sideLines + "\n" + sideLines + "\n" + endLines;

        return output;
    }

    public static String drawPattern(int width, int height) {
        /**
         * Draw pattern according to user given arguments
         * 
         * I hope the implementation is ok. I used char.replace instead of a for loop
         * because it's most similar to other languages implementations, and it felt
         * more natural.
         * 
         * Arguments: Width of Pattern = 3; Height of pattern = 2;
         *  
         * Expected Output: 
         *  X   X   X 
         * / \ / \ / \ 
         * / \ / \ / \ 
         * \ / \ / \ / 
         * \ / \ / \ / 
         *  X   X   X 
         * / \ / \ / \ 
         * / \ / \ / \ 
         * \ / \ / \ / 
         * \ / \ / \ / 
         *  X   X   X
         * 
         * Single: 
         * 
         *  X
         * / \
         * / \
         * \ /
         * \ /
         *  X
         * 
         */
        String single = "  X\n / \\\n / \\\n \\ /\n \\ /\n  X";

        String lineOne   = "  X ";
        String lineTwo   = " / \\";
        String lineThree = " \\ /";

        String lineOneOutput  = new String(new char[width]).replace("\0", lineOne);
        String lineTwoOutput   = new String(new char[width]).replace("\0", lineTwo);
        String lineThreeOutput = new String(new char[width]).replace("\0", lineThree);

        String output = lineOneOutput + "\n" + lineTwoOutput + "\n" + lineTwoOutput + "\n" + lineThreeOutput + "\n" + lineThreeOutput + "\n" + lineOneOutput;

        for (int h = 1; h < height; h++) {
            output += "\n" + lineTwoOutput + "\n" + lineTwoOutput + "\n" + lineThreeOutput + "\n" + lineThreeOutput + "\n" + lineOneOutput;;
        }    

        return output;
    }
}
