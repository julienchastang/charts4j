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

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;

import com.googlecode.charts4j.Color;
import com.googlecode.charts4j.Data;
import com.googlecode.charts4j.Marker;
import com.googlecode.charts4j.Priority;
import com.googlecode.charts4j.ShapeMarker;
import com.googlecode.charts4j.TextMarker;
import com.googlecode.charts4j.collect.Lists;

/**
 * Class for building chart markers parameter string for the Google Chart API.
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 */
final class ChartMarkersParameter extends AbstractParameter {

    /** The Google Chart API chart markers parameter. */
    private static final String           URL_PARAMETER_KEY = "chm";

    /** The markers. */
    private final List<GoogleChartMarker> markers           = Lists.newLinkedList();

    /**
     * Adds the fill area marker.
     *
     * @param fillAreaType
     *            the fill area type
     * @param color
     *            the color
     * @param startLineIndex
     *            the start line index
     * @param endLineIndex
     *            the end line index
     */
    void addFillAreaMarker(final FillAreaType fillAreaType, final Color color, final int startLineIndex, final int endLineIndex) {
        markers.add(new FillAreaMarker(fillAreaType, color, startLineIndex, endLineIndex));
    }

    /**
     * Adds the line style marker.
     *
     * @param color
     *            the color
     * @param dataSetIndex
     *            the data set index
     * @param dataPoint
     *            the data point
     * @param size
     *            the size
     * @param priority
     *            the priority
     */
    void addLineStyleMarker(final Color color, final int dataSetIndex, final int dataPoint, final int size, final Priority priority) {
        markers.add(new LineStyleMarker(color, dataSetIndex, dataPoint, size, priority));
    }

    /**
     * Adds the marker.
     *
     * @param marker
     *            the marker
     * @param dataSetIndex
     *            the data set index
     * @param startIndex
     *            The start index for the marker range.
     * @param endIndex
     *            The end index for the marker range.
     * @param n
     *            Marker on every n-th data point.
     */
    void addMarker(final Marker marker, final int dataSetIndex, final int startIndex, final int endIndex, final int n) {
        if (marker instanceof ShapeMarker) {
            markers.add(new ShapeMarkerParam((ShapeMarker) marker, dataSetIndex, startIndex, endIndex, n));
        } else if (marker instanceof TextMarker) {
            markers.add(new TextMarkerParam((TextMarker) marker, dataSetIndex, startIndex, endIndex, n));
        }
    }

    /**
     * Add marker to each point on the plot.
     *
     * @param marker
     *            the marker
     * @param dataSetIndex
     *            the data set index
     */
    void addMarkers(final Marker marker, final int dataSetIndex) {
        //-1 adds the same shape marker to each point on the plot.
        addMarker(marker, dataSetIndex, -1, 0, 0);
    }


    /**
     * Adds the vertical range marker.
     *
     * @param color
     *            the color
     * @param startPoint
     *            the start point
     * @param endPoint
     *            the end point
     */
    void addVerticalRangeMarker(final Color color, final double startPoint, final double endPoint) {
        markers.add(new RangeMarker(RangeType.VERTICAL, color, startPoint, endPoint));
    }

    /**
     * Adds the horizontal range marker.
     *
     * @param color
     *            the color
     * @param startPoint
     *            the start point
     * @param endPoint
     *            the end point
     */
    void addHorizontalRangeMarker(final Color color, final double startPoint, final double endPoint) {
        markers.add(new RangeMarker(RangeType.HORIZONTAL, color, startPoint, endPoint));
    }

    /**
     * Adds the free marker.
     *
     * @param marker
     *            the marker
     * @param xPos
     *            the x pos
     * @param yPos
     *            the y pos
     */
    void addFreeMarker(final Marker marker, final double xPos, final double yPos) {
        markers.add(new FreeMarker(marker, xPos, yPos));
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
        final StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (GoogleChartMarker m : markers) {
            sb.append(cnt++ > 0 ? "|" : "").append(m);
        }
        return !markers.isEmpty() ? sb.toString() : "";
    }

