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

package com.googlecode.charts4j.parameters;

import java.util.List;

import com.googlecode.charts4j.collect.Lists;

/**
 * Class for building axis ranges parameter string for the Google Chart API.
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 */
final class AxisRangesParameter extends AbstractParameter {

    /** The Google Chart API axis ranges parameter. */
    private static final String   URL_PARAMETER_KEY = "chxr";

    /** The axis ranges. */
    private final List<AxisRange> axisRanges        = Lists.newLinkedList();

    /**
     * Add an axis range.
     *
     * @param index
     *            the index
     * @param startOfRange
     *            the start of range
     * @param endOfRange
     *            the end of range
     * @param interval
     *            the numeric label interval
     */
    void addAxisRange(final int index, final double startOfRange, final double endOfRange, final double interval) {
        axisRanges.add(new AxisRange(index, startOfRange, endOfRange, interval));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getKey() {
        return URL_PARAMETER_KEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getValue() {
        final StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (AxisRange ar : axisRanges) {
            sb.append(cnt++ > 0 ? "|" : "").append(ar);
        }
        return !axisRanges.isEmpty() ? sb.toString() : "";
    }

    /**
     * Container class to hold axis ranges.
     */
    private static class AxisRange {

        /** The index. */
        private final int    index;

        /** The start of range. */
        private final double startOfRange;

        /** The end of range. */
        private final double endOfRange;

        /** Tick mark interval. */
        private final double interval;

        /**
         * Instantiates this container class.
         *
         * @param index
         *            the index
         * @param startOfRange
         *            the start of range
         * @param endOfRange
         *            the end of range
         */
        private AxisRange(final int index, final double startOfRange, final double endOfRange, final double interval) {
            this.index = index;
            this.startOfRange = startOfRange;
            this.endOfRange = endOfRange;
            this.interval = interval;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return index + "," + startOfRange + "," + endOfRange + (Double.isNaN(interval) ? "" : "," + interval);
        }
    }
}
