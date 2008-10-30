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

import com.googlecode.charts4j.collect.ImmutableList;
import com.googlecode.charts4j.collect.Lists;

/**
 * Type that contains code common to all axis labels.
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 * @see AxisStyle
 * @see AxisLabelsFactory
 */
class AxisLabelsImpl implements AxisLabels, RadialAxisLabels {

    /** Axis style for this axis.  **/
    private AxisStyle          axisStyle;

    /** Positions of axis labels. **/
    private final List<Number> positions = Lists.newLinkedList();

    /** Axis labels. **/
    private final List<String> labels    = Lists.newLinkedList();

    /** Numeric range of axis labels.  **/
    private Range              range;

    /**
     * @see AxisLabelsFactory#newNumericAxisLabels(double, double)
     */
    AxisLabelsImpl(final double minRange, final double maxRange) {
        this.range = new Range(minRange, maxRange);
    }

    /**
     * @see AxisLabelsFactory#newAxisLabels(List)
     */
    AxisLabelsImpl(final AxisLabelsImpl axisLabels) {
        this.positions.addAll(axisLabels.positions);
        this.labels.addAll(axisLabels.labels);
        this.axisStyle = axisLabels.getAxisStyle();
        this.range = axisLabels.range;

    }

    /**
     * @see AxisLabelsFactory#newAxisLabels(List, List)
     */
    AxisLabelsImpl(final List<? extends String> labels, final List<? extends Number> positions) {
        this.labels.addAll(labels);
        this.positions.addAll(positions);
    }

    /**
     * Get the axis style.
     *
     * @return the axis style
     */
    AxisStyle getAxisStyle() {
        return axisStyle;
    }

    /**
     *
     * {@inheritDoc}
     */
    public void setAxisStyle(final AxisStyle axisStyle) {
        this.axisStyle = axisStyle;
    }

    /**
     * {@inheritDoc}
     */
    public void setRadialAxisStyle(final Color color, final int fontSize) {
        this.axisStyle = AxisStyle.newAxisStyle(color, fontSize, AxisTextAlignment.CENTER);
    }

    /**
     * Get an immutable list of the labels for this axis.
     *
     * @return an immutable list of labels
     */
    ImmutableList<String> getLabels() {
        return Lists.copyOf(labels);
    }

    /**
     * Get an immutable list of the label positions for this axis.
     *
     * @return an immutable list of label positions.
     */
    ImmutableList<Number> getPositions() {
        return Lists.copyOf(positions);
    }

    /**
     * Get the axis numeric range.
     *
     * @return the axis numeric range
     */
    Range getRange() {
        return range;
    }

    /**
     * An inner class for encapsulating an axis range.
     */
    static final class Range {
        /** The minimum of the axis range. **/
        private final double min;

        /** The maximum of the axis range. **/
        private final double max;

        /**
         * Range constructor.
         *
         * @param min
         *            The minimum of the axis range
         * @param max
         *            The maximum of the axis range
         */
        Range(final double min, final double max) {
            this.min = min;
            this.max = max;
        }

        /**
         * Get the maximum of the axis range.
         *
         * @return the maximum of the axis range
         */
        double getMax() {
            return max;
        }

        /**
         * Get the minimum of the axis range.
         *
         * @return the minimum of the axis range
         */
        double getMin() {
            return min;
        }
    }
}
