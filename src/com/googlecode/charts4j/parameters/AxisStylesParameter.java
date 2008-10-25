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

import com.googlecode.charts4j.AxisTextAlignment;
import com.googlecode.charts4j.Color;
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
    private final List<AxisStyles> axisStyles        = Lists.newLinkedList();

    /**
     * Add an axis style.
     *
     * @param index
     *            the index
     * @param color
     *            the color of the axis style
     * @param fontSize
     *            the font size of the axis style
     * @param alignment
     *            the alignment of the axis style
     */
    void addAxisStyle(final int index, final Color color, final int fontSize, final AxisTextAlignment alignment) {
        axisStyles.add(new AxisStyles(index, color, fontSize, alignment));
    }

    /**
     * {@inheritDoc}
     */
    public String toURLParameterString() {
        final StringBuilder sb = new StringBuilder(URL_PARAMETER_KEY + "=");
        int cnt = 0;
        for (AxisStyles styles : axisStyles) {
            sb.append(cnt++ > 0 ? "|" + styles : styles);
        }
        return !axisStyles.isEmpty() ? sb.toString() : "";
    }

    /**
     * A container class to hold axis styles.
     */
    private static final class AxisStyles {

        /** The index. */
        private final int               index;

        /** The color. */
        private final Color             color;

        /** The font size. */
        private final int               fontSize;

        /** The alignment. */
        private final AxisTextAlignment alignment;

        /**
         * Instantiate axis styles.
         *
         * @param index
         *            the index
         * @param color
         *            the color
         * @param fontSize
         *            the font size
         * @param alignment
         *            the alignment
         */
        private AxisStyles(final int index, final Color color, final int fontSize, final AxisTextAlignment alignment) {
            this.index = index;
            this.color = color;
            this.fontSize = fontSize;
            this.alignment = alignment;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return index + "," + color + "," + fontSize + "," + alignment;
        }
    }
}
