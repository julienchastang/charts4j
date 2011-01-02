/**
 *
 * The MIT License
 *
 * Copyright (c) 2011 the original author or authors.
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

import static org.junit.Assert.assertEquals;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.googlecode.charts4j.collect.Lists;

/**
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 */
public class AxisLabelPositionsParameterTest {

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
        final AxisLabelPositionsParameter p = new AxisLabelPositionsParameter();
        p.addLabelPosition(1, Lists.of(1, 2, 3));
        p.addLabelPosition(2, Lists.of(7, 8, 9));
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(p.toURLParameterString());
        final String expectedString = "chxp=1,1,2,3|2,7,8,9";
        assertEquals("Junit error", expectedString, p.toURLParameterString());
    }

    @Test
    public void test1() {
        AxisLabelPositionsParameter p = new AxisLabelPositionsParameter();
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(p.toURLParameterString());
        String expectedString = "";
        assertEquals("Junit error", expectedString, p.toURLParameterString());
    }

    @Test
    public void test2() {
        AxisLabelPositionsParameter p = new AxisLabelPositionsParameter();
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(p.toURLParameterString());
        p.addLabelPosition(2, Lists.of(1, 2, 3));
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(p.toURLParameterString());
        final String expectedString = "chxp=2,1,2,3";
        assertEquals("Junit error", expectedString, p.toURLParameterString());
    }
}
