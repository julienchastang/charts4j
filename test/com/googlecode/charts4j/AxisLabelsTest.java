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

import static com.googlecode.charts4j.TestUtil.getBasicChart;
import static com.googlecode.charts4j.UrlUtil.normalize;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
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
public class AxisLabelsTest {

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
    public void testNewAxisLabelsStringArray() {
        final LineChart chart = getBasicChart();
        chart.addXAxisLabels(AxisLabelsFactory.newAxisLabels("start", "end"));
        Logger.global.info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?chs=200x125&chd=e:AAgA..&chxt=x&chxl=0:|start|end&cht=lc";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }

    @Test
    public void testNewAxisLabelsListOfQextendsStringDoubleDoubleListOfQextendsNumber() {
        final LineChart chart = TestUtil.getBasicChart();
        final List<Integer> positions = Arrays.asList(10, 20, 80);
        chart.addXAxisLabels(AxisLabelsFactory.newAxisLabels(Arrays.asList("foo", "bar", "zap"), positions));
        Logger.global.info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?chd=e:AAgA..&chs=200x125&cht=lc&chxl=0:|foo|bar|zap&chxp=0,10,20,80&chxr=0,0.0,100.0&chxt=x";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }

    @Test
    public void testNewAxisLabelsStringDoubleDoubleDouble() {
        final LineChart chart = TestUtil.getBasicChart();
        chart.addXAxisLabels(AxisLabelsFactory.newAxisLabels("foo", 33));
        Logger.global.info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?chd=e:AAgA..&chs=200x125&cht=lc&chxl=0:|foo&chxp=0,33.0&chxr=0,0.0,100.0&chxt=x";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }

    @Test
    public void testNewAxisLabelsDoubleDoubleListOfQextendsNumber() {
        final LineChart chart = TestUtil.getBasicChart();
        chart.addXAxisLabels(AxisLabelsFactory.newNumericAxisLabels(Arrays.asList(100, 200, 300, 400, 1000)));
        Logger.global.info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?chd=e:AAgA..&chs=200x125&cht=lc&chxp=0,100,200,300,400,1000&chxr=0,100.0,1000.0&chxt=x";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }

    @Test
    public void testNewAxisLabelsDoubleDouble0() {
        final LineChart chart = TestUtil.getBasicChart();
        chart.addXAxisLabels(AxisLabelsFactory.newNumericRangeAxisLabels(0, 10));
        Logger.global.info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?chd=e:AAgA..&chs=200x125&cht=lc&chxr=0,0.0,10.0&chxt=x";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }
    
    @Test
    public void testNewAxisLabelsDoubleDouble1() {
        final LineChart chart = TestUtil.getBasicChart();
        chart.addXAxisLabels(AxisLabelsFactory.newNumericRangeAxisLabels(0, -10));
        Logger.global.info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?chd=e:AAgA..&chs=200x125&cht=lc&chxr=0,0.0,-10.0&chxt=x";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }
}
