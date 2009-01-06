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

import static com.googlecode.charts4j.Color.BLACK;
import static com.googlecode.charts4j.collect.Preconditions.*;

import com.googlecode.charts4j.collect.ImmutableList;
import com.googlecode.charts4j.collect.Lists;
import com.googlecode.charts4j.parameters.ChartType;
import com.googlecode.charts4j.parameters.FillAreaType;


/**
 * Bar chart constructed with the {@link GCharts} static factory class.
 *
 * Bar chart class that supports vertical and horizontal bar charts. Bars from
 * different data series can either be stacked or side-by-side.
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 *
 * @see BarChartPlot
 * @see GCharts
 */
public class BarChart extends AbstractAxisChart {

    /** Default space within groups of bars. **/
    private static final int          DEFAULT_SPACE_WINTHIN_GROUPS_OF_BARS = 4;

    /** Default space between groups of bars. **/
    private static final int          DEFAULT_SPACE_BETWEEN_GROUPS_OF_BARS = 8;

    /** Default bar width. **/
    private static final int          DEFAULT_BAR_WIDTH                    = 23;

    /** Are the bars stacked or side-by-side. **/
    private boolean                   dataStacked                          = false;

    /** Are the bars horizontal or vertical. **/
    private boolean                   horizontal                           = false;

    /** The bar width. **/
    private int                       barWidth                             = DEFAULT_BAR_WIDTH;

    /** Space between groups of bars. **/
    private int                       spaceBetweenGroupsOfBars             = DEFAULT_SPACE_BETWEEN_GROUPS_OF_BARS;

    /** Space within groups. **/
    private int                       spaceWithinGroupsOfBars              = DEFAULT_SPACE_WINTHIN_GROUPS_OF_BARS;

    /** List of bars to be plotted. **/
    private final ImmutableList<Plot> barChartPlots;

    /**
     * @see GCharts#newBarChart(List)
     */
    BarChart(final ImmutableList<? extends Plot> barChartPlots) {
        super();
        checkContentsNotNull(barChartPlots, "barChartPlots is null or contains a null plot");
        this.barChartPlots = Lists.copyOf(barChartPlots);
    }

    /**
     * Are the bar charts stacked, or side-by-side.
     *
     * @param dataStacked
     *            If true, data from different bar chart plot will be stacked
     *            instead of side-by-side.
     */
    public final void setDataStacked(final boolean dataStacked) {
        this.dataStacked = dataStacked;
    }

    /**
     * Is the bar chart bars horizontal or vertical.
     *
     * @param horizontal
     *            If true, the bar chart will be horizontal instead of vertical.
     */
    public final void setHorizontal(final boolean horizontal) {
        this.horizontal = horizontal;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void prepareData() {
        super.prepareData();

        // Logic to make sure things stay in step.
        boolean hasLegend = false;
        boolean hasColor = false;
        boolean hasZeroLine = false;

        // Logic to make sure things stay in step continued.
        for (Plot plot : barChartPlots) {
            final PlotImpl series = (PlotImpl) plot;
            hasLegend |= (series.getLegend() != null);
            hasColor |= (series.getColor() != null);
            hasZeroLine |= (series.getZeroLine() != 0);
        }

        // Logic to make sure things stay in step continued.
        int lineCount = 0;
        for (Plot p : barChartPlots) {
            final PlotImpl plot = (PlotImpl) p;
            parameterManager.addData(plot.getData());
            if (hasLegend) {
                parameterManager.addLegend(plot.getLegend() != null ? plot.getLegend() : " ");
            }
            if (hasColor) {
                parameterManager.addColor(plot.getColor() != null ? plot.getColor() : BLACK);
            }
            if (hasZeroLine) {
                // Remember zero line has to be between 0 and 1
                parameterManager.setBarChartZeroLineParameter(plot.getZeroLine() / Data.MAX_VALUE);
            }
            if (plot.getDataLine() != null) {
                parameterManager.addLineStyleMarker(plot.getDataLine().getColor(), lineCount, 0, plot.getDataLine().getSize(), plot.getDataLine().getPriority());
            }
            final ImmutableList<Marker> markers = plot.getMarkers();
            for (Marker m : markers) {
                parameterManager.addMarkers(m, lineCount);
            }
            final ImmutableList<MarkedPoints> markedPointsList = plot.getMarkedPointsList();
            for (MarkedPoints mp : markedPointsList) {
                parameterManager.addMarker(mp.getMarker(), lineCount, mp.getStartIndex(), mp.getEndIndex(), mp.getN());
            }
            if (plot.getFillAreaColor() != null) {
                parameterManager.addFillAreaMarker(FillAreaType.FULL, plot.getFillAreaColor(), lineCount, 0);
            }
            lineCount++;
        }

        parameterManager.setBarChartWidthAndSpacingParameter(barWidth, spaceWithinGroupsOfBars, spaceBetweenGroupsOfBars);
        if (horizontal && dataStacked) {
            parameterManager.setChartTypeParameter(ChartType.HORIZONTAL_STACKED_BAR_CHART);
        }
        if (!horizontal && dataStacked) {
            parameterManager.setChartTypeParameter(ChartType.VERTICAL_STACKED_BAR_CHART);
        }
        if (!horizontal && !dataStacked) {
            parameterManager.setChartTypeParameter(ChartType.VERTICAL_GROUPED_BAR_CHART);
        }
        if (horizontal && !dataStacked) {
            parameterManager.setChartTypeParameter(ChartType.HORIZONTAL_GROUPED_BAR_CHART);
        }
    }

    /**
     * Set the bar chart width.
     *
     * @param barWidth
     *            Bar width in pixels. If not set defaults to 23. Must be > 0.
     */
    public final void setBarWidth(final int barWidth) {
        checkArgument(barWidth > 0, "barWidth must be > 0");
        this.barWidth = barWidth;
    }

    /**
     * Set the space between groups of bars.
     *
     * @param spaceBetweenGroupsOfBars
     *            The space between groups of bars. Bars within a group have
     *            half the specified spacing. If not set default to 8. Must be >=
     *            0.
     */
    public final void setSpaceBetweenGroupsOfBars(final int spaceBetweenGroupsOfBars) {
        checkArgument(spaceWithinGroupsOfBars >= 0, "spaceWithinGroupsOfBars must be >= 0");
        this.spaceBetweenGroupsOfBars = spaceBetweenGroupsOfBars;
    }

    /**
     * Set the space within groups of bars.
     *
     * @param spaceWithinGroupsOfBars
     *            The space within groups of bars. Bars within a group have half
     *            the specified spacing. If not set default to 4. Must be >= 0.
     */
    public final void setSpaceWithinGroupsOfBars(final int spaceWithinGroupsOfBars) {
        checkArgument(spaceWithinGroupsOfBars >= 0, "spaceWithinGroupsOfBars must be >= 0");
        this.spaceWithinGroupsOfBars = spaceWithinGroupsOfBars;
    }
}
