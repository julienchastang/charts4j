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

import static com.googlecode.charts4j.collect.Preconditions.*;

/**
 * Static factory class for {@link Marker} hierarchy.
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 *
 */
public final class Markers {

    /**
     * Static factory class can never be instantiated.
     */
    private Markers() {
        throw new AssertionError();
    }

    /**
     * Static factory method to instantiate new {@link TextMarker}.
     *
     * @param text
     *            The text of the marker. Cannot be null.
     * @param color
     *            The color of text marker. Cannot be null.
     * @param size
     *            The size of text marker. Must be > 0.
     * @return The text marker.
     */
    public static Marker newTextMarker(final String text, final Color color, final int size) {
        checkNotNull(text, "text cannot be null");
        checkNotNull(color, "color cannot be null");
        checkArgument(size > 0, "The size of this marker has to be > 0");
        return new TextMarker(text, color, size);
    }

    /**
     * Static factory method to instantiate new {@link ShapeMarker}.
     *
     * @param shape
     *            The shape of the marker (arrows, diamonds, etc.). Cannot be
     *            null.
     * @param color
     *            The color of the shape marker. Cannot be null.
     * @param size
     *            The size of the shape marker. Must be > 0.
     * @return The shape marker.
     */
    public static Marker newShapeMarker(final Shape shape, final Color color, final int size) {
        checkNotNull(shape, "shape cannot be null");
        checkNotNull(color, "color cannot be null");
        checkArgument(size > 0, "The size of this marker has to be > 0");
        return new ShapeMarker(shape, color, size);
    }

    /**
     * Static factory method to instantiate new {@link TextMarker}.
     *
     * @param text
     *            The text of the marker. Cannot be null.
     * @param color
     *            The color of text marker. Cannot be null.
     * @param size
     *            The size of text marker. Must be > 0.
     * @param priority
     *            The marker priority. Cannot be null.
     * @return The text marker.
     */
    public static Marker newTextMarker(final String text, final Color color, final int size, final Priority priority) {
        checkNotNull(text, "text cannot be null");
        checkNotNull(color, "color cannot be null");
        checkArgument(size > 0, "The size of this marker has to be > 0");
        return new TextMarker(text, color, size, priority);
    }

    /**
     * Static factory method to instantiate new {@link ShapeMarker}.
     *
     * @param shape
     *            The shape of the marker. Cannot be null.
     * @param color
     *            The color of shape marker. Cannot be null.
     * @param size
     *            The size of shape marker. Must be > 0.
     * @param priority
     *            The marker priority. Cannot be null.
     * @return The shape marker
     */
    public static Marker newShapeMarker(final Shape shape, final Color color, final int size, final Priority priority) {
        checkNotNull(shape, "shape cannot be null");
        checkNotNull(color, "color cannot be null");
        checkArgument(size > 0, "The size of this marker has to be > 0");
        return new ShapeMarker(shape, color, size, priority);
    }
}
