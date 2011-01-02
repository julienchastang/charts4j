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

/**
 * Class for building grid line parameter string for the Google Chart API.
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 */
final class GridLineParameter extends AbstractParameter {

    /** The Google Chart API grid line parameter. */
    private static final String URL_PARAMETER_KEY = "chg";

    /** The x axis step size. */
    private final double        xAxisStepSize;

    /** The y axis step size. */
    private final double        yAxisStepSize;

    /** The length of line segment. */
    private final int           lengthOfLineSegment;

    /** The length of blank segment. */
    private final int           lengthOfBlankSegment;

    /**
     * Instantiates a new grid line parameter.
     *
     * @param xAxisStepSize
     *            the x axis step size
     * @param yAxisStepSize
     *            the y axis step size
     * @param lengthOfLineSegment
     *            the length of line segment
     * @param lengthOfBlankSegment
     *            the length of blank segment
     */
    GridLineParameter(final double xAxisStepSize, final double yAxisStepSize, final int lengthOfLineSegment, final int lengthOfBlankSegment) {
        this.xAxisStepSize = xAxisStepSize;
        this.yAxisStepSize = yAxisStepSize;
        this.lengthOfLineSegment = lengthOfLineSegment;
        this.lengthOfBlankSegment = lengthOfBlankSegment;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getKey() {
        return URL_PARAMETER_KEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getValue() {
        return xAxisStepSize + "," + yAxisStepSize + "," + lengthOfLineSegment + "," + lengthOfBlankSegment;
    }
}
