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

import static com.googlecode.charts4j.collect.Preconditions.*;

import java.util.List;

import com.googlecode.charts4j.collect.ImmutableList;
import com.googlecode.charts4j.collect.Lists;

/**
 * Static factory class for {@link Plot} hierarchy. The plots can then be
 * rendered by a {@link GChart}.
 *
 * @see GChart
 * @see GCharts
 * @see Data
 * @see DataUtil
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 *
 */
public final class Plots {

    /**
     * Static factory class can never be instantiated.
     */
    private Plots() {
        throw new AssertionError();
    }

    /**
     * Define a bar chart plot. This data will be rendered by a {@link BarChart}.
     *
     * @param data
     *            Data for this bar chart plot. Cannot be null.
     * @see Data
     * @see DataUtil
     * @return a bar chart plot
     */
    public static BarChartPlot newBarChartPlot(final Data data) {
        checkNotNull(data, "data cannot be null.");
        return new PlotImpl(data);
    }

    /**
     * Define a bar chart plot. This data will be rendered by a {@link BarChart}.
     *
     * @param data
     *            Data for this bar chart plot. Cannot be null.
     * @param color
     *            Color for this bar chart plot. Cannot be null.
     *
     * @see Data
     * @see DataUtil
     * @return a bar chart plot
     */
    public static BarChartPlot newBarChartPlot(final Data data, final Color color) {
        checkNotNull(data, "data cannot be null.");
        checkNotNull(color, "color cannot be null.");
        final BarChartPlot plot = new PlotImpl(data);
        plot.setColor(color);
        return plot;
    }

    /**
     * Define a bar chart series. This data will be rendered by {@link BarChart}.
     *
     *
     * @param data
     *            Data for this bar chart plot. Cannot be null.
     * @param color
     *            Color for this bar chart plot. Cannot be null.
     * @param legend
     *            Legend for this bar chart plot. Cannot be null.
     * @see Data
     * @see DataUtil
     * @return a bar chart plot
     */
    public static BarChartPlot newBarChartPlot(final Data data, final Color color, final String legend) {
        checkNotNull(data, "data cannot be null.");
        checkNotNull(color, "color cannot be null.");
        checkNotNull(legend, "legend cannot be null.");
        final BarChartPlot plot = new PlotImpl(data);
        plot.setColor(color);
        plot.setLegend(legend);
        return plot;
    }

    /**
     * Create the scatter plot data.
     *
     * @param xData
     *            x data. Cannot be null.
     * @param yData
     *            y data. Cannot be null.
     * @see Data
     * @return a scatter plot plot
     */
    public static ScatterPlotData newScatterPlotData(final Data xData, final Data yData) {
        checkNotNull(xData, "x data cannot be null.");
        checkNotNull(yData, "y data cannot be null.");
        checkArgument(xData.getSize() == yData.getSize(), "x and y data do not have the same number of elements");
        return new PlotImpl(xData, yData);
    }

    /**
     * Create the scatter plot data. For the 3rd argument, specify the size of
     * the data points. The data in this argument defines the sizes of each
     * point specified in the x,y data (first and second argument). For the
     * points to be properly rendered according to desired sizes, the developer
     * must also specify shape marker(s) for each point via the
     * {@link Plot#addShapeMarkers(Shape, Color, int)} method.
     * <p>
     * The size at which the data point is rendered is a function the marker
     * size defined via the {@link Plot#addShapeMarkers(Shape, Color, int)}
     * method, and the values passed into this method in the pointSizes object.
     * For instance, if a point is defined (via the shape marker) with a size of
     * 20, then the element that corresponds to that point in the data series
     * will render proportionally to that marker definition. A value of 0 will
     * render at size 0, a value of 100 will render at size 20.
     *
     * @param xData
     *            x data. Cannot be null.
     * @param yData
     *            y data. Cannot be null.
     * @param pointSizes
     *            size of x,y data. Cannot be null.
     * @see Data
     * @return a scatter plot plot.
     */
    public static ScatterPlotData newScatterPlotData(final Data xData, final Data yData, final Data pointSizes) {
        checkNotNull(xData, "x data cannot be null.");
        checkNotNull(yData, "y data cannot be null.");
        checkNotNull(pointSizes, "pointSizes data cannot be null.");
        checkArgument(xData.getSize() == yData.getSize() && xData.getSize() == pointSizes.getSize(), "x, y, and pointSizes data do not have the same number of elements");
        final PlotImpl plotImpl = new PlotImpl(xData, yData);
        plotImpl.setPointSizes(pointSizes);
        return plotImpl;
    }

