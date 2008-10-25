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

import com.googlecode.charts4j.collect.ImmutableList;
import com.googlecode.charts4j.collect.Lists;
import com.googlecode.charts4j.parameters.ChartType;

/**
 *
 * Google-o-meter constructed with the {@link GCharts} static factory class.
 *
 * A Google-o-meter looks a bit like a speedometer dial. The range is from 0 to
 * 100. Colors are interpolated from red to green by default. You can provide
 * your own color gradient.
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 *
 * @see GCharts
 */
public class GoogleOMeter extends AbstractGChart {
    /** Data to be plotted. **/
    private final double               data;

    /** Colors to be rendered in this chart. **/
    private final ImmutableList<Color> colors;

    /** Label that will sit atop the arrow. **/
    private final String               label;

    /**
     * @see GCharts#newGoogleOMeter(double, String, List)
     */
    GoogleOMeter(final double data, final String label, final List<? extends Color> colors) {
        super();
        checkArgument(data >= Data.MIN_VALUE && data <= Data.MAX_VALUE, "must be between " + Data.MIN_VALUE + " and " + Data.MAX_VALUE + " : %s", data);
        checkContentsNotNull(colors, "colors is null or contains a null");
        checkArgument(colors.size() >= 2, "Must provide at least 2 colors.");
        checkNotNull(label, "The label cannot be null");
        this.data = data;
        this.label = label;
        this.colors = Lists.copyOf(colors);
    }

    /**
     * @see GCharts#newGoogleOMeter(double)
     */
    GoogleOMeter(final double data) {
        super();
        checkArgument(data >= Data.MIN_VALUE && data <= Data.MAX_VALUE, "must be between " + Data.MIN_VALUE + " and " + Data.MAX_VALUE + " : %s", data);
        this.data = data;
        this.label = null;
        this.colors = Lists.<Color>of();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void prepareData() {
        super.prepareData();
        parameterManager.addData(Data.newData(data));
        parameterManager.addColors(Lists.copyOf(colors));
        if (label != null) {
            parameterManager.addPieChartAndGoogleOMeterLegend(label);
        }
        parameterManager.setChartTypeParameter(ChartType.GOOGLE_O_METER);
    }
}
