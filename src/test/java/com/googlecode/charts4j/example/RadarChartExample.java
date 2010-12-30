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

package com.googlecode.charts4j.example;

import static com.googlecode.charts4j.Color.*;
import static com.googlecode.charts4j.UrlUtil.normalize;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 */
public class RadarChartExample {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).setLevel(Level.ALL);
    }

    /**
     * Testing radar charts
     */
    @Test
    public void example1() {
        // EXAMPLE CODE START
        int count = 202;
        double[] x = new double[count];
        double[] x1 = new double[count];

        int cnt = 0;
        for (double i = 0; i < count; i = i + 1) {
            x[cnt] = Math.sin(i / 4);
            x1[cnt] = 20;
            cnt++;
        }

        final RadarPlot plot1 = Plots.newRadarPlot(DataUtil.scale(x), Color.newColor("3D5593"));
        plot1.setFillAreaColor(Color.newColor("8FA3D6"));
        final RadarPlot plot2 = Plots.newRadarPlot(Data.newData(x1));
        plot2.setFillAreaColor(Color.newColor("3D5593"));
        for (int i = 0; i < count; i = i + 20) {
            plot2.addShapeMarker(Shape.CIRCLE, PINK, 20, i);
        }
        final RadarChart chart = GCharts.newRadarChart(plot1, plot2);
        chart.setBackgroundFill(Fills.newSolidFill(Color.newColor("504227")));
        chart.setSpline(true);
        chart.setDataEncoding(DataEncoding.SIMPLE);
        chart.setSize(500, 500);
        chart.setTitle("Radar Chart", WHITE, 16);
        String url = chart.toURLString();
        // EXAMPLE CODE END. Use this url string in your web or
        // Internet application.
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(url);
        String expectedString = "http://chart.apis.google.com/chart?chco=3D5593,000000&chd=s:fmtz479962xqjbUNHDBABEJPWdlsz479973yrkcVOIEBABEIOVckry379973ysldWPJEBABDINUbjqx269974ztmeXQKFBABDHMTaipw2689850unfYRKFCAACGMSZhpv1589851vogZRLGCAACGLRYgou0589861vphaSMGDAACFKQXfnu0489862wqibTNHDBABFJPWe,MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM&chf=bg,s,504227&chm=B,8FA3D6,0,0,0|o,FFC0CB,1,0,20,0|o,FFC0CB,1,20,20,0|o,FFC0CB,1,40,20,0|o,FFC0CB,1,60,20,0|o,FFC0CB,1,80,20,0|o,FFC0CB,1,100,20,0|o,FFC0CB,1,120,20,0|o,FFC0CB,1,140,20,0|o,FFC0CB,1,160,20,0|o,FFC0CB,1,180,20,0|o,FFC0CB,1,200,20,0|B,3D5593,1,0,0&chs=500x500&cht=rs&chts=FFFFFF,16&chtt=Radar+Chart";
        assertEquals("Junit error", normalize(expectedString), normalize(url));
    }

    @Test
    public void example2() {
        // EXAMPLE CODE START
        RadarPlot plot = Plots.newRadarPlot(Data.newData(80, 50, 50, 80, 60, 80));
        Color plotColor = Color.newColor("CC3366");
        plot.addShapeMarkers(Shape.SQUARE, plotColor, 12);
        plot.addShapeMarkers(Shape.SQUARE, WHITE, 8);
        plot.setColor(plotColor);
        plot.setLineStyle(LineStyle.newLineStyle(4, 1, 0));
        RadarChart chart = GCharts.newRadarChart(plot);
        chart.setTitle("Simple Radar Chart", BLACK, 20);
        chart.setSize(400, 400);
        RadialAxisLabels radialAxisLabels = AxisLabelsFactory.newRadialAxisLabels("Maths", "Arts", "French", "German", "Music");
        radialAxisLabels.setRadialAxisStyle(BLACK, 12);
        chart.addRadialAxisLabels(radialAxisLabels);
        AxisLabels contrentricAxisLabels = AxisLabelsFactory.newNumericAxisLabels(Arrays.asList(0, 20, 40, 60, 80, 100));
        contrentricAxisLabels.setAxisStyle(AxisStyle.newAxisStyle(BLACK, 12, AxisTextAlignment.RIGHT));
        chart.addConcentricAxisLabels(contrentricAxisLabels);
        String url = chart.toURLString();
        // EXAMPLE CODE END. Use this url string in your web or
        // Internet application.
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(url);
        String expectedString = "http://chart.apis.google.com/chart?cht=r&chxt=y,x&chls=4,1,0&chco=CC3366&chs=400x400&chts=000000,20&chxr=0,0.0,100.0&chd=e:zMgAgAzMmZzM&chtt=Simple+Radar+Chart&chxp=0,0,20,40,60,80,100&chxs=0,000000,12,1|1,000000,12,0&chxl=1:|Maths|Arts|French|German|Music&chm=s,CC3366,0,-1,12,0|s,FFFFFF,0,-1,8,0";
        assertEquals("Junit error", normalize(expectedString), normalize(url));
    }
}
