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

package com.googlecode.charts4j;

import static com.googlecode.charts4j.Color.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 *
 */
public class ColorTest {

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
    public void colorTest() {
        final Color color = Color.newColor("000000");
        assertEquals("Junit error", color.toString(), BLACK.toString());
    }

    @Test
    public void colorTest1() {
        final Color color = Color.newColor("FFFFFF");
        assertEquals("Junit error", color.toString(), WHITE.toString());
    }

    @Test
    public void colorTest2() {
        try {
            @SuppressWarnings("unused")
            final Color color = Color.newColor("FFFFFFFF");
        } catch (RuntimeException e) {
            return;
        }
        fail();// Should not happen
    }

    @Test
    public void colorTest3() {
        try {
            @SuppressWarnings("unused")
            final Color color = Color.newColor("foobar");
        } catch (RuntimeException e) {
            return;
        }
        fail();// Should not happen
    }

    @Test
    public void colorTest4() {
        final Color color = Color.newColor("ffffff");
        assertEquals("Junit error", color.toString(), WHITE.toString());
    }

    @Test
    public void colorTest5() {
        final Color color = Color.newColor("ffffff", 0);
        assertEquals("Junit error", "FFFFFF00", color.toString());
    }

    @Test
    public void colorTest6() {
        final Color color = Color.newColor("ffffff", 100);
        assertEquals("Junit error", "FFFFFF", color.toString());
    }
}
