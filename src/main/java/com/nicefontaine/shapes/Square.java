package com.nicefontaine.shapes;

import com.nicefontaine.projections.Projection;
import processing.core.PApplet;

import static processing.core.PConstants.CLOSE;

public class Square implements Shape {

    private final PApplet applet;
    private final Projection projection;
    private final float step;
    private final float leg;

    public Square(PApplet applet, Projection projection, float leg, int npoints) {
        this.applet = applet;
        this.projection = projection;
        this.step = leg / npoints;
        this.leg = leg;
    }

    @Override
    public void draw(float x, float y) {
        applet.beginShape();
        float sx = x;
        float sy = y;
        for (float a = step; a < leg; a += step) {
            sx += a;
            float[] res = projection.project(sx, sy);
            applet.vertex(res[0], res[1]);
        }
        for (float a = step; a < leg; a += step) {
            sy += a;
            float[] res = projection.project(sx, sy);
            applet.vertex(res[0], res[1]);
        }
        for (float a = step; a < leg; a += step) {
            sx -= a;
            float[] res = projection.project(sx, sy);
            applet.vertex(res[0], res[1]);
        }
        for (float a = step; a < leg; a += step) {
            sy -= a;
            float[] res = projection.project(sx, sy);
            applet.vertex(res[0], res[1]);
        }
        applet.endShape(CLOSE);
    }
}
