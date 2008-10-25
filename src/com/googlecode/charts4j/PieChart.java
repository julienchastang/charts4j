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

import com.googlecode.charts4j.collect.ImmutableList;
import com.googlecode.charts4j.collect.Lists;
import com.googlecode.charts4j.parameters.ChartType;

/**
 * Pie chart constructed with the {@link GCharts} static factory class.
 *
 * If the number of colors specified in the {@link Slice} objects is less than
 * the number of slices, then colors are interpolated. If no colors are
 * specified, pie segment colors are interpolated from dark orange to pale
 * yellow.
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 *
 * @see Slice
 * @see GCharts
 */
public class PieChart extends AbstractGChart implements TitledChart {
    /** Pie chart title. **/
    private ChartTitle                 chartTitle;

    /** Is this a 3D pie chart. **/
    private boolean                    threeD = false;

    /** An immutable list of slices for this pie.  **/
    private final ImmutableList<Slice> slices;

    /**
     * Create a pie chart with the given slices.
     *
     * @param slices
     *            list of data slices of the pie chart.
     *
     * @see Slice
     */
    PieChart(final ImmutableList<? extends Slice> slices) {
        super();
        this.slices = Lists.copyOf(slices);
    }

    /**
     * Is this a 3D chart.
     *
     * @return the threeD
     */
    public final boolean isThreeD() {
        return threeD;
    }

    /**
     * If you want the chart to be 3D, set to true.
     *
     * @param threeD
     *            boolean to determine if pie chart is rendered in 3D.
     */
    public final void setThreeD(final boolean threeD) {
        this.threeD = threeD;
    }

    /**
     * {@inheritDoc}
     */
    public final void setTitle(final String title) {
        checkNotNull(title, "The title cannot be null.");
        this.chartTitle = new ChartTitle(title);
    }

    /**
     * {@inheritDoc}
     */
    public final void setTitle(final String title, final Color color, final int fontSize) {
        checkNotNull(title, "The title cannot be null.");
        checkNotNull(color, "The color cannot be null.");
        checkArgument(fontSize > 0, "fontSize must be greater > 0.");
        this.chartTitle = new ChartTitle(title, color, fontSize);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void prepareData() {
        super.prepareData();
        final double[] d = new double[slices.size()];
        int i = 0;
        for (Slice slice : slices) {
            d[i++] = slice.getPercentage();
            parameterManager.addPieChartAndGoogleOMeterLegend(slice.getLabel() != null ? slice.getLabel() : "");
            if (slice.getColor() != null) {
                parameterManager.addColor(slice.getColor());
            }
        }
        parameterManager.addData(Data.newData(d));
        if (threeD) {
            parameterManager.setChartTypeParameter(ChartType.THREE_D_PIE_CHART);
        } else {
            parameterManager.setChartTypeParameter(ChartType.PIE_CHART);
        }
        if (chartTitle != null) {
            parameterManager.setChartTitleParameter(chartTitle.getTitle());
        }
        if (chartTitle != null && chartTitle.getColor() != null) {
            parameterManager.setChartTitleColorAndSizeParameter(chartTitle.getColor(), chartTitle.getFontSize());
        }
    }
}
