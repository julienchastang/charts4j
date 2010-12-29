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
import static com.googlecode.charts4j.Country.Name.*;
import static com.googlecode.charts4j.USAState.Code.*;
import static com.googlecode.charts4j.USAState.Name.COLORADO;
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
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 *
 */
public class MapChartTest {

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
    public void test() {
        MapChart chart = GCharts.newMapChart(GeographicalArea.AFRICA);
        chart.addPoliticalBoundaries(new Country(MADAGASCAR, 90));
        chart.addPoliticalBoundaries(new Country(MOROCCO, 10));
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?cht=t&chtm=africa&chs=440x220&chld=MGMA&chco=FFFFFF,F5F5DC,228B22&chd=e:5mGa";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }

    @Test
    public void test1() {
        MapChart chart = GCharts.newMapChart(GeographicalArea.USA);
        chart.setColorGradient(WHITE, RED, BLUE);
        chart.addPoliticalBoundaries(new USAState(COLORADO, 50));
        chart.addPoliticalBoundaries(new USAState(NY, 90));
        chart.addPoliticalBoundaries(new USAState(ID, 10));
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?cht=t&chtm=usa&chs=440x220&chld=CONYID&chco=FFFFFF,FF0000,0000FF&chd=e:gA5mGa";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }
}
