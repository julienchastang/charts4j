/**
 *
 * The MIT License
 *
 * Copyright (c) 2008 the original author or authors.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:

 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.

 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.googlecode.charts4j;

import static com.googlecode.charts4j.Color.*;
import static com.googlecode.charts4j.UrlUtil.normalize;
import static org.junit.Assert.assertEquals;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 * 
 */
public class MarkableChartTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        Logger.global.setLevel(Level.ALL);
    }

    /**
     * @throws java.lang.Exception
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test0() {
        final Line line = Plots.newLine(Data.newData(10, 20, 30));
        // Defining Line
        final Line line2 = Plots.newLine(Data.newData(0, 45, 35, 75, 100));
        line2.setColor(RED);
        line2.addShapeMarker(Shape.DIAMOND, BLUE, 20, 1);
        line2.addShapeMarker(Shape.CIRCLE, RED, 20, 2);
        line2.addTextMarker("Hello There", BLACK, 20, 3);
        // Defining chart.
        final LineChart chart = GCharts.newLineChart(line, line2);
        chart.setSize(400, 300);
        Logger.global.info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?chs=400x300&chd=e:GaMzTN,AAczWZv...&chco=000000,FF0000&chm=d,0000FF,1,1,20,0|o,FF0000,1,2,20,0|tHello+There,000000,1,3,20,0&cht=lc";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }

    @Test
    public void test1() {
        final Data xData = Data.newData(10, 20, 30);
        final Data yData = Data.newData(10, 20, 30);
        final ScatterPlotData data = Plots.newScatterPlotData(xData, yData);
        data.addShapeMarker(Shape.DIAMOND, RED, 20, 0);
        final ScatterPlot chart = GCharts.newScatterPlot(data);
        Logger.global.info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?chd=e:GaMzTN,GaMzTN&chm=o,000000,0,0,10,0|d,FF0000,0,0,20,0&chs=200x125&cht=s";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }

    // This test exposes a known bug in the google chart api. In particular, you
    // can't mix and match shape marker in scatter plots.
    @Test
    public void test2() {
        final Data xData = Data.newData(10, 20, 30);
        final Data yData = Data.newData(10, 20, 30);
        final ScatterPlotData data = Plots.newScatterPlotData(xData, yData);
        data.addShapeMarker(Shape.ARROW, GREEN, 5, 0);
        data.addShapeMarker(Shape.CIRCLE, BLUE, 20, 1);
        data.addShapeMarker(Shape.DIAMOND, RED, 10, 2);
        final ScatterPlot chart = GCharts.newScatterPlot(data);
        Logger.global.info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?chd=e:GaMzTN,GaMzTN&chm=o,000000,0,0,10,0|a,008000,0,0,5,0|o,0000FF,0,1,20,0|d,FF0000,0,2,10,0&chs=200x125&cht=s";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }

    @Test
    public void test3() {
        final Line line = Plots.newLine(Data.newData(10, 20, 30));
        final LineChart chart = GCharts.newLineChart(line);
        chart.addHorizontalRangeMarker(20, 80, RED);
        chart.addVerticalRangeMarker(20, 80, BLUE);
        // Defining background and chart fills.
        Logger.global.info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?chd=e:GaMzTN&chm=r,FF0000,0,0.20,0.80|R,0000FF,0,0.20,0.80&chs=200x125&cht=lc";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }

    @Test
    public void test4() {
        final Line line1 = Plots.newLine(Data.newData(70, 80, 90));
        final Line line2 = Plots.newLine(Data.newData(40, 50, 60));
        final Line line3 = Plots.newLine(Data.newData(10, 20, 30));
        line1.setFillAreaColor(GREEN);
        line2.setFillAreaColor(BLUE);
        line3.setFillAreaColor(RED);
        final LineChart chart = GCharts.newLineChart(line1, line2, line3);
        // Defining background and chart fills.
        Logger.global.info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?cht=lc&chs=200x125&chm=B,008000,0,0,0|B,0000FF,1,0,0|B,FF0000,2,0,0&chd=e:szzM5m,ZmgAmZ,GaMzTN";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }

    @Test
    public void testPriority() {
        // Defining Line
        final Line line = Plots.newLine(Data.newData(0, 45, 35, 75, 100));
        line.setColor(GREEN);
        Marker diamond = Markers.newShapeMarker(Shape.DIAMOND, BLUE, 20, Priority.HIGH);
        Marker circle = Markers.newShapeMarker(Shape.CIRCLE, RED, 20, Priority.LOW);
        line.addMarker(diamond, 1);
        line.addMarker(circle, 2);
        // Defining chart.
        final LineChart chart = GCharts.newLineChart(line);
        chart.setSize(400, 300);
        Logger.global.info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?cht=lc&chs=400x300&chco=008000&chm=d,0000FF,0,1,20,1|o,FF0000,0,2,20,-1&chd=e:AAczWZv...";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }
}
