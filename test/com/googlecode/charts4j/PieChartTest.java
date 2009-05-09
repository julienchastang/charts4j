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
public class PieChartTest {

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
    public void basicTest() {
        final Slice s1 = Slice.newSlice(45, GRAY, "Safari", "X");
        final Slice s2 = Slice.newSlice(45, ORANGERED, "Firefox", "Y");
        final Slice s3 = Slice.newSlice(10, BLUE, "Internet Explorer", "Z");

        PieChart chart = GCharts.newPieChart(s1, s2, s3);
        chart.setTitle("A Better World 1");
        chart.setSize(500, 200);
        chart.setThreeD(true);
        Logger.global.info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?chco=808080,FF4500,0000FF&chd=e:czczGa&chdl=X|Y|Z&chl=Safari|Firefox|Internet+Explorer&chs=500x200&cht=p3&chtt=A+Better+World+1";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }

    @Test
    public void nocolorTest() {
        final Slice s1 = Slice.newSlice(45, "Safari");
        final Slice s2 = Slice.newSlice(45, "Firefox");
        final Slice s3 = Slice.newSlice(10, "Internet Explorer");

        PieChart chart = GCharts.newPieChart(s1, s2, s3);
        chart.setTitle("A Better World 2");
        chart.setSize(500, 200);
        chart.setThreeD(true);
        Logger.global.info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?cht=p3&chs=500x200&chl=Safari|Firefox|Internet+Explorer&chd=e:czczGa&chtt=A+Better+World+2";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }

    @Test
    public void interpolatedColorTest() {
        final Slice s1 = Slice.newSlice(45, GRAY, "Safari", "A");
        final Slice s2 = Slice.newSlice(45, "Firefox");
        final Slice s3 = Slice.newSlice(10, BLUE, "Internet Explorer", "B");

        PieChart chart = GCharts.newPieChart(s1, s2, s3);
        chart.setTitle("A Better World 3");
        chart.setSize(500, 200);
        chart.setThreeD(true);
        Logger.global.info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?chco=808080,0000FF&chd=e:czczGa&chdl=A||B&chl=Safari|Firefox|Internet+Explorer&chs=500x200&cht=p3&chtt=A+Better+World+3";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }
    
    @Test
    public void fillTest() {
        final Slice s1 = Slice.newSlice(45, GRAY, "Safari", "X");
        final Slice s2 = Slice.newSlice(45, ORANGERED, "Firefox", "Y");
        final Slice s3 = Slice.newSlice(10, BLUE, "Internet Explorer", "Z");

        PieChart chart = GCharts.newPieChart(s1, s2, s3);
        chart.setTitle("A Better World 1");
        chart.setSize(500, 200);
        chart.setAreaFill(Fills.newSolidFill(BLACK));
        chart.setBackgroundFill(Fills.newSolidFill(LIGHTGREY));
        chart.setThreeD(true);
        Logger.global.info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?chco=808080,FF4500,0000FF&chd=e:czczGa&chdl=X|Y|Z&chf=bg,s,D3D3D3|c,s,000000&chl=Safari|Firefox|Internet+Explorer&chs=500x200&cht=p3&chtt=A+Better+World+1";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }
    
    @Test
    public void orientationTest() {
        final Slice s1 = Slice.newSlice(450, "Safari");
        final Slice s2 = Slice.newSlice(450, "Firefox");
        final Slice s3 = Slice.newSlice(100, "Internet Explorer");

        PieChart chart = GCharts.newPieChart(s1, s2, s3);
        chart.setOrientation(3.14/2);
        Logger.global.info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?chd=e:czczGa&chl=Safari|Firefox|Internet+Explorer&chp=1.57&chs=200x125&cht=p";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));

    }
}
