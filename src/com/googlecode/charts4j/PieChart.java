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
public class PieChart extends AbstractGraphChart {
    
    /** Is this a 3D pie chart. */
    private boolean                    threeD = false;

    /** An immutable list of slices for this pie.  */
    private final ImmutableList<Slice> slices;
        
    /** The pie chart orientation radians.  */
    private double orientation = Double.NaN;

    /**
     * Set the pie chart orientation in radians. Positive values will rotate the
     * chart clockwise.
     * 
     * @param radians
     *            the orientation to set in radians
     */
    public void setOrientation(final double radians) {
        this.orientation = radians;
    }

    /**
     * Create a pie chart with the given slices. If slices do not add up to 100,
     * slices will be proportional to the total of all slices.
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
    @Override
    protected void prepareData() {
        super.prepareData();
        final double[] d = new double[slices.size()];
        int i = 0;
        boolean hasLegend = false;
        double sum = 0;
        for (Slice slice : slices) {
            if (slice.getLegend() != null ){
                hasLegend |= true;
            }
            sum += slice.getPercentage();
        }
        
        for (Slice slice : slices) {
            d[i++] = (slice.getPercentage()/sum)*100;
            parameterManager.addPieChartAndGoogleOMeterLegend(slice.getLabel() != null ? slice.getLabel() : "");
            if (hasLegend)
                parameterManager.addLegend(slice.getLegend() != null ? slice.getLegend() : "");
            if (slice.getColor() != null) {
                parameterManager.addColor(slice.getColor());
            }
        }
        if (!Double.isNaN(orientation)) {
            parameterManager.addPieChartOrientation(orientation);
        }
        parameterManager.addData(Data.newData(d));
        parameterManager.setChartTypeParameter(threeD ? ChartType.THREE_D_PIE_CHART : ChartType.PIE_CHART);
    }
}