    /**
     * The GoogleChartMarker tag interface.
     */
    private interface GoogleChartMarker {
    }

    /**
     * The Class GMarker.
     */
    private static class GMarker implements GoogleChartMarker {

        /** The marker. */
        private final String   marker;

        /** The color. */
        private final Color    color;

        /** The data set index. */
        private final int      dataSetIndex;

        /** The start index. */
        private final int      startIndex;

        /** The end index. */
        private final int      endIndex;

        /** The periodicity. */
        private final int      n;

        /** The size. */
        private final int      size;

        /** The priority. */
        private final Priority priority;

        /**
         * Instantiates a new g marker.
         *
         * @param marker
         *            the marker
         * @param color
         *            the color
         * @param dataSetIndex
         *            the data set index
         * @param startIndex
         *            The start index for the marker range.
         * @param endIndex
         *            The end index for the marker range.
         * @param n
         *            Marker on every n-th data point.
         * @param size
         *            the size
         * @param priority
         *            the priority
         */
        private GMarker(final String marker, final Color color, final int dataSetIndex, final int startIndex, final int endIndex, final int n, final int size, final Priority priority) {
            this.marker = marker;
            this.color = color;
            this.dataSetIndex = dataSetIndex;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
            this.n = n;
            this.size = size;
            this.priority = priority;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            final String returnString;
            if (startIndex >= 0 && endIndex == startIndex + 1) {
                returnString =  marker + "," + color + "," + dataSetIndex + "," + startIndex + "," + size + "," + priority;
            }
            else if (startIndex == -1) {
                returnString =  marker + "," + color + "," + dataSetIndex + "," + startIndex + "," + size + "," + priority;
            }
            else {//(endIndex - 1)  ---> The GCA is end point inclusive.
                returnString =  marker + "," + color + "," + dataSetIndex + "," + startIndex + ":" + (endIndex - 1) + ":" + n + "," + size + "," + priority;
            }
            return returnString;
        }
    }

    /**
     * The Class LineStyleMarker.
     */
    private static final class LineStyleMarker extends GMarker implements GoogleChartMarker {

        /**
         * Instantiates a new line style marker.
         *
         * @param color
         *            the color
         * @param dataSetIndex
         *            the data set index
         * @param dataPoint
         *            the data point
         * @param size
         *            the size
         * @param priority
         *            the priority
         */
        private LineStyleMarker(final Color color, final int dataSetIndex, final int dataPoint, final int size, final Priority priority) {
            super("D", color, dataSetIndex, dataPoint, dataPoint + 1, 1, size, priority);
        }
    }

    /**
     * The Class ShapeMarkerParam.
     */
    private static final class ShapeMarkerParam extends GMarker implements GoogleChartMarker {

        /**
         * Instantiates a new shape marker param.
         *
         * @param shapeMarker
         *            the shape marker
         * @param dataSetIndex
         *            the data set index
         * @param startIndex
         *            The start index for the marker range.
         * @param endIndex
         *            The end index for the marker range.
         * @param n
         *            Marker on every n-th data point.
         */
        private ShapeMarkerParam(final ShapeMarker shapeMarker, final int dataSetIndex, final int startIndex, final int endIndex, final int n) {
            super(shapeMarker.getShape().toString(), shapeMarker.getColor(), dataSetIndex, startIndex, endIndex, n, shapeMarker.getSize(), shapeMarker.getPriority());
        }
    }

    /**
     * The Class TextMarkerParam.
     */
    private static final class TextMarkerParam extends GMarker implements GoogleChartMarker {

