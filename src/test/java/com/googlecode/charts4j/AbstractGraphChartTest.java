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
import static com.googlecode.charts4j.TestUtil.getBasicChart;
import static com.googlecode.charts4j.UrlUtil.normalize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

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
public class AbstractGraphChartTest {

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
    public void testSetTitleString0() {
        try {
            final LineChart chart = getBasicChart();
            chart.setTitle(null);
        } catch (NullPointerException e) {
            return;
        }
        fail();// Should not happen
    }

    @Test
    public void testSetTitleString1() {
        final LineChart chart = getBasicChart();
        chart.setTitle("foo");
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?chd=e:AAgA..&chs=200x125&cht=lc&chtt=foo";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }

    @Test
    public void testSetTitleStringColorInt0() {
        try {
            final LineChart chart = getBasicChart();
            chart.setTitle("foo", RED, 0);
        } catch (IllegalArgumentException e) {
            return;
        }
        fail();// Should not happen
    }

    @Test
    public void testSetTitleStringColorInt1() {
        final LineChart chart = getBasicChart();
        chart.setTitle("foo", RED, 20);
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?chd=e:AAgA..&chs=200x125&cht=lc&chts=FF0000,20&chtt=foo";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }

    @Test
    public void testSetLegendPosition() {
        final Plot plot = Plots.newPlot(Data.newData(0, 50, 100), RED, "my Legend");
        final LineChart chart = GCharts.newLineChart(plot);
        chart.setLegendPosition(LegendPosition.TOP);
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?chco=FF0000&chd=e:AAgA..&chdl=my+Legend&chdlp=t&chs=200x125&cht=lc";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }

    @Test
    public void testSetMargins() {
        final Plot plot = Plots.newPlot(Data.newData(0, 50, 100), RED, "my Legend");
        final LineChart chart = GCharts.newLineChart(plot);
        chart.setMargins(20, 20, 20, 20);
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?chco=FF0000&chd=e:AAgA..&chdl=my+Legend&chma=20,20,20,20&chs=200x125&cht=lc";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }

    @Test
    public void testSetLegendMargins() {
        final Plot plot = Plots.newPlot(Data.newData(0, 50, 100), RED, "my Legend");
        final LineChart chart = GCharts.newLineChart(plot);
        chart.setLegendMargins(100, 50);
        chart.setBackgroundFill(Fills.newSolidFill(BLACK));
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?chco=FF0000&chd=e:AAgA..&chdl=my+Legend&chf=bg,s,000000&chma=0,0,0,0|100,50&chs=200x125&cht=lc";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }


    @Test
    public void testSetAreaFill() {
        final LineChart chart = getBasicChart();
        chart.setAreaFill(Fills.newSolidFill(RED));
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?chd=e:AAgA..&chf=c,s,FF0000&chs=200x125&cht=lc";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }
}
