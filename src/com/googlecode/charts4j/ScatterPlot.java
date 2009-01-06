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

import java.util.List;

import com.googlecode.charts4j.parameters.ChartType;

/**
 * Scatter plot constructed with the {@link GCharts} static factory class.
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 *
 * @see ScatterPlotData
 * @see GCharts
 */
public class ScatterPlot extends AbstractMarkableChart {

    /** Scatter plot data to be rendered. **/
    private final Plot sPlotData;

    /**
     * @see GCharts#newScatterPlot(ScatterPlotData)
     */
    ScatterPlot(final Plot scatterPlotData) {
        super();
        this.sPlotData = scatterPlotData;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void prepareData() {
        super.prepareData();
        final PlotImpl scatterPlotData = (PlotImpl) sPlotData;
        parameterManager.addData(scatterPlotData.getXData());
        parameterManager.addData(scatterPlotData.getYData());
        if (scatterPlotData.getPointSizes() != null && scatterPlotData.getPointSizes().getSize() > 0) {
            parameterManager.addData(scatterPlotData.getPointSizes());
        }
        if (scatterPlotData.getColor() != null) {
            parameterManager.addColor(scatterPlotData.getColor());
        }
        if (scatterPlotData.getLegend() != null) {
            parameterManager.addLegend(scatterPlotData.getLegend());
        }
        final List<Marker> markers = scatterPlotData.getMarkers();
        for (Marker m : markers) {
            parameterManager.addMarkers(m, 0);
        }
        if (markers.isEmpty()) {
            final Color color = (scatterPlotData.getColor() != null) ? scatterPlotData.getColor() : Color.BLACK;
            parameterManager.addMarker(new ShapeMarker(Shape.CIRCLE, color, 10), 0, 0, 1, 1);
        }
        final List<MarkedPoints> markedPointsList = scatterPlotData.getMarkedPointsList();
        for (MarkedPoints mp : markedPointsList) {
            parameterManager.addMarker(mp.getMarker(), 0, mp.getStartIndex(), mp.getEndIndex(), mp.getN());
        }
        parameterManager.setChartTypeParameter(ChartType.SCATTER_CHART);
    }
}
