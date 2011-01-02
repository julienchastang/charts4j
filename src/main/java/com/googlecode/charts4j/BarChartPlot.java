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

import static com.googlecode.charts4j.collect.Preconditions.*;

/**
 * Encapsulates data and plot decorations that will be rendered in a
 * {@link BarChart}. Construct with {@link Plots} static factory class.
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 *
 * @see Data
 * @see DataUtil
 * @see BarChart
 */
public interface BarChartPlot extends Curve {

    /**
     * Add a data line on top of the bar chart and specify the color and
     * {@link Priority} of that line.
     *
     * @param dataLineSize
     *            The line thickness for this data line. Must be > 0.
     *
     * @param color
     *            The color of this data line. Cannot be null.
     *
     * @param priority
     *            The priority of this data line. Cannot be null.
     */
    void setDataLine(final int dataLineSize, final Color color, final Priority priority);

    /**
     * Set the bar chart zero line for this plot. Number must be between
     * {@link Data#MIN_VALUE} and {@link Data#MAX_VALUE} corresponding to the
     * same numeric data range in the {@link Data} class.
     *
     * @param zeroLine
     *            the zeroLine to set between {@link Data#MIN_VALUE} and
     *            {@link Data#MAX_VALUE}
     * @see Data
     * @see DataUtil
     */
    void setZeroLine(final double zeroLine);

    /**
     * Sets the color on an individual bar at a given index.
     *
     * @param color
     *            the color of the bar
     * @param index
     *            the index of the bar that will be colored. Must be >= 0 and
     *            cannot be out of bounds with respect to the dataset.
     */
    void setColor(final Color color, final int index);

    /**
     * Type for specifying a dataline sitting on top of the bar chart.
     *
     * @author Julien Chastang (julien.c.chastang at gmail dot com)
     *
     * @see BarChart
     */
    static class  DataLine {

        /** Size thickness of data line.**/
        private final int size;

        /** Color of data line.**/
        private final Color color;

        /** Priority of data line.**/
        private final Priority priority;

        /**
         * Construct a dataline.
         *
         * @param size
         *            Size thickness of data line. Must be > 0.
         * @param color
         *            Color of data line. Cannot be null.
         * @param priority
         *            Priority of data line. Cannot be null.
         */
        DataLine(final int size, final Color color, final Priority priority) {
            checkArgument(size > 0);
            checkNotNull(color);
            checkNotNull(priority);
            this.size = size;
            this.color = color;
            this.priority = priority;
        }

        /**
         * Get the dataline size.
         *
         * @return the size
         */
        int getSize() {
            return size;
        }

        /**
         * Get the dataline color.
         *
         * @return the color
         */
        Color getColor() {
            return color;
        }

        /**
         * Get the dataline priority.
         *
         * @return the priority
         */
        Priority getPriority() {
            return priority;
        }
    }

    /**
     * The BarColor inner class. Individual bars can be colored.
     */
    static class BarColor {

        /** The color. */
        private final Color color;

        /** The index. */
        private final int index;

        /**
         * Instantiates a new bar color.
         *
         * @param color
         *            the color
         * @param index
         *            the index
         */
        BarColor(final Color color, final int index) {
            super();
            this.color = color;
            this.index = index;
        }

        /**
         * Get the colored bar index.
         *
         * @return the index
         */
        int getIndex() {
            return index;
        }

        /**
         * Get the colored bar color.
         *
         * @return the color
         */
        Color getColor() {
            return color;
        }
    }
}
