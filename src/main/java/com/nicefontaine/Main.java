package com.nicefontaine;

import processing.awt.PSurfaceAWT;
import processing.core.PSurface;

import javax.swing.*;

public class Main {

    public static void main(String... args) {
        Processor processor = new Processor();
        PSurface surface = processor.getSurface();
        surface.setSize(600, 600);
        PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surface.getNative();

        JFrame frame = new JFrame("Animation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(canvas);
        frame.setSize(600, 600);
        frame.setVisible(true);

        surface.startThread();
    }
}
