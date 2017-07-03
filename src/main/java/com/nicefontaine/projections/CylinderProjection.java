package com.nicefontaine.projections;

import processing.core.PVector;

public class CylinderProjection implements Projection {

    private final float distance;
    private final float halfWidth;
    private final Projection projection;

    public CylinderProjection(float radius, float width, float distance) {
        this.distance = distance;
        this.halfWidth = width / 2;
        this.projection = new PlaneToCylinderProjection(radius, width);
    }

    @Override
    public float[] project(float x, float y) {
        float sigma = distance / (distance - y);
        PVector support = new PVector(halfWidth, halfWidth, distance);
        float[] result = projection.project(x, y);
        PVector direction = new PVector(halfWidth - result[0],halfWidth - result[1],distance - y);
        PVector res = support.sub(direction.mult(sigma));
        return new float[] {res.x, res.y};
    }
}
