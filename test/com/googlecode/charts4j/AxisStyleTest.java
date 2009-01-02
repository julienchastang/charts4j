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
import static com.googlecode.charts4j.UrlUtil.normalize;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
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
public class AxisStyleTest {

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
    public void testAxisStyle0() {
        final LineChart chart = TestUtil.getBasicChart();
        AxisLabels axisLabels = AxisLabelsFactory.newNumericAxisLabels(Arrays.asList(0, 1, 2, 3, 4, 5));
        axisLabels.setAxisStyle(AxisStyle.newAxisStyle(RED, 16, AxisTextAlignment.CENTER));
        chart.addXAxisLabels(axisLabels);
        Logger.global.info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?chs=200x125&chd=e:AAgA..&chxt=x&chxp=0,0,1,2,3,4,5&chxr=0,0.0,5.0&chxs=0,FF0000,16,0&cht=lc";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }

    @Test
    public void testAxisStyle1() {
        final LineChart chart = TestUtil.getBasicChart();
        AxisStyle axisStyle  = AxisStyle.newAxisStyle(RED, 16, AxisTextAlignment.CENTER);
        axisStyle.setDrawAxis(true);
        axisStyle.setTickMarkColor(RED);
        axisStyle.setTickMarkLength(-50);
        AxisLabels axisLabels = AxisLabelsFactory.newNumericAxisLabels(Arrays.asList(0, 1, 2, 3, 4, 5));
        axisLabels.setAxisStyle(axisStyle);
        chart.addXAxisLabels(axisLabels);
        Logger.global.info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?chd=e:AAgA..&chs=200x125&cht=lc&chxp=0,0,1,2,3,4,5&chxr=0,0.0,5.0&chxs=0,FF0000,16,0,lt,FF0000&chxt=x&chxtc=0,-50";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }
    
    @Test
    public void testAxisAlignment() {
        final LineChart chart = TestUtil.getBasicChart();
        chart.setGrid(50, 50, 5, 0);
        AxisStyle axisStyle  = AxisStyle.newAxisStyle(RED, 16, AxisTextAlignment.LEFT);
        AxisLabels axisLabels = AxisLabelsFactory.newAxisLabels("Foo", 50);
        axisLabels.setAxisStyle(axisStyle);
        chart.addXAxisLabels(axisLabels);
        Logger.global.info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?chd=e:AAgA..&chg=50.0,50.0,5,0&chs=200x125&cht=lc&chxl=0:|Foo&chxp=0,50.0&chxr=0,0.0,100.0&chxs=0,FF0000,16,1&chxt=x";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }

}