        /**
         * Instantiates a new text marker param.
         *
         * @param textMarker
         *            the text marker
         * @param dataSetIndex
         *            the data set index
         * @param startIndex
         *            The start index for the marker range.
         * @param endIndex
         *            The end index for the marker range.
         * @param n
         *            Marker on every n-th data point.
         */
        private TextMarkerParam(final TextMarker textMarker, final int dataSetIndex, final int startIndex, final int endIndex, final int n) {
            super((textMarker.isFlagged() ? "f" : "t") + ParameterUtil.utf8Encode(textMarker.getText()), textMarker.getColor(), dataSetIndex, startIndex, endIndex, n, textMarker.getSize(), textMarker.getPriority());
        }
    }

    /**
     * The Class FillAreaMarker.
     */
    private static final class FillAreaMarker implements GoogleChartMarker {

        /** The fill area type. */
        private final FillAreaType fillAreaType;

        /** The color. */
        private final Color        color;

        /** The start line index. */
        private final int          startLineIndex;

        /** The end line index. */
        private final int          endLineIndex;

        /**
         * Instantiates a new fill area marker.
         *
         * @param fillAreaType
         *            the fill area type
         * @param color
         *            the color
         * @param startLineIndex
         *            the start line index
         * @param endLineIndex
         *            the end line index
         */
        private FillAreaMarker(final FillAreaType fillAreaType, final Color color, final int startLineIndex, final int endLineIndex) {
            this.fillAreaType = fillAreaType;
            this.color = color;
            this.startLineIndex = startLineIndex;
            this.endLineIndex = endLineIndex;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return fillAreaType + "," + color + "," + startLineIndex + "," + endLineIndex + ",0";
        }
    }

    /**
     * The Class RangeMarker.
     */
    private static final class RangeMarker implements GoogleChartMarker {

        /** The range type. */
        private final RangeType rangeType;

        /** The color. */
        private final Color     color;

        /** The start point. */
        private final double    startPoint;

        /** The end point. */
        private final double    endPoint;

        /** The decimal formatter. */
        private final DecimalFormat   decimalFormatter = new DecimalFormat("0.00", new DecimalFormatSymbols(Locale.US));

        /**
         * Instantiates a new range marker.
         *
         * @param rangeType
         *            the range type
         * @param color
         *            the color
         * @param startPoint
         *            the start point
         * @param endPoint
         *            the end point
         */
        private RangeMarker(final RangeType rangeType, final Color color, final double startPoint, final double endPoint) {
            this.rangeType = rangeType;
            this.color = color;
            this.startPoint = startPoint;
            this.endPoint = endPoint;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return rangeType + "," + color + ",0," + decimalFormatter.format(startPoint) + "," + decimalFormatter.format(endPoint);
        }
    }

    /**
     * Private static inner class to encapsulate a FreeMarker.
     */
    private static class FreeMarker implements GoogleChartMarker {

        /** The marker. */
        private final Marker marker;

        /** The x pos. */
        private final double xPos;

        /** The y pos. */
        private final double yPos;

        /**
         * Instantiates a new free marker.
         *
         * @param marker
         *            the marker
         * @param xPos
         *            the x pos
         * @param yPos
         *            the y pos
         */
        private FreeMarker(final Marker marker, final double xPos, final double yPos) {
            this.marker = marker;
            this.xPos = xPos;
            this.yPos = yPos;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            final String s;
            if (marker instanceof TextMarker) {
                final TextMarker m = (TextMarker) marker;
                s = "@" + (m.isFlagged() ? "f" : "t") + m.getText() + "," + m.getColor() + ",0," + xPos / Data.MAX_VALUE + ":" + yPos / Data.MAX_VALUE  + "," + m.getSize()  + "," + m.getPriority();
            } else if (marker instanceof ShapeMarker) {
                final ShapeMarker m = (ShapeMarker) marker;
                s = "@" + m.getShape().toString() + "," + m.getColor() + ",0," + xPos / Data.MAX_VALUE + ":" + yPos / Data.MAX_VALUE  + "," + m.getSize() + "," + m.getPriority();
            } else {
                s = "";
            }
            return s;
        }
    }
}
