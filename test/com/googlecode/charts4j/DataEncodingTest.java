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

import static com.googlecode.charts4j.UrlUtil.normalize;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 */
public class DataEncodingTest {

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
    public void test0() {
        final Data data = Data.newData(0, 100);
        LineChart chart = GCharts.newLineChart(Plots.newPlot(data));
        String expectedString = "http://chart.apis.google.com/chart?chs=200x125&chd=e:AA..&cht=lc";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));

    }

    @Test
    public void test1() {
        final Data data = Data.newData(0, 101);
        LineChart chart = GCharts.newLineChart(Plots.newPlot(data));
        String expectedString = "http://chart.apis.google.com/chart?chs=200x125&chd=e:AA__&cht=lc";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));

    }

    @Test
    public void test2() {
        final Data data = Data.newData(0, 100);
        LineChart chart = GCharts.newLineChart(Plots.newPlot(data));
        chart.setDataEncoding(DataEncoding.SIMPLE);
        String expectedString = "http://chart.apis.google.com/chart?chs=200x125&chd=s:A9&cht=lc";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));

    }

    @Test
    public void test3() {
        final Data data = Data.newData(0, 101);
        LineChart chart = GCharts.newLineChart(Plots.newPlot(data));
        chart.setDataEncoding(DataEncoding.SIMPLE);
        String expectedString = "http://chart.apis.google.com/chart?chs=200x125&chd=s:A_&cht=lc";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));

    }

    @Test
    public void test4() {
        final Data data = Data.newData(0, 99);
        LineChart chart = GCharts.newLineChart(Plots.newPlot(data));
        chart.setDataEncoding(DataEncoding.TEXT);
        String expectedString = "http://chart.apis.google.com/chart?chs=200x125&chd=t:0.0,99.0&cht=lc";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));

    }

    @Test
    public void test5() {
        final Data data = Data.newData(0, 101);
        LineChart chart = GCharts.newLineChart(Plots.newPlot(data));
        chart.setDataEncoding(DataEncoding.TEXT);
        String expectedString = "http://chart.apis.google.com/chart?chs=200x125&chd=t:0.0,-1&cht=lc";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }
}
