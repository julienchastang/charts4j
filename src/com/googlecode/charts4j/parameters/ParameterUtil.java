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

import com.google.gwt.http.client.URL;

/**
 * A utility class for URL parameters.
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 */
final class ParameterUtil {

    /** UTF-8 encoding. **/
    private static final String UTF_8 = "UTF-8";

    /**
     * Cannot instantiate.
     */
    private ParameterUtil() {
        throw new AssertionError();
    }

    /**
     * UTF-8 encode the string.
     *
     * @param s
     *            String to be encoded.
     *
     * @return the encoded string
     */
    static String utf8Encode(final String s) {
        if (s == null) {
            return null;
        }
        // GWT doesnt support URLEncoder
        String encodedUrl = URL.encode(s);
	return encodedUrl;
    }
}
