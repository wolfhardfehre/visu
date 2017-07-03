package com.nicefontaine.shapes;

import com.nicefontaine.projections.Projection;
import processing.core.PApplet;

import static processing.core.PApplet.cos;
import static processing.core.PApplet.sin;
import static processing.core.PConstants.CLOSE;
import static processing.core.PConstants.TWO_PI;

public class Circle implements Shape {

    private final PApplet applet;
    private final Projection projection;
    private final float radius;
    private final float npoints;

    public Circle(PApplet applet, Projection projection, float radius, float npoints) {
        this.applet = applet;
        this.projection = projection;
        this.radius = radius;
        this.npoints = npoints;
    }

    @Override
    public void draw(float x, float y) {
        float angle = TWO_PI / npoints;
        applet.beginShape();
        for (float a = 0; a < TWO_PI; a += angle) {
            float sx = x + cos(a) * radius;
            float sy = y + sin(a) * radius;
            float[] res = projection.project(sx, sy);
            applet.vertex(res[0], res[1]);
        }
        applet.endShape(CLOSE);
    }
}
