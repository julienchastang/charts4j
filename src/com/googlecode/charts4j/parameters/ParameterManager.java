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

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import com.googlecode.charts4j.AxisTextAlignment;
import com.googlecode.charts4j.Color;
import com.googlecode.charts4j.Data;
import com.googlecode.charts4j.DataEncoding;
import com.googlecode.charts4j.GeographicalArea;
import com.googlecode.charts4j.LegendPosition;
import com.googlecode.charts4j.LineStyle;
import com.googlecode.charts4j.Marker;
import com.googlecode.charts4j.Priority;
import com.googlecode.charts4j.collect.ImmutableList;
import com.googlecode.charts4j.collect.Lists;
import com.googlecode.charts4j.collect.Maps;

/**
 * <b>For Charts4J internal use only.</b> The ParameterManager contains all
 * the parameters for a given chart that is being built up. These parameters
 * will eventually be serialized to a string.
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 */
public final class ParameterManager {

    /** The parameter map. */
    private final Map<Class<? extends Parameter>, Parameter> parameterMap = Maps.newHashMap();

    /** The Google Chart API URL. */
    private final String                        url;

    /**
     * Instantiates a new parameter manager with the Google Chart API URL.
     *
     * @param url
     *            the url
     */
    public ParameterManager(final String url) {
        this.url = url;
    }

    /**
     * Inits the.
     */
    public void init() {
        parameterMap.clear();
    }

    /**
     * Adds the axis label position.
     *
     * @param index
     *            the index
     * @param positions
     *            the positions
     */
    public void addAxisLabelPosition(final int index, final ImmutableList<? extends Number> positions) {
        getParameter(AxisLabelPositionsParameter.class).addLabelPosition(index, positions);
    }

    /**
     * Adds the axis labels.
     *
     * @param index
     *            the index
     * @param labels
     *            the labels
     */
    public void addAxisLabels(final int index, final ImmutableList<? extends String> labels) {
        getParameter(AxisLabelsParameter.class).addAxisLabels(index, labels);
    }

    /**
     * Adds the axis range.
     *
     * @param index
     *            the index
     * @param startOfRange
     *            the start of range
     * @param endOfRange
     *            the end of range
     */
    public void addAxisRange(final int index, final double startOfRange, final double endOfRange) {
        getParameter(AxisRangesParameter.class).addAxisRange(index, startOfRange, endOfRange);
    }

    /**
     * Adds the axis style.
     *
     * @param index
     *            the index
     * @param color
     *            the color
     * @param fontSize
     *            the font size
     * @param alignment
     *            the alignment
     */
    public void addAxisStyle(final int index, final Color color, final int fontSize, final AxisTextAlignment alignment) {
        getParameter(AxisStylesParameter.class).addAxisStyle(index, color, fontSize, alignment);
    }

    /**
     * Adds the axis types.
     *
     * @param axisTypes
     *            the axis types
     */
    public void addAxisTypes(final AxisTypes axisTypes) {
        getParameter(AxisTypesParameter.class).addAxisTypes(axisTypes);
    }

    /**
     * Sets the bar chart width and spacing parameter.
     *
     * @param width
     *            the width
     * @param spaceBetweenBarsInGroup
     *            the space between bars in group
     * @param spaceBetweenGroups
     *            the space between groups
     */
    public void setBarChartWidthAndSpacingParameter(final int width, final int spaceBetweenBarsInGroup, final int spaceBetweenGroups) {
        final BarChartWidthAndSpacingParameter p = new BarChartWidthAndSpacingParameter(width, spaceBetweenBarsInGroup, spaceBetweenGroups);
        parameterMap.put(BarChartWidthAndSpacingParameter.class, p);
    }

    /**
     * Sets the bar chart zero line parameter.
     *
     * @param d
     *            the new bar chart zero line parameter
     */
    public void setBarChartZeroLineParameter(final double d) {
        getParameter(BarChartZeroLinesParameter.class).addZeroLine(d);
    }

    /**
     * Adds the linear gradient fill.
     *
     * @param fillType
     *            the fill type
     * @param angle
     *            the angle
     * @param colorAndOffsets
     *            the color and offsets
     */
    public void addLinearGradientFill(final FillType fillType, final int angle, final ImmutableList<? extends ColorAndOffset> colorAndOffsets) {
        getParameter(ChartFillsParameter.class).addLinearGradientFill(fillType, angle, colorAndOffsets);
    }

