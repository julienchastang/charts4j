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
 * <b>For Charts4j internal use only.</b> Enumeration for axis types.
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 */
public enum AxisTypes {

    /** Right Y axis type. */
    RIGHT_Y_AXIS("r"),
    /** Left Y axis type. */
    LEFT_Y_AXIS("y"),
    /** Top X axis type. */
    TOP_X_AXIS("t"),
    /** Bottom X axis type. */
    BOTTOM_X_AXIS("x");

    /** String for the Google Chart API parameter. */
    private final String axisType;

    /**
     * Instantiating enum.
     *
     * @param axisType
     *            the string for the Google Chart API parameter
     */
    private AxisTypes(final String axisType) {
        this.axisType = axisType;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return axisType;
    }
}
