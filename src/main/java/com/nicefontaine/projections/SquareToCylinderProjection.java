package com.nicefontaine.projections;

import processing.core.PApplet;

public class SquareToCylinderProjection implements Projection {

    private final float radius;
    private final float width;

    public SquareToCylinderProjection(float radius, float width) {
        this.radius = radius;
        this.width = width;
    }

    @Override
    public float[] project(float x, float y) {
        float delta  = (2 * PApplet.PI * x) / width;
        float xp = width / 2F + PApplet.cos(delta) * radius;
        float yp = width - (width / 2F + PApplet.sin(delta) * radius);
        return new float[] {xp, yp};
    }
}
