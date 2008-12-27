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

import com.googlecode.charts4j.collect.ImmutableList;

/**
 * Radar chart constructed with the {@link GCharts} static factory class.
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 *
 * @see RadarPlot
 * @see GCharts
 */
public final class RadarChart implements GChart, GraphChart, TitledChart, GridChart {

    /** This class simply forwards all calls to the PrivateRadarChart class. **/
    private final PrivateRadarChart radarChart;

    /**
     * @see GCharts#newRadarChart(java.util.List)
     */
    RadarChart(final ImmutableList<? extends Plot> plots) {
        radarChart = new PrivateRadarChart(plots);
    }

    /**
     * {@inheritDoc}
     */
    public String toURLForHTML() {
        return radarChart.toURLForHTML();
    }

    /**
     * {@inheritDoc}
     */
    public String toURLString() {
        return radarChart.toURLString();
    }

    /**
     * {@inheritDoc}
     */
    public void setAreaFill(final Fill fill) {
        radarChart.setAreaFill(fill);
    }

    /**
     * {@inheritDoc}
     */
    public void setBackgroundFill(final Fill fill) {
        radarChart.setBackgroundFill(fill);
    }

    /**
     * {@inheritDoc}
     */
    public void setTransparency(final int opacity) {
        radarChart.setTransparency(opacity);
    }

    /**
     * {@inheritDoc}
     */
    public void setSize(final int x, final int y) {
        radarChart.setSize(x, y);
    }

    /**
     * {@inheritDoc}
     */
    public void setTitle(final String title) {
        radarChart.setTitle(title);
    }

    /**
     * {@inheritDoc}
     */
    public void setTitle(final String title, final Color color, final int fontSize) {
        radarChart.setTitle(title, color, fontSize);
    }

    /**
     * {@inheritDoc}
     */
    public void setLegendPosition(final LegendPosition legendPosition) {
        radarChart.setLegendPosition(legendPosition);
    }

    /**
     * Add "spoke" labels to radar plot.
     *
     * @param radialAxisLabels
     *            Axis label information containing "spoke" labels.
     *
     * @see AxisLabelsFactory
     */
    public void addRadialAxisLabels(final RadialAxisLabels radialAxisLabels) {
        radarChart.addXAxisLabels((AxisLabels)radialAxisLabels);
    }

    /**
     * Add "bull's eye" labels to radar plot.
     *
     * @param axisLabels
     *            Axis label information containing "bull's eye" labels.
     *
     * @see AxisLabels
     */
    public void addConcentricAxisLabels(final AxisLabels axisLabels) {
        radarChart.addYAxisLabels(axisLabels);
    }

    /**
     * If true, points are connected with splines.
     *
     * @param isSpline
     *            Are the points connected by splines.
     */
    public void setSpline(final boolean isSpline) {
        radarChart.setSpline(isSpline);
    }

    /**
     * {@inheritDoc}
     */
    public void setGrid(final double xAxisStepSize, final double yAxisStepSize, final int lengthOfLineSegment, final int lengthOfBlankSegment) {
        radarChart.setGrid(xAxisStepSize, yAxisStepSize, lengthOfLineSegment, lengthOfBlankSegment);
    }

    /**
     * Add a radial axis range marker.
     *
     * @param startPoint
     *            the 0 position is at 12 o'clock, 50 is 6 o'clock, and 100 is at 12 o'clock.
     * @param endPoint
     *            the 0 position is at 12 o'clock, 50 is 6 o'clock, and 100 is at 12 o'clock.
     * @param color
     *            color of range marker. Cannot be null.
     */
    public final void addRadialAxisRangeMarker(final double startPoint, final double endPoint, final Color color) {
        radarChart.addRadialAxisRangeMarker(startPoint, endPoint, color);
    }

    /**
     * Add a concentric axis range marker.
     *
     * @param startPoint
     *            the 0 position is at the center of the radar chart and 100 is
     *            at the outside limit.
     * @param endPoint
     *            the 0 position is at the center of the radar chart and 100 is
     *            at the outside limit.
     * @param color
     *            color of range marker. Cannot be null.
     */
    public final void addConcentricAxisRangeMarker(final double startPoint, final double endPoint, final Color color) {
        radarChart.addHorizontalRangeMarker(startPoint, endPoint, color);
    }

    /**
     * {@inheritDoc}
     */
    public void setDataEncoding(final DataEncoding dataEncoding) {
        radarChart.setDataEncoding(dataEncoding);
    }
    
    /**
     * {@inheritDoc}
     */
    public void setMargins(final int leftMargin, final int rightMargin, final int topMargin, final int bottomMargin) {
        radarChart.setMargins(leftMargin, rightMargin, topMargin, bottomMargin);
    }

    /**
     * {@inheritDoc}
     */
    public void setLegendMargins(final int legendWidth, final int legendHeight) {
        radarChart.setLegendMargins(legendWidth, legendHeight);
    }
}
