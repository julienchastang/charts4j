/**
 *
 * The MIT License
 *
 * Copyright (c) 2011 the original author or authors.
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

import static com.googlecode.charts4j.Color.BLUE;
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
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 */
public class ScatterPlotTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).setLevel(Level.ALL);
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
    public void test0() {
        final Data xData = Data.newData(0, 10, 20, 100);
        final Data yData = Data.newData(0, 45, 10, 100);
        final ScatterPlotData data = Plots.newScatterPlotData(xData, yData);
        final GChart chart = GCharts.newScatterPlot(data);
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?chd=e:AAGaMz..,AAczGa..&chm=o,000000,0,0,10,0&chs=200x125&cht=s";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }

    @Test
    public void test1() {
        final Data xData = Data.newData(0, 10, 20, 100);
        final Data yData = Data.newData(0, 45, 10, 100);
        final ScatterPlotData data = Plots.newScatterPlotData(xData, yData);
        data.addShapeMarkers(Shape.DIAMOND, BLUE, 20);
        data.setPointSizes(Data.newData(100, 50, 100, 10));
        final ScatterPlot chart = GCharts.newScatterPlot(data);
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?chd=e:AAGaMz..,AAczGa..,..gA..Ga&chm=d,0000FF,0,-1,20,0&chs=200x125&cht=s";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }

    @Test
    public void test2() {
        final Data xData = Data.newData(0, 10, 20, 100);
        final Data yData = Data.newData(0, 45, 10, 100);
        final ScatterPlotData data = Plots.newScatterPlotData(xData, yData);
        data.addShapeMarker(Shape.DIAMOND, BLUE, 20,2);
        final ScatterPlot chart = GCharts.newScatterPlot(data);
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?chd=e:AAGaMz..,AAczGa..&chm=o,000000,0,0,10,0|d,0000FF,0,2,20,0&chs=200x125&cht=s";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }
}
