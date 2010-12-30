package com.googlecode.charts4j.example;

import static com.googlecode.charts4j.example.Color.*;
import static com.googlecode.charts4j.example.UrlUtil.normalize;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.BeforeClass;
import org.junit.Test;

public class GeneralExample {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).setLevel(Level.ALL);
    }

    @Test
    //Defining a very simple chart.
    public void example1() {
        // EXAMPLE CODE START
        Plot plot = Plots.newPlot(Data.newData(0, 66.6, 33.3, 100));
        LineChart chart = GCharts.newLineChart(plot);
        String url = chart.toURLString();
        // EXAMPLE CODE END. Use this url string in your web or
        // Internet application.
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(url);
        String expectedString = "http://chart.apis.google.com/chart?chd=e:AAqnVU..&chs=200x125&cht=lc";
        assertEquals("Junit error", normalize(expectedString), normalize(url));
    }

    @Test
    //Note that data, grids, axis labels, range markers all snap together nicely.
    public void example2() {
        // EXAMPLE CODE START
        Plot plot = Plots.newPlot(Data.newData(0, 66.6, 33.3, 100));
        LineChart chart = GCharts.newLineChart(plot);
        chart.addHorizontalRangeMarker(33.3, 66.6, LIGHTBLUE);
        chart.setGrid(33.3, 33.3, 3, 3);
        chart.addXAxisLabels(AxisLabelsFactory.newAxisLabels(Arrays.asList("Peak","Valley"), Arrays.asList(33.3,66.6)));
        chart.addYAxisLabels(AxisLabelsFactory.newNumericAxisLabels(0,33.3,66.6,100));
        String url = chart.toURLString();
        // EXAMPLE CODE END. Use this url string in your web or
        // Internet application.
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(url);
        String expectedString = "http://chart.apis.google.com/chart?chs=200x125&chd=e:AAqnVU..&chg=33.3,33.3,3,3&chxt=y,x&chxp=0,0.0,33.3,66.6,100.0|1,33.3,66.6&chxr=0,0.0,100.0|1,0.0,100.0&chxl=1:|Peak|Valley&chm=r,ADD8E6,0,0.33,0.67&cht=lc";
        assertEquals("Junit error", normalize(expectedString), normalize(url));
    }

    @Test
    // Polymorphic chart example. A plot can be expressed in a
    // line chart, bar chart, radar chart, scatter plot.
    public void example3() {
        // EXAMPLE CODE START
        Plot plot = Plots.newPlot(Data.newData(0, 10, 20, 30, 40, 50, 60, 70, 80, 90));
        plot.addShapeMarkers(Shape.DIAMOND, BLUE, 12);

        //Same data expressed in different charts.
        LineChart lineChart = GCharts.newLineChart(plot);
        lineChart.setSize(400, 200);
        BarChart barChart = GCharts.newBarChart(plot);
        barChart.setSize(400, 200);
        RadarChart radarChart = GCharts.newRadarChart(plot);
        radarChart.setSize(400, 200);
        ScatterPlot  scatterChart = GCharts.newScatterPlot(plot);
        scatterChart.setSize(400, 200);
        XYLineChart  xyLineChart = GCharts.newXYLineChart(plot);
        xyLineChart.setSize(400, 200);


        String lineChartUrl = lineChart.toURLString();
        String barChartUrl = barChart.toURLString();
        String radarChartUrl = radarChart.toURLString();
        String scatterChartUrl = scatterChart.toURLString();
        String xyLineChartUrl = xyLineChart.toURLString();

        // EXAMPLE CODE END. Use these URLs string in your web or
        // Internet application.

        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(lineChartUrl);
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(barChartUrl);
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(radarChartUrl);
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(scatterChartUrl);
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(xyLineChartUrl);


        String expectedLineChartUrl    = "http://chart.apis.google.com/chart?chs=400x200&chd=e:AAGaMzTNZmgAmZszzM5m&chm=d,0000FF,0,-1,12,0&cht=lc";
        String expectedBarChartUrl     = "http://chart.apis.google.com/chart?chs=400x200&chd=e:AAGaMzTNZmgAmZszzM5m&chm=d,0000FF,0,-1,12,0&chbh=23,4,8&cht=bvg";
        String expectedRadarChartUrl   = "http://chart.apis.google.com/chart?chs=400x200&chd=e:AAGaMzTNZmgAmZszzM5m&chm=d,0000FF,0,-1,12,0&cht=r";
        String expectedScatterChartUrl = "http://chart.apis.google.com/chart?chd=e:AAHHOOVVccjjqqxx44..,AAGaMzTNZmgAmZszzM5m&chm=d,0000FF,0,-1,12,0&chs=400x200&cht=s";
        String expectedXYLineChartUrl  = "http://chart.apis.google.com/chart?chd=e:AAHHOOVVccjjqqxx44..,AAGaMzTNZmgAmZszzM5m&chm=d,0000FF,0,-1,12,0&chs=400x200&cht=lxy";


        assertEquals("Junit error", normalize(expectedLineChartUrl), normalize(lineChartUrl));
        assertEquals("Junit error", normalize(expectedBarChartUrl), normalize(barChartUrl));
        assertEquals("Junit error", normalize(expectedRadarChartUrl), normalize(radarChartUrl));
        assertEquals("Junit error", normalize(expectedScatterChartUrl), normalize(scatterChartUrl));
        assertEquals("Junit error", normalize(expectedXYLineChartUrl), normalize(xyLineChartUrl));
    }
}
