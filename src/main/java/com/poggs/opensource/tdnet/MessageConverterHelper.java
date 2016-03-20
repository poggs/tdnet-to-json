package com.poggs.opensource.tdnet;

import javax.xml.datatype.XMLGregorianCalendar;

/**
 * Common helper methods for TD.net message conversion
 *
 * @author pwh
 */
public class MessageConverterHelper {

    /**
     * Convert null strings to empty strings
     * @param input An input string or null
     * @return An empty string if the input string is null, otherwise returns the input string
     */
    public static String emptyIfNull(Object input) {

        String returnValue = "";

        if(input != null) {
            returnValue = input.toString();
        }

        return returnValue;

    }

    /**
     * Convert an XMLGregorianCalendar object in to epoch seconds
     * @param input An XMLGregorianCalendar object
     * @return The number of milliseconds since the UNIX epoch as a String
     */
    public static String timestampToEpochSecs(XMLGregorianCalendar input) {

        String returnValue = "";

        if(input != null) {
            long timestamp = input.toGregorianCalendar().toInstant().toEpochMilli();
            returnValue = String.valueOf(timestamp);
        }

        return returnValue;

    }

}
