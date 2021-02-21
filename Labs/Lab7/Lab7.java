import java.awt.Color;
import java.util.*;
import java.awt.Graphics;
import java.util.Random;

public class Lab7 {
	/**
	 * Drunkards Walk
	 * 
	 * Using a user inputted circle size and consequently panel size,
	 * perform a drunk walk by randomly moving a pixel in 5 px increments
	 * until the pixel leaves the circle boundaries. When it finally does, 
	 * print that it has exited the circle and print the number of steps.
	 */

	// these values are global to all methods
	static int panelSize = 0;
	static int r = (panelSize-100) / 2; // circle radius
	static int width = r*2;
	static int height = r*2;
	static int UpperLeftCircleX = 50;
	static int UpperLeftCircleY = 50;
	static final int drunkRadius = 4;
	static final int increment = 5;
	static int numOfSteps = 0;

	public static Color[] colorArray = {Color.RED,Color.GREEN,Color.BLUE};

	static int Dx = UpperLeftCircleX + r; // drunk initial position
	static int Dy = UpperLeftCircleY + r; // at center of circle

	public static void main(String[] args) {
		System.out.println("Lab 7 written by Elizabeth Graham\n");  // Output student name

        Scanner scanner = new Scanner(System.in);  // Init scanner, for input

		// Get Circle Radius
        System.out.println("Enter circle radius: ");
        String radius = scanner.nextLine();

		r = Integer.parseInt(radius);
		panelSize = r * 2 + 100;
		width = r*2;
		height = r*2;
		// double xPoint = center - (0.5 * w);
		UpperLeftCircleX = (int)(panelSize*0.5) - (int)(width*0.5);
		UpperLeftCircleY = (int)(panelSize*0.5) - (int)(width*0.5);

		// Get Circle Color
        System.out.println("Colors: \n1. Red\n2. Green\n3. Blue");
        System.out.println("Enter circle color's respective number (E.g. 1-3): ");
        String color = scanner.nextLine();

        System.out.println("Radius: " + radius + "\nColor: " + color);


		DrawingPanel panel = new DrawingPanel(panelSize, panelSize);

		// get graphics reference from DrawingPanel
		Graphics g = panel.getGraphics();

		// set Cx, Cy values correctly
		int Cy = UpperLeftCircleX + r; // center of circle in X
		int Cx = UpperLeftCircleY + r; // center of circle in Y

		Dx = UpperLeftCircleX + r; // drunk initial position
		Dy = UpperLeftCircleY + r; // at center of circle

		Random rand = new Random(); // random generator

		g.setColor(colorArray[Integer.parseInt(color)-1]);
		// draw big circle
		g.drawOval(UpperLeftCircleX, UpperLeftCircleY, width, height);
		// draw big circle
		g.setColor(Color.RED);
		// draw drunk initial position
		g.fillOval(Dx, Dy, drunkRadius, drunkRadius);

		// animation loop, while not outside big circle loop
		while (!outsideCircle(Cx, Cy)) {

			// move drunk
			moveDrunk(rand, g);
			numOfSteps++;

			// pause for animation effect
			panel.sleep(100); 

		} // end while

		System.out.println("Drunk moved outside big circle ");
		System.out.println("Number of steps: " + numOfSteps);

	} // main

	// code moveDrunk. Change DX or Dy depending of outcome
	// of generated value using rand.nextInt(4); Returns 0,1,2,3
	/// nested if-else, 0 move up,1 move down,2 move right,move left
	// in Y in Y in X in X
	// move increments of 5 pixels
	public static void moveDrunk(Random rand, Graphics g) {

		// erase drunk's last position
		g.setColor(Color.WHITE);
		g.fillOval(Dx, Dy, drunkRadius, drunkRadius);

		int randNumber = rand.nextInt(4); // 0-3

		// move drunk position coordinate
		// use if-else statement here to handle 4 cases of randNumber
		if (randNumber == 0) {
			Dy += increment;
		} else if (randNumber == 1) {
			Dy -= increment;
		} else if (randNumber == 2) {
			Dx += increment;
		} else {
			Dx -= increment;
		}

		// redraw with updated coordinate
		g.setColor(Color.RED);
		// move drunk with new coordinates
		g.fillOval(Dx, Dy, drunkRadius, drunkRadius);

	} // method

	// checks if Drunk is ouside big circle
	// (Cx, Cy) is the center of the circle
	// Returns true if outside circle, false if inside
	public static boolean outsideCircle(int Cx, int Cy) {

		boolean outside = false;

		// use distance formula to set boolean outside
		// (Cx - Dx)^2 + (Cy - Dy) ^2 > r^2
		if (Math.pow(Cx - Dx, 2) + Math.pow(Cy - Dy, 2) > Math.pow(r, 2)) {
			return !outside;
		} else {
			return outside;
		}
	} // method

} // class
