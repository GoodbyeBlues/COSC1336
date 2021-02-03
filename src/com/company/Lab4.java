package com.company;

import java.awt.*;


public class Lab4 {
    // The width and height of the DrawingPanel.
    public static final int PANEL_SIZE = 444;

    // Right now this draws an X, but should draw two hyperbolas.
    public static void main(String[] args) {
        DrawingPanel panel = new DrawingPanel(PANEL_SIZE, PANEL_SIZE);
        Graphics g = panel.getGraphics();
        g.drawLine(0, 0, PANEL_SIZE, PANEL_SIZE);
        g.drawLine(0, PANEL_SIZE, PANEL_SIZE, 0);
    }
}
