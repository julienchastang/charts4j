package com.googlecode.charts4j;

import static com.googlecode.charts4j.UrlUtil.normalize;
import static org.junit.Assert.assertEquals;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GChartsTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        Logger.global.setLevel(Level.ALL);
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testNewLineChart0() {
        try {
            Line[] lines = null;
            GCharts.newLineChart(lines);
        } catch (NullPointerException e) {
            return;
        }
    }

    @Test
    public void testNewLineChart1() {
        try {
            Line[] lines = { TestUtil.getBasicLine(), null };
            GCharts.newLineChart(lines);
        } catch (NullPointerException e) {
            return;
        }
    }

    @Test
    public void testPloymorphicPlots() {
        Plot curve = Plots.newPlot(Data.newData(10, 99, 30));
        Line line = Plots.newLine(Data.newData(70, 5, 50), Color.RED, "foo");

        LineChart lc = GCharts.newLineChart(curve, line);
        Logger.global.info(lc.toURLString());
        String expectedString = "http://chart.apis.google.com/chart?chs=200x125&chd=e:Ga.WTN,szDNgA&chdl=+|foo&chco=000000,FF0000&cht=lc";
        assertEquals("Junit error", normalize(expectedString), normalize(lc.toURLString()));


        RadarChart rc = GCharts.newRadarChart(curve, line);
        Logger.global.info(rc.toURLString());
        expectedString = "http://chart.apis.google.com/chart?chs=200x125&chd=e:Ga.WTN,szDNgA&chdl=+|foo&chco=000000,FF0000&cht=r";
        assertEquals("Junit error", normalize(expectedString), normalize(rc.toURLString()));


        BarChart bc = GCharts.newBarChart(curve, line);
        Logger.global.info(bc.toURLString());
        expectedString = "http://chart.apis.google.com/chart?chs=200x125&chd=e:Ga.WTN,szDNgA&chdl=+|foo&chco=000000,FF0000&chbh=23,4,8&cht=bvg";
        assertEquals("Junit error", normalize(expectedString), normalize(bc.toURLString()));


        XYLineChart xyc = GCharts.newXYLineChart(curve, line);
        Logger.global.info(xyc.toURLString());
        expectedString = "http://chart.apis.google.com/chart?chs=200x125&chd=e:AAgA..,Ga.WTN,AAgA..,szDNgA&chdl=+|foo&chco=000000,FF0000&cht=lxy";
        assertEquals("Junit error", normalize(expectedString), normalize(xyc.toURLString()));


        ScatterPlot sp = GCharts.newScatterPlot(line);
        Logger.global.info(sp.toURLString());
        expectedString = "http://chart.apis.google.com/chart?chs=200x125&chd=e:AAgA..,szDNgA&chco=FF0000&chdl=foo&chm=o,FF0000,0,0,10,0&cht=s";
        assertEquals("Junit error", normalize(expectedString), normalize(sp.toURLString()));
    }
}
