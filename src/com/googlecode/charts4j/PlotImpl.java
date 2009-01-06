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
 * Plot implementation class. This class must always remain package private. It
 * is constructed via the {@link Plots} static factory class.
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 *
 */
final class PlotImpl implements BarChartPlot, Line, RadarPlot, ScatterPlotData, XYLine {

    /** X data series for this plot. **/
    private final Data               xData;

    /** Y data series for this plot. **/
    private final Data               yData;

    /** List of marked points for this plot. **/
    private final List<MarkedPoints> markedPointsList = Lists.newLinkedList();

    /** List of markers to be added to all point on this plot. **/
    private final List<Marker> markers = Lists.newLinkedList();

    /** Color of this plot. **/
    private Color                    color;

    /** Legend for this plot. **/
    private String                   legend;

    /** Point sizes for this scatter plot. **/
    private Data                     pointSizes;

    /** Fill area color for this plot. **/
    private Color                    fillAreaColor;

    /** Zero line if this is a bar chart. */
    private double                   zeroLine = Data.MIN_VALUE;

    /** Dataline for this bar chart. */
    private DataLine                 dataLine;

    /** The line style for this plot. */
    private LineStyle                lineStyle;

    /** The priority for this plot. **/
    private Priority                 priority;

    /**
     * Construct a plot with x and y data.
     *
     * @param xdata
     *            x data series
     * @param ydata
     *            y data series
     */
    PlotImpl(final Data xdata, final Data ydata) {
        this.xData = xdata;
        this.yData = ydata;
    }

    /**
     * Construct a plot with y data. Y data is evenly spread on x axis.
     *
     * @param data
     *            y data series
     */
    PlotImpl(final Data data) {
        this.yData = data;
        //Below, the * / 100 is to prevent ill-conditioned math.
        int inc = 0;
        if (data.getSize() > 1) {
            inc = ((int)Data.MAX_VALUE) * 100 / (data.getSize() - 1);
        }
        final List<Number> xVals = Lists.newLinkedList();
        double x = Data.MIN_VALUE;
        for (int i = (int) Data.MIN_VALUE; i < data.getSize(); i++) {
            xVals.add(x / 100);
            x = x + inc;
        }
        this.xData = Data.newData(xVals);
    }

    /**
     * Copy constructor.
     *
     * @param plotImpl
     *            object to be copied.
     */
    PlotImpl(final PlotImpl plotImpl) {
        xData = plotImpl.xData;
        yData = plotImpl.yData;
        markedPointsList.addAll(plotImpl.markedPointsList);
        markers.addAll(plotImpl.markers);
        color = plotImpl.color;
        legend = plotImpl.legend;
        pointSizes = plotImpl.pointSizes;
        fillAreaColor = plotImpl.fillAreaColor;
        zeroLine = plotImpl.zeroLine;
        dataLine = plotImpl.dataLine;
        lineStyle = plotImpl.lineStyle;
        priority = plotImpl.priority;
    }

    /**
     * Get the Y series data.
     *
     * @return the y series data.
     */
    Data getData() {
        return yData;
    }

    /**
     * Get the X series data.
     *
     * @return the x series data.
     */
    Data getXData() {
        return xData;
    }

    /**
     * Get the Y series data.
     *
     * @return the y series data.
     */
    Data getYData() {
        return yData;
    }

    /**
     * Get the legend for this plot.
     *
     *
     * @return the legend as a string.
     */
    String getLegend() {
        return legend;
    }

    /**
     * {@inheritDoc}
     */
    public void setLegend(final String legend) {
        checkNotNull(legend, "legend cannot be null");
        this.legend = legend;
    }

    /**
     * Get the color of this plot.
     *
     * @return the color of this plot. Could return null.
     */
    Color getColor() {
        return color;
    }

    /**
     * {@inheritDoc}
     */
    public void setColor(final Color color) {
        checkNotNull(color, "color cannot be null");
        this.color = color;
    }

    /**
     * Get the fill area color for this plot.
     *
     * @return the fill area for this plot. Could be null.
     */
    Color getFillAreaColor() {
        return fillAreaColor;
    }

    /**
     * {@inheritDoc}
     */
    public void setFillAreaColor(final Color color) {
        checkNotNull(color, "color cannot be null");
        this.fillAreaColor = color;
    }

    /**
     * Get the list of marked points for this plot.
     *
     * @return an immutable list of marked points.
     */
    ImmutableList<MarkedPoints> getMarkedPointsList() {
        return Lists.copyOf(markedPointsList);
    }

    /**
     * Get the list of markers for this plot.
     *
     * @return an immutable list of markers.
     */
    ImmutableList<Marker> getMarkers() {
        return Lists.copyOf(markers);
    }

