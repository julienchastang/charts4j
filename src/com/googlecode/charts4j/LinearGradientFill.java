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
import com.googlecode.charts4j.parameters.ColorAndOffset;

/**
 * Linear gradient fill. This class is constructed with the
 * {@link Fills#newLinearGradientFill(int, Color, double)} static factory
 * method.
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 */
public class LinearGradientFill extends AbstractLinearFill {

    /** Colors and offsets list. **/
    private final List<ColorAndOffset> colorsAndOffsets = Lists.newLinkedList();

    /**
     * @see Fills#newLinearGradientFill(int, Color, double)
     */
    LinearGradientFill(final int angle, final Color color, final double offset) {
        super(angle);
        colorsAndOffsets.add(new ColorAndOffset(color, offset));
    }

    /**
     * Copy constructor.
     *
     * @param linearGradientFill
     *            fill to copy.
     */
    private LinearGradientFill(final LinearGradientFill linearGradientFill) {
        super(linearGradientFill.getAngle());
        colorsAndOffsets.addAll(linearGradientFill.colorsAndOffsets);
    }
    
    /**
     * {@inheritDoc}
     */
    public Fill klone() {
        return new LinearGradientFill(this);
    }

    /**
     * Add additional fill gradients.
     *
     * @param color
     *            Additional color. Cannot be null.
     *
     * @param offset
     *            Additional offset.
     */
    public final void addColorAndOffset(final Color color, final double offset) {
        checkNotNull(color, "Color cannot be null");
        colorsAndOffsets.add(new ColorAndOffset(color, offset));
    }

    /**
     * Return a list of color and offsets for this fill.
     *
     * @return Color and offset list.
     */
    final ImmutableList<ColorAndOffset> getColorsAndOffsets() {
        return Lists.copyOf(colorsAndOffsets);
    }
}
