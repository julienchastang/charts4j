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
 * Class for building axis labels parameter string for the Google Chart API.
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 */
final class AxisLabelsParameter extends AbstractParameter {

    /** The Google Chart API axis labels parameter. */
    private static final String    URL_PARAMETER_KEY = "chxl";

    /** The axis labels. */
    private final List<AxisLabels> axisLabels        = Lists.newLinkedList();

    /**
     * Add an axis labels.
     *
     * @param index
     *            the index
     * @param labels
     *            the labels
     */
    void addAxisLabels(final int index, final ImmutableList<? extends String> labels) {
        axisLabels.add(new AxisLabels(index, labels));
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
        for (AxisLabels aLabels : axisLabels) {
            sb.append(cnt++ > 0 ? "|" : "").append(aLabels);

        }
        return !axisLabels.isEmpty() ? sb.toString() : "";
    }

    /**
     * A container to hold axis labels.
     */
    private static final class AxisLabels {

        /** The index. */
        private final int          index;

        /** The labels. */
        private final ImmutableList<String> labels;

        /**
         * Instantiates this container.
         *
         * @param index
         *            the index
         * @param labels
         *            the labels
         */
        private AxisLabels(final int index, final ImmutableList<? extends String> labels) {
            this.index = index;
            this.labels = Lists.copyOf(labels);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            if (labels.isEmpty()) {
                return "";
            } else {
                final StringBuilder sb = new StringBuilder(index + ":|");
                int cnt = 0;
                for (String label : labels) {
                    final String l = ParameterUtil.utf8Encode(label);
                    sb.append(cnt++ > 0 ? "|" : "").append(l);
                }
                return sb.toString();
            }
        }
    }
}
