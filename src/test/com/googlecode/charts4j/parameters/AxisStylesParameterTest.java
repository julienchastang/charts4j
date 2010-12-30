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

package com.googlecode.charts4j.parameters;

import static com.googlecode.charts4j.Color.*;
import static org.junit.Assert.assertEquals;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.googlecode.charts4j.AxisStyle;
import com.googlecode.charts4j.AxisTextAlignment;

/**
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 */
public class AxisStylesParameterTest {

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
    public void test0() {
        final AxisStylesParameter p = new AxisStylesParameter();
        p.addAxisStyle(1, AxisStyle.newAxisStyle(BLUE, 12, AxisTextAlignment.CENTER));
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(p.toURLParameterString());
        final String expectedString = "chxs=1,0000FF,12,0";
        assertEquals("Junit error", expectedString, p.toURLParameterString());
    }

    @Test
    public void test1() {
        final AxisStylesParameter p = new AxisStylesParameter();
        p.addAxisStyle(1, AxisStyle.newAxisStyle(BLUE, 12, AxisTextAlignment.CENTER));
        p.addAxisStyle(2, AxisStyle.newAxisStyle(RED, 12, AxisTextAlignment.CENTER));
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(p.toURLParameterString());
        final String expectedString = "chxs=1,0000FF,12,0|2,FF0000,12,0";
        assertEquals("Junit error", expectedString, p.toURLParameterString());
    }

    @Test
    public void test2() {
        final AxisStylesParameter p = new AxisStylesParameter();
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(p.toURLParameterString());
        final String expectedString = "";
        assertEquals("Junit error", expectedString, p.toURLParameterString());
    }

    @Test
    public void test4() {
        final AxisStylesParameter p = new AxisStylesParameter();
        final AxisStyle axisStyle = AxisStyle.newAxisStyle(BLUE, 12, AxisTextAlignment.CENTER);
        p.addAxisStyle(1, axisStyle);
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(p.toURLParameterString());
        final String expectedString = "chxs=1,0000FF,12,0";
        assertEquals("Junit error", expectedString, p.toURLParameterString());
    }

    @Test
    public void test5() {
        final AxisStylesParameter p = new AxisStylesParameter();
        final AxisStyle axisStyle = AxisStyle.newAxisStyle(BLUE, 12, AxisTextAlignment.CENTER);
        axisStyle.setDrawTickMarks(true);
        axisStyle.setTickMarkColor(RED);
        p.addAxisStyle(1, axisStyle);
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(p.toURLParameterString());
        final String expectedString = "chxs=1,0000FF,12,0,lt,FF0000";
        assertEquals("Junit error", expectedString, p.toURLParameterString());
    }

    @Test
    public void test6() {
        final AxisStylesParameter p = new AxisStylesParameter();
        final AxisStyle axisStyle = AxisStyle.newAxisStyle(BLUE, 12, AxisTextAlignment.CENTER);
        axisStyle.setDrawTickMarks(false);
        p.addAxisStyle(1, axisStyle);
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(p.toURLParameterString());
        final String expectedString = "chxs=1,0000FF,12,0,l";
        assertEquals("Junit error", expectedString, p.toURLParameterString());
    }
}
