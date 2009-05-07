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
 * Map chart constructed with the {@link GCharts} static factory class.
 *
 * Build a map and paramaterize it with countries and US states that you want to
 * color along a color gradient. You can also select and zoom in on a
 * {@link GeographicalArea}.
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 *
 * @see PoliticalBoundary
 * @see USAState
 * @see Country
 * @see GeographicalArea
 * @see GCharts
 */
public class MapChart extends AbstractGChart {

    /** Max chart width. **/
    private static final int              MAX_WIDTH         = 440;

    /** Max chart height. **/
    private static final int              MAX_HEIGHT        = 220;

    /** Min chart width. **/
    private static final int              MIN_WIDTH         = 0;

    /** Min chart height. **/
    private static final int              MIN_HEIGHT        = 0;

    /** Default chart width. **/
    static final int                      DEFAULT_WIDTH     = 440;

    /** Default chart height. **/
    static final int                      DEFAULT_HEIGHT    = 220;

    /** The list of US States and countries to render.  **/
    private final List<PoliticalBoundary> pBoundaries       = Lists.newLinkedList();

    /** The color gradient to use to render the US State and countries.  **/
    private final List<Color>             colorGradientList = Lists.newLinkedList();

    /**  The part of the world this map should focus on. **/
    private final GeographicalArea        geographicalArea;

    /**
     * Construct a map with a {@link GeographicalArea}.
     *
     * @param geographicalArea
     *            Pass in the {@link GeographicalArea}. Cannot be null.
     *
     * @see GeographicalArea
     */
    MapChart(final GeographicalArea geographicalArea) {
        super();
        checkNotNull(geographicalArea, "geographicalArea cannot be null.");
        this.geographicalArea = geographicalArea;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void prepareData() {
        super.prepareData();
        parameterManager.setGeographicalAreaParameter(geographicalArea);

        final List<ImmutableList<Color>> colors = Lists.newArrayList();
        for (Color color : colorGradientList) {
            colors.add(Lists.of(color));
        }
        parameterManager.addColors(Lists.copyOf(colors));

        int cnt = 0;
        final double[] countryColors = new double[pBoundaries.size()];
        for (PoliticalBoundary pb : pBoundaries) {
            parameterManager.addGeoCode(pb.getCode());
            countryColors[cnt++] = pb.getColor();
        }
        if (cnt > 0) {
            parameterManager.addData(Data.newData(countryColors));
        } else {
            parameterManager.addData(Data.INVALID);
        }
        parameterManager.setChartTypeParameter(ChartType.MAP_CHART);
    }

    /**
     * Define a default color and color gradient.
     *
     * @param defaultColor
     *            Default color for this map.
     * @param colorGradient
     *            Colors defined in the {@link PoliticalBoundary} will be
     *            interpolated along this color gradient.
     *
     * @see PoliticalBoundary
     */
    public final void setColorGradient(final Color defaultColor, final Color... colorGradient) {
        colorGradientList.clear();
        colorGradientList.add(defaultColor);
        colorGradientList.addAll(Lists.of(colorGradient));
    }

    /**
     * Add a political boundary (e.g. {@link Country} or {@link USAState}).
     *
     * @param politicalBoundary
     *            Pass in a political boundary.
     */
    public final void addPoliticalBoundary(final PoliticalBoundary politicalBoundary) {
        pBoundaries.add(politicalBoundary);
    }

    /**
     * Add one or more political boundaries (e.g. {@link Country} or
     * {@link USAState}).
     *
     * @param politicalBoundaries
     *            Pass in one or more political boundaries.
     */
    public final void addPoliticalBoundaries(final PoliticalBoundary... politicalBoundaries) {
        pBoundaries.addAll(Lists.of(politicalBoundaries));
    }

    /**
     * Add a list of political boundaries (e.g. {@link Country} or
     * {@link USAState}).
     *
     * @param politicalBoundaries
     *            Pass in a list of political boundaries.
     */
    public final void addPoliticalBoundaries(final List<? extends PoliticalBoundary> politicalBoundaries) {
        pBoundaries.addAll(politicalBoundaries);
    }

    /**
     * The default is 440x220 which is also the maximum size allowable for a
     * MapChart.
     *
     * @param width
     *            Map chart width
     * @param height
     *            Map chart height
     *
     */
    @Override
    public final void setSize(final int width, final int height) {
        checkArgument(width > MIN_WIDTH && width <= MAX_WIDTH, "width must be > " + MIN_WIDTH + " and <= " + MAX_WIDTH + ": %s", width);
        checkArgument(height > MIN_HEIGHT && height <= MAX_HEIGHT, "height must be > " + MIN_WIDTH + " and <= " + MAX_WIDTH + ": %s", height);
        super.setSize(width, height);
    }
}