    /**
     * Adds the linear stripe fill.
     *
     * @param fillType
     *            the fill type
     * @param angle
     *            the angle
     * @param colorAndWidths
     *            the color and widths
     */
    public void addLinearStripeFill(final FillType fillType, final int angle, final ImmutableList<? extends ColorAndWidth> colorAndWidths) {
        getParameter(ChartFillsParameter.class).addLinearStripeFill(fillType, angle, colorAndWidths);
    }

    /**
     * Adds the solid fill.
     *
     * @param solidFillType
     *            the solid fill type
     * @param color
     *            the color
     */
    public void addSolidFill(final SolidFillType solidFillType, final Color color) {
        getParameter(ChartFillsParameter.class).addSolidFill(solidFillType, color);
    }

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
    public void addFillAreaMarker(final FillAreaType fillAreaType, final Color color, final int startLineIndex, final int endLineIndex) {
        getParameter(ChartMarkersParameter.class).addFillAreaMarker(fillAreaType, color, startLineIndex, endLineIndex);
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
    public void addLineStyleMarker(final Color color, final int dataSetIndex, final int dataPoint, final int size, final Priority priority) {
        getParameter(ChartMarkersParameter.class).addLineStyleMarker(color, dataSetIndex, dataPoint, size, priority);
    }

    /**
     * Add a marker to the plot.
     *
     * @param marker
     *            the marker
     * @param dataSetIndex
     *            the data set index
     * @param dataPoint
     *            the data point
     */
    public void addMarker(final Marker marker, final int dataSetIndex, final int dataPoint) {
        getParameter(ChartMarkersParameter.class).addMarker(marker, dataSetIndex, dataPoint);
    }

    /**
     * Add markers to each point on the plot.
     *
     * @param marker
     *            the marker
     * @param dataSetIndex
     *            the data set index
     */
    public void addMarkers(final Marker marker, final int dataSetIndex) {
        getParameter(ChartMarkersParameter.class).addMarkers(marker, dataSetIndex);
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
    public void addVerticalRangeMarker(final Color color, final double startPoint, final double endPoint) {
        getParameter(ChartMarkersParameter.class).addVerticalRangeMarker(color, startPoint, endPoint);
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
    public void addHorizontalRangeMarker(final Color color, final double startPoint, final double endPoint) {
        getParameter(ChartMarkersParameter.class).addHorizontalRangeMarker(color, startPoint, endPoint);
    }

    /**
     * Sets the chart size parameter.
     *
     * @param width
     *            the width
     * @param height
     *            the height
     */
    public void setChartSizeParameter(final int width, final int height) {
        final ChartSizeParameter p = new ChartSizeParameter(width, height);
        parameterMap.put(ChartSizeParameter.class, p);
    }

    /**
     * Sets the chart title color and size parameter.
     *
     * @param color
     *            the color
     * @param fontSize
     *            the font size
     */
    public void setChartTitleColorAndSizeParameter(final Color color, final int fontSize) {
        final ChartTitleColorAndSizeParameter p = new ChartTitleColorAndSizeParameter(color, fontSize);
        parameterMap.put(ChartTitleColorAndSizeParameter.class, p);
    }

    /**
     * Sets the chart title parameter.
     *
     * @param title
     *            the new chart title parameter
     */
    public void setChartTitleParameter(final String title) {
        final ChartTitleParameter p = new ChartTitleParameter(title);
        parameterMap.put(ChartTitleParameter.class, p);
    }

    /**
     * Sets the chart type parameter.
     *
     * @param chartType
     *            the new chart type parameter
     */
    public void setChartTypeParameter(final ChartType chartType) {
        final ChartTypeParameter p = new ChartTypeParameter(chartType);
        parameterMap.put(ChartTypeParameter.class, p);
    }

    /**
     * Adds the color.
     *
     * @param color
     *            the color
     */
    public void addColor(final Color color) {
        getParameter(ColorsParameter.class).addColors(Lists.of(color));
    }

    /**
     * Adds the colors.
     *
     * @param colors
     *            the colors
     */
    public void addColors(final ImmutableList<? extends Color> colors) {
        getParameter(ColorsParameter.class).addColors(colors);
    }

    /**
     * Adds the legend.
     *
     * @param legend
     *            the legend
     */
    public void addLegend(final String legend) {
        getParameter(DataLegendsParameter.class).addLegends(Lists.of(legend));
    }

    /**
     * Adds the legends.
     *
     * @param legends
     *            the legends
     */
    public void addLegends(final ImmutableList<? extends String> legends) {
        getParameter(DataLegendsParameter.class).addLegends(legends);
    }

    /**
     * Adds the data.
     *
     * @param data
     *            the data
     */
    public void addData(final Data data) {
        getParameter(DataParameter.class).addData(data);
    }

    /**
     * Sets the data encoding.
     *
     * @param dataEncoding
     *            the new data encoding
     */
    public void setDataEncoding(final DataEncoding dataEncoding) {
        getParameter(DataParameter.class).setDataEncoding(dataEncoding);
    }

    /**
     * Adds the geo code.
     *
     * @param geoCode
     *            the geo code
     */
    public void addGeoCode(final String geoCode) {
        getParameter(GeoCodesParameter.class).addGeoCode(geoCode);
    }

    /**
     * Sets the geographical area parameter.
     *
     * @param geographicalArea
     *            the new geographical area parameter
     */
    public void setGeographicalAreaParameter(final GeographicalArea geographicalArea) {
        final GeographicalAreaParameter p = new GeographicalAreaParameter(geographicalArea);
        parameterMap.put(GeographicalAreaParameter.class, p);
    }

    /**
     * Sets the grid line parameter.
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
    public void setGridLineParameter(final double xAxisStepSize, final double yAxisStepSize, final int lengthOfLineSegment, final int lengthOfBlankSegment) {
        final GridLineParameter p = new GridLineParameter(xAxisStepSize, yAxisStepSize, lengthOfLineSegment, lengthOfBlankSegment);
        parameterMap.put(GridLineParameter.class, p);
    }

    /**
     * Sets the legend position parameter.
     *
     * @param legendPosition
     *            the new legend position parameter
     */
    public void setLegendPositionParameter(final LegendPosition legendPosition) {
        final LegendPositionParameter p = new LegendPositionParameter(legendPosition);
        parameterMap.put(LegendPositionParameter.class, p);
    }

    /**
     * Adds the line chart line style.
     *
     * @param lineStyle
     *            the line style
     */
    public void addLineChartLineStyle(final LineStyle lineStyle) {
        getParameter(LineChartLineStylesParameter.class).addLineStyle(lineStyle);
    }

    /**
     * Adds the pie chart and google o meter legend.
     *
     * @param legend
     *            the legend
     */
    public void addPieChartAndGoogleOMeterLegend(final String legend) {
        getParameter(PieChartAndGoogleOMeterLegendParameter.class).addLegend(legend);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        final Collection<Parameter> c = parameterMap.values();
        final List<String> parameters = Lists.newLinkedList();

        for (Parameter p : c) {
            final String paramString = p.toURLParameterString();
            if (!"".equals(paramString)) {
                parameters.add(paramString);
            }
        }

        Collections.sort(parameters, new Comparator<String>() {
            public int compare(final String s1, final String s2) {
                return s1.length() - s2.length();
            }
        });

        int cnt = 0;
        final StringBuilder sb = new StringBuilder(url + "?");
        for (String p : parameters) {
            sb.append(cnt++ > 0 ? "&" + p : p);
        }
        return sb.toString();
    }

    /**
     * Get the parameter.
     *
     * @param <T>
     *            type of parameter to retrieve
     * @param clazz
     *            the class of the parameter to retrieve
     *
     * @return the parameter
     * @throws ParameterInstantiationException
     *             if the parameter could not be instantiated
     */
    private <T extends Parameter> T getParameter(final Class<T> clazz) throws ParameterInstantiationException {
        //Should always be safe.
        @SuppressWarnings("unchecked")
        T p = (T) parameterMap.get(clazz);
        if (p == null) {
            try {
                p = clazz.newInstance();
            } catch (InstantiationException e) {
                throw new ParameterInstantiationException("Internal error: Could not instatiate " + clazz.getName(), e);
            } catch (IllegalAccessException e) {
                throw new ParameterInstantiationException("Internal error: Could not instatiate " + clazz.getName(), e);
            }
            parameterMap.put(clazz, p);
        }
        return p;
    }

    /**
     * The exception class for cases where the parameter cannot be instantiated
     * through reflection.
     */
    public static class ParameterInstantiationException extends RuntimeException {

        /** The serial version uid. */
        private static final long serialVersionUID = -7837316818196725716L;

        /**
         * Instantiates a new parameter instantiation exception.
         *
         * @param message
         *            the message
         * @param cause
         *            the cause
         */
        private ParameterInstantiationException(final String message, final Throwable cause) {
            super(message, cause);
        }
    }
}
