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

package com.googlecode.charts4j;

import static com.googlecode.charts4j.collect.Preconditions.*;

/**
 * Common code to political boundary classes.
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 *
 */
abstract class AbstractPoliticalBoundary implements PoliticalBoundary {

    /** Max color along gradient. **/
    private static final int         MAX_COLOR      = 100;

    /** Min color along gradient. **/
    private static final int         MIN_COLOR      = 0;


    /** Political boundary code. **/
    private final String code;

    /** Political boundary color. **/
    private final int    color;

    /**
     * AbstractPoliticalBoundary constructor.
     *
     * @param code
     *            political boundary code. Cannot be null.
     * @param color
     *            color code. Must be >= 0 and <= 100.
     *
     */
    AbstractPoliticalBoundary(final String code, final int color) {
        super();
        checkNotNull(code);
        checkArgument(color >= MIN_COLOR && color <= MAX_COLOR);
        this.code = code;
        this.color = color;
    }

    /**
     * {@inheritDoc}
     */
    public String getCode() {
        return code;
    }

    /**
     * {@inheritDoc}
     */
    public int getColor() {
        return color;
    }
}
