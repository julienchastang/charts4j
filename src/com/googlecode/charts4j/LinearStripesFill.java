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

import static com.googlecode.charts4j.collect.Preconditions.checkNotNull;

import java.util.List;

import com.googlecode.charts4j.collect.ImmutableList;
import com.googlecode.charts4j.collect.Lists;
import com.googlecode.charts4j.parameters.ColorAndWidth;

/**
 * Linear stripes fill. This class is constructed with the
 * {@link Fills#newLinearStripesFill(int, Color, double)} static factory method.
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 */
public class LinearStripesFill extends AbstractLinearFill {

    /** Color and widths list for this fill. **/
    private final List<ColorAndWidth> colorsAndWidths = Lists.newLinkedList();

    /**
     * @see Fills#newLinearStripesFill(int, Color, double)
     */
    LinearStripesFill(final int angle, final Color color, final double width) {
        super(angle);
        colorsAndWidths.add(new ColorAndWidth(color, width));
    }

    /**
     * Copy constructor.
     *
     * @param linearStripesFill
     *            to copy
     */
    private LinearStripesFill(final LinearStripesFill linearStripesFill) {
        super(linearStripesFill.getAngle());
        colorsAndWidths.addAll(linearStripesFill.colorsAndWidths);
    }

    /**
     * {@inheritDoc}
     */
    public Fill klone() {
        return new LinearStripesFill(this);
    }

    /**
     * Color and width for additional stripes.
     *
     * @param color
     *            color of additional stripe. Cannot be null.
     * @param width
     *            width of stripe.
     */
    public final void addColorAndWidth(final Color color, final double width) {
        checkNotNull(color, "Color cannot be null");
        colorsAndWidths.add(new ColorAndWidth(color, width));
    }

    /**
     * Return a list of color and widths for this fill.
     *
     * @return Color and widths list.
     */
    final ImmutableList<ColorAndWidth> getColorsAndWidths() {
        return Lists.copyOf(colorsAndWidths);
    }
}
