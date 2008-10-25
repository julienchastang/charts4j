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
 * Shape markers for {@link LineChart}s, {@link XYLineChart}s,
 * {@link RadarChart}s, {@link ScatterPlot}s, and {@link BarChart}s. Markers are
 * constructed with the {@link Markers} class.
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 *
 * @see LineChart
 * @see XYLineChart
 * @see ScatterPlot
 * @see BarChart
 */
public class ShapeMarker extends AbstractMarker {

    /** Shape of marker. **/
    private final Shape shape;

    /**
     * @see Markers#newShapeMarker(Shape, Color, int)
     */
    ShapeMarker(final Shape shape, final Color color, final int size) {
        super(color, size, Priority.NORMAL);
        this.shape = shape;
    }

    /**
     * @see Markers#newShapeMarker(Shape, Color, int, Priority)
     */
    ShapeMarker(final Shape shape, final Color color, final int size, final Priority priority) {
        super(color, size, priority);
        this.shape = shape;
    }

    /**
     * Get the shape associated with ShapeMarker.
     *
     * @return shape
     */
    public final Shape getShape() {
        return shape;
    }
}
