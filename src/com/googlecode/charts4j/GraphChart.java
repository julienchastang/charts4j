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

/**
 * Interface for all charts that support legend positions. (MapChart,
 * GoogleOMeter and PieChart do not support legend positions.)
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 *
 */
public interface GraphChart {

    /**
     * Specify where the chart legends will appear.
     *
     * @param legendPosition
     *            The legend position. Cannot be null.
     */
    void setLegendPosition(final LegendPosition legendPosition);

    /**
     * Specify chart area fill.
     *
     * @param fill
     *            Chart area fill. Cannot be null. This mutable parameter is
     *            defensively copied upon entry.
     */
    void setAreaFill(final Fill fill);
}
