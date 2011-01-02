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

package com.googlecode.charts4j.example;

import static com.googlecode.charts4j.Color.WHITE;
import static com.googlecode.charts4j.UrlUtil.normalize;
import static org.junit.Assert.assertEquals;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.BeforeClass;
import org.junit.Test;

import com.googlecode.charts4j.AxisLabels;
import com.googlecode.charts4j.AxisLabelsFactory;
import com.googlecode.charts4j.AxisStyle;
import com.googlecode.charts4j.AxisTextAlignment;
import com.googlecode.charts4j.Color;
import com.googlecode.charts4j.Data;
import com.googlecode.charts4j.Fills;
import com.googlecode.charts4j.GCharts;
import com.googlecode.charts4j.LinearGradientFill;
import com.googlecode.charts4j.Plots;
import com.googlecode.charts4j.ScatterPlot;
import com.googlecode.charts4j.ScatterPlotData;
import com.googlecode.charts4j.Shape;

/**
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 */
public class ScatterChartExample {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).setLevel(Level.ALL);
    }

    @Test
    public void example1() {
        // EXAMPLE CODE START
        Data d1 = Data.newData(10, 50, 30, 45, 65, 95, 20, 80);
        Data d2 = Data.newData(20, 40, 40, 15, 85, 95, 80, 20);
        Data pointSizes = Data.newData(100, 30, 50, 75, 40, 35, 80, 100);
        ScatterPlotData data = Plots.newScatterPlotData(d1, d2, pointSizes);
        data.setLegend("Diamond");
        Color diamondColor = Color.newColor("FF471A");
        data.addShapeMarkers(Shape.DIAMOND, diamondColor, 30);
        data.setColor(diamondColor);
        ScatterPlot chart = GCharts.newScatterPlot(data);
        chart.setSize(600, 450);
        chart.setGrid(20, 20, 3, 2);

        AxisLabels axisLabels = AxisLabelsFactory.newNumericRangeAxisLabels(0, 100);
        axisLabels.setAxisStyle(AxisStyle.newAxisStyle(WHITE, 13, AxisTextAlignment.CENTER));

        chart.addXAxisLabels(axisLabels);
        chart.addYAxisLabels(axisLabels);

        chart.setTitle("Scatter Plot", WHITE, 16);
        chart.setBackgroundFill(Fills.newSolidFill(Color.newColor("2F3E3E")));
        LinearGradientFill fill = Fills.newLinearGradientFill(0, Color.newColor("3783DB"), 100);
        fill.addColorAndOffset(Color.newColor("9BD8F5"), 0);
        chart.setAreaFill(fill);
        String url = chart.toURLString();
        // EXAMPLE CODE END. Use this url string in your web or
        // Internet application.
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(url);
        String expectedString = "http://chart.apis.google.com/chart?chf=bg,s,2F3E3E|c,lg,0,3783DB,1.0,9BD8F5,0.0&chs=600x450&chd=e:GagATNczpm8yMzzM,MzZmZmJm2Z8yzMMz,..TNgAv.ZmWZzM..&chtt=Scatter+Plot&chts=FFFFFF,16&chg=20.0,20.0,3,2&chxt=y,x&chxr=0,0.0,100.0|1,0.0,100.0&chxs=0,FFFFFF,13,0|1,FFFFFF,13,0&chco=FF471A&chdl=Diamond&chm=d,FF471A,0,-1,30,0&cht=s";
        assertEquals("Junit error", normalize(expectedString), normalize(url));
    }
}
