package com.nicefontaine;

import com.nicefontaine.projections.Projection;
import com.nicefontaine.projections.PlaneToCylinderProjection;
import org.junit.Assert;
import org.junit.Test;

public class PlaneToCylinderProjectionTest {

    private static final float PRECISION = 1e-6f;

    @Test
    public void projectSquareToCylinder22_withRadius2() {
        // given
        Projection projection = new PlaneToCylinderProjection(2F, 8F);

        // when
        float[] result = projection.project(2, 2);

        // then
        Assert.assertEquals(4, result[0], PRECISION);
        Assert.assertEquals(2, result[1], PRECISION);
    }

    @Test
    public void projectSquareToCylinder44_withRadius2() {
        // given
        Projection projection = new PlaneToCylinderProjection(2F, 8F);

        // when
        float[] result = projection.project(4, 4);

        // then
        Assert.assertEquals(2, result[0], PRECISION);
        Assert.assertEquals(4, result[1], PRECISION);
    }

    @Test
    public void projectSquareToCylinder66_withRadius2() {
        // given
        Projection projection = new PlaneToCylinderProjection(2F, 8F);

        // when
        float[] result = projection.project(6, 6);

        // then
        Assert.assertEquals(4, result[0], PRECISION);
        Assert.assertEquals(6, result[1], PRECISION);
    }

    @Test
    public void projectSquareToCylinder88_withRadius2() {
        // given
        Projection projection = new PlaneToCylinderProjection(2F, 8F);

        // when
        float[] result = projection.project(8, 8);

        // then
        Assert.assertEquals(6, result[0], PRECISION);
        Assert.assertEquals(4, result[1], PRECISION);
    }

    @Test
    public void projectSquareToCylinder22_withRadius4() {
        // given
        Projection projection = new PlaneToCylinderProjection(4F, 8F);

        // when
        float[] result = projection.project(2, 2);

        // then
        Assert.assertEquals(4, result[0], PRECISION);
        Assert.assertEquals(0, result[1], PRECISION);
    }

    @Test
    public void projectSquareToCylinder44_withRadius4() {
        // given
        Projection projection = new PlaneToCylinderProjection(4F, 8F);

        // when
        float[] result = projection.project(4, 4);

        // then
        Assert.assertEquals(0, result[0], PRECISION);
        Assert.assertEquals(4, result[1], PRECISION);
    }

    @Test
    public void projectSquareToCylinder66_withRadius4() {
        // given
        Projection projection = new PlaneToCylinderProjection(4F, 8F);

        // when
        float[] result = projection.project(6, 6);

        // then
        Assert.assertEquals(4, result[0], PRECISION);
        Assert.assertEquals(8, result[1], PRECISION);
    }

    @Test
    public void projectSquareToCylinder88_withRadius4() {
        // given
        Projection projection = new PlaneToCylinderProjection(4F, 8F);

        // when
        float[] result = projection.project(8, 8);

        // then
        Assert.assertEquals(8, result[0], PRECISION);
        Assert.assertEquals(4, result[1], PRECISION);
    }
}
