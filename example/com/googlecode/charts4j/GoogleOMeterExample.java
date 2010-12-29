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
public class GoogleOMeterExample {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).setLevel(Level.ALL);
    }

    @Test
    public void example1() {
        // EXAMPLE CODE START
        GoogleOMeter chart = GCharts.newGoogleOMeter(90, "Fast", "VELOCITY", Color.newColor("1148D4"), Color.newColor("5766DE"), Color.newColor("DB3270"), Color.newColor("D41111"));
        chart.setTitle("How Fast?", BLACK, 14);
        chart.setSize(600, 250);
        final LinearGradientFill fill = Fills.newLinearGradientFill(0, BLUE, 100);
        fill.addColorAndOffset(RED, 0);
        chart.setBackgroundFill(fill);
        chart.setAreaFill(Fills.newSolidFill(Color.newColor(GRAY, 70)));
        String url = chart.toURLString();
        // EXAMPLE CODE END. Use this url string in your web or
        // Internet application.

        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(url);
        String expectedString = "http://chart.apis.google.com/chart?cht=gom&chd=e:5m&chl=Fast&chs=600x250&chdl=VELOCITY&chts=000000,14&chtt=How+Fast%3F&chco=1148D4,5766DE,DB3270,D41111&chf=bg,lg,0,0000FF,1.0,FF0000,0.0|c,s,808080B2";
        assertEquals("Junit error", normalize(expectedString), normalize(url));
    }
}
