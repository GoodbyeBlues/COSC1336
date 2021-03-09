import java.awt.*;
import javax.swing.*;


public class Project2 {
    // Window Class Variables
    public static final int PANEL_SIZE = 300;  // Constant panel size var, width and height
    public static DrawingPanel p = new DrawingPanel(PANEL_SIZE, PANEL_SIZE);  // Init Panel with proper dimensions
    public static Graphics g = p.getGraphics();  // Init graphics instance
    public static JLabel label = new JLabel("TEST THIS IS A TEST");
    // Player Variables
    public static int PATROL_Y = 250;
    public static int patrolX = 270;
    public static int PATROL_SIZE = 20;
    // Enemy Variables
    public static int ENEMY_Y = 20;
    public static int enemyX = 0;
    public static int ENEMY_SIZE = 30;
    // Input Variables
    public static int RIGHT_ARROW = 39;
    public static int LEFT_ARROW = 37;
    public static int UP_ARROW = 38;
    // Player Missle Variables
    public static int patrolMissleX;
    public static int patrolMissleY = 0;
    public static int PATROL_MISSILE_LENGTH = 10;


    public static void main(String[] args) {
        System.out.println("Project 2 written by Elizabeth Graham\n"); // Output student name
        // startGame(panel, g);
        //UpdateLabel("Project 2 by Elizabeth Graham");
    }


    public static void startGame(DrawingPanel panel, Graphics g) {
        /**
         * 
         */
        int x = 0;
        int y = 270;
        int deltaX = 1;
        int deltaY = -3;

        drawPatrol(g, Color.GREEN);

        for (int time = 0; time <= 1000; time++) {
            panel.sleep(50);
        }
    }


    public static void drawPatrol(Graphics g, Color c) {
        /**
         * fills a square at x = patrolX, y = PATROL_Y, with side PATROL_SIZE in the
         * given color. Do a Google for “Java Graphics fillRect to find a graphics method.
         * Call drawPatrol(g, Color.GREEN) before the for loop statement.
         * Get it working.
         */
        /* PSEUDOCODE
        */
    }


    public static void updateEnemyShip(Graphics g) {
        /**
         * draws the enemy ship first in white, then increment enemyX by 1, and then draws
         * the ship again in red. Put a call to this method inside the for loop.
         */
        /* PSEUDOCODE
        */
    }


    public static void updatePatrolMissle(Graphics g) {
        /**
            moves the missile and draws it similar to moveEnemyShipAndDraw:
            •Do not draw anything if patrolMissileY is 0.
            •Otherwise, the missile as a vertical line with the stated length and x-position.
            •PatrolMissileY is the top of the line.
            •Draw the missile in white, move the missile up 5 pixels, and draw it again in
            black.
            •If the patrolMissileY is 0 or negative, do not draw the missile in black, but set
            patrolMissileY to 0.
            Call this method before the sleep in the loop.
            When the up arrow key is pushed and patrolMissileY is 0, set patrolMissileX to
            be the center of the patrol ship and set the top of the missile so that its bottom is one
            pixel above the top of the patrol ship (PATROL_Y).
            You should only be able to fire one missile at a time and the up arrow should not do
            anything if a missile is still displayed.
         */
        /* PSEUDOCODE
        */
    }


    public static boolean detectHit() {
        /**
            Returns true if the current missile has hit the enemy ship and false otherwise.
            There is a hit if the top of the missile is inside the enemy ship.
            For this to happen two thing must be true:
            •the x value of the top of the missile must be between the left and right sides of
            the enemy
            •the y value of the top of the missile must be between the top and bottom of the
            enemy.
            At the end of the loop in startGame, set hit to true if detectHit() returns true.
            Modify moveEnemyShipAndDraw so that if hit is true, the enemy ship is drawn in black
            and does not move. In this case, display the message:
            Enemy ship hit!
            in green on a line below the patrol ship.
            If the enemy ship moves off the screen or time runs out, Display the message:
            Enemy ship got away!
            in red on a line below the patrol ship.
         */

        /* PSEUDOCODE
        */
        return false;
    }


    public static void inputListener(DrawingPanel panel, Graphics g) {
        /**
            This will call panel.getKeyCode() that returns a code for a key. It returns 0 if no key
            has been pushed, and will return one of the above constants if the corresponding arrow
            key has been pushed.
            •The method handleKeys should do nothing if the returned key code is 0.
            •If the key code is RIGHT_ARROW or LEFT_ARROW, move the patrol ship to
            the right or left by 3 pixels, but do not let any part of the patrol ship move off the
            screen.
            To move the patrol ship:
            •draw the patrol ship in white (to erase the old one)
            •change patrolX
            •draw the patrol ship in green
            Call the method handleKeys in the loop. You should be able to move the patrol ship by
            pushing the left and right arrows on the keyboard.
            Before using the arrow keys, make sure your drawing window is the active window
            by clicking the mouse in this window.
         */

        /* PSEUDOCODE
        inputDict = {leftArrow: moveLeft, upArrow: shootMissle, rightArrow: moveRight}

        if panel.getKeyCode() in inputDict:
            inputDict[panel.getKeyCode()]()
        */
    }
}
