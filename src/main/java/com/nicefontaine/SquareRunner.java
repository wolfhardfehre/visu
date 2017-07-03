package com.nicefontaine;

import com.nicefontaine.projections.CylinderProjection;
import com.nicefontaine.projections.Projection;
import com.nicefontaine.shapes.Circle;
import com.nicefontaine.shapes.Shape;
import processing.core.PApplet;
import processing.core.PSurface;

public class SquareRunner extends PApplet {

    private Projection projection;
    private float radius = 100;
    private int width = 600;
    private Shape shape;

    public void settings() {
        size(width, width);
    }

    public void setup() {
        projection = new CylinderProjection(radius, width, 100);
        //shape = new Square(this, projection, 5, 5);
        shape = new Circle(this, projection, 20, 100);
    }

    public void draw() {
        background(0);
        shape.draw(mouseX, mouseY);

        //ellipse(mouseX, mouseY, 70, 60);
        //square(mouseX, mouseY, 5, 5);
        //polygon(mouseX, mouseY, 80, 20);
    }

    public PSurface getSurface() {
        return initSurface();
    }

    void polygon(float x, float y, float radius, int npoints) {
        float angle = TWO_PI / npoints;
        beginShape();
        for (float a = 0; a < TWO_PI; a += angle) {
            float sx = x + cos(a) * radius;
            float sy = y + sin(a) * radius;
            vertex(sx, sy);
        }
        endShape(CLOSE);
    }
}