package io.github.davidbruce.jsg;


import io.github.humbleui.skija.Font;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Wrap {
    public static List<String> splitOnSpace(String str) {
        //might need to update this to deal with non-breaking space U+00A0
        return Arrays.asList(str.trim().split("\\s+"));
    }
    public static List<String> wordWrap(Font font, String str, float width) {
        var lineLength = 0.0;
        var wrappedLines = new ArrayList<String>();
        for (var line : str.split("\n")) {
            var word = splitOnSpace(line);
            var wordSpaceLength = font.measureText(word + " ").getWidth();
            if (lineLength + wordSpaceLength > width) {
               wrappedLines.add(line);
               lineLength = wordSpaceLength;
            } else {
                lineLength += wordSpaceLength;
            }
        }
        return wrappedLines;
    }
}
