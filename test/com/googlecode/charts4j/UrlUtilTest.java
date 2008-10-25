package com.googlecode.charts4j;

import static com.googlecode.charts4j.UrlUtil.normalize;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UrlUtilTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
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
    public void testNormalize() {
        final String unnormalizedString = "http://chart.apis.google.com/chart?cht=lc&chs=200x125&chxt=x&chd=e:AA&chxl=0:|start|end";
        final String expectedString = "http://chart.apis.google.com/chart?chd=e:AA&chs=200x125&cht=lc&chxl=0:|start|end&chxt=x";
        assertEquals("Junit error", normalize(expectedString), UrlUtil.normalize(unnormalizedString));
    }
}
