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

import static com.googlecode.charts4j.Color.BLUE;
import static com.googlecode.charts4j.TestUtil.getBasicChart;
import static com.googlecode.charts4j.UrlUtil.normalize;
import static org.junit.Assert.*;

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
public class AbstractGChartTest {

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
    public void testSetSize0() {
        try {
            final LineChart chart = getBasicChart();
            chart.setSize(0, 0);
        } catch (IllegalArgumentException e) {
            return;
        }
        fail();// Should not happen
    }

    @Test
    public void testSetSize1() {
        try {
            final LineChart chart = getBasicChart();
            chart.setSize(1001, 1001);
        } catch (IllegalArgumentException e) {
            return;
        }
        fail();// Should not happen
    }

    @Test
    public void testSetBackgroundFill() {
        final LineChart chart = getBasicChart();
        chart.setBackgroundFill(Fills.newSolidFill(BLUE));
        Logger.global.info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?chd=e:AAgA..&chf=bg,s,0000FF&chs=200x125&cht=lc";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }

    @Test
    public void testSetTransparency() {
        final LineChart chart = getBasicChart();
        chart.setTransparency(10);
        Logger.global.info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?chd=e:AAgA..&chf=a,s,FFFFFF19&chs=200x125&cht=lc";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }

    @Test
    public void testSetDataEncoding0() {
        final LineChart chart = getBasicChart();
        chart.setDataEncoding(DataEncoding.TEXT);
        Logger.global.info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?chd=t:0.0,50.0,100.0&chs=200x125&cht=lc";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }

    @Test
    public void testSetDataEncoding1() {
        final LineChart chart = getBasicChart();
        chart.setDataEncoding(DataEncoding.SIMPLE);
        Logger.global.info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?chd=s:Af9&chs=200x125&cht=lc";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }

    @Test
    public void testSetURLEndpoint() {
        final LineChart chart = getBasicChart();
        chart.setDataEncoding(DataEncoding.SIMPLE);
        chart.setURLEndpoint("http://localhost:8080/eastwood-1.1.0/chart");
        Logger.global.info(chart.toURLString());
        String expectedString = "http://localhost:8080/eastwood-1.1.0/chart?chd=s:Af9&chs=200x125&cht=lc";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }
}
