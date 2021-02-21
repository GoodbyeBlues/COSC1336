import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class lab7 {
	
		//these values are global to all methods
		static final int PANEL_SIZE = 400;
		static final int width = PANEL_SIZE - 100;
		static final int height = PANEL_SIZE - 100;
		static final int UpperLeftCircleX = 50;
		static final int UpperLeftCircleY = 50;
		static final int r = width / 2;  //circle radius
		static final int drunkRadius = 4;
		static final int increment = 5;

		static int Dx = UpperLeftCircleX + r;  //drunk initial position
		static int Dy = UpperLeftCircleY + r;  //at center of circle
		static DrawingPanel panel = new DrawingPanel(PANEL_SIZE,PANEL_SIZE); 
		//get graphics reference from DrawingPanel
		static Graphics g = panel.getGraphics();
	   
		public static void main(String[] args) {
			/**
			 * Drunkards Walk Program
			 * Using a user inputted circle radius
			 * and circle color, print a circle and 
			 * begin placing pixels at random increments
			 * until the pixel exits the circle.
			 */

			//set Cx, Cy  values correctly
			int Cy =  UpperLeftCircleX + r;  //center of circle in X
			int Cx =  UpperLeftCircleY + r;  //center of circle in Y

			int numberOfSteps = 0;

			Random rand = new Random(); //random generator

			// draw big circle
			g.drawOval(UpperLeftCircleX, UpperLeftCircleY, 
										width, height);  
			//draw big circle
			g.setColor(Color.RED);
			//draw drunk initial position
			g.fillOval(Dx, Dy, drunkRadius, drunkRadius); 

			//animation loop, while not outside big circle loop
			while(!outsideCircle(Cx, Cy)) {

				//move drunk
				moveDrunk(rand, g);
				numberOfSteps++;

				//pause for animation effect
				panel.sleep(50);
				
			}  //end while

			System.out.println("Drunk moved outside big circle ");
			System.out.println("Number of steps: " + numberOfSteps);

			} //main
	   
	   
		public static void moveDrunk(Random rand, Graphics g) {
			//code moveDrunk. Change DX or Dy depending of outcome  
			// of generated value using rand.nextInt(4); Returns 0,1,2,3 
			// nested if-else,  0 move up,1 move down,2 move right,move left
			//                     in Y        in Y        in X       in X 
			// move increments of 5 pixels

			//erase drunk's last position
			//g.setColor(Color.WHITE);
			//g.fillOval(Dx, Dy, drunkRadius, drunkRadius); 

			//move drunk position coordinate
			//use if-else statement here to handle 4 cases of randNumber 
			int randNumber = rand.nextInt(4); //0-3

			if (randNumber == 0) {
				// Move up	y+=5
				Dy += increment; 
			}
			else if (randNumber == 1) {
				// Move down	y-=5
				Dy -= increment; 
			}
			else if (randNumber == 2) {
				// Move right	x+=5
				Dx += increment; 
			}
			else {  // randNumber is 3
				// Move left	x-=5
				Dx -= increment; 
			}

			//redraw with updated coordinate
			g.setColor(Color.RED);
			//move drunk with new coordinates
			g.fillOval(Dx, Dy, drunkRadius, drunkRadius);
	   } //method
	   
	  
 
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
} //class
