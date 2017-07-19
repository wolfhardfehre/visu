package com.nicefontaine;

import com.nicefontaine.projections.Projection;
import processing.awt.PSurfaceAWT;
import processing.core.PSurface;

import javax.swing.*;
import java.awt.*;

class ProcessorView extends JPanel {

    private final PSurface surface;

    ProcessorView(String title, Processor processor) {
        surface = processor.getSurface();
        surface.setSize(600, 600);

        PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surface.getNative();

        Dimension size = getPreferredSize();
        size.width = 600;
        size.height = 600;
        setPreferredSize(size);

        setBorder(BorderFactory.createTitledBorder(title));

        GridBagConstraints constraints = new GridBagConstraints();

        constraints.anchor = GridBagConstraints.LINE_START;

        constraints.weightx = 0.5;
        constraints.weighty = 0.5;

        constraints.gridx = 0;
        constraints.gridy = 0;

        add(canvas, constraints);
    }

    void start() {
        surface.startThread();
    }
}
