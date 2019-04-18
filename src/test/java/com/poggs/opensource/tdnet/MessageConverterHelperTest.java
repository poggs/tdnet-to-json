package com.poggs.opensource.tdnet;

import org.junit.Test;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import java.util.GregorianCalendar;

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

    @Test
    public void convertsXMLGregorianCalendarToString() throws DatatypeConfigurationException {
        GregorianCalendar cal = new GregorianCalendar();
        long targetTime = 1454328000000L;
        cal.setTimeInMillis(targetTime);
        XMLGregorianCalendar gregCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
        String result = MessageConverterHelper.timestampToEpochSecs(gregCal);
        assertEquals("1454328000000", result);
    }

    @Test
    public void returnsNullWhenXMLGregorianCalendarObjectIsNull() {
        String result = MessageConverterHelper.timestampToEpochSecs(null);
        assertEquals("", result);
    }

}