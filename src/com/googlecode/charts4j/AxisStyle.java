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

import static com.googlecode.charts4j.collect.Preconditions.checkArgument;
import static com.googlecode.charts4j.collect.Preconditions.checkNotNull;

/**
 * Type for specifying axis styles.
 * 
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 * @see AxisLabels
 * @see AxisLabelsFactory
 */
public final class AxisStyle {
    /** Axis text color. */
    private final Color             textColor;

    /** Axis text font size. */
    private final int               fontSize;

    /** Axis text alignment relative to tick mark. */
    private final AxisTextAlignment alignment;

    /** Are the tick marks drawn. */
    private Boolean                 areTickMarksDrawn;

    /** The tick mark length. Can be negative. */
    private Integer                 tickMarkLength;

    /** The tick mark color. */
    private Color                   tickMarkColor;

    /**
     * @see #newAxisStyle(Color, int, AxisTextAlignment)
     */
    AxisStyle(final Color textColor, final int fontSize, final AxisTextAlignment alignment) {
        this.textColor = textColor;
        this.fontSize = fontSize;
        this.alignment = alignment;
    }

    /**
     * Get the text color.
     * 
     * @return the text color
     */
    public Color getTextColor() {
        return textColor;
    }

    /**
     * Get the text font size.
     * 
     * @return the text fontSize
     */
    public int getFontSize() {
        return fontSize;
    }

    /**
     * Get the text alignment with respect to the tick mark.
     * 
     * @return the alignment
     */
    public AxisTextAlignment getAlignment() {
        return alignment;
    }

    /**
     * Are the tick marks drawn?
     * 
     * @return are the tick marks displayed? Can be null if it was never set.
     */
    public Boolean drawTickMarks() {
        return areTickMarksDrawn;
    }

    /**
     * The developer can override default tick mark behavior with this method.
     * 
     * @param drawTickMarks
     *            Are the tick marks displayed?
     */
    public void setDrawTickMarks(final boolean drawTickMarks) {
        this.areTickMarksDrawn = drawTickMarks;
    }

    /**
     * Get the tick mark length. Can be negative.
     * 
     * @return the tickMarkLength
     */
    public Integer getTickMarkLength() {
        return tickMarkLength;
    }

    /**
     * Set the tick mark length. Can be negative. Will also implicitly call
     * {@link #setDrawTickMarks(boolean)} with true.
     * 
     * @param tickMarkLength
     *            the tickMarkLength to set
     */
    public void setTickMarkLength(final int tickMarkLength) {
        setDrawTickMarks(true);
        this.tickMarkLength = tickMarkLength;
    }

    /**
     * Get the tick mark color.
     * 
     * @return the tickMarkColor
     */
    public Color getTickMarkColor() {
        return tickMarkColor;
    }

    /**
     * Set the tick mark color. Will also implicitly call
     * {@link #setDrawTickMarks(boolean)} with true.
     * 
     * @param tickMarkColor
     *            the tickMarkColor to set
     */
    public void setTickMarkColor(final Color tickMarkColor) {
        if (tickMarkColor != null) {
            setDrawTickMarks(true);
            this.tickMarkColor = tickMarkColor;
        }
    }

    /**
     * Define an axis style.
     *
     * @param textColor
     *            color of text displayed along the axis. Cannot be null.
     * @param fontSize
     *            font size of text displayed along the axis. Must be > 0.
     * @param alignment
     *            alignment of text along the axis with respect to the axis tick
     *            marks. Only works for horizontal axes. Cannot be null.
     * @return the new constructed axis style
     */
    public static AxisStyle newAxisStyle(final Color textColor, final int fontSize, final AxisTextAlignment alignment) {
        checkNotNull(textColor, "color must not be null");
        checkArgument(fontSize > 0, "fontsize must be > 0");
        checkNotNull(alignment, "alignment must not be null");
        return new AxisStyle(textColor, fontSize, alignment);
    }
    
    /**
     * Copy constructor.
     * 
     * @param axisStyle
     *            the axis style
     * 
     * @return the axis style
     */
    static AxisStyle newAxisStyle(final AxisStyle axisStyle) {
        if (axisStyle == null) {
            return null;
        }
        final AxisStyle as = new AxisStyle(axisStyle.textColor, axisStyle.fontSize, axisStyle.alignment);
        as.areTickMarksDrawn = axisStyle.areTickMarksDrawn;
        as.tickMarkColor = axisStyle.tickMarkColor;
        as.tickMarkLength = axisStyle.tickMarkLength;
        return as;
    }
    
    /**
     * Here is the deal with this very strange copy constructor. There is
     * currently a bug in the Google Chart API where the alignment is reversed
     * with respect to what is specified in the documentation:
     * http://code.google.com/apis/chart/labels.html#axis_styles. This method
     * simply swaps right and left axis text alignment. Note also that the
     * alignments are *correct* for the radar chart's concentric axis labels, so
     * there is no need for this adjustment with radar charts. For more
     * information, see the discussion here:
     * 
     * http://groups.google.com/group/google-chart-api/browse_thread/thread/c70760a4437cf945/810fa2ef6dbddd1d?show_docid=810fa2ef6dbddd1d
     * 
     * @param axisStyle
     *            the axis style
     * 
     * @return the axis style
     */
    static AxisStyle correctAxisStyle(final AxisStyle axisStyle) {
        if (axisStyle == null) {
            return null;
        }

        final AxisStyle as;
        switch (axisStyle.alignment) {
        case RIGHT:
            as = newAxisStyle(axisStyle.textColor, axisStyle.fontSize, AxisTextAlignment.LEFT);
            break;
        case LEFT:
            as = newAxisStyle(axisStyle.textColor, axisStyle.fontSize, AxisTextAlignment.RIGHT);
            break;
        default:
            as = newAxisStyle(axisStyle);
            break;
        }
        as.areTickMarksDrawn = axisStyle.areTickMarksDrawn;
        as.tickMarkColor = axisStyle.tickMarkColor;
        as.tickMarkLength = axisStyle.tickMarkLength;
        return as;
    }
}