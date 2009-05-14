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

import static com.googlecode.charts4j.Color.WHITE;
import static com.googlecode.charts4j.collect.Preconditions.*;

import com.googlecode.charts4j.parameters.FillType;
import com.googlecode.charts4j.parameters.ParameterManager;
import com.googlecode.charts4j.parameters.SolidFillType;

/**
 * Contains code common to all charts.
 * 
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 */
abstract class AbstractGChart implements GChart {

    /** Contains accumulation of all parameters set by client. */
    protected final ParameterManager parameterManager = new ParameterManager();

    /** The largest possible area for all charts except maps is 300,000 pixels. */
    private static final int         MAX_PIXELS       = 300000;

    /** Max chart width. */
    private static final int         MAX_WIDTH        = 1000;

    /** Max chart height. */
    private static final int         MAX_HEIGHT       = 1000;

    /** Min chart width. */
    private static final int         MIN_WIDTH        = 0;

    /** Min chart height. */
    private static final int         MIN_HEIGHT       = 0;

    /** Default chart width. */
    private static final int         DEFAULT_WIDTH    = 200;

    /** Default chart height. */
    private static final int         DEFAULT_HEIGHT   = 125;

    /** Max opacity. */
    private static final int         MAX_OPACITY      = 100;

    /** Min opacity. */
    private static final int         MIN_OPACITY      = 0;

    /** Default opacity. */
    private static final int         DEFAULT_OPACITY  = 100;

    /** Width field. */
    private int                      width            = DEFAULT_WIDTH;

    /** Height field. */
    private int                      height           = DEFAULT_HEIGHT;

    /** Background chart fill. */
    private Fill                     backgroundFill;

    /** Chart opacity. */
    private int                      opacity          = DEFAULT_OPACITY;

    /** Data encoding for this chart. */
    private DataEncoding             dataEncoding     = DataEncoding.EXTENDED;

    /** Margins for this chart.  */
    private Margins                  margins;

    /** For configuration of the chart URL endpoint.  */
    private String                   chartURLEndpoint = "http://chart.apis.google.com/chart";

    /**
     * AbstractGChart constructor.
     */
    AbstractGChart() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    public void setSize(final int width, final int height) {
        checkArgument(width * height <= MAX_PIXELS, "The largest possible area for all charts except maps is 300,000 pixels.");
        checkArgument(width > MIN_WIDTH && width <= MAX_WIDTH, "width must be > " + MIN_WIDTH + " and <= " + MAX_WIDTH + ": %s", width);
        checkArgument(height > MIN_HEIGHT && height <= MAX_HEIGHT, "height must be > " + MIN_WIDTH + " and <= " + MAX_WIDTH + ": %s", height);
        this.width = width;
        this.height = height;
    }

    /**
     * {@inheritDoc}
     */
    public final String toURLString() {
        parameterManager.init(chartURLEndpoint);
        prepareData();
        return parameterManager.toString();
    }

    /**
     * {@inheritDoc}
     */
    public final String toURLForHTML() {
        return toURLString().replaceAll("&", "&amp;");
    }

    /**
     * {@inheritDoc}
     */
    public void setBackgroundFill(final Fill fill) {
        checkNotNull(fill, "The background fill cannot be null");
        this.backgroundFill = fill;
    }

    /**
     * {@inheritDoc}
     */
    public void setTransparency(final int opacity) {
        checkArgument(opacity >= MIN_OPACITY && opacity <= MAX_OPACITY, "opacity must be between " + MIN_OPACITY + " and " + MAX_OPACITY + ": %s", opacity);
        this.opacity = opacity;
    }

    /**
     * {@inheritDoc}
     */
    public final void setDataEncoding(final DataEncoding dataEncoding) {
        checkNotNull(dataEncoding, "The data encoding cannot be null");
        this.dataEncoding = dataEncoding;
    }
    
    /**
     * {@inheritDoc}
     */    
    public void setMargins(final int leftMargin, final int rightMargin, final int topMargin, final int bottomMargin) {
        this.margins = new Margins(leftMargin, rightMargin, topMargin, bottomMargin);
    }

    /**
     * Sets the chart URL endpoint. The default end point chart URL is
     * http://chart.apis.google.com/chart. This method is useful in situations
     * where other Internet services support the Google Chart API. For instance,
     * JFreeChart has a Google Chart API emulation called <a
     * href="http://www.jfree.org/eastwood/">Eastwood</a>. API users can supply
     * the Eastwood servlet address as the end point URL.
     * 
     * @param chartURLEndpoint
     *            the new chart url endpoint
     */
    public void setChartURLEndpoint(final String chartURLEndpoint) {
        checkNotNull(chartURLEndpoint, "The chart URL endpoint cannot be null");
        this.chartURLEndpoint = chartURLEndpoint;
    }

    /**
     * Prepare data for URL String formation.
     */
    protected void prepareData() {
        if (backgroundFill instanceof SolidFill) {
            final SolidFill solid = (SolidFill) backgroundFill;
            parameterManager.addSolidFill(SolidFillType.BACKGROUND, solid.getColor());
        } else if (backgroundFill instanceof LinearGradientFill) {
            final LinearGradientFill lg = (LinearGradientFill) backgroundFill;
            parameterManager.addLinearGradientFill(FillType.BACKGROUND, lg.getAngle(), lg.getColorsAndOffsets());
        } else if (backgroundFill instanceof LinearStripesFill) {
            final LinearStripesFill ls = (LinearStripesFill) backgroundFill;
            parameterManager.addLinearStripeFill(FillType.BACKGROUND, ls.getAngle(), ls.getColorsAndWidths());
        }
        if (opacity < DEFAULT_OPACITY) {
            parameterManager.addSolidFill(SolidFillType.TRANSPARENCY, Color.newColor(WHITE, opacity));
        }
        parameterManager.setChartSizeParameter(width, height);
        parameterManager.setDataEncoding(dataEncoding);
        if (margins != null) {
            parameterManager.setMargins(margins.bottomMargin, margins.leftMargin, margins.rightMargin, margins.topMargin);
        }
    }

    /**
     * Inner class that encapsulates the chart margins.
     */
    private static final class Margins {
        
        /** The left margin. */
        private final int leftMargin; 
        
        /** The right margin. */
        private final int rightMargin;
        
        /** The top margin. */
        private final int topMargin;
        
        /** The bottom margin. */
        private final int bottomMargin;
        
        /**
         * Define the chart margins.
         * 
         * @param bottomMargin
         *            the bottom margin
         * @param leftMargin
         *            the left margin
         * @param rightMargin
         *            the right margin
         * @param topMargin
         *            the top margin
         */
        private Margins(final int bottomMargin, final int leftMargin, final int rightMargin, final int topMargin) {
            this.bottomMargin = bottomMargin;
            this.leftMargin   = leftMargin;
            this.rightMargin  = rightMargin;
            this.topMargin    = topMargin;
        }
    }
}
