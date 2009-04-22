package com.googlecode.charts4j.parameters;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class TestNoArgumentConstructor {

    @Test
    public void testGridLineParameter() throws InstantiationException, IllegalAccessException {

        Parameter p = new GridLineParameter(1d, 2d, 1, 1);
        assertNotNull(p);

        Class<? extends Parameter> clazz = p.getClass();
        assertNotNull(clazz);

        Parameter p2 = clazz.newInstance();
        assertNotNull(p2);

    }

}
