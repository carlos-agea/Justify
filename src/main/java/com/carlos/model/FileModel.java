package com.carlos.model;

import java.util.ArrayList;
import java.util.List;

public class FileModel {
    private Integer width;
    private Integer weight;
    private List<Paragraph> paragraph;

    public FileModel() {
        this.paragraph = new ArrayList<>();
        this.width = 0;
        this.weight = 0;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public List<Paragraph> getParagraph() {
        return paragraph;
    }

    public void setParagraph(List<Paragraph> paragraph) {
        this.paragraph = paragraph;
    }

    public void addParagraph(Paragraph paragraph) {
        this.paragraph.add(paragraph);
    }

}
