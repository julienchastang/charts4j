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
import static com.googlecode.charts4j.UrlUtil.normalize;
import static org.junit.Assert.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.googlecode.charts4j.collect.Lists;

/**
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 * 
 */
public class GoogleOMeterTest {

    /**
     * @throws java.lang.Exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        Logger.global.setLevel(Level.ALL);
    }

    /**
     * @throws java.lang.Exception
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test0() {
        GoogleOMeter chart = GCharts.newGoogleOMeter(100);
        Logger.global.info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?cht=gom&chs=200x125&chd=e:..";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }

    @Test
    public void test1() {
        GoogleOMeter chart = GCharts.newGoogleOMeter(50, "speed", RED, GREEN, BLUE);
        Logger.global.info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?cht=gom&chs=200x125&chl=speed&chco=FF0000,008000,0000FF&chd=e:gA";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }

    @Test
    public void test2() {
        List<Color> colors = Lists.of(BLUE, WHITE, RED);
        GoogleOMeter chart = GCharts.newGoogleOMeter(25, "speed", colors);
        Logger.global.info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?cht=gom&chs=200x125&chl=speed&chco=0000FF,FFFFFF,FF0000&chd=e:QA";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }

    @Test
    public void test3() {
        try {
            @SuppressWarnings("unused")
            GoogleOMeter chart = GCharts.newGoogleOMeter(50, "speed", RED);
        } catch (IllegalArgumentException e) {
            return;
        }
        fail();// Should not happen
    }
}
