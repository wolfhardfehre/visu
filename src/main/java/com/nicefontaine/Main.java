package com.nicefontaine;

import processing.awt.PSurfaceAWT;
import processing.core.PSurface;

import javax.swing.*;

public class Main {

    public static void main(String... args) {
        SquareRunner pt = new SquareRunner();
        PSurface ps = pt.getSurface();
        ps.setSize(600, 600);
        PSurfaceAWT.SmoothCanvas smoothCanvas = (PSurfaceAWT.SmoothCanvas) ps.getNative();

        JFrame frame = new JFrame("JFrame Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(smoothCanvas);
        frame.setSize(600, 600);
        frame.setVisible(true);

        ps.startThread();
    }
}
