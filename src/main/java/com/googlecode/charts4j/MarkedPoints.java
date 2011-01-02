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

/**
 * Marked point(s) that describe data points to be decorated with a text or
 * shape marker.
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 *
 */
class MarkedPoints {
    /** Text or shape marker. **/
    private final Marker marker;

    /** The start index of marker. **/
    private final int    startIndex;

    /** The end index of marker, end point exclusive. **/
    private final int    endIndex;

    /** The periodicity of marker. **/
    private final int    n;

    /**
     * Marker point constructor.
     *
     * @param marker
     *            The shape or text marker for this series.
     *
     * @param index
     *            The index of the point to decorate.
     *
     */
    MarkedPoints(final Marker marker, final int index) {
        super();
        this.marker = marker;
        this.startIndex = index;
        this.endIndex = index + 1;
        this.n = 1;
    }

    /**
     * Marker point constructor.
     *
     * @param marker
     *            The shape or text marker for this series.
     * @param startIndex
     *            The start index for the marker range.
     * @param endIndex
     *            The end index for the marker range.
     * @param n
     *            Marker on every n-th data point.
     */
    MarkedPoints(final Marker marker, final int startIndex, final int endIndex,  final int n) {
        this.marker = marker;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.n = n;
    }

    /**
     * Get the marker for this marker series.
     *
     * @return the marker
     */
    Marker getMarker() {
        return marker;
    }

    /**
     * Get the start index of the point to decorate.
     *
     * @return the start index
     */
    int getStartIndex() {
        return startIndex;
    }

    /**
     * Get the end index of the point to decorate.
     *
     * @return the end index
     */
    int getEndIndex() {
        return endIndex;
    }

    /**
     * Get the periodicity.
     *
     * @return the periodicity
     */
    int getN() {
        return n;
    }
}
