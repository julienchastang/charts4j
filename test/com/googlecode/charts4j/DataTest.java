package com.googlecode.charts4j;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DataTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).setLevel(Level.ALL);
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
    public void testData0() {
        try {
            @SuppressWarnings("unused")
            final Data data = new Data(null);
        } catch (NullPointerException e) {
            return;
        }
        fail();// Should not happen
    }

    @Test
    public void testData1() {
        Data data = new Data(-1, 0, 100);
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(data.toString());
        assertEquals("Junit error", "[-1.0, 0.0, 100.0]", data.toString());

    }

    @Test
    public void testNewDataListOfQextendsNumber() {
        Data data = Data.newData(Arrays.asList(-1, 0, 100));
        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info(data.toString());
        assertEquals("Junit error", "[-1.0, 0.0, 100.0]", data.toString());
    }
}
