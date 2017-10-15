package com.carlos.Services;

import java.util.List;

public interface LineService {
    Integer getGapsNumber(String str);
    String mergeSpaces(String str);
    String getWord(String line, Integer pos) throws Exception;
    List<String> getWords(String line);
    Integer getSpacesNumber(String str);
    String justifyBoth(String line, Integer width);
    String createGap(Integer n);
    List<String> getPossibleLines(String line);
    Integer getWeight(String line);
}
