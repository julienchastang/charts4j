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

package com.googlecode.charts4j.parameters;

import com.googlecode.charts4j.Color;
import com.googlecode.charts4j.Data;

/**
 * <b>For Charts4J internal use only.</b> Class to encapsulate colors and
 * offsets for {@link com.googlecode.charts4j.LinearStripesFill}
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 */
public class ColorAndWidth {

    /** The color. */
    private final Color  color;

    /** The width. */
    private final double width;

    /**
     * Instantiates this container.
     *
     * @param color
     *            the color
     * @param width
     *            the width
     */
    public ColorAndWidth(final Color color, final double width) {
        this.color = color;
        this.width = width;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        //The Google Chart API expect a value between 0 and 1
        return color + "," + width / Data.MAX_VALUE;
    }
}
