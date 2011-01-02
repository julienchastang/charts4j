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
public class BarChartTest {

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
    public void testNoLabel() {
        final BarChartPlot data1 = Plots.newBarChartPlot(Data.newData(35, 50, 30, 40), BLUE);
        final BarChartPlot data2 = Plots.newBarChartPlot(Data.newData(10, 20, 30, 25), RED, "Q2");
        final BarChart chart = GCharts.newBarChart(data1, data2);
        chart.setSize(400, 200);
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?cht=bvg&chbh=23,4,8&chs=400x200&chco=0000FF,FF0000&chdl=+|Q2&chd=e:WZgATNZm,GaMzTNQA";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }

    @Test
    public void test0() {
        final BarChartPlot data1 = Plots.newBarChartPlot(Data.newData(35, 50, 30, 40), BLUE, "Q1");
        final BarChartPlot data2 = Plots.newBarChartPlot(Data.newData(10, 20, 30, 25), RED, "Q2");
        final BarChart chart = GCharts.newBarChart(data1, data2);
        chart.addXAxisLabels(AxisLabelsFactory.newAxisLabels("2000", "2001", "2002", "2003"));
        chart.addYAxisLabels((AxisLabelsFactory.newAxisLabels("$0", "$100")));
        chart.setSize(400, 200);
        chart.setTitle("Quarterly Revenue|(in billions of dollars)", GREEN, 15);
        chart.setBackgroundFill(Fills.newSolidFill(LIGHTGREY));
        chart.setAreaFill(Fills.newSolidFill(LIGHTSEAGREEN));
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?chbh=23,4,8&chco=0000FF,FF0000&chd=e:WZgATNZm,GaMzTNQA&chdl=Q1|Q2&chf=bg,s,D3D3D3|c,s,20B2AA&chs=400x200&cht=bvg&chts=008000,15&chtt=Quarterly+Revenue%7C%28in+billions+of+dollars%29&chxl=0:|%240|%24100|1:|2000|2001|2002|2003&chxt=y,x";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }

    @Test
    public void testVerticalBarChart() {
        BarChartPlot data1 = Plots.newBarChartPlot(Data.newData(35, 50, 30, 40), BLUE, "Q1");
        BarChartPlot data2 = Plots.newBarChartPlot(Data.newData(10, 20, 30, 25), RED, "Q2");
        BarChart chart = GCharts.newBarChart(data1, data2);
        chart.setSize(400, 200);
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?cht=bvg&chbh=23,4,8&chs=400x200&chco=0000FF,FF0000&chdl=Q1|Q2&chd=e:WZgATNZm,GaMzTNQA";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }

    @Test
    public void testHorizontalBarChart() {
        BarChartPlot data1 = Plots.newBarChartPlot(Data.newData(35, 50, 30, 40), BLUE, "Q1");
        BarChartPlot data2 = Plots.newBarChartPlot(Data.newData(10, 20, 30, 25), RED, "Q2");
        BarChart chart = GCharts.newBarChart(data1, data2);
        chart.setSize(200, 300);
        chart.setHorizontal(true);
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?cht=bhg&chbh=23,4,8&chs=200x300&chco=0000FF,FF0000&chdl=Q1|Q2&chd=e:WZgATNZm,GaMzTNQA";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }

    @Test
    public void testStackedDataBarChart() {
        BarChartPlot data1 = Plots.newBarChartPlot(Data.newData(35, 50, 30, 40), BLUE, "Q1");
        BarChartPlot data2 = Plots.newBarChartPlot(Data.newData(10, 20, 30, 25), RED, "Q2");
        BarChart chart = GCharts.newBarChart(data1, data2);
        chart.setSize(200, 300);
        chart.setDataStacked(true);
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?cht=bvs&chbh=23,4,8&chs=200x300&chco=0000FF,FF0000&chdl=Q1|Q2&chd=e:WZgATNZm,GaMzTNQA";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }

    @Test
    public void testDataLineAndFillArea() {
        BarChartPlot data1 = Plots.newBarChartPlot(Data.newData(35, 50, 30, 40), BLUE, "Q1");
        BarChartPlot data2 = Plots.newBarChartPlot(Data.newData(10, 20, 30, 25), RED, "Q2");
        data1.setDataLine(3, RED, Priority.LOW);
        data1.setFillAreaColor(GREEN);
        data2.setDataLine(3, PINK, Priority.HIGH);
        data2.setFillAreaColor(YELLOW);
        BarChart chart = GCharts.newBarChart(data1, data2);
        chart.setSize(400, 200);
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?cht=bvg&chbh=23,4,8&chs=400x200&chco=0000FF,FF0000&chdl=Q1|Q2&chm=D,FF0000,0,0,3,-1|B,008000,0,0,0|D,FFC0CB,1,0,3,1|B,FFFF00,1,0,0&chd=e:WZgATNZm,GaMzTNQA";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }

    @Test
    public void testTextMarker() {
        BarChartPlot data1 = Plots.newBarChartPlot(Data.newData(35, 50, 30, 40), BLUE, "Q1");
        BarChartPlot data2 = Plots.newBarChartPlot(Data.newData(10, 20, 30, 25), RED, "Q2");
        data1.addShapeMarker(Shape.DIAMOND, AQUA, 20, 0);
        data1.addShapeMarker(Shape.DIAMOND, AQUA, 20, 1);
        data2.addTextMarker("foo", BLACK, 12, 1);
        BarChart chart = GCharts.newBarChart(data1, data2);
        chart.setSize(400, 200);
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?chbh=23,4,8&chco=0000FF,FF0000&chd=e:WZgATNZm,GaMzTNQA&chdl=Q1|Q2&chm=d,00FFFF,0,0,20,0|d,00FFFF,0,1,20,0|tfoo,000000,1,1,12,0&chs=400x200&cht=bvg";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }

    @Test
    public void testBarChartZeroLine() {
        BarChartPlot data1 = Plots.newBarChartPlot(Data.newData(0, 25, 50, 75, 100), BLUE);
        BarChartPlot data2 = Plots.newBarChartPlot(Data.newData(0, 25, 50, 75, 100), RED);
        data2.setZeroLine(50);
        BarChart chart = GCharts.newBarChart(data1, data2);
        chart.setSize(400, 200);
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?chs=400x200&chd=e:AAQAgAv...,AAQAgAv...&chco=0000FF,FF0000&chp=0.0,0.5&chbh=23,4,8&cht=bvg";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }

    @Test
    public void testSetSpaceBetweenGroupsOfBars() {
        BarChartPlot data1 = Plots.newBarChartPlot(Data.newData(0, 25, 50, 75, 100), BLUE);
        BarChartPlot data2 = Plots.newBarChartPlot(Data.newData(0, 25, 50, 75, 100), RED);
        BarChart chart = GCharts.newBarChart(data1, data2);
        chart.setSize(400, 200);
        chart.setSpaceBetweenGroupsOfBars(30);
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?chbh=23,4,30&chco=0000FF,FF0000&chd=e:AAQAgAv...,AAQAgAv...&chs=400x200&cht=bvg";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }

    @Test
    public void testSetBarWidth() {
        BarChartPlot data1 = Plots.newBarChartPlot(Data.newData(0, 25, 50, 75, 100), BLUE);
        BarChartPlot data2 = Plots.newBarChartPlot(Data.newData(0, 25, 50, 75, 100), RED);
        BarChart chart = GCharts.newBarChart(data1, data2);
        chart.setSize(400, 200);
        chart.setBarWidth(30);
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?chs=400x200&chd=e:AAQAgAv...,AAQAgAv...&chco=0000FF,FF0000&chbh=30,4,8&cht=bvg";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }

    @Test
    public void testSetSpaceWithinGroupsOfBars() {
        BarChartPlot data1 = Plots.newBarChartPlot(Data.newData(0, 25, 50, 75, 100), BLUE);
        BarChartPlot data2 = Plots.newBarChartPlot(Data.newData(0, 25, 50, 75, 100), RED);
        BarChart chart = GCharts.newBarChart(data1, data2);
        chart.setSize(400, 200);
        chart.setSpaceWithinGroupsOfBars(30);
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?chs=400x200&chd=e:AAQAgAv...,AAQAgAv...&chco=0000FF,FF0000&chbh=23,30,8&cht=bvg";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }

    @Test
    public void testDifferentColoredBars() {
        BarChartPlot data1 = Plots.newBarChartPlot(Data.newData(10, 25, 50, 75, 100), BLUE);
        BarChartPlot data2 = Plots.newBarChartPlot(Data.newData(100, 75, 50, 35, 10), RED);
        data2.setColor(GREEN, 0);
        BarChart chart = GCharts.newBarChart(data1,data2);
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?cht=bvg&chbh=23,4,8&chs=200x125&chd=e:GaQAgAv...,..v.gAWZGa&chco=0000FF,008000|FF0000|FF0000|FF0000|FF0000";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }

    @Test
    public void testAutoResize() {
        BarChartPlot data1 = Plots.newBarChartPlot(Data.newData(5, 25, 50, 75, 100), BLUE);
        BarChartPlot data2 = Plots.newBarChartPlot(Data.newData(5, 25, 50, 75, 100), RED);
        BarChart chart = GCharts.newBarChart(data1, data2);
        chart.setSize(400, 200);
        chart.setBarWidth(BarChart.AUTO_RESIZE);
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?chbh=a,4,8&chco=0000FF,FF0000&chd=e:DNQAgAv...,DNQAgAv...&chs=400x200&cht=bvg";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }
}
