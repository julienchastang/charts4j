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

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.googlecode.charts4j.collect.ImmutableList;
import com.googlecode.charts4j.collect.Lists;
import com.googlecode.charts4j.collect.Maps;
import com.googlecode.charts4j.parameters.AxisTypes;

/**
 * Abstract type that is common to all charts with axes.
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 */
public abstract class AbstractAxisChart extends AbstractGraphChart implements GridChart {

    /** List of X axis labels. **/
    private final List<AxisLabelsImpl> xAxisLabels     = Lists.newLinkedList();

    /** List of Y axis labels. **/
    private final List<AxisLabelsImpl> yAxisLabels     = Lists.newLinkedList();

    /** List of top axis labels. **/
    private final List<AxisLabelsImpl> topAxisLabels   = Lists.newLinkedList();

    /** List of right axis labels. **/
    private final List<AxisLabelsImpl> rightAxisLabels = Lists.newLinkedList();

    /**
     * Line style for grid. For internal purposes only. Thickness field is
     * ignored.
     */
    private LineStyle                  gridLineStyle;

    /** X axis step size for the grid. **/
    private double                     xAxisStepSize;

    /** Y axis step size for the grid. **/
    private double                     yAxisStepSize;

    /**
     * Abstract Axis chart constructor.
     */
    AbstractAxisChart() {
        super();
    }

    /**
     * Add X axis labels.
     *
     * @param axisLabels
     *            x axis labels. Cannot be null. axisLabels parameter is
     *            defensively copied.
     */
    public final void addXAxisLabels(final AxisLabels axisLabels) {
        checkNotNull(axisLabels, "axisLabel cannnot be null");
        xAxisLabels.add(AxisLabelsFactory.newAxisLabels((AxisLabelsImpl) axisLabels));
    }

    /**
     * Add Y axis information.
     *
     * @param axisLabels
     *            y axis information. Cannot be null. axisLabel parameter is
     *            defensively copied.
     */
    public final void addYAxisLabels(final AxisLabels axisLabels) {
        checkNotNull(axisLabels, "axisLabel cannnot be null");
        yAxisLabels.add(AxisLabelsFactory.newAxisLabels((AxisLabelsImpl) axisLabels));
    }

    /**
     * Add Top axis information.
     *
     * @param axisLabels
     *            top axis information. Cannot be null. axisLabel parameter is
     *            defensively copied.
     */
    public final void addTopAxisLabels(final AxisLabels axisLabels) {
        checkNotNull(axisLabels, "axisLabel cannnot be null");
        topAxisLabels.add(AxisLabelsFactory.newAxisLabels((AxisLabelsImpl) axisLabels));
    }

    /**
     * Add Right axis information.
     *
     * @param axisLabels
     *            right axis information. Cannot be null. axisLabels parameter
     *            is defensively copied.
     */
    public final void addRightAxisLabels(final AxisLabels axisLabels) {
        checkNotNull(axisLabels, "axisLabels cannnot be null");
        rightAxisLabels.add(AxisLabelsFactory.newAxisLabels((AxisLabelsImpl) axisLabels));
    }

    /**
     * {@inheritDoc}
     */
    public final void setGrid(final double xAxisStepSize, final double yAxisStepSize, final int lengthOfLineSegment, final int lengthOfBlankSegment) {
        checkArgument(xAxisStepSize > 0, "xAxisStepSize must be positive: %s", xAxisStepSize);
        checkArgument(yAxisStepSize > 0, "yAxisStepSize must be positive: %s", yAxisStepSize);
        checkArgument(lengthOfLineSegment >= 0, "lengthOfLineSegment must be 0 or positive: %s", lengthOfLineSegment);
        checkArgument(lengthOfBlankSegment >= 0, "lengthOfBlankSegment must be 0 or positive: %s", lengthOfBlankSegment);
        this.xAxisStepSize = xAxisStepSize;
        this.yAxisStepSize = yAxisStepSize;
        // Line thickness is ignored. LineStyle just happened to be a convenient
        // container.
        gridLineStyle = LineStyle.newLineStyle(1, lengthOfLineSegment, lengthOfBlankSegment);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void prepareData() {
        super.prepareData();
        if (gridLineStyle != null) {
            parameterManager.setGridLineParameter(xAxisStepSize, yAxisStepSize, gridLineStyle.getLengthOfLineSegment(), gridLineStyle.getLengthOfBlankSegment());
        }
        if (!xAxisLabels.isEmpty() || !yAxisLabels.isEmpty() || !topAxisLabels.isEmpty() || !rightAxisLabels.isEmpty()) {

            final Map<AxisTypes, List<AxisLabelsImpl>> axisTypeMap = Maps.newEnumMap(AxisTypes.class);
            axisTypeMap.put(AxisTypes.RIGHT_Y_AXIS, rightAxisLabels);
            axisTypeMap.put(AxisTypes.TOP_X_AXIS, topAxisLabels);
            axisTypeMap.put(AxisTypes.LEFT_Y_AXIS, yAxisLabels);
            axisTypeMap.put(AxisTypes.BOTTOM_X_AXIS, xAxisLabels);

            int axisIndex = 0;
            for (Map.Entry<AxisTypes, List<AxisLabelsImpl>> entry : axisTypeMap.entrySet()) {
                for (AxisLabelsImpl axisLabel : entry.getValue()) {
                    parameterManager.addAxisTypes(entry.getKey());
                    // if there are labels but no positions
                    if (axisLabel.getPositions().isEmpty() && !axisLabel.getLabels().isEmpty()) {
                        parameterManager.addAxisLabels(axisIndex, axisLabel.getLabels());
                    }
                    // if there are labels and positions
                    else if (!axisLabel.getPositions().isEmpty() && !axisLabel.getLabels().isEmpty()) {
                        parameterManager.addAxisLabels(axisIndex, axisLabel.getLabels());
                        parameterManager.addAxisLabelPosition(axisIndex, axisLabel.getPositions());
                        parameterManager.addAxisRange(axisIndex, Data.MIN_VALUE, Data.MAX_VALUE);
                    }
                    // if there are positions but no labels
                    else if (!axisLabel.getPositions().isEmpty() && axisLabel.getLabels().isEmpty()) {
                        final List<Double> sortedpositions = convertToSortedDoubleList(axisLabel.getPositions());
                        parameterManager.addAxisLabelPosition(axisIndex, axisLabel.getPositions());
                        parameterManager.addAxisRange(axisIndex, sortedpositions.get(0), sortedpositions.get(sortedpositions.size() - 1));
                    } else if (axisLabel.getRange() != null) {
                        parameterManager.addAxisRange(axisIndex, axisLabel.getRange().getMin(), axisLabel.getRange().getMax());
                    }
                    if (axisLabel.getAxisStyle() != null) {
                        parameterManager.addAxisStyle(axisIndex, axisLabel.getAxisStyle().getColor(), axisLabel.getAxisStyle().getFontSize(), axisLabel.getAxisStyle().getAlignment());
                    }
                    axisIndex++;
                }
            }
        }
    }

    /**
     * A method to convert a number list to a double list.
     *
     * @param positions
     *            the axis positions list.
     * @return a double list containing positions.
     */
    private static List<Double> convertToSortedDoubleList(final ImmutableList<? extends Number> positions) {
        final List<Double> doubleList = Lists.newLinkedList();
        for (Number number : positions) {
            doubleList.add(number.doubleValue());
        }
        Collections.sort(doubleList);
        return doubleList;
    }
}
