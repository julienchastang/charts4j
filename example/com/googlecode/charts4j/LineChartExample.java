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

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 */
public class LineChartExample {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        Logger.global.setLevel(Level.ALL);
    }

    @Test
    public void example1() {

        // EXAMPLE CODE START
        
        // Defining lines
        final int NUM_POINTS = 25;
        final double[] competition = new double[NUM_POINTS];
        final double[] mywebsite = new double[NUM_POINTS];
        for (int i = 0; i < NUM_POINTS; i++) {
            competition[i] = 100-(Math.cos(30*i*Math.PI/180)*10 + 50)*i/20;
            mywebsite[i] = (Math.cos(30*i*Math.PI/180)*10 + 50)*i/20;
        }
        Line line1 = Plots.newLine(Data.newData(mywebsite), Color.newColor("CA3D05"), "My Website.com");
        line1.setLineStyle(LineStyle.newLineStyle(3, 1, 0));
        line1.addShapeMarkers(Shape.DIAMOND, Color.newColor("CA3D05"), 12);
        line1.addShapeMarkers(Shape.DIAMOND, Color.WHITE, 8);
        Line line2 = Plots.newLine(Data.newData(competition), SKYBLUE, "Competition.com");
        line2.setLineStyle(LineStyle.newLineStyle(3, 1, 0));
        line2.addShapeMarkers(Shape.DIAMOND, SKYBLUE, 12);
        line2.addShapeMarkers(Shape.DIAMOND, Color.WHITE, 8);


        // Defining chart.
        LineChart chart = GCharts.newLineChart(line1, line2);
        chart.setSize(600, 450);
        chart.setTitle("Web Traffic|(in billions of hits)", WHITE, 14);
        chart.addHorizontalRangeMarker(40, 60, Color.newColor(RED, 30));
        chart.addVerticalRangeMarker(70, 90, Color.newColor(GREEN, 30));
        chart.setGrid(25, 20, 3, 2);

        // Defining axis info and styles
        AxisStyle axisStyle = AxisStyle.newAxisStyle(WHITE, 12, AxisTextAlignment.CENTER);
        AxisLabels xAxis = AxisLabelsFactory.newAxisLabels("Nov", "Dec", "Jan", "Feb", "Mar");
        xAxis.setAxisStyle(axisStyle);
        AxisLabels xAxis2 = AxisLabelsFactory.newAxisLabels("2007", "2007", "2008", "2008", "2008");
        xAxis2.setAxisStyle(axisStyle);
        AxisLabels yAxis = AxisLabelsFactory.newAxisLabels("", "25", "50", "75", "100");
        AxisLabels xAxis3 = AxisLabelsFactory.newAxisLabels("Month", 50.0);
        xAxis3.setAxisStyle(AxisStyle.newAxisStyle(WHITE, 14, AxisTextAlignment.CENTER));
        yAxis.setAxisStyle(axisStyle);
        AxisLabels yAxis2 = AxisLabelsFactory.newAxisLabels("Hits", 50.0);
        yAxis2.setAxisStyle(AxisStyle.newAxisStyle(WHITE, 14, AxisTextAlignment.CENTER));
        yAxis2.setAxisStyle(axisStyle);

        // Adding axis info to chart.
        chart.addXAxisLabels(xAxis);
        chart.addXAxisLabels(xAxis2);
        chart.addXAxisLabels(xAxis3);
        chart.addYAxisLabels(yAxis);
        chart.addYAxisLabels(yAxis2);
       
        // Defining background and chart fills.
        chart.setBackgroundFill(Fills.newSolidFill(Color.newColor("1F1D1D")));
        LinearGradientFill fill = Fills.newLinearGradientFill(0, Color.newColor("363433"), 100);
        fill.addColorAndOffset(Color.newColor("2E2B2A"), 0);
        chart.setAreaFill(fill);
        String url = chart.toURLString();
        // EXAMPLE CODE END. Use this url string in your web or
        // Internet application.
        Logger.global.info(url);
        String expectedString = "http://chart.apis.google.com/chart?chf=bg,s,1F1D1D|c,lg,0,363433,1.0,2E2B2A,0.0&chs=600x450&chd=e:AAB4DhEzFxGnHrJRLhOZRmUpXCYZYpYAXCWfXCZIczhmmtrKuE,..-H8e7M6O5Y4U2u0exmuZrWo9nmnWn.o9pgo9m3jMeZZSU1R7&chtt=Web+Traffic%7C%28in+billions+of+hits%29&chts=FFFFFF,14&chg=25.0,20.0,3,2&chxt=y,y,x,x,x&chxl=0:||25|50|75|100|1:|Hits|2:|Nov|Dec|Jan|Feb|Mar|3:|2007|2007|2008|2008|2008|4:|Month&chxs=0,FFFFFF,12,0|1,FFFFFF,12,0|2,FFFFFF,12,0|3,FFFFFF,12,0|4,FFFFFF,14,0&chxp=1,50.0|4,50.0&chxr=1,0.0,100.0|4,0.0,100.0&chm=r,FF00004C,0,0.40,0.60|R,0080004C,0,0.70,0.90|d,CA3D05,0,-1,12,0|d,FFFFFF,0,-1,8,0|d,87CEEB,1,-1,12,0|d,FFFFFF,1,-1,8,0&chdl=My+Website.com|Competition.com&chco=CA3D05,87CEEB&chls=3,1,0|3,1,0&cht=lc";
        assertEquals("Junit error", normalize(expectedString), normalize(url));
    }
    
    @Test
    public void example2() {
        // EXAMPLE CODE START
        // Defining Line
        final double[] sp500 = { 62.960, 74.560, 84.300, 92.200, 95.890, 103.800, 91.600, 92.270, 96.870, 116.930, 97.540, 67.160, 89.770, 106.880, 94.750, 96.280, 107.840, 135.330, 122.300, 140.340, 164.860, 166.260, 210.680, 243.370,
                247.840, 277.080, 350.680, 328.710, 415.140, 438.820, 468.660, 460.920, 614.120, 753.850, 970.840, 1231.93, 1464.47, 1334.22, 1161.02, 879.390, 1109.64, 1213.55, 1258.17, 1424.71, 1475.25 };
        final double INFLATION = 0.035;
        
        final double[] inflation = new double[sp500.length];
        inflation[0] = sp500[0];
        for (int i = 1; i < inflation.length; i++) {
            inflation[i] = inflation[i-1] *INFLATION + inflation[i-1];
        }
        
        Line line1 = Plots.newLine(DataUtil.scaleWithinRange(0,1500,sp500), YELLOW, "S & P 500");
        line1.setLineStyle(LineStyle.newLineStyle(3, 1, 0));
        line1.addShapeMarkers(Shape.CIRCLE, YELLOW, 10);
        line1.addShapeMarkers(Shape.CIRCLE, BLACK, 7);
        line1.addShapeMarker(Shape.VERTICAL_LINE_PARTIAL, BLUE,3,8);
        line1.addShapeMarker(Shape.VERTICAL_LINE_PARTIAL, BLUE,3,17);
        line1.addShapeMarker(Shape.VERTICAL_LINE_PARTIAL, BLUE,3,24);
        line1.addShapeMarker(Shape.VERTICAL_LINE_PARTIAL, BLUE,3,40);
        line1.setFillAreaColor(LIGHTYELLOW);
        
        Line line2 = Plots.newLine(DataUtil.scaleWithinRange(0,1500,inflation), LIMEGREEN, "Inflation");
        line2.setLineStyle(LineStyle.newLineStyle(3, 1, 0));
        line2.addShapeMarkers(Shape.CIRCLE, LIME, 10);
        line2.addShapeMarkers(Shape.CIRCLE, BLACK, 7);
        line2.setFillAreaColor(LIGHTGREEN);


        // Defining chart.
        LineChart chart = GCharts.newLineChart(line1,line2);
        chart.setSize(600, 450);
        chart.setTitle("S & P 500|1962 - 2008", WHITE, 14);

        // Defining axis info and styles
        AxisStyle axisStyle = AxisStyle.newAxisStyle(WHITE, 12, AxisTextAlignment.CENTER);
        AxisLabels yAxis = AxisLabelsFactory.newNumericRangeAxisLabels(0, sp500[sp500.length-1]);
        yAxis.setAxisStyle(axisStyle);
        AxisLabels xAxis1 = AxisLabelsFactory.newAxisLabels(Arrays.asList("Fed Chiefs:","Burns","Volcker","Greenspan","Bernanke"), Arrays.asList(5,18,39,55,92));
        xAxis1.setAxisStyle(axisStyle);
        AxisLabels xAxis2 = AxisLabelsFactory.newNumericRangeAxisLabels(1962, 2008);
        xAxis2.setAxisStyle(axisStyle);
        AxisLabels xAxis3 = AxisLabelsFactory.newAxisLabels("Year", 50.0);
        xAxis3.setAxisStyle(AxisStyle.newAxisStyle(WHITE, 14, AxisTextAlignment.CENTER));

        // Adding axis info to chart.
        chart.addYAxisLabels(yAxis);
        chart.addXAxisLabels(xAxis1);
        chart.addXAxisLabels(xAxis2);
        chart.addXAxisLabels(xAxis3);
        chart.setGrid(100, 6.78, 5, 0);

        // Defining background and chart fills.
        chart.setBackgroundFill(Fills.newSolidFill(BLACK));
        chart.setAreaFill(Fills.newSolidFill(Color.newColor("708090")));
        String url = chart.toURLString();
        // EXAMPLE CODE END. Use this url string in your web or
        // Internet application.
        Logger.global.info(url);
        Logger.global.info(url.length() + "");
        String expectedString = "http://chart.apis.google.com/chart?chf=bg,s,000000|c,s,708090&chs=600x450&chd=e:CsDMDmD8EGEbD6D8EIE.EKC3D1EkEDEHEmFxFOF.HCHGI.KYKlL0O9OBRtSuT.TqaNgKpa0j-e46xilhvVzx1r8x-7,CsCyC4C.DFDMDTDbDiDqDyD7EEENEWEgEqE0E.FKFWFiFuF7GIGWGkGzHCHSHiHzIFIXIqI9JRJmJ7KSKpLALZLzMN&chtt=S+%26+P+500%7C1962+-+2008&chts=FFFFFF,14&chg=100.0,6.78,5,0&chxt=y,x,x,x&chxr=0,0.0,1475.25|1,0.0,100.0|2,1962.0,2008.0|3,0.0,100.0&chxs=0,FFFFFF,12,0|1,FFFFFF,12,0|2,FFFFFF,12,0|3,FFFFFF,14,0&chxl=1:|Fed+Chiefs%3A|Burns|Volcker|Greenspan|Bernanke|3:|Year&chxp=1,5,18,39,55,92|3,50.0&chdl=S+%26+P+500|Inflation&chco=FFFF00,32CD32&chm=o,FFFF00,0,-1,10,0|o,000000,0,-1,7,0|v,0000FF,0,8,3,0|v,0000FF,0,17,3,0|v,0000FF,0,24,3,0|v,0000FF,0,40,3,0|B,FFFFE0,0,0,0|o,00FF00,1,-1,10,0|o,000000,1,-1,7,0|B,90EE90,1,0,0&chls=3,1,0|3,1,0&cht=lc";
        assertEquals("Junit error", normalize(expectedString), normalize(url));
    }

}
