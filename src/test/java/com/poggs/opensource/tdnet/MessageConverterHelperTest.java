package com.poggs.opensource.tdnet;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for the MessageConverterHelper class
 *
 * @author pwh
 */
public class MessageConverterHelperTest {

    @Test
    public void returnsEmptyForNullString() {
        String result = MessageConverterHelper.emptyIfNull(null);
        assertEquals("", result);
    }

    @Test
    public void returnsStringForNonNullString() {
        String result = MessageConverterHelper.emptyIfNull("test");
        assertEquals("test", result);
    }

    @Test
    public void returnsStringForEmptyString() {
        String result = MessageConverterHelper.emptyIfNull("");
        assertEquals("", result);
    }

}