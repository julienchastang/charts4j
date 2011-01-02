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
 * Class for building axis tick mark length parameter string for the Google
 * Chart API.
 * 
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 */
public class TickMarkLengthParameter extends AbstractParameter {

    /** The Google Chart API axis tick mark length parameter. */
    private static final String            URL_PARAMETER_KEY = "chxtc";

    /** The axis tick mark lengths. */
    private final List<AxisTickMarkLength> tickMarkLengths   = Lists.newLinkedList();

    /**
     * Add the tick mark length.
     *
     * @param index
     *            the axis index
     * @param tickMarkLength
     *            the tick mark length
     */
    public void addTickMarkLength(final int index, final int tickMarkLength) {
        tickMarkLengths.add(new AxisTickMarkLength(index, tickMarkLength));
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
        for (AxisTickMarkLength tml : tickMarkLengths) {
            sb.append(cnt++ > 0 ? "|" : "").append(tml);
        }
        return !tickMarkLengths.isEmpty() ? sb.toString() : "";
    }

    /**
     *  Private class to encapsulate the axis tick mark length.
     */
    private static final class AxisTickMarkLength {

        /** The index. */
        private final int index;

        /** The tick mark length. */
        private final int tickMarkLength;

        /**
         * Instantiates a new axis tick mark length.
         *
         * @param index
         *            the index
         * @param tickMarkLength
         *            the tick mark length
         */
        public AxisTickMarkLength(final int index, final int tickMarkLength) {
            this.index = index;
            this.tickMarkLength = tickMarkLength;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return index + "," + tickMarkLength;
        }
    }
}
