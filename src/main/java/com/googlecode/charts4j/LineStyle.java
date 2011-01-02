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

import static com.googlecode.charts4j.collect.Preconditions.checkArgument;

/**
 * Class for specifying line styles on {@link LineChart}s, {@link XYLine}s,
 * and {@link RadarPlot}s. You can specify if a line is solid or dotted, and
 * the thickness of the line with this class. Also, for your convenience, there
 * are a few predefined lines.
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 */
public final class LineStyle {

    /** Thick line. **/
    public static final LineStyle THICK_LINE         = newLineStyle(5, 1, 0);

    /** Medium line. **/
    public static final LineStyle MEDIUM_LINE        = newLineStyle(3, 1, 0);

    /** Thin line. **/
    public static final LineStyle THIN_LINE          = newLineStyle(1, 1, 0);

    /** Thick dotted line. **/
    public static final LineStyle THICK_DOTTED_LINE  = newLineStyle(5, 5, 3);

    /** Medium dotted line. **/
    public static final LineStyle MEDIUM_DOTTED_LINE = newLineStyle(3, 5, 3);

    /** Thin dotted line. **/
    public static final LineStyle THIN_DOTTED_LINE   = newLineStyle(1, 5, 3);

    /** Line style thickness. **/
    private final int       lineThickness;

    /** Length of line segment. **/
    private final int       lengthOfLineSegment;

    /** Length of blank segment. **/
    private final int       lengthOfBlankSegment;

    /**
     * @see #newLineStyle(int, int, int)
     */
    LineStyle(final int lineThickness, final int lengthOfLineSegment, final int lengthOfBlankSegment) {
        this.lineThickness = lineThickness;
        this.lengthOfLineSegment = lengthOfLineSegment;
        this.lengthOfBlankSegment = lengthOfBlankSegment;
    }

    /**
     * Get the thickness of the line.
     *
     * @return The thickness of the line.
     */
    public int getLineThickness() {
        return lineThickness;
    }

    /**
     * Get the length of the line segment.
     *
     * @return Length of line segment.
     */
    public int getLengthOfLineSegment() {
        return lengthOfLineSegment;
    }

    /**
     * Get the length of the blank segment.
     *
     * @return Length of blank segment.
     */
    public int getLengthOfBlankSegment() {
        return lengthOfBlankSegment;
    }

    /**
     * Create a line style.
     *
     * @param lineThickness
     *            Thickness of line. Must be > 0.
     * @param lengthOfLineSegment
     *            Length of line segment. Must be >= 0.
     * @param lengthOfBlankSegment
     *            Length of blank segment. Must be >= 0.
     * @return a LineStyle
     */
    public static LineStyle newLineStyle(final int lineThickness, final int lengthOfLineSegment, final int lengthOfBlankSegment) {
        checkArgument(lineThickness > 0, "line thickness must be > 0: %s", lineThickness);
        checkArgument(lengthOfLineSegment >= 0, "length of line segment must be >= 0: %s", lengthOfLineSegment);
        checkArgument(lengthOfBlankSegment >= 0, "length of blank segment must be > 0: %s", lengthOfBlankSegment);
        return new LineStyle(lineThickness, lengthOfLineSegment, lengthOfBlankSegment);
    }
}
