package com.googlecode.charts4j;

import static com.googlecode.charts4j.Color.*;
import static com.googlecode.charts4j.UrlUtil.normalize;
import static org.junit.Assert.assertEquals;

import java.util.logging.Logger;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PlotTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
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
    public void testAddShapeMarkersShapeColorIntIntInt() {
        final Line line =  TestUtil.getBasicLine();
        line.addShapeMarkers(Shape.DIAMOND, BLUE, 12);
        final LineChart chart = GCharts.newLineChart(line);
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?chd=e:AAgA..&chm=d,0000FF,0,-1,12,0&chs=200x125&cht=lc";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }

    @Test
    public void testAddTextMarkers() {
        final Line line =  TestUtil.getBasicLine();
        line.addTextMarker("foo", BLACK, 12, 1);
        final LineChart chart = GCharts.newLineChart(line);
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?chd=e:AAgA..&chm=tfoo,000000,0,1,12,0&chs=200x125&cht=lc";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }

    @Test
    public void testAddShapeMarkersShapeColorInt() {
        final Line line =  TestUtil.getBasicLine();
        line.addShapeMarkers(Shape.DIAMOND, BLUE, 12);
        final LineChart chart = GCharts.newLineChart(line);
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?chd=e:AAgA..&chm=d,0000FF,0,-1,12,0&chs=200x125&cht=lc";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }

    @Test
    public void testAddMarkers() {
        final Line line =  TestUtil.getBasicLine();
        line.addMarker(Markers.newShapeMarker(Shape.X, RED, 12), 0);
        line.addMarker(Markers.newTextMarker("foo", BLACK, 12), 1);
        final LineChart chart = GCharts.newLineChart(line);
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?chd=e:AAgA..&chm=x,FF0000,0,0,12,0|tfoo,000000,0,1,12,0&chs=200x125&cht=lc";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }

    @Test
    public void testAddFlaggedMarkers() {
        final Line line =  TestUtil.getBasicLine();
        line.addMarker(Markers.newFlaggedTextMarker("foo", BLACK, 12), 1);
        final LineChart chart = GCharts.newLineChart(line);
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?chd=e:AAgA..&chm=ffoo,000000,0,1,12,0&chs=200x125&cht=lc";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }
}
