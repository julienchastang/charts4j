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
import static com.googlecode.charts4j.collect.Preconditions.checkContentsNotNull;
import static com.googlecode.charts4j.collect.Preconditions.checkNotNull;

import java.util.Collections;
import java.util.List;

import com.googlecode.charts4j.collect.ImmutableList;
import com.googlecode.charts4j.collect.Lists;
import com.googlecode.charts4j.collect.PrimitiveArrays;

/**
 * Perusing the <a href="http://groups.google.com/group/google-chart-api">
 * Google Chart API Group</a> reveals that a lot of users and developers are
 * having difficulty scaling their data. A common question is "What do I do
 * about negative numbers?". Or "What if my data lies outside the simple or
 * extended encoding range?" The answer to these problems is that users must
 * scale their data so that they may be rendered in the chart. This class helps
 * users achieve that goal.
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 *
 * @see Data
 * @see Plots
 * @see GCharts
 */
public final class DataUtil {

    /**
     * Constructor must never be called.
     */
    private DataUtil() {
        throw new AssertionError();
    }

    /**
     * Static factory method that will scale data between the min and max. If
     * max equals min or max is less than min, no scaling will occur.
     *
     * Note that the min value can be less than the minimum value of the data
     * and that the max value can be greater than the maximum value of the data.
     * This scenario is useful when you don't want your plot to span the entire
     * chart, but you would like the plots to be "squeezed in" a bit.
     *
     * @param min
     *            The minimum value in the scaling range.
     * @param max
     *            The maximum value in the scaling range.
     * @param data
     *            The data
     * @return A Data object scaled between min and max.
     *
     * @see Data
     */
    public static Data scaleWithinRange(final double min, final double max, final double[] data) {
        checkArgument(max - min > 0, "min >= max!");
        return Data.newData(privateScale(data, min, max));
    }

    /**
     * Static factory method that will scale data between the min and max. If
     * max equals min or max is less than min, no scaling will occur.
     *
     * Note that the min value can be less than the minimum value of the data
     * and that the max value can be greater than the maximum value of the data.
     * This scenario is useful when you don't want your plot to span the entire
     * chart, but you would like the plots to be "squeezed in" a bit.
     *
     * @param min
     *            The minimum value in the scaling range.
     * @param max
     *            The maximum value in the scaling range.
     * @param data
     *            The data list to be scaled. The Number type is used as a
     *            convenience but Numbers that fall outside the
     *            {@link Double#MAX_VALUE} and {@link Double#MIN_VALUE} should
     *            not be used.
     * @return A Data object scaled between min and max.
     * @see Data
     */
    public static Data scaleWithinRange(final double min, final double max, final List<? extends Number> data) {
        return scaleWithinRange(min, max, toDoubleArray(Lists.copyOf(data)));
    }

    /**
     * Static factory method that will simply scale between the minimum and
     * maximum values in the data.
     *
     * @param data
     *            Provide a data series that will be scaled by this method.
     *
     * @return A Data object scaled between minimum and maximum in the provided
     *         data series.
     * @see Data
     */
    public static Data scale(final double... data) {
        checkNotNull(data, "data is null or contents of data is null.");
        final double min = Collections.min(PrimitiveArrays.asList(data));
        final double max = Collections.max(PrimitiveArrays.asList(data));
        checkArgument(min < max, "Cannot scale this data. It is ill conditioned.");
        return Data.newData(privateScale(data, min, max));
    }

    /**
     * Static factory method that will simply scale between the minimum and
     * maximum values in the data.
     *
     * @param data
     *            Provide a data series that will be scaled by this method.
     *
     * @return A Data object scaled between minimum and maximum in the provided
     *         data series. The Number type is used as a convenience but Numbers
     *         that fall outside the {@link Double#MAX_VALUE} and
     *         {@link Double#MIN_VALUE} should not be used.
     * @see Data
     */
    public static Data scale(final List<? extends Number> data) {
        checkContentsNotNull(data, "data is null or contents of data is null.");
        return scale(toDoubleArray(Lists.copyOf(data)));
    }

    /**
     * This method is for scaling multiple data series at once. It is useful in
     * situations where you have multiple plots in one chart, and you want the
     * data consistently scaled by the same factor. The data are scaled between
     * the minimum and maximum data points found for all data. The returned
     * scaled {@link Data} list can be plotted with the guarantee that all the
     * plots will fit on the chart.
     *
     * @param data
     *            the data. The first index is the data series index. The second
     *            is the data series.
     *
     * @return the list of Data objects that can then be plotted.
     */
    public static List<Data> scale(final double data[][]) {
        checkNotNull(data, "data cannot be null");
        final List<Double> allData = Lists.newLinkedList();
        for (double[] d : data) {
            for (double doub : d) {
                allData.add(doub);
            }
        }
        final double min = Collections.min(allData);
        final double max = Collections.max(allData);
        final List<Data> list = Lists.newLinkedList();
        for (double[] d : data) {
            list.add(scaleWithinRange(min, max, d));
        }
        return list;
    }

    /**
     * This method is for scaling multiple data series at once. It is useful in
     * situations where you have multiple plots in one chart, and you want the
     * data consistently scaled by the same factor. The data are scaled between
     * the minimum and maximum data points found for all data. The returned
     * scaled {@link Data} list can be plotted with the guarantee that all the
     * plots will fit on the chart.
     *
     * @param data
     *            the data.
     *
     * @return the list of Data objects that can then be plotted.
     */
    public static List<Data> scale(final List<? extends List<? extends Number>> data) {
        checkContentsNotNull(data, "data is null or contents of data is null.");
        final double[][] d = new double[data.size()][];
        int j = 0;
        for (List<? extends Number> datum : data) {
            checkContentsNotNull(datum, "data is null or contents of data is null.");
            double[] plotData = new double[datum.size()];
            int i = 0;
            for (Number n : datum) {
                plotData[i++] = n.doubleValue();
            }
            d[j++] = plotData;
        }
        return scale(d);
    }

    /**
     * Convert a list of numbers to a double array. Numbers that fall outside
     * the {@link Double.MAX_VALUE} and {@link Double.MIN_VALUE} should not be
     * used.
     *
     * @param data
     *            List of numbers
     * @return a double a array.
     */
    static double[] toDoubleArray(final ImmutableList<? extends Number> data) {
        final double[] d = new double[data.size()];
        for (int i = 0; i < d.length; i++) {
            d[i] = data.get(i).doubleValue();
        }
        return d;
    }

    /**
     * Method that scales the data.
     *
     * @param doubleArray
     *            Data to be scaled. Cannot be null.
     * @param min
     *            Minimum range for scaled data.
     * @param max
     *            Maximum range of scaled data.
     * @return scaled double array
     */
    private static double[] privateScale(final double[] doubleArray, final double min, final double max) {
        checkNotNull(doubleArray, "doubleArray cannot be null");
        checkArgument(max - min > 0, "min > max!");
        final double[] scaledData = new double[doubleArray.length];
        for (int j = 0; j < doubleArray.length; j++) {
            scaledData[j] = ((doubleArray[j] - min) / (max - min)) * Data.MAX_VALUE;
        }
        return scaledData;
    }
}
