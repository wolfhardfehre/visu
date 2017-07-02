package com.nicefontaine.projections;

public class NoProjection implements Projection {
    @Override
    public float[] project(float x, float y) {
        return new float[] {x, y};
    }
}