    /**
     * Define a line. This data will be rendered by a {@link LineChart}.
     *
     * @param data
     *            Data for this line. Cannot be null.
     * @see Data
     * @see DataUtil
     * @return line plot
     */
    public static Line newLine(final Data data) {
        checkNotNull(data, "data cannot be null.");
        return new PlotImpl(data);
    }

    /**
     * Define a line. This data will be rendered by a {@link LineChart}.
     *
     * @param data
     *            Data for this line. Cannot be null.
     * @param color
     *            Line color. Cannot be null.
     *
     * @see Data
     * @see DataUtil
     * @return line plot
     */
    public static Line newLine(final Data data, final Color color) {
        checkNotNull(data, "data cannot be null.");
        checkNotNull(color, "color cannot be null.");
        final Line line = new PlotImpl(data);
        line.setColor(color);
        return line;
    }

    /**
     * Define a line. This data will be rendered by a {@link LineChart}.
     *
     * @param data
     *            Data for this line. Cannot be null.
     * @param color
     *            Line color. Cannot be null.
     * @param legend
     *            Legend for this line. Cannot be null.
     * @see Data
     * @see DataUtil
     * @return line plot
     */
    public static Line newLine(final Data data, final Color color, final String legend) {
        checkNotNull(data, "data cannot be null.");
        checkNotNull(color, "color cannot be null.");
        checkNotNull(legend, "legend cannot be null.");
        final Line line = new PlotImpl(data);
        line.setColor(color);
        line.setLegend(legend);
        return line;
    }

    /**
     * Define a xy line. This data will be rendered by a {@link XYLineChart}.
     *
     * @param xData
     *            Data for this xy line.
     * @param yData
     *            Data for this xy line.
     * @see Data
     * @return xy line plot.
     */
    public static XYLine newXYLine(final Data xData, final Data yData) {
        checkNotNull(xData, "x data cannot be null.");
        checkNotNull(yData, "y data cannot be null.");
        checkArgument(xData.getSize() == yData.getSize(), "x and y data do not have the same number of elements");
        return new PlotImpl(xData, yData);
    }

    /**
     * Define a xy line. This data will be rendered by a {@link XYLineChart}.
     *
     * @param xData
     *            Data for this xy line. Cannot be null.
     * @param yData
     *            Data for this xy line. Cannot be null.
     * @param color
     *            XYLine color.  Cannot be null.
     *
     * @see Data
     * @see DataUtil
     * @return xy line plot
     */
    public static XYLine newXYLine(final Data xData, final Data yData, final Color color) {
        checkNotNull(xData, "x data cannot be null.");
        checkNotNull(yData, "y data cannot be null.");
        checkNotNull(color, "color cannot be null.");
        checkArgument(xData.getSize() == yData.getSize(), "x and y data do not have the same number of elements");
        final XYLine xyLine = new PlotImpl(xData, yData);
        xyLine.setColor(color);
        return xyLine;
    }

    /**
     * Define a xy line. This data will be rendered by a {@link XYLineChart}.
     *
     * @param xData
     *            Data for this xy line. Cannot be null.
     * @param yData
     *            Data for this xy line. Cannot be null.
     * @param color
     *            XYLine color. Cannot be null.
     * @param legend
     *            Legend for this xy line. Cannot be null.
     * @see Data
     * @see DataUtil
     * @return xy line plot
     */
    public static XYLine newXYLine(final Data xData, final Data yData, final Color color, final String legend) {
        checkNotNull(xData, "x data cannot be null.");
        checkNotNull(yData, "y data cannot be null.");
        checkNotNull(color, "color cannot be null.");
        checkNotNull(legend, "legend cannot be null.");
        checkArgument(xData.getSize() == yData.getSize(), "x and y data do not have the same number of elements");
        final XYLine xyLine = new PlotImpl(xData, yData);
        xyLine.setColor(color);
        xyLine.setLegend(legend);
        return xyLine;
    }

