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

package com.googlecode.charts4j;

import com.googlecode.charts4j.collect.ImmutableList;
import com.googlecode.charts4j.collect.Lists;
import com.googlecode.charts4j.parameters.ChartType;

/**
 * Private radar chart. Not part of API. See RadarChart for public API.
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 *
 * @see GCharts
 */
class PrivateRadarChart extends AbstractLineChart {

    /** Plots to be rendered by this chart.  **/
    private final ImmutableList<Plot> plots;

    /** Is this radar chart a splined chart.  **/
    private boolean isSpline = false;

    /**
     * @see GCharts#newRadarChart(java.util.List)
     */
    PrivateRadarChart(final ImmutableList<? extends Plot> plots) {
        super(plots);
        this.plots = Lists.copyOf(plots);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void prepareData() {
        super.prepareData();

        for (Plot p : plots) {
            final PlotImpl plot = (PlotImpl) p;
            parameterManager.addData(plot.getData());
        }
        parameterManager.setChartTypeParameter(isSpline ? ChartType.RADAR_SPLINE_CHART : ChartType.RADAR_CHART);
    }

    /**
     * @see RadarChart#setSpline(boolean)
     */
    void setSpline(final boolean isSpline) {
        this.isSpline = isSpline;
    }
}
