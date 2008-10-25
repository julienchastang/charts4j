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
 * <b>For Charts4j internal use only.</b>. The Enum ChartType.
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 */
public enum ChartType {

    /** The map chart. */
    MAP_CHART("t"),
    /** The line chart. */
    LINE_CHART("lc"),
    /** The sparkline chart. */
    SPARKLINE_CHART("ls"),
    /** The xy line chart. */
    XY_LINE_CHART("lxy"),
    /** The pie chart. */
    PIE_CHART("p"),
    /** The 3d pie chart. */
    THREE_D_PIE_CHART("p3"),
    /** The google-o-meter. */
    GOOGLE_O_METER("gom"),
    /** The radar chart. */
    RADAR_CHART("r"),
    /** The radar spline chart. */
    RADAR_SPLINE_CHART("rs"),
    /** The venn diagram. */
    VENN_DIAGRAM("v"),
    /** The scatter chart. */
    SCATTER_CHART("s"),
    /** The vertical stacked bar chart. */
    VERTICAL_STACKED_BAR_CHART("bvs"),
    /** The horizontal stacked bar chart. */
    HORIZONTAL_STACKED_BAR_CHART("bhs"),
    /** The vertical grouped bar chart. */
    VERTICAL_GROUPED_BAR_CHART("bvg"),
    /** The horizontal grouped bar chart. */
    HORIZONTAL_GROUPED_BAR_CHART("bhg");

    /** String for the Google Chart API parameter. */
    private final String chartTypeString;

    /**
     * Instantiating enum.
     *
     * @param chartType
     *            the string for the Google Chart API parameter
     */
    private ChartType(final String chartType) {
        this.chartTypeString = chartType;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return chartTypeString;
    }
}
