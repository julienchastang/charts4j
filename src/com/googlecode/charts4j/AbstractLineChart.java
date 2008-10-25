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

import static com.googlecode.charts4j.Color.BLACK;

import com.googlecode.charts4j.collect.ImmutableList;
import com.googlecode.charts4j.collect.Lists;
import com.googlecode.charts4j.parameters.FillAreaType;

/**
 * Common code for line charts exists here.
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 *
 */
abstract class AbstractLineChart extends AbstractMarkableChart {

    /** The collection of lines to be plotted by the AbstractLineChart. **/
    private final ImmutableList<Plot> lines;

    /**
     * AbstractLineChart constructor.
     *
     * @param lines
     *            collection of lines to be plotted by the AbstractLineChart.
     *            This mutable list is defensively copied upon entry.
     *
     */
    AbstractLineChart(final ImmutableList<? extends Plot> lines) {
        super();
        this.lines = Lists.copyOf(lines);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void prepareData() {
        super.prepareData();

        // Logic to make sure things stay in step.
        boolean hasLegend = false;
        boolean hasColor = false;

        // Logic to make sure things stay in step continued.
        for (Plot p : lines) {
            final PlotImpl plot = (PlotImpl) p;
            hasLegend |= (plot.getLegend() != null);
            hasColor |= (plot.getColor() != null);
        }

        // Logic to make sure things stay in step continued.
        int lineCount = 0;
        for (Plot p : lines) {
            final PlotImpl line = (PlotImpl) p;
            if (hasLegend) {
                parameterManager.addLegend(line.getLegend() != null ? line.getLegend() : " ");
            }
            if (hasColor) {
                parameterManager.addColor(line.getColor() != null ? line.getColor() : BLACK);
            }
            final ImmutableList<ShapeMarker> shapeMarkers = line.getShapeMarkers();
            for (ShapeMarker sm : shapeMarkers) {
                parameterManager.addShapeMarkers(sm, lineCount);
            }
            final ImmutableList<MarkerPoint> markerPoint = line.getMarkerPoints();
            for (MarkerPoint mp : markerPoint) {
                parameterManager.addMarker(mp.getMarker(), lineCount, mp.getIndex());
            }
            if (line.getFillAreaColor() != null) {
                parameterManager.addFillAreaMarker(FillAreaType.FULL, line.getFillAreaColor(), lineCount, 0);
            }
            lineCount++;
        }
    }

    /**
     * Get an ImmutableList of lines for this chart.
     *
     * @return The immutable list of lines to be plotted by the
     *         AbstractLineChart.
     */
    protected final ImmutableList<Plot> getLines() {
        return Lists.copyOf(lines);
    }
}
