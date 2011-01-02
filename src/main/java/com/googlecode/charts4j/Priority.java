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

/**
 * Determines the order in which the chart elements (ex: shape markers) are
 * drawn. LOW specifies the element is drawn before all other parts of the
 * chart. This means the element will be at least partially obscured if another
 * chart element is drawn in the same place. NORMAL is the default. HIGH
 * specifies the element is drawn on top of all other parts of the chart. This
 * means it will at least partially hide another chart elements if it is drawn
 * in the same place.
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 */
public enum Priority {
    /** Low priority. **/
    LOW(-1),
    /** Normal priority. **/
    NORMAL(0),
    /** High priority. **/
    HIGH(1);

    /** Number for the Google Chart API. **/
    private final int priority;

    /**
     * Constructor.
     *
     * @param priority
     *            Number for the Google Chart API
     */
    Priority(final int priority) {
        this.priority = priority;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return priority + "";
    }
}