    /**
     * {@inheritDoc}
     */
    public void addShapeMarker(final Shape shape, final Color color, final int size, final int index) {
        checkNotNull(shape, "shape cannot be null");
        checkNotNull(color, "color cannot be null");
        checkArgument(index >= 0, "index must be >= 0");
        checkArgument(index < yData.getSize(), "index is out of bounds");
        markedPointsList.add(new MarkedPoints(Markers.newShapeMarker(shape, color, size), index));
    }

    /**
     * {@inheritDoc}
     */
    public void addTextMarker(final String text, final Color color, final int size, final int index) {
        checkNotNull(text, "text cannot be null");
        checkNotNull(color, "color cannot be null");
        checkArgument(index >= 0, "index must be >= 0");
        checkArgument(index < yData.getSize(), "index is out of bounds");
        markedPointsList.add(new MarkedPoints(Markers.newTextMarker(text, color, size), index));
    }

    /**
     * {@inheritDoc}
     */
    public void addShapeMarkers(final Shape shape, final Color color, final int size) {
        checkNotNull(shape, "shape cannot be null");
        checkNotNull(color, "color cannot be null");
        markers.add(Markers.newShapeMarker(shape, color, size));
    }

    /**
     * {@inheritDoc}
     */
    public void addMarker(final Marker marker, final int index) {
        checkNotNull(marker, "marker cannot be null");
        checkArgument(index >= 0, "index must be >= 0");
        markedPointsList.add(new MarkedPoints(marker, index));
    }
    
    /**
     * {@inheritDoc}
     */
    public void addMarkers(final Marker marker) {
        checkNotNull(marker, "marker cannot be null");
        markers.add(marker);
    }

    /**
     * {@inheritDoc}
     */
    public void addMarkers(final Marker marker, final int startIndex, final int endIndex, final int n) {
        checkNotNull(marker, "marker cannot be null");
        checkArgument(startIndex >= 0, "start index must be >= 0");
        checkArgument(endIndex > 0, "end index must be > 0");
        checkArgument(endIndex > startIndex, "end index must be > start index");
        checkArgument(n > 0, "n must be > 0");
        markedPointsList.add(new MarkedPoints(marker, startIndex, endIndex, n));
    }

    /**
     * {@inheritDoc}
     */
    public void addMarkers(final Marker marker, final int n) {
        addMarkers(marker, 0, yData.getSize(), n);
    }
    
    /**
     * {@inheritDoc}
     */
    public void addMarkers(final Marker marker, final int startIndex, final int endIndex) {
        addMarkers(marker, startIndex, endIndex, 1);
    }

    /**
     * {@inheritDoc}
     */
    public void setDataLine(final int dataLineSize, final Color color, final Priority priority) {
        checkNotNull(color, "color cannot be null");
        checkNotNull(priority, "priority cannot be null");
        checkArgument(dataLineSize >= 0, "data line size must be >= 0");
        dataLine = new DataLine(dataLineSize, color, priority);
    }

    /**
     * Get the data line for bar charts.
     *
     * @return the data line for bar charts.
     */
    DataLine getDataLine() {
        return dataLine;
    }

    /**
     * Get the zero line for bar charts.
     *
     * @return the zero line for bar charts.
     */
    double getZeroLine() {
        return zeroLine;
    }

    /**
     * {@inheritDoc}
     */
    public void setZeroLine(final double zeroLine) {
        checkArgument(zeroLine >= Data.MIN_VALUE && zeroLine <= Data.MAX_VALUE, "Zero line must be between " + Data.MIN_VALUE + " and " + Data.MAX_VALUE);
        this.zeroLine = zeroLine;
    }

    /**
     * {@inheritDoc}
     */
    public void setPriority(final Priority priority) {
        checkNotNull(priority, "priority cannot be null");
        this.priority = priority;
    }

    /**
     * {@inheritDoc}
     */
    public void setLineStyle(final LineStyle lineStyle) {
        checkNotNull(lineStyle, "line style cannot be null");
        this.lineStyle = lineStyle;
    }

    /**
     * Get the line style for this plot.
     *
     * @return the line style for this plot.
     */
    LineStyle getLineStyle() {
        return lineStyle;
    }

    /**
     * {@inheritDoc}
     */
    public void setPointSizes(final Data pointSizes) {
        checkNotNull(pointSizes, "point sizes cannot be null");
        this.pointSizes = pointSizes;
    }

    /**
     * Get the point sizes for scatter plots.
     *
     * @return the point sizes for scatter plots.
     */
    Data getPointSizes() {
        return pointSizes;
    }

    /**
     * Get the priority for this plot.
     *
     * @return the priority for this plot
     */
    Priority getPriority() {
        return priority;
    }
}
