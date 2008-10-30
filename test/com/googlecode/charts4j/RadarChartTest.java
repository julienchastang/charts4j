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
 * 
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 */
public class RadarChartTest {

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

    /**
     * Testing radar charts
     */
    @Test
    public void test0() {
        Data data = Data.newData(10, 20, 30, 40, 50, 60, 70, 80, 90);
        final RadarChart chart = GCharts.newRadarChart(Plots.newRadarPlot(data));
        chart.setSize(500, 500);
        Logger.global.info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?cht=r&chs=500x500&chd=e:GaMzTNZmgAmZszzM5m";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }
    
    /**
     * Testing radar charts with grids
     */
    @Test
    public void testGrid() {
        Data data = Data.newData(10, 20, 30, 40, 50, 60, 70, 80, 90);
        final RadarChart chart = GCharts.newRadarChart(Plots.newRadarPlot(data));
        chart.setSize(500, 500);
        chart.setGrid(10, 10, 2, 2);
        Logger.global.info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?chd=e:GaMzTNZmgAmZszzM5m&chg=10.0,10.0,2,2&chs=500x500&cht=r";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }
    
    /**
     * Testing radar charts with range markers
     */
    @Test
    public void testRangeMarker() {
        Data data = Data.newData(10, 20, 30, 40, 50, 60, 70, 80, 90);
        final RadarChart chart = GCharts.newRadarChart(Plots.newRadarPlot(data));
        chart.setSize(500, 500);
        chart.addRadialAxisRangeMarker(0, 50, RED);
        chart.addConcentricAxisRangeMarker(10, 90, GREEN);
        Logger.global.info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?chd=e:GaMzTNZmgAmZszzM5m&chm=r,008000,0,0.10,0.90|R,FF0000,0,0.00,4.00&chs=500x500&cht=r";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }

    /**
     * Testing radar charts
     */
    @Test
    public void test1() {
        final RadarPlot plot1 = Plots.newRadarPlot(Data.newData(10, 20, 30, 40, 50, 60, 70, 80, 90), GREEN);
        final RadarPlot plot2 = Plots.newRadarPlot(Data.newData(90, 80, 70, 60, 50, 40, 30, 20, 10), RED);
        final RadarChart chart = GCharts.newRadarChart(plot1, plot2);
        chart.setSize(500, 500);
        chart.addRadialAxisLabels(AxisLabelsFactory.newRadialAxisLabels("0", "45", "90", "135", "180", "225", "270", "315"));
        chart.setTitle("Cardioid");
        Logger.global.info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?cht=r&chs=500x500&chxt=x&chco=008000,FF0000&chd=e:GaMzTNZmgAmZszzM5m,5mzMszmZgAZmTNMzGa&chxl=0:|0|45|90|135|180|225|270|315&chtt=Cardioid";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }

    /**
     * Testing radar charts
     */
    @Test
    public void test2() {
        final RadarPlot plot1 = Plots.newRadarPlot(Data.newData(0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100), MAROON);
        plot1.setLineStyle(LineStyle.newLineStyle(5, 1, 0));
        final RadarChart chart = GCharts.newRadarChart(plot1);
        chart.setSize(500, 500);
        chart.addConcentricAxisLabels(AxisLabelsFactory.newAxisLabels("0", "50", "100"));
        Logger.global.info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?cht=r&chs=500x500&chxt=y&chls=5,1,0&chco=800000&chd=e:AAGaMzTNZmgAmZszzM5m..&chxl=0:|0|50|100";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }

    /**
     * Testing radar charts
     */
    @Test
    public void test3() {
        final RadarPlot plot1 = Plots.newRadarPlot(Data.newData(0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100), MAROON);
        plot1.setLineStyle(LineStyle.newLineStyle(5, 1, 0));
        final RadarChart chart = GCharts.newRadarChart(plot1);
        chart.setSize(500, 500);
        chart.addConcentricAxisLabels(AxisLabelsFactory.newAxisLabels("0", "50", "100"));
        chart.setSpline(true);
        chart.setTitle("The Spiral Jetty");
        Logger.global.info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?cht=rs&chs=500x500&chxt=y&chls=5,1,0&chco=800000&chd=e:AAGaMzTNZmgAmZszzM5m..&chxl=0:|0|50|100&chtt=The+Spiral+Jetty";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }

    /**
     * Testing radar charts
     */
    @Test
    public void test4() {
        final RadarPlot plot1 = Plots.newRadarPlot(Data.newData(0, 20, 30, 40, 50, 60, 70, 80, 0), ORANGERED);
        Color color = Color.newColor(BLUE.toString(), 55);
        plot1.setFillAreaColor(color);
        final RadarChart chart = GCharts.newRadarChart(plot1);
        chart.setSpline(true);
        chart.setTitle("A shell");
        chart.setSize(500, 500);
        chart.addRadialAxisLabels(AxisLabelsFactory.newRadialAxisLabels("0", "45", "90", "135", "180", "225", "270", "315"));
        Logger.global.info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?cht=rs&chs=500x500&chxt=x&chco=FF4500&chm=B,0000FF8C,0,0,0&chd=e:AAMzTNZmgAmZszzMAA&chxl=0:|0|45|90|135|180|225|270|315&chtt=A+shell";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }
}
