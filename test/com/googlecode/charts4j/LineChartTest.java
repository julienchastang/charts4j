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

import static com.googlecode.charts4j.Color.AZURE;
import static com.googlecode.charts4j.Color.BLACK;
import static com.googlecode.charts4j.Color.GREEN;
import static com.googlecode.charts4j.Color.LIGHTBLUE;
import static com.googlecode.charts4j.Color.LIGHTGREY;
import static com.googlecode.charts4j.Color.RED;
import static com.googlecode.charts4j.Color.WHITE;
import static com.googlecode.charts4j.UrlUtil.normalize;
import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;
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
public class LineChartTest {

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

    /**
     * A chart with colored lines and mulitple labels
     */
    @Test
    public void test0() {
        // Defining Line
        final Line line = Plots.newLine(Data.newData(0, 45, 35, 75, 100));
        line.setLineStyle(LineStyle.newLineStyle(3, 1, 0));
        line.setColor(RED);
        // Defining chart.
        final LineChart chart = GCharts.newLineChart(line);
        chart.setSize(400, 300);
        chart.setTitle("Web Traffic|(in billions of hits)", RED, 14);
        chart.addXAxisLabels(AxisLabelsFactory.newAxisLabels("Nov", "Dec", "Jan", "Feb", "Mar"));
        chart.addXAxisLabels(AxisLabelsFactory.newAxisLabels("2008", "2007", "2008", "2008", "2008"));
        chart.addYAxisLabels(AxisLabelsFactory.newAxisLabels("", "25", "50", "75", "100"));
        // Defining background and chart fills.
        chart.setBackgroundFill(Fills.newSolidFill(LIGHTGREY));
        final LinearGradientFill fill = Fills.newLinearGradientFill(0, LIGHTBLUE, 100);
        fill.addColorAndOffset(WHITE, 0);
        chart.setAreaFill(fill);
        Logger.global.info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?chco=FF0000&chd=e:AAczWZv...&chf=bg,s,D3D3D3|c,lg,0,ADD8E6,1.0,FFFFFF,0.0&chls=3,1,0&chs=400x300&cht=lc&chts=FF0000,14&chtt=Web+Traffic%7C%28in+billions+of+hits%29&chxl=0:||25|50|75|100|1:|Nov|Dec|Jan|Feb|Mar|2:|2008|2007|2008|2008|2008&chxt=y,x,x";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }

    /**
     * Testing legends, line styles and multiple lines.
     */
    @Test
    public void test1() {

        final Line line = Plots.newLine(Data.newData(0, 50, 100), GREEN);
        line.setLineStyle(LineStyle.newLineStyle(3, 6, 3));
        final Line line2 = Plots.newLine(Data.newData(0, 10, 20), RED, "my legend 2");
        final LineChart chart = GCharts.newLineChart(line, line2);
        chart.setTitle("Foobar");
        Logger.global.info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?cht=lc&chs=200x125&chls=3,6,3|1,1,0&chco=008000,FF0000&chdl=+|my+legend+2&chd=e:AAgA..,AAGaMz&chtt=Foobar";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }

    /**
     * Testing chart fill.
     */
    @Test
    public void test2() {
        final Line line = Plots.newLine(Data.newData(0, 50, 100), GREEN);
        final LineChart chart = GCharts.newLineChart(line);
        chart.setTitle("Foobar");
        chart.setBackgroundFill(Fills.newSolidFill(AZURE));
        chart.setAreaFill(Fills.newSolidFill(BLACK));
        Logger.global.info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?cht=lc&chs=200x125&chco=008000&chf=bg,s,F0FFFF|c,s,000000&chd=e:AAgA..&chtt=Foobar";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }

    /**
     * Testing linear stripes.
     */
    @Test
    public void test3() {
        final Line line = Plots.newLine(Data.newData(0, 50, 100), GREEN);
        line.setLineStyle(LineStyle.newLineStyle(3, 6, 3));
        line.setLegend("foo");
        final AxisLabels info = AxisLabelsFactory.newNumericRangeAxisLabels(20, 30);
        final LineChart chart = GCharts.newLineChart(line);
        chart.addYAxisLabels(info);
        chart.setTitle("Foobar");
        final LinearStripesFill ls = Fills.newLinearStripesFill(0, LIGHTGREY, 20);
        ls.addColorAndWidth(WHITE, 20);
        chart.setBackgroundFill(ls);
        Logger.global.info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?chco=008000&chd=e:AAgA..&chdl=foo&chf=bg,ls,0,D3D3D3,0.2,FFFFFF,0.2&chls=3,6,3&chs=200x125&cht=lc&chtt=Foobar&chxr=0,20.0,30.0&chxt=y";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }

    /**
     * Testing sparklines
     */
    @Test
    public void test4() {
        final Line line = Plots.newLine(Data.newData(0, 50, 100), GREEN);
        final LineChart chart = GCharts.newLineChart(line);
        chart.setSparkline(true);
        chart.setTitle("Foobar");
        Logger.global.info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?cht=ls&chs=200x125&chco=008000&chd=e:AAgA..&chtt=Foobar";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }

    /**
     * Testing Gridlines
     */
    @Test
    public void test5() {
        final Line line = Plots.newLine(Data.newData(0, 50, 100), GREEN);
        final LineChart chart = GCharts.newLineChart(line);
        chart.setSize(400, 400);
        chart.setGrid(20, 20, 5, 5);
        Logger.global.info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?chco=008000&chd=e:AAgA..&chg=20.0,20.0,5,5&chs=400x400&cht=lc";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }

    /**
     * Testing Gridlines
     */
    @Test
    public void test6() {
        final Line line0 = Plots.newLine(Data.newData(0, 50, 100), RED);
        line0.setPriority(Priority.LOW);
        final Line line1 = Plots.newLine(Data.newData(0, 50, 100), GREEN);
        line1.setPriority(Priority.HIGH);
        final LineChart chart = GCharts.newLineChart(line0, line1);
        chart.setSize(400, 400);
        chart.setGrid(20, 20, 5, 5);
        Logger.global.info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?chco=FF0000,008000&chd=e:AAgA..,AAgA..&chg=20.0,20.0,5,5&chm=D,FF0000,0,0,1,-1|D,008000,1,0,1,1&chs=400x400&cht=lc";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }

    /**
     * Testing legends, line styles and multiple lines.
     */
    @Test
    public void test7() {
        final Line line = Plots.newLine(Data.newData(0, 50, 100), GREEN, "myLegend");
        final LineChart chart = GCharts.newLineChart(line);
        chart.setLegendPosition(LegendPosition.BOTTOM);
        Logger.global.info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?chco=008000&chd=e:AAgA..&chdl=myLegend&chdlp=b&chs=200x125&cht=lc";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }

    /**
     * Testing chart transparency. Also exposes a bug in the Google Chart API
     * where the label color badge disappears.
     */
    @Test
    public void test8() {
        final Line line = Plots.newLine(Data.newData(0, 50, 100), GREEN, "myLegend");
        final LineChart chart = GCharts.newLineChart(line);
        chart.setTransparency(50);
        Logger.global.info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?chco=008000&chd=e:AAgA..&chdl=myLegend&chf=a,s,FFFFFF7F&chs=200x125&cht=lc";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }

    /**
     * Testing plotting one point.
     */
    @Test
    public void test9() {
        final Line line = Plots.newLine(Data.newData(50));
        final LineChart chart = GCharts.newLineChart(line);
        Logger.global.info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?cht=lc&chd=e:gA&chs=200x125";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));
    }

    @Test
    public void test10() {
        double d0[] = new double[100];
        double d1[] = new double[100];

        for (int i = 0; i < d0.length; i++) {
            d0[i] = 5*Math.sin(i*0.2);
        }

        for (int i = 0; i < d1.length; i++) {
            d1[i] = Math.cos(i*0.2);
        }

        List<Data> data = DataUtil.scale(new double[][]{d0,d1});
        List<Plot> plots = new LinkedList<Plot>();

        for (Data d : data) {
            plots.add(Plots.newPlot(d));
        }

        final LineChart chart = GCharts.newLineChart(plots);

        Logger.global.info(chart.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?chd=e:gAmXsdyE296791.i...K9G541nwgqukheIX1R2MbHyEHBjANAIBUDvHRLzRIXEdWjvp-v01B5Z8w--.9.q-G7W3gyutMnIgzabUROmJnFhCeAnAAArClFrJ0O1UiathFnatcy83s7f-N.t.8-68o5O00vkptjddEWyQ4LlHGDmBPAGAPBpEQH-MpSGYGeakzq.wv116C,mamRl5lSkdjdiUhGf0ejdVcPbSahZ-ZqZnZ0aRa8b0c3eCfSgkh0jAkEk-lrmJmYmXmFlkk1j5i0hngWfEd1crbqa0aLZxZmZtaDaobbcadiewgChTihjpknlal-mUmZmOl0lKkTjSiHg4fmeWdJcEbJaaZ6ZpZoZ4aXbFb.dDePfggxiBjMkOlGlxmNmZmVmBldkrju&chs=200x125&cht=lc";
        assertEquals("Junit error", normalize(expectedString), normalize(chart.toURLString()));

    }
}
