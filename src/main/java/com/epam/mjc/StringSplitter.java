package com.epam.mjc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;


public class StringSplitter {
    public static void main(String[] args) {
        StringSplitter str = new StringSplitter();
        System.out.println(str.splitByDelimiters("qw3e1rt4yu2i3opa1sd1fg2hj4kl", List.of("1", "2", "3")));
    }

    /**
     * Splits given string applying all delimiters to it. Keeps order of result substrings as in source string.
     *
     * @param source     source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {
        ArrayList<String> delimitersArray = new ArrayList<>(delimiters);
        StringBuilder delimiterString = new StringBuilder();

        delimiterString.append("[");
        for (String item : delimitersArray) {
            delimiterString.append(item);
        }
        delimiterString.append("]");

        ArrayList<String> splitString;
        splitString = new ArrayList<>(Arrays.asList(source.split(delimiterString.toString())));
        splitString.removeAll(List.of(""));
        return splitString;
    }
}
