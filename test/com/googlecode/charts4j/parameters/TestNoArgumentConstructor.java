package com.googlecode.charts4j.parameters;

import org.junit.Test;
import static org.junit.Assert.assertNotNull;

import com.googlecode.charts4j.parameters.GridLineParameter;

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
