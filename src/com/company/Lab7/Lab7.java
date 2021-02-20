

import java.awt.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Lab7 {
    /** Drunk Walk Program
     *	//public static DrawingPanel p = new DrawingPanel(Lab7.panelSize, Lab7.panelSize);  // Init Panel with proper dimensions
     */

    public static final Scanner CONSOLE = new Scanner(System.in);
    public static int panelSize = 512;  // Panel size var, width and height
    public static double centerPoint = 1;
    public static int Dx = 1;
    public static int Dy = 1;
	public static Random rand = new Random();
    public static int r = 0;


    public static void main(String[] args) {
        /**
         * Ask the user for the radius and color of the circle (at least 2 color choices)
         * Do the drunk walk and then determine if it strayed outside of the circle
         */
        int numberOfSteps = 0;

        System.out.println("Lab 7 written by Elizabeth Graham\n");  // Output student name

        Scanner scanner = new Scanner(System.in);  // Init scanner, for input

        System.out.println("Enter circle radius: ");
        String radius = scanner.nextLine();
        r = Integer.parseInt(radius);
        System.out.println("Colors: \n1. Red\n2. Green\n3. Blue");
        System.out.println("Enter circle color's respective number (E.g. 1-3): ");
        String color = scanner.nextLine();
        scanner.close();  // Close scanner

        System.out.println("Radius: " + radius + "\nColor: " + color);  // Print out the input for the user to see

        panelSize = Integer.parseInt(radius) * 2 + 100;  // Set the panelSize Var to the circle radius + 100px for padding

        Dx = (int)(panelSize*0.5) - (int)(Integer.parseInt(radius)*0.5);  //Drunk initial position
        Dy = (int)(panelSize*0.5) - (int)(Integer.parseInt(radius)*0.5);  //Center of circle

        Window.drawCircle(Integer.parseInt(radius), Integer.parseInt(color));  // Init the window and draw the circle

        //draw big circle
        Window.g.setColor(Color.RED);
        //draw drunk initial position
        Window.g.fillOval(Dx, Dy, Window.drunkRadius, Window.drunkRadius);

        centerPoint = (Lab7.panelSize*0.5) - (Integer.parseInt(radius)*0.5);

        //animation loop, while not outside big circle loop
			while(!outsideCircle((int)centerPoint, (int)centerPoint)) {

				//move drunk
				Window.moveDrunk(rand, Window.g);
				numberOfSteps++;

				//pause for animation effect
				Window.panel.sleep(100);

			}  //end while

			System.out.println("Drunk moved outside big circle ");
			System.out.println("Number of steps: " + numberOfSteps);
    }


     //checks if Drunk is ouside big circle
	   //(Cx, Cy) is the center of the circle
	   //Returns true if outside circle, false if inside
	   public static boolean outsideCircle(int Cx, int Cy) {
		   /**
			* Using the distance formula, determine if the drunks step has veered
			* outside the circle or not. This is ran every step.
		    */
		   boolean outside = false;

		   //use distance formula to set boolean outside
	       // (Cx - Dx)^2 + (Cy - Dy) ^2 > r^2
		   if ((Math.pow(Cx-Dx, 2) + Math.pow(Cy-Dy, 2)) > Math.pow(r, 2)) {
			   return !outside;
		   }
		  return outside;  // If not, it's outside the circle
	   } //method


}


class Window {

    public static DrawingPanel panel = new DrawingPanel(Lab7.panelSize, Lab7.panelSize);  // Init Panel with proper dimensions
    public static Graphics g = panel.getGraphics();  // Init graphics instance
    public static Color[] colorArray = {Color.RED,Color.GREEN,Color.BLUE};  // Color array, so user can choose circle color
    public static final int drunkRadius = 4;
	public static final int increment = 5;


    public static void drawCircle(int radius, int color) {
        /*
            Call the fillOval function using the arguments xPoint
            for coordinates and radius for radius.
        */
        double centerPoint = (Lab7.panelSize*0.5) - (radius*0.5);
        g.setColor(colorArray[color-1]);  // Set the color of the circle to the current index
        g.drawOval((int)Lab7.centerPoint, (int)centerPoint, radius*2, radius*2);
    }


    public static void moveDrunk(Random rand, Graphics g) {
			//code moveDrunk. Change DX or Dy depending of outcome
			// of generated value using rand.nextInt(4); Returns 0,1,2,3
			// nested if-else,  0 move up,1 move down,2 move right,move left
			//                     in Y        in Y        in X       in X
			// move increments of 5 pixels

			//erase drunk's last position
			g.setColor(Color.WHITE);
			g.fillOval(Lab7.Dx, Lab7.Dy, drunkRadius, drunkRadius);

			//move drunk position coordinate
			//use if-else statement here to handle 4 cases of randNumber
			int randNumber = rand.nextInt(4); //0-3

			if (randNumber == 0) {
				// Move up	y+=5
				Lab7.Dy += increment;
			}
			else if (randNumber == 1) {
				// Move down	y-=5
				Lab7.Dy -= increment;
			}
			else if (randNumber == 2) {
				// Move right	x+=5
				Lab7.Dx += increment;
			}
			else {  // randNumber is 3
				// Move left	x-=5
				Lab7.Dx -= increment;
			}

			//redraw with updated coordinate
			g.setColor(Color.RED);
			//move drunk with new coordinates
			g.fillOval(Lab7.Dx, Lab7.Dy, drunkRadius, drunkRadius);
	   } //method
}
