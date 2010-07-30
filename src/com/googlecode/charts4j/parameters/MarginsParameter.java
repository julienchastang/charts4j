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

/**
 * Class for defining chart margins.
 */
final class MarginsParameter extends AbstractParameter {

    /** The Google Chart API chart margin parameter. */
    private static final String URL_PARAMETER_KEY = "chma";

    /** The left margin. */
    private  int           leftMargin = 0;

    /** The right margin. */
    private  int           rightMargin = 0;

    /** The top margin. */
    private  int           topMargin = 0;

    /** The bottom margin. */
    private  int           bottomMargin = 0;

    /** The legend margins. */
    private LegendMargins       legendMargins;

    /**
     * Set the chart margins.
     *
     * @param bottomMargin
     *            the bottom margin
     * @param leftMargin
     *            the left margin
     * @param rightMargin
     *            the right margin
     * @param topMargin
     *            the top margin
     */
    void setMargins(final int bottomMargin, final int leftMargin, final int rightMargin, final int topMargin) {
        this.bottomMargin = bottomMargin;
        this.leftMargin = leftMargin;
        this.rightMargin = rightMargin;
        this.topMargin = topMargin;
    }


    /**
     * Sets the legend margins.
     *
     * @param width
     *            the legend width
     * @param height
     *            the legend height
     */
    void setLegendMargins(final int width, final int height) {
        this.legendMargins = new LegendMargins(width, height);
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
        final String legendMarginsString = legendMargins != null ? "|" + legendMargins.width + "," + legendMargins.height : "";
        return leftMargin + "," + rightMargin + "," + topMargin + "," + bottomMargin + legendMarginsString;
    }

    /**
     * Private class to encapsulate legend margins.
     */
    private static class LegendMargins {
        /** The legend height. */
        private final int height;

        /** The legend width. */
        private final int width;

        /**
         * Instantiates a new legend margins.
         *
         * @param height
         *            the legend height
         * @param width
         *            the legend width
         */
        private LegendMargins(final int height, final int width) {
            super();
            this.height = height;
            this.width = width;
        }
    }
}
