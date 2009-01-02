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

import com.googlecode.charts4j.AxisStyle;
import com.googlecode.charts4j.collect.Lists;

/**
 * Class for building axis styles parameter string for the Google Chart API.
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 */
final class AxisStylesParameter implements Parameter {

    /** The Google Chart API axis styles parameter. */
    private static final String    URL_PARAMETER_KEY = "chxs";

    /** The axis styles. */
    private final List<PrivateAxisStyles> axisStyles = Lists.newLinkedList();

    /**
     * Add an axis style.
     *
     * @param index
     *            the index
     * @param axisStyle
     *            the axisStyle
     */
    void addAxisStyle(final int index, final AxisStyle axisStyle) {
        axisStyles.add(new PrivateAxisStyles(index, axisStyle));
    }

    /**
     * {@inheritDoc}
     */
    public String toURLParameterString() {
        final StringBuilder sb = new StringBuilder(URL_PARAMETER_KEY + "=");
        int cnt = 0;
        for (PrivateAxisStyles styles : axisStyles) {
            sb.append(cnt++ > 0 ? "|" + styles : styles);
        }
        return !axisStyles.isEmpty() ? sb.toString() : "";
    }

    /**
     * A container class to hold axis styles.
     */
    private static final class PrivateAxisStyles {

        /** Draw tick marks. */
        private static final String DRAW_TICK_MARKS = "t";
        
        /** Draw axis lines. */
        private static final String DRAW_AXIS_LINE = "l";

        /** The index. */
        private final int               index;

        /** The axis style. */
        private final AxisStyle axisStyle;

        /**
         * Instantiate axis styles.
         *
         * @param index
         *            the index
         * @param axisStyle
         *            the axisStyle
         */
        private PrivateAxisStyles(final int index, final AxisStyle axisStyle) {
            this.index = index;
            this.axisStyle = axisStyle;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder(index + "," + axisStyle.getTextColor() + "," + axisStyle.getFontSize() + "," + axisStyle.getAlignment());
            sb.append(getDrawingControlString(axisStyle) != null ? "," + getDrawingControlString(axisStyle) : "");
            sb.append(axisStyle.getTickMarkColor() != null ? "," + axisStyle.getTickMarkColor() : "");
            return sb.toString();
        }
        
        /**
         * Build the drawing control string.
         * 
         * @param axisStyle
         *            the axis style
         * 
         * @return the drawing control string
         */
        private String getDrawingControlString(final AxisStyle axisStyle) {
            final StringBuilder sb = new StringBuilder();
            sb.append(axisStyle.drawAxis() != null && axisStyle.drawAxis() ? DRAW_AXIS_LINE : "");
            sb.append(axisStyle.drawTickMarks() != null && axisStyle.drawTickMarks() ? DRAW_TICK_MARKS : "");
            return sb.length() > 0 ? sb.toString() : null;
        }
    }
}