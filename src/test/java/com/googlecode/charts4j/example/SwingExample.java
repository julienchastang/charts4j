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

package com.googlecode.charts4j.example;

import java.awt.BorderLayout;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.junit.Ignore;

import com.googlecode.charts4j.Data;
import com.googlecode.charts4j.GCharts;
import com.googlecode.charts4j.LineChart;
import com.googlecode.charts4j.Plot;
import com.googlecode.charts4j.Plots;

/**
 * Example code for displaying a chart via Swing. This is an alternative
 * to displaying charts via JSP and Servlet technology.
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 */
@Ignore("not a unit test, just a Java Swing example")
public class SwingExample {

    /**
     * main
     *
     * @param s
     *            args not read.
     * @throws IOException
     */
    public static void main(String...s) throws IOException {
        Plot plot = Plots.newPlot(Data.newData(0, 66.6, 33.3, 100));
        LineChart chart = GCharts.newLineChart(plot);
        displayUrlString(chart.toURLString());
    }

    /**
     * Display the chart in a swing window.
     *
     *
     * @param urlString
     *            the url string to display.
     * @throws IOException
     */
    private static void displayUrlString(final String urlString) throws IOException{
        JFrame frame = new JFrame();
        JLabel label = new JLabel(new ImageIcon(ImageIO.read(new URL(urlString))));
        frame.getContentPane().add(label, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}
