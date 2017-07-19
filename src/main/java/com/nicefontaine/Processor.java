package com.nicefontaine;

import com.nicefontaine.models.CoordinateModel;
import com.nicefontaine.projections.Projection;
import com.nicefontaine.shapes.Circle;
import com.nicefontaine.shapes.Shape;
import processing.core.PApplet;
import processing.core.PSurface;

public class Processor extends PApplet {

    private final Shape shape;
    private final CoordinateModel model;
    private final boolean isUpdater;

    Processor(final Projection projection, CoordinateModel model, boolean isUpdater) {
        this.shape = new Circle(this, projection, 20, 100);
        this.model = model;
        this.isUpdater = isUpdater;
    }

    public void settings() {
        size(600, 600);
    }

    public void draw() {
        background(0);
        if (isUpdater) {
            model.set(new int[] {mouseX, mouseY});
        }
        int[] values = model.get();
        shape.draw(values[0], values[1]);
    }

    public PSurface getSurface() {
        return initSurface();
    }
}