package com.nicefontaine;

import com.nicefontaine.models.CoordinateModel;
import com.nicefontaine.projections.CylinderProjection;
import com.nicefontaine.projections.NoProjection;
import com.nicefontaine.projections.Projection;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private final ProcessorView cylinderView;
    private final ProcessorView normalView;

    public MainFrame(String title) {
        super(title);

        // set layout manager
        setLayout(new BorderLayout());

        CoordinateModel model = new CoordinateModel();

        // create swing component
        Projection projection = new CylinderProjection(100, 600, 100);
        cylinderView = createView("Cylinder", projection, model, false);

        projection = new NoProjection();
        normalView = createView("Normal", projection, model, true);

        // add swing components to contant pane
        Container container = getContentPane();
        container.add(cylinderView, BorderLayout.WEST);
        container.add(normalView, BorderLayout.EAST);
    }

    private ProcessorView createView(final String title,
                                     final Projection projection,
                                     final CoordinateModel model,
                                     final boolean isUpdater) {
        final Processor processor = new Processor(projection, model, isUpdater);
        return new ProcessorView(title, processor);
    }

    public void start() {
        cylinderView.start();
        normalView.start();
    }
}
