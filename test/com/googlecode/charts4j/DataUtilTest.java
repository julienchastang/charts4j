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
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 * 
 */
public class DataUtilTest {

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
    public void testScaleData0() {
        Data data = DataUtil.scaleWithinRange(0, 10, new double[] { 1, 2, 3, 4, 5, 6 });
        Logger.global.info(data.toString());
        assertEquals("Junit error", "[10.0, 20.0, 30.0, 40.0, 50.0, 60.0]", data.toString());
    }

    @Test
    public void testScaleData1() {
        Data data = DataUtil.scale(1, 2, 3, 4, 5, 6);
        Logger.global.info(data.toString());
        assertEquals("Junit error", "[0.0, 20.0, 40.0, 60.0, 80.0, 100.0]", data.toString());
    }

    @Test
    public void testScaleData2() {
        Data data = DataUtil.scale(-10, 1, 2, 3, 4, 5, 6);
        Logger.global.info(data.toString());
        assertEquals("Junit error", "[0.0, 68.75, 75.0, 81.25, 87.5, 93.75, 100.0]", data.toString());
    }

    @Test
    public void testScaleData3() {
        Data data = DataUtil.scaleWithinRange(0, 10, Arrays.asList(1, 2, 3, 4, 5, 6));
        Logger.global.info(data.toString());
        assertEquals("Junit error", "[10.0, 20.0, 30.0, 40.0, 50.0, 60.0]", data.toString());
    }
}
