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
public class XYLineChartTest {

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
    public void test0() {

        double[] x = new double[10];
        double[] y = new double[10];
        int cnt = 0;
        for (double i = 0; i < 10; i = i + 1) {
            x[cnt] = 50 + 49 * Math.sin(i / 18);
            y[cnt] = 50 + 49 * Math.cos(i / 20);
            cnt++;
        }

        Data data1 = Data.newData(x);
        Data data2 = Data.newData(y);
        XYLine line = Plots.newXYLine(data1, data2);
        line.setColor(BLUE);
        XYLineChart chart = GCharts.newXYLineChart(line);
        chart.setSize(400, 400);
        Logger.global.info(chart.toURLString());
    }

    @Test
    public void testEvenlySpacedDataPoints() {

        Data data1 = Data.newData(10, 11, 12, 50);
        Data data2 = Data.newData(30, 10, 30, 20);
        XYLine line = Plots.newXYLine(data1, data2);
        line.setColor(BLUE);
        XYLineChart chart = GCharts.newXYLineChart(line);
        chart.setSize(400, 400);
        Logger.global.info(chart.toURLString());
    }
}
