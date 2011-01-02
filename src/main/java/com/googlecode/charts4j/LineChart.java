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
import com.googlecode.charts4j.collect.Lists;
import com.googlecode.charts4j.parameters.ChartType;

/**
 * Line chart constructed with the {@link GCharts} static factory class.
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 *
 * @see Line
 * @see GCharts
 */
public class LineChart extends AbstractLineChart {

    /** Lines to be rendered by this chart. **/
    private final ImmutableList<Plot> lines;

    /** Is this a sparkline chart? **/
    private boolean isSparkline = false;

    /**
     * @see GCharts#newLineChart(java.util.List)
     */
    LineChart(final ImmutableList<? extends Plot> lines) {
        super(lines);
        this.lines = Lists.copyOf(lines);
    }

    /**
     * A sparkline chart is exactly the same as a line chart except that the
     * axes lines are not drawn for sparklines. You can add axes labels if you
     * wish.
     *
     * @param isSparkline
     *            Defaults to false.
     */
    public final void setSparkline(final boolean isSparkline) {
        this.isSparkline = isSparkline;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void prepareData() {
        super.prepareData();
        for (Plot l : lines) {
            final PlotImpl line = (PlotImpl) l;
            parameterManager.addData(line.getData());
        }
        parameterManager.setChartTypeParameter(isSparkline ? ChartType.SPARKLINE_CHART : ChartType.LINE_CHART);
    }
}
