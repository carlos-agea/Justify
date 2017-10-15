package com.carlos.Services;

import com.carlos.model.Paragraph;
import com.carlos.model.WeightedParagraph;

public interface ParagraphService {
    String getLine(Paragraph paragraph);
    Paragraph justifyLeft(Paragraph paragraph, Integer width);
    WeightedParagraph justifyBoth(Paragraph paragraph, Integer width);
    Paragraph createParagraphHaving(Paragraph paragraph, String firstLine, Integer width);
    Integer getWeight(Paragraph paragraph);
    Paragraph justifyLeft(String line, Integer width);
}
