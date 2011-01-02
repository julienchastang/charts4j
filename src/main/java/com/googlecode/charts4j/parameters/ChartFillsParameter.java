/**
 *
 * The MIT License
 *
 * Copyright (c) 2011 the original author or authors.
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

package com.googlecode.charts4j.parameters;

import java.util.List;

import com.googlecode.charts4j.Color;
import com.googlecode.charts4j.collect.ImmutableList;
import com.googlecode.charts4j.collect.Lists;

/**
 * Class for building chart fills parameter string for the Google Chart API.
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 */
final class ChartFillsParameter extends AbstractParameter {

    /** The Google Chart API chart fills parameter. */
    private static final String URL_PARAMETER_KEY = "chf";

    /** The fills. */
    private final List<Fill>    fills             = Lists.newLinkedList();

    /**
     * Adds the solid fill.
     *
     * @param solidFillType
     *            the solid fill type
     * @param color
     *            the color
     */
    void addSolidFill(final SolidFillType solidFillType, final Color color) {
        fills.add(new Solid(solidFillType, color));
    }

    /**
     * Adds the linear gradient fill.
     *
     * @param fillType
     *            the fill type
     * @param angle
     *            the angle
     * @param colorAndOffsets
     *            the color and offsets
     */
    void addLinearGradientFill(final FillType fillType, final int angle, final ImmutableList<? extends ColorAndOffset> colorAndOffsets) {
        fills.add(new LinearGradient(fillType, angle, colorAndOffsets));
    }

    /**
     * Adds the linear stripe fill.
     *
     * @param fillType
     *            the fill type
     * @param angle
     *            the angle
     * @param colorAndWidths
     *            the color and widths
     */
    void addLinearStripeFill(final FillType fillType, final int angle, final ImmutableList<? extends ColorAndWidth> colorAndWidths) {
        fills.add(new LinearStripes(fillType, angle, colorAndWidths));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getKey() {
        return URL_PARAMETER_KEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getValue() {
        final StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (Fill f : fills) {
            sb.append(cnt++ > 0 ? "|" : "").append(f);
        }
        return !fills.isEmpty() ? sb.toString() : "";
    }

    /**
     * The Interface Fill.
     */
    private interface Fill {
    }

    /**
     * The Class Solid.
     */
    private static final class Solid implements Fill {

        /** The solid fill type. */
        private final SolidFillType solidFillType;

        /** The color. */
        private final Color         color;

        /**
         * Instantiates a new solid.
         *
         * @param solidFillType
         *            the solid fill type
         * @param color
         *            the color
         */
        Solid(final SolidFillType solidFillType, final Color color) {
            this.solidFillType = solidFillType;
            this.color = color;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return solidFillType + ",s," + color;
        }
    }

    /**
     * The Class LinearGradient.
     */
    private static final class LinearGradient implements Fill {

        /** The fill type. */
        private final FillType             fillType;

        /** The angle. */
        private final int                  angle;

        /** The color and offsets. */
        private final ImmutableList<ColorAndOffset> colorAndOffsets;

        /**
         * Instantiates a new linear gradient.
         *
         * @param fillType
         *            the fill type
         * @param angle
         *            the angle
         * @param colorAndOffsets
         *            the color and offsets
         */
        private LinearGradient(final FillType fillType, final int angle, final ImmutableList<? extends ColorAndOffset> colorAndOffsets) {
            this.fillType = fillType;
            this.angle = angle;
            this.colorAndOffsets = Lists.copyOf(colorAndOffsets);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            int cnt = 0;
            for (ColorAndOffset co : colorAndOffsets) {
                sb.append(cnt++ > 0 ? "," : "").append(co);
            }
            return fillType + ",lg," + angle + "," + sb.toString();
        }
    }

    /**
     * The Class LinearStripes.
     */
    private static final class LinearStripes implements Fill {

        /** The fill type. */
        private final FillType            fillType;

        /** The angle. */
        private final int                 angle;

        /** The color and widths. */
        private final ImmutableList<ColorAndWidth> colorAndWidths;

        /**
         * Instantiates a new linear stripes.
         *
         * @param fillType
         *            the fill type
         * @param angle
         *            the angle
         * @param colorAndWidths
         *            the color and widths
         */
        private LinearStripes(final FillType fillType, final int angle, final ImmutableList<? extends ColorAndWidth> colorAndWidths) {
            this.fillType = fillType;
            this.angle = angle;
            this.colorAndWidths = Lists.copyOf(colorAndWidths);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            int cnt = 0;
            for (ColorAndWidth cw : colorAndWidths) {
                sb.append(cnt++ > 0 ? ",": "").append(cw);
            }

            return fillType + ",ls," + angle + "," + sb.toString();
        }
    }
}
