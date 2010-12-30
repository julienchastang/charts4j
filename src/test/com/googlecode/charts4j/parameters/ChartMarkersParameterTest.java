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

import com.googlecode.charts4j.Marker;
import com.googlecode.charts4j.Markers;
import com.googlecode.charts4j.Priority;
import com.googlecode.charts4j.Shape;

/**
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 */
public class ChartMarkersParameterTest {

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
        final ChartMarkersParameter p = new ChartMarkersParameter();
        p.addFillAreaMarker(FillAreaType.FULL, RED, 1, 3);
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(p.toURLParameterString());
        final String expectedString = "chm=B,FF0000,1,3,0";
        assertEquals("Junit error", expectedString, p.toURLParameterString());
    }

    @Test
    public void test1() {
        final ChartMarkersParameter p = new ChartMarkersParameter();
        p.addLineStyleMarker(BLUE, 1, 3, 12, Priority.HIGH);
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(p.toURLParameterString());
        final String expectedString = "chm=D,0000FF,1,3,12,1";
        assertEquals("Junit error", expectedString, p.toURLParameterString());
    }

    @Test
    public void test2() {
        final ChartMarkersParameter p = new ChartMarkersParameter();
        p.addHorizontalRangeMarker(WHEAT, 0.1, 0.3);
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(p.toURLParameterString());
        final String expectedString = "chm=r,F5DEB3,0,0.10,0.30";
        assertEquals("Junit error", expectedString, p.toURLParameterString());
    }

    @Test
    public void test3() {
        final ChartMarkersParameter p = new ChartMarkersParameter();
        final Marker sm = Markers.newShapeMarker(Shape.CIRCLE, PERU, 13, Priority.LOW);
        p.addMarker(sm, 1, 5, 6, 1);
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(p.toURLParameterString());
        final String expectedString = "chm=o,CD853F,1,5,13,-1";
        assertEquals("Junit error", expectedString, p.toURLParameterString());
    }

    @Test
    public void test4() {
        final ChartMarkersParameter p = new ChartMarkersParameter();
        p.addMarker(Markers.newTextMarker("foobar", BLACK, 15), 7, 5, 6, 1);
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(p.toURLParameterString());
        final String expectedString = "chm=tfoobar,000000,7,5,15,0";
        assertEquals("Junit error", expectedString, p.toURLParameterString());
    }

    @Test
    public void test5() {
        final ChartMarkersParameter p = new ChartMarkersParameter();
        final Marker sm = Markers.newShapeMarker(Shape.CIRCLE, PERU, 13, Priority.LOW);
        p.addMarker(sm, 1, 5, 6, 1);
        p.addMarker(Markers.newTextMarker("foobar", BLACK, 15), 7, 5, 6, 1);
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(p.toURLParameterString());
        final String expectedString = "chm=o,CD853F,1,5,13,-1|tfoobar,000000,7,5,15,0";
        assertEquals("Junit error", expectedString, p.toURLParameterString());
    }

    @Test
    public void test6() {
        final ChartMarkersParameter p = new ChartMarkersParameter();
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(p.toURLParameterString());
        final String expectedString = "";
        assertEquals("Junit error", expectedString, p.toURLParameterString());
    }

    @Test
    public void test7() {
        final ChartMarkersParameter p = new ChartMarkersParameter();
        final Marker sm = Markers.newShapeMarker(Shape.CIRCLE, PERU, 13, Priority.LOW);
        p.addMarker(sm, 1, 5, 10 ,2);
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(p.toURLParameterString());
        final String expectedString = "chm=o,CD853F,1,5:9:2,13,-1";
        assertEquals("Junit error", expectedString, p.toURLParameterString());
    }

    @Test
    public void test8() {
        final ChartMarkersParameter p = new ChartMarkersParameter();
        final Marker sm = Markers.newShapeMarker(Shape.CIRCLE, PERU, 13, Priority.LOW);
        p.addMarker(sm, 1, 5, 6 ,2);
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(p.toURLParameterString());
        final String expectedString = "chm=o,CD853F,1,5,13,-1";
        assertEquals("Junit error", expectedString, p.toURLParameterString());
    }

    @Test
    public void test9() {
        final ChartMarkersParameter p = new ChartMarkersParameter();
        final Marker sm = Markers.newShapeMarker(Shape.CIRCLE, PERU, 13, Priority.LOW);
        p.addMarkers(sm, 1);
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(p.toURLParameterString());
        final String expectedString = "chm=o,CD853F,1,-1,13,-1";
        assertEquals("Junit error", expectedString, p.toURLParameterString());
    }

    @Test
    public void addFreeShapeMarker() {
        final ChartMarkersParameter p = new ChartMarkersParameter();
        final Marker sm = Markers.newShapeMarker(Shape.CIRCLE, PERU, 13, Priority.LOW);
        p.addFreeMarker(sm, 10, 20);
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(p.toURLParameterString());
        final String expectedString = "chm=@o,CD853F,0,0.1:0.2,13,-1";
        assertEquals("Junit error", expectedString, p.toURLParameterString());
    }

    @Test
    public void addFreeTextMarker() {
        final ChartMarkersParameter p = new ChartMarkersParameter();
        final Marker sm = Markers.newTextMarker("charts4j", PERU, 13, Priority.HIGH);
        p.addFreeMarker(sm, 20, 10);
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(p.toURLParameterString());
        final String expectedString = "chm=@tcharts4j,CD853F,0,0.2:0.1,13,1";
        assertEquals("Junit error", expectedString, p.toURLParameterString());
    }
}
