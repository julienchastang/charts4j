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
import static com.googlecode.charts4j.collect.Preconditions.*;

import java.util.Arrays;
import java.util.List;

import com.googlecode.charts4j.collect.Lists;

/**
 * Static factory class for {@link GChart} hierarchy.
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 *
 */
public final class GCharts {

    /**
     * Static factory class can never be instantiated.
     */
    private GCharts() {
        throw new AssertionError();
    }

    /**
     * Create a {@link LineChart}. Supply this method with one or more
     * {@link Line}s to be rendered by this chart.
     *
     * @param plots
     *            Lines to be rendered in this line chart. Cannot be null or
     *            contain a null.
     * @return Line chart with the specified lines.
     *
     * @see Line
     * @see LineChart
     * @see Plots
     */
    public static LineChart newLineChart(final Line... plots) {
        checkNotNull(plots, "plots cannot be null or contain a null.");
        checkContentsNotNull(Arrays.asList(plots), "plots cannot be null or contain a null.");
        return new LineChart(Plots.copyOf(plots));
    }

    /**
     * Create a {@link LineChart}. Supply this method with one or more
     * {@link Plot}s to be rendered by this chart.
     *
     * @param plots
     *            Plots to be rendered in this line chart. Cannot be null or
     *            contain a null.
     * @return Line chart with the specified plots.
     *
     * @see Plot
     * @see LineChart
     * @see Plots
     */
    public static LineChart newLineChart(final Plot... plots) {
        checkNotNull(plots, "plots cannot be null or contain a null.");
        checkContentsNotNull(Arrays.asList(plots), "plots cannot be null or contain a null.");
        return newLineChart(Plots.copyOf(plots));
    }

    /**
     * Create a {@link LineChart}. Supply this method with one or more
     * {@link Plot}s to be rendered by this chart.
     *
     * @param plots
     *            Plots to be rendered in this line chart. Cannot be null or
     *            contain a null.
     * @return Line chart with the specified plots.
     *
     * @see Plot
     * @see LineChart
     * @see Plots
     */
    public static LineChart newLineChart(final List<? extends Plot> plots) {
        checkContentsNotNull(plots, "plots cannot be null or contain a null.");
        return new LineChart(Plots.copyOf(plots));
    }

    /**
     * Create a {@link RadarChart}. Supply this method with one or more
     * {@link RadarPlot}s to be rendered by this chart.
     *
     * @param plots
     *            Radar plots to be rendered in this radar chart. Cannot be null
     *            or contain a null.
     * @return Radar chart with the specified plots.
     *
     * @see RadarPlot
     * @see RadarChart
     * @see Plots
     */
    public static RadarChart newRadarChart(final RadarPlot... plots) {
        checkNotNull(plots, "plots cannot be null or contain a null.");
        checkContentsNotNull(Arrays.asList(plots), "plots cannot be null or contain a null.");
        return new RadarChart(Plots.copyOf(plots));
    }

    /**
     * Create a {@link RadarChart}. Supply this method with one or more
     * {@link Plot}s to be rendered by this chart.
     *
     * @param plots
     *            Radar plots to be rendered in this radar chart. Cannot be null
     *            or contain a null.
     * @return Radar chart with the specified plots.
     *
     * @see Plot
     * @see RadarChart
     * @see Plots
     */
    public static RadarChart newRadarChart(final Plot... plots) {
        checkNotNull(plots, "plots cannot be null or contain a null.");
        checkContentsNotNull(Arrays.asList(plots), "plots cannot be null or contain a null.");
        return newRadarChart(Plots.copyOf(plots));
    }

    /**
     * Create a {@link RadarChart}. Supply this method with one or more
     * {@link Plot}s to be rendered by this chart.
     *
     * @param plots
     *            Radar plots to be rendered in this radar chart. Cannot be null
     *            or contain a null.
     * @return Radar chart with the specified plots.
     *
     * @see Plot
     * @see RadarChart
     * @see Plots
     */
    public static RadarChart newRadarChart(final List<? extends Plot> plots) {
        checkContentsNotNull(plots, "plots cannot be null or contain a null.");
        return new RadarChart(Plots.copyOf(plots));
    }

    /**
     * Create a {@link BarChart}. Supply this method with one or more
     * {@link BarChartPlot}s to be rendered by this chart.
     *
     * @param plots
     *            Bar chart plots to be rendered in this bar chart. Cannot be
     *            null or contain null.
     * @return Bar chart with the specified plots.
     *
     * @see BarChartPlot
     * @see BarChart
     * @see Plots
     */
    public static BarChart newBarChart(final BarChartPlot... plots) {
        checkNotNull(plots, "plots cannot be null or contain a null.");
        checkContentsNotNull(Arrays.asList(plots), "plots cannot be null or contain a null.");
        return new BarChart(Plots.copyOf(plots));
    }

