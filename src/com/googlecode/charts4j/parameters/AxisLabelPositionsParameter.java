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

package com.googlecode.charts4j.parameters;

import java.util.List;

import com.googlecode.charts4j.collect.ImmutableList;
import com.googlecode.charts4j.collect.Lists;

/**
 * Class for building axis label positions parameter string for the Google Chart
 * API.
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 */
final class AxisLabelPositionsParameter implements Parameter {

    /** The Google Chart API axis label parameter. */
    private static final String            URL_PARAMETER_KEY = "chxp";

    /** List containing label positions. **/
    private final List<AxisLabelPositions> labelPositions    = Lists.newLinkedList();

    /**
     * Add label positions.
     *
     * @param index
     *            the index
     * @param positions
     *            the positions of the labels
     */
    void addLabelPosition(final int index, final ImmutableList<? extends Number> positions) {
        labelPositions.add(new AxisLabelPositions(index, positions));
    }

    /**
     * {@inheritDoc}
     */
    public String toURLParameterString() {
        final StringBuilder sb = new StringBuilder(URL_PARAMETER_KEY + "=");
        int cnt = 0;
        for (AxisLabelPositions positions : labelPositions) {
            sb.append(cnt++ > 0 ? "|" : "").append(positions);
        }
        return (!labelPositions.isEmpty()) ? sb.toString() : "";
    }

    /**
     * A container class to hold axis label positions.
     */
    private static final class AxisLabelPositions {

        /** The index. */
        private final int          index;

        /** The positions. */
        private final ImmutableList<Number> positions;

        /**
         * Instantiates this container class.
         *
         * @param index
         *            the index
         * @param positions
         *            the positions
         */
        private AxisLabelPositions(final int index, final ImmutableList<? extends Number> positions) {
            this.index = index;
            this.positions = Lists.copyOf(positions);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            if (positions.isEmpty()) {
                return "";
            } else {
                final StringBuilder sb = new StringBuilder(index + ",");
                int cnt = 0;
                for (Number n : positions) {
                    sb.append(cnt++ > 0 ? "," : "").append(n);
                }
                return sb.toString();
            }
        }
    }
}
