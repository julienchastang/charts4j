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

import static com.googlecode.charts4j.Color.RED;
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
public class AbstractAxisChartTest {

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
    public void testSetGrid0() {
        try {
            final LineChart chart = getBasicChart();
            chart.setGrid(0, 0, 0, 0);
        } catch (IllegalArgumentException e) {
            return;
        }
        fail();// Should not happen
    }

    @Test
    public void testSetGrid1() {
        final LineChart chart = getBasicChart();
        chart.setGrid(10, 10, 1, 0);
        Logger.global.info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?chd=e:AAgA..&chg=10.0,10.0,1,0&chs=200x125&cht=lc";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }

    @Test
    public void testXAxisLabels0() {
        final LineChart chart = getBasicChart();
        chart.addXAxisLabels(AxisLabelsFactory.newAxisLabels("start", "end"));
        Logger.global.info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?chs=200x125&chd=e:AAgA..&chxt=x&chxl=0:|start|end&cht=lc";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }

    @Test
    public void testXAxisLabels1() {
        final LineChart chart = TestUtil.getBasicChart();
        final AxisLabels ai = AxisLabelsFactory.newAxisLabels("start", "end");
        ai.setAxisStyle(AxisStyle.newAxisStyle(RED, 14, AxisTextAlignment.RIGHT));
        chart.addXAxisLabels(ai);
        Logger.global.info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?chd=e:AAgA..&chs=200x125&cht=lc&chxl=0:|start|end&chxs=0,FF0000,14,1&chxt=x";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }

    @Test
    public void testYAxisLabels() {
        final LineChart chart = getBasicChart();
        chart.addYAxisLabels(AxisLabelsFactory.newAxisLabels("start", "end"));
        Logger.global.info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?chs=200x125&chd=e:AAgA..&chxt=y&chxl=0:|start|end&cht=lc";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }

    @Test
    public void testTopAxisLabels() {
        final LineChart chart = getBasicChart();
        chart.addTopAxisLabels(AxisLabelsFactory.newAxisLabels("start", "end"));
        Logger.global.info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?chs=200x125&chd=e:AAgA..&chxt=t&chxl=0:|start|end&cht=lc";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }

    @Test
    public void testRightAxisLabels() {
        final LineChart chart = getBasicChart();
        chart.addRightAxisLabels(AxisLabelsFactory.newAxisLabels("start", "end"));
        Logger.global.info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?chs=200x125&chd=e:AAgA..&chxt=r&chxl=0:|start|end&cht=lc";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }

}
