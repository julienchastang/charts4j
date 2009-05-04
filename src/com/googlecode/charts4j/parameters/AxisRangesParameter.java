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

import com.googlecode.charts4j.collect.Lists;

/**
 * Class for building axis ranges parameter string for the Google Chart API.
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 */
final class AxisRangesParameter implements Parameter {

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
     */
    void addAxisRange(final int index, final double startOfRange, final double endOfRange) {
        axisRanges.add(new AxisRange(index, startOfRange, endOfRange));
    }

    /**
     * {@inheritDoc}
     */
    public String toURLParameterString() {
        final StringBuilder sb = new StringBuilder(URL_PARAMETER_KEY + "=");
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
        private AxisRange(final int index, final double startOfRange, final double endOfRange) {
            this.index = index;
            this.startOfRange = startOfRange;
            this.endOfRange = endOfRange;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return index + "," + startOfRange + "," + endOfRange;
        }
    }
}
