package com.cfs.main;

import javax.swing.*;
import java.awt.*;

public class GUI extends Canvas {

    private static final int WIDTH = 1000;
    private static final int HEIGHT = 700;

    private JFrame frame;

    void createAndShowGUI(){
        frame = new JFrame("Fractal Tree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.add(this);
        frame.setVisible(true);
    }

    @Override
    public void paint(Graphics g){
        g.setColor(Color.BLACK);
        drawTree(g, WIDTH / 2, HEIGHT - 50, -90, 11);
    }

    private void drawTree(Graphics g, int x1, int y1, double angle, int depth){
        if(depth == 0){
            return;
        }
        double r = 10.0;
        int x2 = x1 + (int)(Math.cos(Math.toRadians(angle)) * depth * r);
        int y2 = y1 + (int)(Math.sin(Math.toRadians(angle)) * depth * r);
        g.drawLine(x1, y1, x2, y2);
        try {
            Thread.sleep(5);
        } catch(Exception ignore){}

        drawTree(g, x2, y2, angle - 30, depth - 1);
        drawTree(g, x2, y2, angle + 30, depth - 1);
    }
}
