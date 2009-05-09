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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.googlecode.charts4j.collect.Lists;
import com.googlecode.charts4j.collect.PrimitiveArrays;

/**
 * Static factory class for {@link AxisLabels}.
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 *
 */
public final class AxisLabelsFactory {

    /**
     * Static factory class can never be instantiated.
     */
    private AxisLabelsFactory() {
        throw new AssertionError();
    }

    /**
     * Labels are placed on the axis according to the positions argument.
     * Positions must be expressed between 0 and 100 consistent with the rest of
     * this API.
     *
     * @param labels
     *            Labels that will be displayed along side the axis. Cannot be
     *            null or contain a null.
     * @param positions
     *            Positions of labels expressed between 0 and 100.
     *
     * @return AxisLabels
     */
    public static AxisLabels newAxisLabels(final List<? extends String> labels, final List<? extends Number> positions) {
        checkContentsNotNull(labels, "labels list is null or contains a null value");
        checkContentsNotNull(positions, "positions list is null or contains a null value");
        if (!labels.isEmpty() && !positions.isEmpty()) {
            // if no labels, positions will be used as labels
            checkArgument(labels.size() == positions.size(), "There must be the same number of labels as positions.");
            for (Number n : positions) {
                checkArgument(n.doubleValue() >= Data.MIN_VALUE && n.doubleValue() <= Data.MAX_VALUE, "position does not fall between " + Data.MIN_VALUE + " and " + Data.MAX_VALUE + " range");
            }
        }
        return new AxisLabelsImpl(labels, positions);
    }

    /**
     * Labels will be placed uniformly along the axis.
     *
     * @param labels
     *            Labels that will be displayed along side the axis.
     *
     * @return AxisLabels
     */
    public static AxisLabels newAxisLabels(final List<? extends String> labels) {
        checkContentsNotNull(labels, "labels list is null or contains a null value");
        return newAxisLabels(labels, Collections.<Number> emptyList());
    }

    /**
     * Labels will be placed uniformly along the axis.
     *
     * @param labels
     *            Labels that will be displayed along side the axis.
     *
     * @return AxisLabels
     */
    public static AxisLabels newAxisLabels(final String... labels) {
        checkContentsNotNull(Arrays.asList(labels), "labels list is null or contains a null value");
        return newAxisLabels(Arrays.asList(labels), Collections.<Number>emptyList());
    }

    /**
     * Labels will be placed uniformly around a radar chart.
     *
     * @param labels
     *            Labels that will be displayed around a radar chart.
     *
     * @return RadialAxisLabels
     * @see RadarChart
     */
    public static RadialAxisLabels newRadialAxisLabels(final List<? extends String> labels) {
        return (RadialAxisLabels)newAxisLabels(labels, Collections.<Number> emptyList());
    }

    /**
     * Labels will be placed uniformly around a radar chart.
     *
     * @param labels
     *            Labels that will be displayed around a radar chart.
     *
     * @return RadialAxisLabels
     * @see RadarChart
     */
    public static RadialAxisLabels newRadialAxisLabels(final String... labels) {
        return (RadialAxisLabels)newAxisLabels(Arrays.asList(labels), Collections.<Number> emptyList());
    }



    /**
     * This method is useful for placing a label along the axis at a specific
     * location.
     *
     * @param label
     *            Label that will be displayed along side the axis. Cannot be
     *            null.
     * @param position
     *            Position of label. Must be between 0 and 100.
     *
     * @return AxisLabels
     *
     */
    public static AxisLabels newAxisLabels(final String label, final double position) {
        checkNotNull(label, "label cannot be null.");
        return newAxisLabels(Lists.of(label), Lists.of(position));
    }

    /**
     * This method takes an arbitrary list of numbers that will be placed
     * proportionally along the axis.
     *
     * @param values
     *            Values along the start and end range. Cannot be null or
     *            contain a null.
     *
     * @return AxisLabels
     *
     */
    public static AxisLabels newNumericAxisLabels(final List<? extends Number> values) {
        return newAxisLabels(Collections.<String> emptyList(), values);
    }

    /**
     * This method takes an arbitrary list of numbers that will be placed
     * proportionally along the axis.
     *
     * @param values
     *            Values along the start and end range. Cannot be null or
     *            contain a null.
     *
     * @return AxisLabels
     *
     */
    public static AxisLabels newNumericAxisLabels(final double... values) {
        checkNotNull(values, "values cannot be null.");
        return newNumericAxisLabels(PrimitiveArrays.asList(values));
    }

    /**
     * Define a range on the axis. Values are evenly spaced between the min and
     * max range.
     *
     * @param minRange
     *            The start of the range.
     * @param maxRange
     *            The end of the range.
     *
     * @return AxisLabels
     */
    public static AxisLabels newNumericRangeAxisLabels(final double minRange, final double maxRange) {
        return new AxisLabelsImpl(minRange, maxRange, Double.NaN);
    }

    /**
     * Define a range on the axis. Values are evenly spaced between the min and
     * max range according to the interval.
     *
     * @param minRange
     *            The start of the range.
     * @param maxRange
     *            The end of the range.
     * @param interval
     *            The numeric label interval.
     *
     * @return AxisLabels
     */
    public static AxisLabels newNumericRangeAxisLabels(final double minRange, final double maxRange, final double interval) {
        return new AxisLabelsImpl(minRange, maxRange, interval);
    }
}
