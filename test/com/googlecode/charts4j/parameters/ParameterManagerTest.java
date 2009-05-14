package com.googlecode.charts4j.parameters;

import static com.googlecode.charts4j.Color.BLUE;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.googlecode.charts4j.Markers;

public class ParameterManagerTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        Logger.global.setLevel(Level.ALL);
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test0() throws Exception {
        final ParameterManager pm = new ParameterManager();
        pm.init("http://chart.apis.google.com/chart");
        pm.setChartTypeParameter(ChartType.LINE_CHART);
        Logger.global.info(pm.toString());
    }

    @Test
    public void test1() throws Exception {
        final ParameterManager pm = new ParameterManager();
        pm.init("http://chart.apis.google.com/chart");
        pm.setChartTypeParameter(ChartType.LINE_CHART);
        pm.addMarker(Markers.newTextMarker("Hello", BLUE, 12), 0, 3, 4, 1);
        Logger.global.info(pm.toString());
    }
}
