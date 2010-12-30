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

package com.googlecode.charts4j;

/**
 * Top level plot interface. All plots can be annotated with {@link Marker}s.
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 *
 */
public interface Plot extends Kloneable<Plot> {

    /**
     * Set the legend.
     *
     * @param legend
     *            plot legend. Cannot be null.
     */
    void setLegend(final String legend);

    /**
     * Set the color for this plot.
     *
     * @param color
     *            color. Cannot be null
     */
    void setColor(final Color color);

    /**
     * Add a shape marker to a point.
     *
     * @param shape
     *            Arrows, Diamonds, etc. Cannot be null.
     * @param color
     *            Color of the shape maker. Cannot be null.
     * @param size
     *            The size of the shape marker. Must be > 0.
     * @param index
     *            The index of the point decorated with a shape marker. Must be >=
     *            0.
     */
    void addShapeMarker(final Shape shape, final Color color, final int size, final int index);

    /**
     * Add a text marker to a point.
     *
     * @param text
     *            Text marker. Cannot be null.
     * @param color
     *            Color of text marker. Cannot be null.
     * @param size
     *            The font size of the text marker. Must be > 0.
     * @param index
     *            The index at which the text marker should be added. Must be >=
     *            0.
     */
    void addTextMarker(final String text, final Color color, final int size, final int index);

    /**
     * Add a shape marker to each point on a plot.
     *
     * @param shape
     *            Arrows, Diamonds, etc. Cannot be null.
     * @param color
     *            Color of the shape maker. Cannot be null.
     * @param size
     *            The size of the shape marker. Must be > 0.
     */
    void addShapeMarkers(final Shape shape, final Color color, final int size);

    /**
     * Add a {@link Marker}.
     *
     * @param marker
     *            The text or shape marker. Cannot be null.
     * @param index
     *            The index at which the text marker should be added. Must be >=
     *            0.
     */
    void addMarker(final Marker marker, final int index);

    /**
     * Add a {@link Marker} to each point on a plot.
     *
     * @param marker
     *            The text or shape marker. Cannot be null.
     */
    void addMarkers(final Marker marker);

    /**
     * Add a {@link Marker}.
     *
     * @param marker
     *            The text or shape marker. Cannot be null.
     * @param n
     *            Marker on every n-th data point. Must be >= 1.
     */
    void addMarkers(final Marker marker, final int n);

    /**
     * Add a {@link Marker}.
     *
     * @param marker
     *            The text or shape marker. Cannot be null.
     * @param startIndex
     *            The start index for the marker range. Must be >= 0.
     * @param endIndex
     *            The end index for the marker range. Must be positive and >
     *            start index. End point exclusive.
     * @param n
     *            Marker on every n-th data point. Must be >= 1.
     */
    void addMarkers(final Marker marker, final int startIndex, final int endIndex, final int n);

    /**
     * Add {@link Marker}s.
     *
     * @param marker
     *            The text or shape marker. Cannot be null.
     * @param startIndex
     *            The start index for the marker range. Must be >= 0.
     * @param endIndex
     *            The end index for the marker range. Must be positive and >
     *            start index. End point exclusive.
     */
    void addMarkers(final Marker marker, final int startIndex, final int endIndex);
}