    /**
     * Create a {@link BarChart}. Supply this method with one or more
     * {@link Plot}s to be rendered by this chart.
     *
     * @param plots
     *            Plots to be rendered in this bar chart. Cannot be null or contain a null.
     * @return Bar chart with the specified plots.
     *
     * @see Plot
     * @see BarChart
     * @see Plots
     */
    public static BarChart newBarChart(final Plot... plots) {
        checkNotNull(plots, "plots cannot be null or contain a null.");
        checkContentsNotNull(Arrays.asList(plots), "plots cannot be null or contain a null.");
        return newBarChart(Plots.copyOf(plots));
    }

    /**
     * Create a {@link BarChart}. Supply this method with one or more
     * {@link Plot}s to be rendered by this chart.
     *
     * @param plots
     *            Plots to be rendered in this bar chart. Cannot be null or
     *            contain a null.
     * @return Bar chart with the specified plots.
     *
     * @see Plot
     * @see BarChart
     * @see Plots
     */
    public static BarChart newBarChart(final List<? extends Plot> plots) {
        checkContentsNotNull(plots, "plots cannot be null or contain a null.");
        return new BarChart(Plots.copyOf(plots));
    }

    /**
     * Create a {@link XYLineChart} with the given XYLines.
     *
     * @param plots
     *            XYLines to be rendered in this line chart. Cannot be null or
     *            contain a null.
     * @return XYLine chart
     *
     * @see XYLine
     * @see Plots
     * @see XYLineChart
     */
    public static XYLineChart newXYLineChart(final XYLine... plots) {
        checkNotNull(plots, "plots cannot be null or contain a null.");
        checkContentsNotNull(Arrays.asList(plots), "plots cannot be null or contain a null.");
        return new XYLineChart(Plots.copyOf(plots));
    }

    /**
     * Create a {@link XYLineChart} with the given plots.
     *
     * @param plots
     *            Plots to be rendered in this line chart. Cannot be null or
     *            contain a null.
     * @return XYLine chart
     *
     * @see XYLine
     * @see Plot
     * @see Plots
     * @see XYLineChart
     */
    public static XYLineChart newXYLineChart(final Plot... plots) {
        checkNotNull(plots, "plots cannot be null or contain a null.");
        checkContentsNotNull(Arrays.asList(plots), "plots cannot be null or contain a null.");
        return newXYLineChart(Plots.copyOf(plots));
    }

    /**
     * Create a {@link XYLineChart} with the given plots.
     *
     * @param plots
     *            Plots to be rendered in this line chart. Cannot be null or
     *            contain a null.
     * @return XYLine chart
     *
     * @see XYLine
     * @see Plot
     * @see Plots
     * @see XYLineChart
     */
    public static XYLineChart newXYLineChart(final List<? extends Plot> plots) {
        checkContentsNotNull(plots, "plots cannot be null or contain a null.");
        return new XYLineChart(Plots.copyOf(plots));
    }

    /**
     * Create a {@link ScatterPlot} with the given scatter plot data.
     *
     * @param scatterPlotData
     *            Scatter plot data to be rendered in this scatter plot. Cannot
     *            be null.
     * @return Scatter plot
     *
     * @see ScatterPlotData
     * @see ScatterPlot
     */
    public static ScatterPlot newScatterPlot(final ScatterPlotData scatterPlotData) {
        checkNotNull(scatterPlotData);
        return new ScatterPlot(scatterPlotData);
    }

    /**
     * Create a {@link ScatterPlot}.
     *
     * @param scatterPlotData
     *            Scatter plot data to be rendered in this scatter plot. Cannot be null.
     * @return Scatter plot.
     *
     * @see ScatterPlotData
     * @see ScatterPlot
     */
    public static ScatterPlot newScatterPlot(final Plot scatterPlotData) {
        checkNotNull(scatterPlotData, "scatterPlotData cannot be null");
        return new ScatterPlot(scatterPlotData);
    }

    /**
     * Create a {@link PieChart} with the given pie slices.
     *
     * @param slices
     *            Slices of the pie chart. Cannot be null or
     *            contain a null.
     *
     * @return Pie Chart
     *
     * @see Slice
     * @see PieChart
     */
    public static PieChart newPieChart(final Slice... slices) {
        // TODO: Might want to warn to user about % not adding up to 100.
        checkNotNull(slices, "slices cannot be null or contain a null.");
        checkContentsNotNull(Arrays.asList(slices), "slices cannot be null or contain a null.");
        return newPieChart(Lists.of(slices));
    }

