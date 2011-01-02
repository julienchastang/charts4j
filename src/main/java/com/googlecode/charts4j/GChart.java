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

import java.util.Map;

/**
 * Top level interface for all charts. Herein is functionality common to all
 * charts.
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 */
public interface GChart {

    /**
     * Set the chart size. If no size is specified, the chart will default to
     * 200x125.
     *
     * @param width
     *            chart width. Must be > 0 and <= 1000.
     * @param height
     *            chart height. Must be > 0 and <= 1000.
     *
     * @see <a href="http://code.google.com/apis/chart/#chart_size">Chart Size</a>
     */
    void setSize(final int width, final int height);

    /**
     * Get a map of all the parameters necessary to generate a Google Chart API
     * request. This method is specifically (and perhaps only) useful in a POST
     * request scenario. It is still up to the developers to take these parameters
     * and generate a POST request. For instance, they may want to use JSON to pass 
     * parameters to the browser in order to make the POST request. 
     *
     * @return a map of all the parameters
     * @see <a href="http://code.google.com/apis/chart/docs/post_requests.html">POST Requests</a>
     */
    Map<String, String> getParameters();

    /**
     * Create a URL string given the information supplied to this chart. You can
     * copy and paste this string into your web browser, and see if you get the
     * results you anticipated. Better yet, incorporate this method call or
     * {@link #toURLForHTML()} into your Internet application to dynamically
     * generate charts. URLs beyond 2000 characters are not recommended. You can
     * sometimes get away with the simple encoding scheme if URL length is a
     * problem. See {@link #setDataEncoding(DataEncoding dataEncoding)}
     *
     * @return URL String
     *
     * @see DataEncoding
     * @see <a href="http://www.boutell.com/newfaq/misc/urllength.html">WWW
     *      FAQs: What is the maximum length of a URL?</a>
     */
    String toURLString();

    /**
     * Create a URL with the ampersand character entity reference ({@literal &amp;})
     * in place of an ampersand. Useful for embedding your link in a web page.
     *
     * @return URL string
     */
    String toURLForHTML();

    /**
     * Specify background fill.
     *
     * @param fill
     *            Background fill. Cannot be null.
     * @see Fill
     */
    void setBackgroundFill(final Fill fill);

    /**
     * Specify the chart transparency. Use cautiously as this feature may
     * obscure background fills. Also there appears to be a bug in the Google
     * Chart API where setting a transparency makes the label color disappear.
     *
     * @param opacity
     *            Supply a number between 0 and 100. 0 is completely
     *            transparent, and 100 is completely opaque.
     */
    void setTransparency(final int opacity);

    /**
     * Set the data encoding scheme. The only advantage to the simple encoding
     * scheme is it will ultimately result in shorter URLs, but at the cost of
     * lower resolution. charts4j defaults to the extended encoding, but if
     * you have lots of data and if you are willing to sacrifice resolution, the
     * simple encoding may be right for you.
     *
     * @param dataEncoding
     *            Supply the data encoding, either simple or extended. Cannot be
     *            null.
     */
    void setDataEncoding(final DataEncoding dataEncoding);

    /**
     * Specify the chart margins. The overall size of the chart defined with the
     * {@link #setSize(int, int)} method will not change. The margin moves
     * inward. It is similar to a CSS padding.
     *
     * @param leftMargin
     *            the left margin
     * @param rightMargin
     *            the right margin
     * @param topMargin
     *            the top margin
     * @param bottomMargin
     *            the bottom margin
     */
    void setMargins(final int leftMargin, final int rightMargin, final int topMargin, final int bottomMargin);

    /**
     * Sets the chart URL endpoint. The default end point chart URL is
     * <code>http://chart.apis.google.com/chart</code>. This method is useful in
     * situations where other Internet services support the Google Chart API.
     * For instance, JFreeChart has a Google Chart API emulation called <a
     * href="http://www.jfree.org/eastwood/">Eastwood</a>. API users can supply
     * the Eastwood servlet address as the end point URL (e.g.
     * <code>http://localhost:8080/eastwood-1.1.0/chart</code>). Note that
     * Eastwood is not a 100% emulation of the Google Chart API so
     * "your mileage may vary" in terms of what charts are supported by
     * Eastwood.
     *
     * @param urlEndpoint
     *            the new chart url endpoint
     *
     * @see <a href="http://www.jfree.org/eastwood/">JFreeChart Eastwood Servlet</a>
     */
   public void setURLEndpoint(final String urlEndpoint);
}
