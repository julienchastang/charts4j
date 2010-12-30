/**
 *
 * The MIT License
 *  * Copyright (c) 2008 the original author or authors.
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

import java.util.Arrays;
import java.util.List;

import com.googlecode.charts4j.collect.Lists;

/**
 * Type that contains the numeric information that will be rendered in the
 * chart.
 *
 * The constructor and static factory methods in this class take values from 0
 * to 100. If your data does not fall in that range, you need to scale it so it
 * does. This is the case for negative number, for instance. If you are having
 * trouble scaling your data please see {@link DataUtil}.
 *
 * Numbers outside the 0 to 100 range will be considered invalid and will be
 * treated as invalid according to the chart type.
 *
 * For the curious, behind the scenes, the data in this class is converted to
 * the Google Chart API simple, text, or extended encoding.
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 *
 * @see DataUtil
 * @see Plots
 * @see GCharts
 */
public class Data {

    /** Minimum value of data is zero.  **/
    public static final double MIN_VALUE = 0;

    /** Maximum value of data is 100.  **/
    public static final double MAX_VALUE = 100;

    /** Invalid data series.  **/
    public static final Data   INVALID   = newData(-1);

    /** The data array that will ultimately be rendered by the chart.  **/
    private final double[]     data;

    /**
     * The data that will eventually be rendered by a chart. The static factory
     * methods {@link #newData(double...)} and {@link #newData(List)} should be
     * used in preference to this constructor.
     *
     * @param data
     *            Double data. Double values must be between 0 and 100. data
     *            array is defensively copied. Numbers outside the 0 to 100
     *            range will be considered invalid and will be treated as
     *            invalid according to the chart type.
     */
    public Data(final double... data) {
        checkNotNull(data, "data is null or contents of data is null.");
        this.data = data.clone();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return Arrays.toString(data);
    }

    /**
     * Get a copy of the backing array. Original backing array is not visible to
     * the caller.
     *
     * @return copy of double array representing the data.
     */
    public final double[] getData() {
        return data.clone();
    }

    /**
     * Get the size of the dataset.
     *
     * @return Size of the dataset.
     */
    public final int getSize() {
        return data.length;
    }

    /**
     * Static factory method for creating {@link Data} instance.
     *
     * @param data
     *            Double data. Double values must be between 0 and 100. data
     *            array is deep copied so the array reference the client passes
     *            is not kept. Numbers outside the 0 to 100 range will be
     *            considered invalid and will be treated as invalid according to
     *            the chart type.
     * @return Freshly constructed Data object.
     */
    public static Data newData(final double... data) {
        return new Data(data);
    }

    /**
     * Static factory method for creating {@link Data} instance.
     *
     * @param data
     *            Number data. Number values must be between 0 and 100. List is
     *            defensively copied. Numbers outside the 0 to 100 range will be
     *            considered invalid and will be treated as invalid according to
     *            the chart type.
     * @return Freshly constructed Data object.
     */
    public static Data newData(final List<? extends Number> data) {
        checkContentsNotNull(data, "data is null or contents of data is null.");
        return new Data(DataUtil.toDoubleArray(Lists.copyOf(data)));
    }
}
