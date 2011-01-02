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
 * Enumeration for specifying shape of {@link ShapeMarker}.
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 *
 */
public enum Shape {
    /** Arrow. **/
    ARROW("a"),
    /** Cross. **/
    CROSS("c"),
    /** Diamond. **/
    DIAMOND("d"),
    /** Circle. **/
    CIRCLE("o"),
    /** Square. **/
    SQUARE("s"),
    /** Partial vertical line. **/
    VERTICAL_LINE_PARTIAL("v"),
    /** Full vertical line spanning chart. **/
    VERTICAL_LINE_FULL("V"),
    /** Horizontal line. **/
    HORIZONTAL_LINE("h"),
    /** X. **/
    X("x");

    /** String required for Google Chart API. **/
    private final String shape;

    /**
     * Constructor.
     *
     * @param shape
     *            String required for Google Chart API
     */
    private Shape(final String shape) {
        this.shape = shape;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return shape;
    }
}
