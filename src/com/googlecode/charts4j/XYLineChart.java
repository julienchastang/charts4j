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

import java.util.Set;

import com.googlecode.charts4j.collect.ImmutableList;
import com.googlecode.charts4j.collect.Lists;
import com.googlecode.charts4j.collect.Sets;
import com.googlecode.charts4j.parameters.ChartType;

/**
 * XY Line chart constructed with the {@link GCharts} static factory class.
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 *
 * @see XYLine
 * @see GCharts
 */
public class XYLineChart extends AbstractLineChart {

    /** List of lines to be ploted this chart. **/
    private final ImmutableList<Plot> xylines;

    /**
     * Create a XY line chart.
     *
     * @param xylines
     *            xy lines to be rendered by this chart
     * @see XYLine
     */
    XYLineChart(final ImmutableList<? extends Plot> xylines) {
        super(xylines);
        this.xylines = Lists.copyOf(xylines);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void prepareData() {
        super.prepareData();
        for (Plot xyl : xylines) {
            final PlotImpl xyline = (PlotImpl) xyl;
            final PlotImpl xy = removeDuplicatePoints(xyline);
            parameterManager.addData(xy.getXData());
            parameterManager.addData(xy.getYData());
        }
        parameterManager.setChartTypeParameter(ChartType.XY_LINE_CHART);
    }

    /**
     * Method that purges duplicate points.
     *
     * @param xyline
     *            plot that will be purged of duplicate lines.
     * @return plot purged of duplicates
     */
    private PlotImpl removeDuplicatePoints(final PlotImpl xyline) {
        final double[] xData = xyline.getXData().getData();
        final double[] yData = xyline.getYData().getData();

        if (xData.length != yData.length) {
            return xyline;
        }

        // Removing duplicates. Can assume xData and yData are the same length.
        final Set<XYPoint> set = Sets.newLinkedHashSet();
        for (int i = 0; i < xData.length; i++) {
            set.add(new XYPoint(xData[i], yData[i]));
        }

        final double[] x = new double[set.size()];
        final double[] y = new double[set.size()];

        int i = 0;
        for (XYPoint point : set) {
            x[i] = point.x;
            y[i] = point.y;
            i++;
        }
        return new PlotImpl(Data.newData(x), Data.newData(y));
    }

    /**
     * XY point.
     *
     * @author Julien Chastang (julien.c.chastang at gmail dot com)
     */
    private static final class XYPoint {
        /** X.  **/
        private final double x;

        /** Y.  **/
        private final double y;

        /**
         * Construct an XY point.
         *
         * @param x x
         * @param y y
         */
        private XYPoint(final double x, final double y) {
            super();
            this.x = x;
            this.y = y;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean equals(final Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof XYPoint)) {
                return false;
            }
            final XYPoint objA = (XYPoint) obj;
            return (this.x == objA.x) && (this.y == objA.y);
        }

        /**
         *
         * {@inheritDoc}
         */
        @Override
        public int hashCode() {
            int hash = 1;
            hash = hash * 31 + Double.valueOf(x).hashCode();
            hash = hash * 31 + Double.valueOf(y).hashCode();
            return hash;
        }
    }
}
