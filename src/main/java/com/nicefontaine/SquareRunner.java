package com.nicefontaine;

import com.nicefontaine.projections.SquareToCircleAreaProjection;
import com.nicefontaine.projections.Projection;
import processing.core.PApplet;
import processing.core.PSurface;

public class SquareRunner extends PApplet {

    private Projection projection;
    private float radius = 300;
    private int width = 600;

    public void settings() {
        size(width, width);
    }

    public void setup() {
        projection = new SquareToCircleAreaProjection(radius, width, 100);
    }

    public void draw() {
        background(0);
        //ellipse(mouseX, mouseY, 70, 60);
        square(mouseX, mouseY, 5, 5);
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

    private void square(float x, float y, float width, int pointsPerSide) {
        float step = width / pointsPerSide;
        beginShape();
        float sx = x;
        float sy = y;
        for (float a = step; a < width; a += step) {
            sx += a;
            float[] res = projection.project(sx, sy);
            vertex(res[0], res[1]);
        }
        for (float a = step; a < width; a += step) {
            sy += a;
            float[] res = projection.project(sx, sy);
            vertex(res[0], res[1]);
        }
        for (float a = step; a < width; a += step) {
            sx -= a;
            float[] res = projection.project(sx, sy);
            vertex(res[0], res[1]);
        }
        for (float a = step; a < width; a += step) {
            sy -= a;
            float[] res = projection.project(sx, sy);
            vertex(res[0], res[1]);
        }
        endShape(CLOSE);
    }
}