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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.googlecode.charts4j.collect.ImmutableList;
import com.googlecode.charts4j.collect.Lists;

/**
 * Small URL utility class.
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 *
 */
public final class UrlUtil {

    /**
     * Cannot be instantiated.
     */
    private UrlUtil() {
        throw new AssertionError();
    }

    /**
     * A method that reformats the URL so that the parameters appear in
     * alphabetical order. This is useful for comparing URL strings in unit
     * tests, for instance.
     *
     * @param s
     *            String to be normalized
     * @return Normalized string
     */
    public static String normalize(final String s) {
        if (s == null) {
            return "";
        }
        final ImmutableList<String> stringList = Lists.of(s.split("\\?"));
        if (stringList.size() != 2) {
            return s;
        }
        final String args = stringList.get(1);
        final List<String> params = Arrays.asList(args.split("&"));
        Collections.sort(params);
        final StringBuilder sb = new StringBuilder(stringList.get(0) + "?");
        int cnt = 0;
        for (String p : params) {
            sb.append(cnt++ > 0 ? "&" : "").append(p);
        }
        return sb.toString();
    }
}
