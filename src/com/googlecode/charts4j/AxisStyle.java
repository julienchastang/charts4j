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
 * Type for specifying axis styles.
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 * @see AxisLabels
 * @see AxisLabelsFactory
 */
public final class AxisStyle {
    /** Axis text color. **/
    private final Color             color;

    /** Axis text font size. **/
    private final int               fontSize;

    /** Axis text alignment relative to tick mark. **/
    private final AxisTextAlignment alignment;

    /**
     * @see #newAxisStyle(Color, int, AxisTextAlignment)
     */
    AxisStyle(final Color color, final int fontSize, final AxisTextAlignment alignment) {
        this.color = color;
        this.fontSize = fontSize;
        this.alignment = alignment;
    }

    /**
     * @return the color
     */
    Color getColor() {
        return color;
    }

    /**
     * @return the fontSize
     */
    int getFontSize() {
        return fontSize;
    }

    /**
     * @return the alignment
     */
    AxisTextAlignment getAlignment() {
        return alignment;
    }

    /**
     * Define an axis style.
     *
     * @param color
     *            color of text displayed along the axis. Cannot be null.
     * @param fontSize
     *            font size of text displayed along the axis. Must be > 0.
     * @param alignment
     *            alignment of text along the axis with respect to the axis tick
     *            marks. Cannot be null.
     * @return the new constructed axis style
     */
    public static AxisStyle newAxisStyle(final Color color, final int fontSize, final AxisTextAlignment alignment) {
        checkNotNull(color, "color must not be null");
        checkArgument(fontSize > 0, "fontsize must be > 0");
        checkNotNull(alignment, "alignment must not be null");
        return new AxisStyle(color, fontSize, alignment);
    }
}
