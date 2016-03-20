package com.poggs.opensource.tdnet;

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
    public static String emptyIfNull(String input) {
        return input == null ? "" : input;
    }

}