    /**
     * Create a {@link PieChart} with the given pie slices.
     *
     * @param slices
     *            Slices of the pie chart. Cannot be null or
     *            contain a null.
     *
     * @return Pie chart.
     *
     * @see Slice
     * @see PieChart
     */
    public static PieChart newPieChart(final List<? extends Slice> slices) {
        checkContentsNotNull(slices, "slices cannot be null or contain a null.");
        return new PieChart(Lists.copyOf(slices));
    }

    /**
     * Create a Venn Diagram. Please specify all parameters between 0 and 100.
     *
     * @param circle1Size
     *            the first three values specify the relative sizes of three
     *            circles, A, B, and C
     * @param circle2Size
     *            the first three values specify the relative sizes of three
     *            circles, A, B, and C
     * @param circle3Size
     *            the first three values specify the relative sizes of three
     *            circles, A, B, and C
     * @param abIntersect
     *            the fourth value specifies the area of A intersecting B
     * @param bcIntersect
     *            the fifth value specifies the area of B intersecting C
     * @param caIntersect
     *            the sixth value specifies the area of C intersecting A
     * @param abcIntersect
     *            the seventh value specifies the area of A intersecting B
     *            intersecting C
     * @return a VennDiagram
     */
    public static VennDiagram newVennDiagram(final double circle1Size, final double circle2Size, final double circle3Size, final double abIntersect, final double bcIntersect, final double caIntersect, final double abcIntersect) {
        return new VennDiagram(circle1Size, circle2Size, circle3Size, abIntersect, bcIntersect, caIntersect, abcIntersect);
    }

    /**
     * Create a {@link GoogleOMeter}.
     *
     * @param data
     *            A number between 0 and 100.
     * @return a GoogleOMeter
     */
    public static GoogleOMeter newGoogleOMeter(final double data) {
        return newGoogleOMeter(data, null, null, Lists.<Color>of());
    }
    
    /**
     * Create a {@link GoogleOMeter}.
     *
     * @param data
     *            A number between 0 and 100.
     * @param label
     *            Label that will appear at the top of the arrow.
     * @return a GoogleOMeter
     */
    public static GoogleOMeter newGoogleOMeter(final double data,final String label) {
        return newGoogleOMeter(data, label, null, Lists.<Color>of());
    }

    /**
     * Use {@link #newGoogleOMeter(double, String, String, Color...)} instead.
     */
    @Deprecated //Since 1.1 Going away in future release.
    public static GoogleOMeter newGoogleOMeter(final double data, final String label, final Color... colors) {
        return newGoogleOMeter(data, label, null, Lists.of(colors));
    }

    /**
     * Use {@link #newGoogleOMeter(double, String, String, List)} instead.
     */
    @Deprecated  //Since 1.1 Going away in future release.
    public static GoogleOMeter newGoogleOMeter(final double data, final String label, final List<? extends Color> colors) {
        return newGoogleOMeter(data, label, null, colors);
    }
    
    /**
     * @see GCharts#newGoogleOMeter(double, String, String, List)
     */
    public static GoogleOMeter newGoogleOMeter(final double data, final String label, final String legend, final Color... colors) {
        return newGoogleOMeter(data, label, legend, Lists.of(colors));
    }
    
    /**
     * Create a {@link GoogleOMeter}.
     *
     * @param data
     *            A number between 0 and 100.
     * @param label
     *            Label that will appear at the top of the arrow. If null, will
     *            not be displayed.
     * @param legend
     *            Legend that will appear to the right of the Google-O-Meter. If
     *            null, will not be displayed.
     * @param colors
     *            Must provide at least two color. Colors will be interpolated
     *            between colors provided. Must supply at least two colors.
     *            Cannot be null.
     * @return a GoogleOMeter
     */
    public static GoogleOMeter newGoogleOMeter(final double data, final String label, final String legend, final List<? extends Color> colors) {
        return new GoogleOMeter(data, label, legend, colors == null ? Lists.<Color>of() : colors);
    }

    /**
     * Create a map chart with a {@link GeographicalArea}.
     *
     * @param geographicalArea
     *            Pass in the {@link GeographicalArea}. Cannot be null.
     *
     * @see GeographicalArea
     * @return a MapChart
     */
    public static MapChart newMapChart(final GeographicalArea geographicalArea) {
        checkNotNull(geographicalArea, "geographicalArea cannot be null");
        final MapChart mapChart = new MapChart(geographicalArea);
        mapChart.setSize(MapChart.DEFAULT_WIDTH, MapChart.DEFAULT_HEIGHT);
        mapChart.setColorGradient(WHITE, BEIGE, FORESTGREEN);
        return mapChart;
    }
}
