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

import java.util.List;

import com.googlecode.charts4j.collect.Lists;

/**
 * Abstract type that represents all charts that support {@link Marker}s.
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 *
 */
public abstract class AbstractMarkableChart extends AbstractAxisChart {

    /** Collection of vertical range markers. **/
    private final List<VerticalRangeMarker>   verticalRangeMarkers   = Lists.newLinkedList();

    /** Collection of horizontal range markers. **/
    private final List<HorizontalRangeMarker> horizontalRangeMarkers = Lists.newLinkedList();

    /**
     * AbstractMarkableChart constructor.
     */
    AbstractMarkableChart() {
        super();
    }

    /**
     * Add a vertical range marker.
     *
     * @param startPoint
     *            the position on the x-axis at which the range starts where 0
     *            is leftmost and 100 rightmost.
     * @param endPoint
     *            the position on the x-axis at which the range starts where 0
     *            is leftmost and 100 rightmost.
     * @param color
     *            color of range marker.
     */
    public final void addVerticalRangeMarker(final double startPoint, final double endPoint, final Color color) {
        checkRangeArgs(startPoint, endPoint);
        checkNotNull(color, "Color cannot be null.");
        verticalRangeMarkers.add(new VerticalRangeMarker(color, startPoint, endPoint));
    }

    /**
     * Add a radial axis range marker. Package private method to be accessed by
     * {@link RadarChart} class only.
     *
     * @param startPoint
     *            the 0 position is at 12 o'clock, 50 is at 6 o'clock, and 100
     *            is at 12 o'clock.
     * @param endPoint
     *            the 0 position is at 12 o'clock, 50 is at 6 o'clock, and 100
     *            is at 12 o'clock.
     * @param color
     *            color of range marker. Cannot be null.
     */
    final void addRadialAxisRangeMarker(final double startPoint, final double endPoint, final Color color) {
        checkRangeArgs(startPoint, endPoint);
        checkNotNull(color, "Color cannot be null.");
        // Curiously radial axis range markers for radar charts are from 0 to 800.
        verticalRangeMarkers.add(new VerticalRangeMarker(color, startPoint * 8, endPoint * 8));
    }
    /**
     * Add a horizontal range marker.
     *
     * @param startPoint
     *            the position on the y-axis at which the range starts where 0
     *            is the bottom and 100 is the top.
     * @param endPoint
     *            the position on the y-axis at which the range ends where 0 is
     *            the bottom and 100 is the top.
     * @param color
     *            color of range marker. Cannot be null.
     */
    public final void addHorizontalRangeMarker(final double startPoint, final double endPoint, final Color color) {
        checkRangeArgs(startPoint, endPoint);
        checkNotNull(color, "Color cannot be null.");
        horizontalRangeMarkers.add(new HorizontalRangeMarker(color, startPoint, endPoint));
    }

    /**
     *
     * Check the range arguments.
     *
     * @param startPoint
     *            the position on the axis at which the range starts where 0 is
     *            the bottom and 100 is the top.
     * @param endPoint
     *            the position on the axis at which the range ends where 0 is
     *            the bottom and 100 is the top.
     */
    private void checkRangeArgs(final double startPoint, final double endPoint) {
        checkArgument(startPoint >= Data.MIN_VALUE && startPoint <= Data.MAX_VALUE, "must be between 0 and 100 : %s", startPoint);
        checkArgument(endPoint >= Data.MIN_VALUE && endPoint <= Data.MAX_VALUE, "must be between 0 and 100 : %s", endPoint);
        checkArgument(startPoint < endPoint, "start point must be < end point : %s %s", startPoint, endPoint);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void prepareData() {
        super.prepareData();
        for (RangeMarker m : horizontalRangeMarkers) {
            parameterManager.addHorizontalRangeMarker(m.getColor(), m.getStartPoint() / Data.MAX_VALUE, m.getEndPoint() / Data.MAX_VALUE);
        }
        for (RangeMarker m : verticalRangeMarkers) {
            parameterManager.addVerticalRangeMarker(m.getColor(), m.getStartPoint() / Data.MAX_VALUE, m.getEndPoint() / Data.MAX_VALUE);
        }
    }

    /**
     * Encapsulating range marker information.
     *
     * @author Julien Chastang (julien.c.chastang at gmail dot com)
     *
     */
    private static class RangeMarker {
        /** Range maker color. **/
        private final Color  color;

        /** Range marker start. **/
        private final double startPoint;

        /** Range marker end. **/
        private final double endPoint;

        /**
         * RangeMarker constructor.
         *
         * @param color
         *            range marker color.
         * @param startPoint
         *            range start point.
         * @param endPoint
         *            range end point.
         */
        private RangeMarker(final Color color, final double startPoint, final double endPoint) {
            this.color = color;
            this.startPoint = startPoint;
            this.endPoint = endPoint;
        }

        /**
         * Get the range color.
         *
         * @return the range color.
         */
        private Color getColor() {
            return color;
        }

        /**
         * Get the range start point.
         *
         * @return the range start point.
         */
        private double getStartPoint() {
            return startPoint;
        }

        /**
         * Get the range end point.
         *
         * @return the range end point.
         */
        private double getEndPoint() {
            return endPoint;
        }
    }

    /**
     * Encapsulating vertical range marker information.
     *
     * @author Julien Chastang (julien.c.chastang at gmail dot com)
     *
     */
    private static final class VerticalRangeMarker extends RangeMarker {

        /**
         * Vertical range marker constructor.
         *
         * @param color
         *            range marker color.
         * @param startPoint
         *            range start point.
         * @param endPoint
         *            range end point.
         */
        private VerticalRangeMarker(final Color color, final double startPoint, final double endPoint) {
            super(color, startPoint, endPoint);
        }
    }

    /**
     * Encapsulating horizontal range marker information.
     *
     * @author Julien Chastang (julien.c.chastang at gmail dot com)
     *
     */
    
    private static final class HorizontalRangeMarker extends RangeMarker {

        /**
         * Horizontal range marker constructor.
         *
         * @param color
         *            range marker color.
         * @param startPoint
         *            range start point.
         * @param endPoint
         *            range end point.
         */
        private HorizontalRangeMarker(final Color color, final double startPoint, final double endPoint) {
            super(color, startPoint, endPoint);
        }
    }
}
