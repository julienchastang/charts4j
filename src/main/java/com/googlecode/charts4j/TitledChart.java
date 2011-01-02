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

/**
 * Interface for all charts that support titles. (MapChart does not support
 * support titles.)
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 *
 */
public interface TitledChart {

    /**
     * Specify a chart title. Use a pipe character (|) to force a line break.
     *
     * @param title
     *            Chart title. Cannot be null.
     */
    void setTitle(final String title);

    /**
     * Specify a chart title with color and font size. Use a pipe character (|)
     * to force a line break.
     *
     * @param title
     *            Chart title. Cannot be null.
     * @param color
     *            Chart title color. Cannot be null.
     * @param fontSize
     *            Chart title font size. Must be > 0.
     */
    void setTitle(final String title, final Color color, final int fontSize);

    /**
     * A class to encapsulate chart titles.
     *
     * @author Julien Chastang (julien.c.chastang at gmail dot com)
     *
     */
    static class ChartTitle {

        /** Chart title. **/
        private final String title;

        /** Chart title color. **/
        private Color        color;

        /** Chart title font size. **/
        private int          fontSize;

        /**
         * @see TitledChart#setTitle(String)
         */
        ChartTitle(final String title) {
            checkNotNull(title, "title cannot be null");
            this.title = title;
        }

        /**
         * @see TitledChart#setTitle(String, Color, int)
         */
        ChartTitle(final String title, final Color color, final int fontSize) {
            checkArgument(fontSize > 0, "font size must be > 0: %s", fontSize);
            checkNotNull(title, "Title cannot be null.");
            checkNotNull(color, "Color cannot be null.");
            this.title = title;
            this.color = color;
            this.fontSize = fontSize;
        }

        /**
         * Get the title.
         *
         * @return the title
         */
        String getTitle() {
            return title;
        }

        /**
         * Get the color.
         *
         * @return the color
         */
        Color getColor() {
            return color;
        }

        /**
         * Get the font size.
         *
         *
         * @return The font size
         */
        int getFontSize() {
            return fontSize;
        }
    }
}
