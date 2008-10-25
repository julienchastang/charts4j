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
public class VennDiagramTest {

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
        try {
            @SuppressWarnings("unused")
            final VennDiagram chart = GCharts.newVennDiagram(-1, 80, 60, 30, 30, 30, 10);
        } catch (IllegalArgumentException e) {
            return;
        }
        fail();// Should not happen
    }

    @Test
    public void test1() {
        final VennDiagram chart = GCharts.newVennDiagram(100, 80, 60, 30, 30, 30, 10);
        chart.setCircleLegends("foo", "bar", "zap");
        chart.setCircleColors(PINK, BLUE, RED);
        Logger.global.info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?cht=v&chs=200x125&chco=FFC0CB,0000FF,FF0000&chdl=foo|bar|zap&chd=e:..zMmZTNTNTNGa";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }
}
