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
 * Abstract type that contains code common to text and shape markers.
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 *
 */
class AbstractMarker implements Marker {

    /** Marker color.  **/
    private final Color    color;

    /** Marker size.  **/
    private final int      size;

    /** Marker priority.  **/
    private final Priority priority;

    /**
     * Create a marker.
     *
     * @param color
     *            Color of marker. Cannot be null.
     *
     * @param size
     *            The size of the shape marker. Must be > 0.
     *
     * @param priority
     *            The priority to set. Cannot be null.
     *
     */
    AbstractMarker(final Color color, final int size, final Priority priority) {
        checkNotNull(color);
        checkNotNull(priority);
        checkArgument(size > 0);
        this.color = color;
        this.size = size;
        this.priority = priority;
    }

    /**
     * Get the marker color.
     *
     * @return color
     */
    public Color getColor() {
        return color;
    }

    /**
     * Get the marker size.
     *
     * @return size
     */
    public int getSize() {
        return size;
    }

    /**
     * Get the marker priority.
     *
     * @return priority
     */
    public Priority getPriority() {
        return priority;
    }
}
