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

/**
 * The geographical area enumeration that must be supplied for
 * {@link GCharts#newMapChart(GeographicalArea)}.
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 *
 * @see PoliticalBoundary
 * @see USAState
 * @see Country
 * @see MapChart
 * @see GCharts
 */
public enum GeographicalArea {

    /** Africa. **/
    AFRICA("africa"),

    /** Asia. **/
    ASIA("asia"),

    /** Europe. **/
    EUROPE("europe"),

    /** Middle East. **/
    MIDDLE_EAST("middle_east"),

    /** South America. **/
    SOUTH_AMERICA("south_america"),

    /** USA. **/
    USA("usa"),

    /** World. **/
    WORLD("world");

    /** String for the Google Chart API. **/
    private final String geographicalArea;

    /**
     * Enum constructor.
     *
     * @param geographicalArea
     *            String for the Google Chart API
     */
    private GeographicalArea(final String geographicalArea) {
        this.geographicalArea = geographicalArea;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return geographicalArea;
    }
}
