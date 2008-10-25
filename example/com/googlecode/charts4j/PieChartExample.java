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
import static org.junit.Assert.assertEquals;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 */
public class PieChartExample {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        Logger.global.setLevel(Level.ALL);
    }

    @Test
    public void example1() {
        // EXAMPLE CODE START
        Slice s1 = Slice.newSlice(30, Color.newColor("CACACA"), "Safari");
        Slice s2 = Slice.newSlice(30, Color.newColor("DF7417"), "Firefox");
        Slice s3 = Slice.newSlice(30, Color.newColor("951800"), "Chrome");
        Slice s4 = Slice.newSlice(10, Color.newColor("01A1DB"), "Internet Explorer");

        PieChart chart = GCharts.newPieChart(s1, s2, s3, s4);
        chart.setTitle("A Better Web", BLACK, 16);
        chart.setSize(500, 200);
        chart.setThreeD(true);
        String url = chart.toURLString();
        // EXAMPLE CODE END. Use this url string in your web or
        // Internet application.
        Logger.global.info(url);
        String expectedString = "http://chart.apis.google.com/chart?chs=500x200&chd=e:TNTNTNGa&chl=Safari|Firefox|Chrome|Internet+Explorer&chco=CACACA,DF7417,951800,01A1DB&cht=p3&chtt=A+Better+Web&chts=000000,16";
        assertEquals("Junit error", normalize(expectedString), normalize(url));
    }
    
    @Test
    public void example2() {
        // EXAMPLE CODE START
        Slice s1 = Slice.newSlice(90, YELLOW,"Ms. Pac-Man");
        Slice s2 = Slice.newSlice(10, RED);

        PieChart chart = GCharts.newPieChart(s1, s2);
        chart.setTitle("2D Pie Chart", BLACK, 16);
        chart.setSize(500, 200);
        String url = chart.toURLString();
        // EXAMPLE CODE END. Use this url string in your web or
        // Internet application.
        Logger.global.info(url);
        String expectedString = "http://chart.apis.google.com/chart?chs=500x200&chd=e:5mGa&chl=Ms.+Pac-Man|&chco=FFFF00,FF0000&cht=p&chtt=2D+Pie+Chart&chts=000000,16";
        assertEquals("Junit error", normalize(expectedString), normalize(url));
    }

}
