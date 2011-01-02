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
 * Specify the data encoding to supply to the Google Chart API. The only
 * advantage to the simple encoding scheme is it will ultimately result in
 * shorter URLs, but at the cost of lower resolution. charts4j defaults to
 * extended encoding, but if you have lots of data and if you are willing to
 * sacrifice resolution, the simple encoding may be right for you. Text encoding
 * was included for the sake of completeness. Text encoding has limited
 * usefulness other than perhaps debugging. It should probably be avoided unless
 * you want to see the actual data in the URL at the cost of a much longer URL.
 *
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 *
 * @see GChart#setDataEncoding(DataEncoding dataEncoding)
 */
public enum DataEncoding {
    /**
     * Simple Data Encoding.
     */
    SIMPLE("s:"),
    /**
     * Extended Data Encoding.
     */
    EXTENDED("e:"),
    /**
     * Text Data Encoding.
     */
    TEXT("t:");

    /** Encoding parameter for Google Chart API. **/
    private final String encoding;

    /**
     * To provide the Google Chart API with the right parameter.
     *
     * @param encoding
     *            encoding parameter for Google Chart API
     */
    private DataEncoding(final String encoding) {
        this.encoding = encoding;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return encoding;
    }
}