    /**
     * Define a radar plot. This data will be rendered by a {@link RadarPlot}.
     *
     * @param data
     *            Data for this radar plot. Cannot be null.
     * @see Data
     * @see DataUtil
     * @return radar plot
     */
    public static RadarPlot newRadarPlot(final Data data) {
        checkNotNull(data, "data cannot be null.");
        return new PlotImpl(data);
    }

    /**
     * Define a radar plot. This data will be rendered by a {@link RadarPlot}.
     *
     * @param data
     *            Data for this radar plot. Cannot be null.
     * @param color
     *            RadarPlot color. Cannot be null.
     *
     * @see Data
     * @see DataUtil
     * @return Radar plot
     */
    public static RadarPlot newRadarPlot(final Data data, final Color color) {
        checkNotNull(data, "data cannot be null.");
        checkNotNull(color, "color cannot be null.");
        final RadarPlot plot = new PlotImpl(data);
        plot.setColor(color);
        return plot;
    }

    /**
     * Define a radar plot. This data will be rendered by a {@link RadarPlot}.
     *
     * @param data
     *            Data for this radar plot. Cannot be null.
     * @param color
     *            RadarPlot color. Cannot be null.
     * @param legend
     *            Legend for this radar plot. Cannot be null.
     * @see Data
     * @see DataUtil
     * @return Radar plot.
     */
    public static RadarPlot newRadarPlot(final Data data, final Color color, final String legend) {
        checkNotNull(data, "data cannot be null.");
        checkNotNull(color, "color cannot be null.");
        checkNotNull(legend, "legend cannot be null.");
        final RadarPlot plot = new PlotImpl(data);
        plot.setColor(color);
        plot.setLegend(legend);
        return plot;
    }

    /**
     * Define a plot. This data will be rendered by a {@link LineChart}
     * {@link XYLineChart} {@link BarChart} {@link RadarPlot}.
     *
     * @param data
     *            Data for this plot. Cannot be null.
     * @see Data
     * @see DataUtil
     * @return plot
     */
    public static Plot newPlot(final Data data) {
        checkNotNull(data, "data cannot be null.");
        return new PlotImpl(data);
    }

    /**
     * Define a plot. This data will be rendered by a {@link LineChart}
     * {@link XYLineChart} {@link BarChart} {@link RadarPlot}.
     *
     * @param data
     *            Data for this plot. Cannot be null.
     * @param color
     *            Plot color. Cannot be null.
     *
     * @see Data
     * @see DataUtil
     * @return plot
     */
    public static Plot newPlot(final Data data, final Color color) {
        checkNotNull(data, "data cannot be null.");
        checkNotNull(color, "color cannot be null.");
        final PlotImpl plotImpl = new PlotImpl(data);
        plotImpl.setColor(color);
        return plotImpl;
    }

    /**
     * Define a plot. This data will be rendered by a {@link LineChart}
     * {@link XYLineChart} {@link BarChart} {@link RadarPlot}.
     *
     * @param data
     *            Data for this plot. Cannot be null.
     * @param color
     *            Plot color. Cannot be null.
     * @param legend
     *            Legend for this plot. Cannot be null.
     * @see Data
     * @see DataUtil
     * @return plot
     */
    public static Plot newPlot(final Data data, final Color color, final String legend) {
        checkNotNull(data, "data cannot be null.");
        checkNotNull(color, "color cannot be null.");
        checkNotNull(legend, "legend cannot be null.");
        final PlotImpl plotImpl = new PlotImpl(data);
        plotImpl.setColor(color);
        plotImpl.setLegend(legend);
        return plotImpl;
    }

    /**
     * Make a deep copy of a plot list.
     *
     * @param plots
     *            The list of plots to be copied.
     * @return An a new immutable list of plots.
     */
    static ImmutableList<Plot> copyOf(final List<? extends Plot> plots) {
        final List<Plot> plotList = Lists.newLinkedList();
        for (Plot p : plots) {
            plotList.add(p.klone());
        }
        return Lists.copyOf(plotList);
    }

    /**
     * Make a deep copy of a plot list.
     *
     * @param plots
     *            The list of plots to be copied.
     * @return An a new immutable list of plots.
     */
    static ImmutableList<Plot> copyOf(final Plot... plots) {
        return copyOf(Lists.of(plots));
    }
}
