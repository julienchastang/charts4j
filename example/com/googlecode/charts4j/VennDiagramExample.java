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
public class VennDiagramExample {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        Logger.global.setLevel(Level.ALL);
    }

    @Test
    public void example1() {
        // EXAMPLE CODE START
        final VennDiagram chart = GCharts.newVennDiagram(100, 80, 60, 30, 30, 30, 10);
        chart.setTitle("Mr. Venn", WHITE, 16);
        chart.setSize(600, 450);
        chart.setCircleLegends("Set A", "Set B", "Set C");
        chart.setCircleColors(YELLOW, RED, BLUE);
        chart.setBackgroundFill(Fills.newSolidFill(BLACK));
        String url = chart.toURLString();
        // EXAMPLE CODE END. Use this url string in your web or
        // Internet application.
        Logger.global.info(url);
        String expectedString = "http://chart.apis.google.com/chart?cht=v&chs=600x450&chts=FFFFFF,16&chf=bg,s,000000&chco=FFFF00,FF0000,0000FF&chdl=Set+A|Set+B|Set+C&chd=e:..zMmZTNTNTNGa&chtt=Mr.+Venn";
        assertEquals("Junit error", normalize(expectedString), normalize(url));
    }
}
