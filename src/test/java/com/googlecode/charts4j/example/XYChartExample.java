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

package com.googlecode.charts4j.example;

import static com.googlecode.charts4j.Color.WHITE;
import static com.googlecode.charts4j.UrlUtil.normalize;
import static org.junit.Assert.assertEquals;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.BeforeClass;
import org.junit.Test;

import com.googlecode.charts4j.Color;
import com.googlecode.charts4j.Data;
import com.googlecode.charts4j.Fills;
import com.googlecode.charts4j.GCharts;
import com.googlecode.charts4j.Plots;
import com.googlecode.charts4j.XYLine;
import com.googlecode.charts4j.XYLineChart;

/**
 *
 * @author Julien Chastang (julien.c.chastang at gmail dot com)
 */
public class XYChartExample {

    private static final int MAX = 400;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).setLevel(Level.ALL);
    }

    @Test
    public void example1() {
        // EXAMPLE CODE START
        double[] x = new double[MAX];
        double[] y = new double[MAX];
        int cnt = 0;
        for (double i = 0; cnt < MAX; i = i + 3) {
            x[cnt] = 50 + 49 * Math.sin(i / 18);
            y[cnt] = 50 + 49 * Math.cos(i / 20);
            cnt++;
        }

        Data data1 = Data.newData(x);
        Data data2 = Data.newData(y);
        XYLine line = Plots.newXYLine(data1, data2);
        line.setColor(Color.newColor("27FEF6"));
        XYLineChart chart = GCharts.newXYLineChart(line);
        chart.setSize(500, 500);
        chart.setTitle("Lissajous curve", WHITE, 16);
        chart.setBackgroundFill(Fills.newSolidFill(Color.newColor("121411")));
        String url = chart.toURLString();
        // EXAMPLE CODE END. Use this url string in your web or
        // Internet application.
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(url);
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(url.length() + "");
        String expectedString = "http://chart.apis.google.com/chart?cht=lxy&chs=500x500&chts=FFFFFF,16&chco=27FEF6&chf=bg,s,121411&chd=e:gAlMqQvBzY3N6Y80-e.R.N-R8g582qywuVpgkbfNaBVAQSMAIRFMC3BWArA4B7D0GgJ4N3SXXPcWhkmvruwZ0m4O7M9a-z.W.B91705C1jxes6oAi3dpYfTiO8K0HREaCVBDApBGCaEjHcLBPLTzYwd6jIoRtLxt1w5M7896.D.V-w9T7D4D0YwJremehScFW-SHNpJrGVDtB2A2AsBaC-FWIdMNQhVQaTffkspxuly.236G8n-W.O.Q-Z8t6O3BzKuyp.k7fuahVeQuMZImFeDEBdAtA0ByDmGNJhNdR6Wwb2hEmPrQv90N36689O-t.V.F9.8D5V17x5tYofjXeJY.UAPXLMHlEqCfBJApBBCQETHIKpOwTVYRdaionxstxS1Y457t9w--.W-29f7T4Y0xwlr8m-hzclXdSkODKCGoD7CAA5AqBTCyFFIHL0QFUyZze-kMpSuIyk2g508a-N.L.S-h866g3XzkvOqelbgObBV9RLMyI8FvDQBlAvAxBqDZF7JKNDRdWRbWgjlvqxvhz03k6r9C-m.T.J-I8R5o2SyUt1o-j3eqZeUePzLkH6E6CrBPAqA8CGEEG0KROUS3Xxc6iInSsPw31A4l7e9m-5.W-79q7j4s1JxBsandiTdFX8TCOeKaG8EKCJA-ApBNCmE0HyLbPpUUZTeejsoztryK2J5h8M-E.I.U-o9H6x3sz9vrq9l7gvbhWcRnNMJTGBDeBtAyAuBiDMFpI0MpRAVya2gClPqTvEzb3P6a82-e.R.N-R8f572oyuuSpdkYfKZ-U9QP,.W.A988O5428zfvmrXm3iNdhY4UZQLMTI4F-DpB-A9ApBCCID4GRJPMtQoU4ZZeCivnYr2wDz53S6K8d-G.E.W-69y7.5k2kzEvIq3mWhsc.YXT5PuL5IhFrDbB0A5AqBICSEHGlJmNIRFVYZ6ekjRn5sVwg0T3p6d8r-P.I.V-09n7w5R2NypurqXl1hKceX2TaPRLfILFZDOBrA1ArBOCdEXG4J-NjRjV4abfGjyoZs0w80s3.6v84-Y.M.T-u9c7g4811yOuNp3lUgob8XWS8O0LGH1FIDBBjAxAsBVCpEnHNKWN.SBWYa8fokUo6tTxZ1G4U7A9F-g.P.S-n9Q7Q4o1cxytvpXkygHbbW1SdOYKtHgE3C0BbAuAvBcC1E4HiKvObSgW4bdgJk1patxx11e4p7R9R-n.S.P-f9E6.4T1ExWtQo3kRfla5WVR.N9KUHLEmCoBUAsAyBkDCFJH3LIO3S-XYb.grlWp6uPyQ134-7h9d-u.U.M-X836t390qw6syoXjwfDaYV1RhNhJ8G3EWCcBNArA1BsDPFbINLhPTTdX5cghNl3qautyr2P5S7x9o-1.V.I-P8q6b3n0RwesTn2jOehZ3VVRDNGJkGjEGCRBHAqA5B1DcFtIjL7PwT8YZdChumZq6vLzG2m5m8B9z-7.W.E-F8c6J3Rz3wBrznViseAZWU2QlMrJNGPD3CHBCApA9B-DrF.I6MVQNUbY6djiQm6rZvozh29558P99.A.W-.988N5226zdvkrUm0iLdeY1UWQIMRI2F8DoB9A9ApBC&chtt=Lissajous+curve";
        assertEquals("Junit error", normalize(expectedString), normalize(url));
    }
}
