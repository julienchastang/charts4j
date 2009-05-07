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
 * your own color gradient. The arrow can have a label and a legend.
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 *
 * @see GCharts
 */
public class GoogleOMeter extends AbstractGraphChart {
    /** Data to be plotted. **/
    private final double               data;

    /** Colors to be rendered in this chart. **/
    private final ImmutableList<Color> colors;

    /** Label that will sit atop the arrow. **/
    private final String               label;
    
    /** Legend. **/
    private final String               legend;

    /**
     * @see GCharts#newGoogleOMeter(double, String, String, List)
     */
    GoogleOMeter(final double data, final String label, final String legend, final List<? extends Color> colors) {
        super();
        checkArgument(data >= Data.MIN_VALUE && data <= Data.MAX_VALUE, "must be between " + Data.MIN_VALUE + " and " + Data.MAX_VALUE + " : %s", data);
        checkContentsNotNull(colors, "colors is null or contains a null");
        checkArgument(colors.size() != 1, "Must provide at least 2 colors or none at all.");
        this.data = data;
        this.label = label;
        this.legend = legend;
        this.colors = Lists.copyOf(colors);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void prepareData() {
        super.prepareData();
        parameterManager.addData(Data.newData(data));

        final List<ImmutableList<Color>> colorList = Lists.newArrayList();
        for (Color color : colors) {
            colorList.add(Lists.of(color));
        }
        parameterManager.addColors(Lists.copyOf(colorList));
        if (label != null) {
            parameterManager.addPieChartAndGoogleOMeterLegend(label);
        }
        if (legend != null) {
            parameterManager.addLegend(legend);
        }
        parameterManager.setChartTypeParameter(ChartType.GOOGLE_O_METER);
    }
}
