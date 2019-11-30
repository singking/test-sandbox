package com.singking.dates;

import static org.junit.Assert.assertEquals;

public class TestADateFormatter {

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void testAccount2() throws java.text.ParseException {
        java.text.DateFormat df = java.text.DateFormat.getTimeInstance(java.text.DateFormat.SHORT, java.util.Locale.US);

        System.out.println(df.parse("12:00 pm"));

        assertEquals("Thu Jan 01 12:00:00 GMT 1970", df.parse("12:00 pm").toString());
    }
}
