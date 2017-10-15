package com.carlos.model;

import com.carlos.Services.Weightable;
import java.util.List;

public class WeightedParagraph implements Weightable {

    private List<String> lines;
    private Integer weight;

    public WeightedParagraph(Paragraph paragraph, Integer weight) {
        this.lines = paragraph.getLines();
        this.weight = weight;
    }

    @Override
    public Integer getWeight() {
        return this.weight;
    }

    public List<String> getLines() {
        return this.lines;
    }
}
