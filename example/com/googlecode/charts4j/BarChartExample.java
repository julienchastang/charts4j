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
public class BarChartExample {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        Logger.global.setLevel(Level.ALL);
    }

    @Test
    public void example1() {
        // EXAMPLE CODE START
        // Defining data plots.
        BarChartPlot team1 = Plots.newBarChartPlot(Data.newData(25, 43, 12, 30), BLUEVIOLET, "Team A");
        BarChartPlot team2 = Plots.newBarChartPlot(Data.newData(8, 35, 11, 5), ORANGERED, "Team B");
        BarChartPlot team3 = Plots.newBarChartPlot(Data.newData(10, 20, 30, 30), LIMEGREEN, "Team C");

        // Instantiating chart.
        BarChart chart = GCharts.newBarChart(team1, team2, team3);

        // Defining axis info and styles
        AxisStyle axisStyle = AxisStyle.newAxisStyle(BLACK, 13, AxisTextAlignment.CENTER);
        AxisLabels score = AxisLabelsFactory.newAxisLabels("Score", 50.0);
        score.setAxisStyle(axisStyle);
        AxisLabels year = AxisLabelsFactory.newAxisLabels("Year", 50.0);
        year.setAxisStyle(axisStyle);

        // Adding axis info to chart.
        chart.addXAxisLabels(AxisLabelsFactory.newAxisLabels("2002", "2003", "2004", "2005"));
        chart.addYAxisLabels(AxisLabelsFactory.newNumericRangeAxisLabels(0, 100));
        chart.addYAxisLabels(score);
        chart.addXAxisLabels(year);

        chart.setSize(600, 450);
        chart.setBarWidth(100);
        chart.setSpaceWithinGroupsOfBars(20);
        chart.setDataStacked(true);
        chart.setTitle("Team Scores", BLACK, 16);
        chart.setGrid(100, 10, 3, 2);
        chart.setBackgroundFill(Fills.newSolidFill(ALICEBLUE));
        LinearGradientFill fill = Fills.newLinearGradientFill(0, LAVENDER, 100);
        fill.addColorAndOffset(WHITE, 0);
        chart.setAreaFill(fill);
        String url = chart.toURLString();
        // EXAMPLE CODE END. Use this url string in your web or
        // Internet application.
        Logger.global.info(url);
        String expectedString = "http://chart.apis.google.com/chart?chf=bg,s,F0F8FF|c,lg,0,E6E6FA,1.0,FFFFFF,0.0&chs=600x450&chd=e:QAbhHrTN,FIWZHCDN,GaMzTNTN&chtt=Team+Scores&chts=000000,16&chg=100.0,10.0,3,2&chxt=y,y,x,x&chxr=0,0.0,100.0|1,0.0,100.0|3,0.0,100.0&chxl=1:|Score|2:|2002|2003|2004|2005|3:|Year&chxp=1,50.0|3,50.0&chxs=1,000000,13,0|3,000000,13,0&chdl=Team+A|Team+B|Team+C&chco=8A2BE2,FF4500,32CD32&chbh=100,20,8&cht=bvs";
        assertEquals("Junit error", normalize(expectedString), normalize(url));
    }

    @Test
    public void example2() {
        // EXAMPLE CODE START
        // Defining data series.
        final int MAX_MEDALS = 51;
        Data goldData= DataUtil.scaleWithinRange(0, MAX_MEDALS, Arrays.asList(MAX_MEDALS, 36, 23, 19, 16));
        Data silverData= DataUtil.scaleWithinRange(0, MAX_MEDALS, Arrays.asList(21, 38, 21, 13, 10));
        Data bronzeData= DataUtil.scaleWithinRange(0, MAX_MEDALS, Arrays.asList(28, 36, 28, 15, 15));
        BarChartPlot gold = Plots.newBarChartPlot(goldData, GOLD, "Gold");
        BarChartPlot silver = Plots.newBarChartPlot(silverData, SILVER, "Silver");
        BarChartPlot bronze = Plots.newBarChartPlot(bronzeData, Color.BROWN, "Bronze");
        BarChart chart = GCharts.newBarChart(gold, silver,  bronze);

        // Defining axis info and styles
        AxisStyle axisStyle = AxisStyle.newAxisStyle(BLACK, 13, AxisTextAlignment.CENTER);
        AxisLabels country = AxisLabelsFactory.newAxisLabels("Country", 50.0);
        country.setAxisStyle(axisStyle);
        AxisLabels countries = AxisLabelsFactory.newAxisLabels("Germany", "United Kingdom", "Russia", "USA", "China");
        countries.setAxisStyle(axisStyle);
        AxisLabels medals = AxisLabelsFactory.newAxisLabels("Medals", 50.0);
        medals.setAxisStyle(axisStyle);
        AxisLabels medalCount = AxisLabelsFactory.newNumericRangeAxisLabels(0, MAX_MEDALS);
        medalCount.setAxisStyle(axisStyle);
        

        // Adding axis info to chart.
        chart.addXAxisLabels(medalCount);
        chart.addXAxisLabels(medals);
        chart.addYAxisLabels(countries);
        chart.addYAxisLabels(country);
        chart.addTopAxisLabels(medalCount);
        chart.setHorizontal(true);
        chart.setSize(450, 650);
        chart.setSpaceBetweenGroupsOfBars(30);
        
        chart.setTitle("2008 Beijing Olympics Medal Count", BLACK, 16);
        ///51 is the max number of medals.
        chart.setGrid((50.0/MAX_MEDALS)*20, 600, 3, 2);
        chart.setBackgroundFill(Fills.newSolidFill(LIGHTGREY));
        LinearGradientFill fill = Fills.newLinearGradientFill(0, Color.newColor("E37600"), 100);
        fill.addColorAndOffset(Color.newColor("DC4800"), 0);
        chart.setAreaFill(fill);
        String url = chart.toURLString();
        // EXAMPLE CODE END. Use this url string in your web or
        // Internet application.

        Logger.global.info(url);
        String expectedString = "http://chart.apis.google.com/chart?chf=bg,s,D3D3D3|c,lg,0,E37600,1.0,DC4800,0.0&chs=450x650&chd=e:..tLc3X2UF,aWvraWQUMj,jItLjIS0S0&chtt=2008+Beijing+Olympics+Medal+Count&chts=000000,16&chg=19.6078431372549,600.0,3,2&chxt=y,y,t,x,x&chxl=0:|Germany|United+Kingdom|Russia|USA|China|1:|Country|4:|Medals&chxs=0,000000,13,0|1,000000,13,0|2,000000,13,0|3,000000,13,0|4,000000,13,0&chxp=1,50.0|4,50.0&chxr=1,0.0,100.0|2,0.0,51.0|3,0.0,51.0|4,0.0,100.0&chdl=Gold|Silver|Bronze&chco=FFD700,C0C0C0,A52A2A&chbh=23,4,30&cht=bhg";
        assertEquals("Junit error", normalize(expectedString), normalize(url));
    }
}
