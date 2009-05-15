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

package com.googlecode.charts4j.parameters;

import java.util.List;

import com.google.gwt.i18n.client.NumberFormat;
import com.googlecode.charts4j.Data;
import com.googlecode.charts4j.DataEncoding;
import com.googlecode.charts4j.collect.Lists;

/**
 * Class for building data parameter string for the Google Chart API.
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 */
final class DataParameter implements Parameter {

    /** The Google Chart API data parameter. */
    private static final String   URL_PARAMETER_KEY       = "chd";

    /** The decimal formatter; GWT doesnt support DecimalFormat. */
    private final NumberFormat decimalFormatter = NumberFormat.getFormat("##.0");

    /** The Constant EXTENDED_ENCODING_CHARS. */
    private static final char[]   EXTENDED_ENCODING_CHARS = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
            'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', '.'};

    /** The Constant SIMPLE_ENCODING_CHARS. */
    private static final char[]   SIMPLE_ENCODING_CHARS   = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
            'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    /** The Constant EXTENDED_ENCODING. */
    private static final String[] EXTENDED_ENCODING       = new String[4096];

    /** The Constant SIMPLE_ENCODING. */
    private static final String[] SIMPLE_ENCODING         = new String[62];

    static { // Fill the encoding arrays in static block.
        int cnt = 0;
        for (int i = 0; i < EXTENDED_ENCODING_CHARS.length; i++) {
            for (int j = 0; j < EXTENDED_ENCODING_CHARS.length; j++) {
                EXTENDED_ENCODING[cnt++] = EXTENDED_ENCODING_CHARS[i] + "" + EXTENDED_ENCODING_CHARS[j];
            }
        }
        cnt = 0;
        for (int i = 0; i < SIMPLE_ENCODING_CHARS.length; i++) {
            SIMPLE_ENCODING[cnt++] = SIMPLE_ENCODING_CHARS[i] + "";
        }
    }

    /** The datas. */
    private final List<Data>      datas                   = Lists.newLinkedList();

    /** The data encoding. */
    private DataEncoding          dataEncoding            = DataEncoding.EXTENDED;

    /**
     * Instantiates a new data parameter.
     */
    DataParameter() {
        super();
    }

    /**
     * Adds the data.
     *
     * @param data
     *            the data
     */
    void addData(final Data data) {
        datas.add(data);
    }

    /**
     * Gets the data encoding.
     *
     * @return the data encoding
     */
    DataEncoding getDataEncoding() {
        return dataEncoding;
    }

    /**
     * Sets the data encoding.
     *
     * @param dataEncoding
     *            the new data encoding
     */
    void setDataEncoding(final DataEncoding dataEncoding) {
        this.dataEncoding = dataEncoding;
    }

    /**
     * Extended encoding.
     *
     * @param data
     *            the data
     *
     * @return the string
     */
    private String extendedEncoding(final double[] data) {

        if (data == null || data.length == 0) {
            return "";
        }

        final StringBuilder encodedData = new StringBuilder();
        for (double datum : data) { // The following cast to int is safe.
            final int index = (int) ((datum >= Data.MIN_VALUE && datum <= Data.MAX_VALUE) ? Math.round((datum / Data.MAX_VALUE) * (EXTENDED_ENCODING.length - 1)) : -1);
            encodedData.append((index < 0 || index > (EXTENDED_ENCODING.length - 1)) ? "__" : EXTENDED_ENCODING[index]);
        }
        return encodedData.toString();
    }

    /**
     * Simple encoding.
     *
     * @param data
     *            the data
     *
     * @return the string
     */
    private String simpleEncoding(final double[] data) {

        if (data == null || data.length == 0) {
            return "";
        }

        final StringBuilder encodedData = new StringBuilder();
        for (double datum : data) { // The following cast to int is safe.
            int index = (int) ((datum >= Data.MIN_VALUE && datum <= Data.MAX_VALUE) ? Math.round((datum / Data.MAX_VALUE) * (SIMPLE_ENCODING.length - 1)) : -1);
            encodedData.append((index < 0 || index > (SIMPLE_ENCODING.length - 1)) ? "_" : SIMPLE_ENCODING[index]);
        }
        return encodedData.toString();
    }

    /**
     * Text encoding.
     *
     * @param data
     *            the data
     *
     * @return the string
     */
    private String textEncoding(final double[] data) {
        if (data == null || data.length == 0) {
            return "";
        }

        final StringBuilder encodedData = new StringBuilder();
        int count = 0;
        for (double datum : data) {
            encodedData.append(count++ > 0 ? "," : "").append(datum >= Data.MIN_VALUE && datum <= Data.MAX_VALUE ? decimalFormatter.format(datum) : "-1");
        }
        return encodedData.toString();
    }

    /**
     * {@inheritDoc}
     */
    public String toURLParameterString() {
        final StringBuilder sb = new StringBuilder(URL_PARAMETER_KEY + "=" + dataEncoding);
        final String seperator = dataEncoding.equals(DataEncoding.TEXT) ? "|" : ",";
        int cnt = 0;
        for (Data data : datas) {
            final String dataString = dataEncoding.equals(DataEncoding.SIMPLE) ? simpleEncoding(data.getData()) : dataEncoding.equals(DataEncoding.TEXT) ? textEncoding(data.getData()) : extendedEncoding(data.getData());
            sb.append(cnt++ > 0 ? seperator : "").append(dataString);
        }
        return sb.toString();
    }
}
