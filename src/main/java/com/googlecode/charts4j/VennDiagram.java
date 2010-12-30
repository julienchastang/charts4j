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
import static com.googlecode.charts4j.collect.Preconditions.checkNotNull;

import java.util.List;

import com.googlecode.charts4j.collect.ImmutableList;
import com.googlecode.charts4j.collect.Lists;
import com.googlecode.charts4j.parameters.ChartType;

/**
 * Venn diagram constructed with the
 * {@link GCharts#newVennDiagram(double, double, double, double, double, double, double)}
 * method.
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 *
 * @see GCharts
 */
public class VennDiagram extends AbstractGraphChart {

    /** First Venn diagram circle. **/
    private Color          circle1Color;

    /** Second Venn diagram circle. **/
    private Color          circle2Color;

    /** Third Venn diagram circle. **/
    private Color          circle3Color;

    /** First Venn diagram circle legend. **/
    private String         circle1Legend;

    /** Second Venn diagram circle legend. **/
    private String         circle2Legend;

    /** Third Venn diagram circle legend. **/
    private String         circle3Legend;

    /** Data array that will hold the circle sizes. **/
    private final double[] data;

    /**
     * @see GCharts#newVennDiagram(double, double, double, double, double,
     *      double, double)
     */
    VennDiagram(final double circle1Size, final double circle2Size, final double circle3Size, final double abIntersect, final double bcIntersect, final double caIntersect, final double abcIntersect) {
        super();
        final double[] data = {circle1Size, circle2Size, circle3Size, abIntersect, bcIntersect, caIntersect, abcIntersect};
        for (double d : data) {
            checkArgument(d >= Data.MIN_VALUE && d <= Data.MAX_VALUE, "Venn diagram values must be between 0 and 100: %s", d);
        }
        this.data = data;
    }

    /**
     * Set the colors of the circles.
     *
     * @param circle1Color
     *            color of circle 1. Cannot be null.
     * @param circle2Color
     *            color of circle 2. Cannot be null.
     * @param circle3Color
     *            color of circle 3. Cannot be null.
     * @see Color
     */
    public final void setCircleColors(final Color circle1Color, final Color circle2Color, final Color circle3Color) {
        checkNotNull(circle1Color);
        checkNotNull(circle2Color);
        checkNotNull(circle3Color);
        this.circle1Color = circle1Color;
        this.circle2Color = circle2Color;
        this.circle3Color = circle3Color;
    }

    /**
     * Set the legends of the circles.
     *
     * @param circle1Legend
     *            legend of circle 1. Cannot be null.
     * @param circle2Legend
     *            legend of circle 2. Cannot be null.
     * @param circle3Legend
     *            legend of circle 3. Cannot be null.
     */
    public final void setCircleLegends(final String circle1Legend, final String circle2Legend, final String circle3Legend) {
        checkNotNull(circle1Legend);
        checkNotNull(circle2Legend);
        checkNotNull(circle3Legend);
        this.circle1Legend = circle1Legend;
        this.circle2Legend = circle2Legend;
        this.circle3Legend = circle3Legend;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void prepareData() {
        super.prepareData();
        if (circle1Color != null && circle2Color != null && circle3Color != null) {

            final List<ImmutableList<Color>> colors = Lists.newArrayList();
            colors.add(Lists.of(circle1Color));
            colors.add(Lists.of(circle2Color));
            colors.add(Lists.of(circle3Color));
            parameterManager.addColors(Lists.copyOf(colors));
        }
        if (circle1Legend != null && circle2Legend != null && circle3Legend != null) {
            parameterManager.addLegends(Lists.of(circle1Legend, circle2Legend, circle3Legend));
        }
        parameterManager.setChartTypeParameter(ChartType.VENN_DIAGRAM);
        parameterManager.addData(Data.newData(data));
    }
}
