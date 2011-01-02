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
 * Enumeration for specifying position of label with respect to axis tick mark.
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 *
 */
public enum AxisTextAlignment {
    /** Label position left of tick mark. */
    LEFT(-1),

    /** Label position centered above tick mark.*/
    CENTER(0),

    /** Label position to the right of the text mark. */
    RIGHT(1);

    /** Value for Google Chart API parameter. **/
    private final int alignment;

    /**
     * Overloading constructor to provide Google Chart API with the right
     * parameter value.
     *
     * @param alignment for the Google Chart API
     */
    private AxisTextAlignment(final int alignment) {
        this.alignment = alignment;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return alignment + "";
    }
}
