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
 * Type that describes the labels that appear on the axes. Construct with the
 * {@link AxisLabelsFactory} class.
 *
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 * @see AxisStyle
 * @see AxisLabelsFactory
 */
public interface AxisLabels extends Kloneable<AxisLabels> {

    /**
     * Set the desired axis style. AxisStyle mutable will be defensively copied
     * upon entry.
     *
     * @param axisStyle
     *            Set the axis style that will define the appearance of the text
     *            along side the axis. Cannot pass in null.
     *
     * @see AxisStyle
     */
    void setAxisStyle(final AxisStyle axisStyle);
}
