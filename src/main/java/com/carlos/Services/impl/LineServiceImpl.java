package com.carlos.Services.impl;

import com.carlos.Services.LineService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LineServiceImpl implements LineService {

    @Override
    public String mergeSpaces(String str) {
        char currentChar = '\0', previousChar = '\0';
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < str.length(); i++) {
            currentChar = str.charAt(i);
            if (currentChar == ' ') {
                if (previousChar != ' ') {
                    sb.append(currentChar);
                }
            } else {
                sb.append(currentChar);
            }
            previousChar = currentChar;
        }
        return sb.toString();
    }

    @Override
    public Integer getWeight(String line) {
        Double weight = 0d;

        int lp = 0, mp = 0, rp = 0; //left, middle and right pointers
        for (; rp < line.length(); rp++) {
            if (line.charAt(rp) != ' ' && line.charAt(mp) == ' ') {
                weight += Math.pow(rp - lp - 1, 2);
            }
            if (line.charAt(rp) == ' ' && line.charAt(mp) != ' ') {
                lp = rp;
            }
            mp = rp;
        }
        return weight.intValue();
    }

    @Override
    public String getWord(String line, Integer pos) throws Exception {
        return getWords(line).get(pos);
    }

    @Override
    public List<String> getWords(String line) {
        line = mergeSpaces(line);
        String[] words = line.split(" ");
        return Arrays.asList(words);
    }

    @Override
    public List<String> getPossibleLines(String line) {
        List<String> words = getWords(line);
        List<String> possibleLines = new ArrayList<>();
        possibleLines.add(words.get(0));
        for (int i = 1; i < words.size(); i++) {
            possibleLines.add(possibleLines.get(i - 1) + " " + words.get(i));
        }
        return possibleLines;
    }

    @Override
    public Integer getSpacesNumber(String str) {
        return (int) str.chars().mapToObj(i -> (char) i).filter(c -> c == ' ').count();
    }

    @Override
    public String justifyBoth(String line, Integer width) {
        line = mergeSpaces(line);
        if (line.length() >= width) return line;    // line too long

        Integer totalSpaces = width - line.length() + getSpacesNumber(line);
        Integer gaps = getGapsNumber(line);
        if (gaps == 0) return line; // not justifiable

        Integer spacesXGap = totalSpaces / gaps;
        Integer bigGaps = totalSpaces % gaps;

        StringBuffer justifiedLineSb = new StringBuffer();
        int wordNum = 0;
        for (String word : getWords(line)) {
            justifiedLineSb.append(word);
            if (wordNum < gaps) {
                if (wordNum < bigGaps) justifiedLineSb.append(createGap(spacesXGap + 1));
                else justifiedLineSb.append(createGap(spacesXGap));
            }
            wordNum++;
        }

        return justifiedLineSb.toString();
    }

    @Override
    public String createGap(Integer n) {
        return String.format("%" + n + "s", "");
    }

    @Override
    public Integer getGapsNumber(String str) {
        Integer counter = 0;
        String mergedStr = mergeSpaces(str);
        for (int i = 0; i < mergedStr.length(); i++) {
            if (mergedStr.charAt(i) == ' ') {
                counter++;
            }
        }
        return counter;
    }

}
