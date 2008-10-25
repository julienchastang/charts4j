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
import static com.googlecode.charts4j.collect.Preconditions.checkNotNull;

import java.util.List;

import com.googlecode.charts4j.collect.ImmutableList;
import com.googlecode.charts4j.collect.Lists;

/**
 * Abstract class for all priority charts.
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 */
abstract class AbstractPriorityChart extends AbstractLineChart {

    /** Lines to be rendered by this chart. **/
    private final ImmutableList<Plot> lines;

    /**
     * Constructor for all priority charts.
     *
     * @param lines Collection of lines to be rendered.
     */
    AbstractPriorityChart(final ImmutableList<? extends Plot> lines) {
        super(lines);
        checkNotNull(lines);
        this.lines = Lists.copyOf(lines);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void prepareData() {
        super.prepareData();
        final List<Color> colors        = Lists.newLinkedList();
        final List<LineStyle> lStyles   = Lists.newLinkedList();
        final List<Priority> priorities = Lists.newLinkedList();

        // Logic to make sure things stay in step.
        boolean hasColor          = false;
        boolean hasLineStyle      = false;
        boolean hasPriorities     = false;

        // Logic to make sure things stay in step continued.
        for (Plot line : lines) {
            final PlotImpl plot = (PlotImpl) line;
            hasColor          |= (plot.getColor() != null);
            hasLineStyle      |= (plot.getLineStyle() != null);
            hasPriorities     |= (plot.getPriority()  != null);
        }

        // Logic to make sure things stay in step continued.
        for (Plot l : lines) {
            final PlotImpl line = (PlotImpl) l;
            if (hasColor) {
                colors.add(line.getColor() != null ? line.getColor() : BLACK);
            }
            if (hasLineStyle) {
                parameterManager.addLineChartLineStyle(line.getLineStyle() != null ? line.getLineStyle() : LineStyle.newLineStyle(1, 1, 0));
                lStyles.add(line.getLineStyle() != null ? line.getLineStyle() : LineStyle.newLineStyle(1, 1, 0));
            }
            if (hasPriorities) {
                priorities.add(line.getPriority() != null ? line.getPriority() : Priority.NORMAL);
            }
        }
        if (!priorities.isEmpty()) {
            setPriorities(priorities, colors, lStyles);
        }
    }

    /**
     * Private convenience method for setting priorities.
     *
     * @param priorities
     * @param colors
     * @param lineStyles
     */
    private void setPriorities(final List<Priority> priorities, final List<? extends Color> colors, final List<? extends LineStyle> lineStyles) {
        for (int i = 0; i < priorities.size(); i++) {
            final Color color = (colors.isEmpty()) ? BLACK : colors.get(i);
            final int size = (lineStyles.isEmpty()) ? 1 : lineStyles.get(i).getLineThickness();
            parameterManager.addLineStyleMarker(color, i, 0, size, priorities.get(i));
        }
    }
}
