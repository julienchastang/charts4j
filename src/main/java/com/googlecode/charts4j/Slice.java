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
 * Slice of pie for a {@link PieChart}. If the number of colors specified is
 * less than the number of slices, then colors are interpolated. If no colors
 * are specified, pie segment colors are interpolated from dark orange to pale
 * yellow.
 *
 * If slices do not add up to 100, slices will be proportional to the total of
 * all slices.
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 *
 * @see PieChart
 * @see GCharts
 */
public class Slice {

    /** Percent of pie. **/
    private final int    percent;

    /** Label for pie slice. **/
    private final String label;

    /** Legend for pie slice. **/
    private final String legend;

    /** Color for pie slice. **/
    private final Color  color;

    /**
     * @see #newSlice(int, Color, String)
     */
    Slice(final int percent, final Color color, final String sliceLabel, final String sliceLegend) {
        this.percent = percent;
        this.color = color;
        this.label = sliceLabel;
        this.legend = sliceLegend;
    }

    /**
     * Get the percentage for this slice of the pie.
     *
     * @return percentage that this slice will take of the pie.
     */
    public final int getPercentage() {
        return percent;
    }

    /**
     * Get the color for this slice of the pie.
     *
     * @return color of pie slice.
     *
     */
    public final Color getColor() {
        return color;
    }

    /**
     * Get the pie slice label.
     *
     * @return label of pie slice.
     */
    public final String getLabel() {
        return label;
    }

    /**
     * Get the pie slice legend.
     *
     * @return legend of pie slice.
     */
    public final String getLegend() {
        return legend;
    }

    /**
     * Create a pie slice.
     *
     * @param percent
     *            percent of pie. Must be >= 0.
     * @param color
     *            color of slice.
     * @param sliceLabel
     *            label associated with slice.
     * @return a slice of pie.
     */
    public static Slice newSlice(final int percent, final Color color, final String sliceLabel) {
        return newSlice(percent, color, sliceLabel, null);
    }

    /**
     * Create a pie slice.
     *
     * @param percent
     *            percent of pie. Must be >= 0.
     * @param color
     *            color of slice.
     * @param sliceLabel
     *            label associated with slice.
     * @param sliceLegend
     *            legend associated with slice.
     * @return a slice of pie.
     */
    public static Slice newSlice(final int percent, final Color color, final String sliceLabel, final String sliceLegend) {
        checkArgument(percent >= 0, "value must be between >= 0: %s", percent);
        return new Slice(percent, color, sliceLabel, sliceLegend);
    }

    /**
     * Use {@link #newSlice(int, Color, String, String)} instead.
     */
    @Deprecated //Since version 1.1. Going away in a future release.
    public static Slice newSlice(final int percent, final Color color) {
        return newSlice(percent, color, null, null);
    }

    /**
     * Create a pie slice.
     *
     * @param percent
     *            percent of pie. Must be >= 0.
     * @param sliceLabel
     *            label associated with slice.
     * @return a slice of pie.
     */
    public static Slice newSlice(final int percent, final String sliceLabel) {
        return newSlice(percent, null, sliceLabel, null);
    }
}
