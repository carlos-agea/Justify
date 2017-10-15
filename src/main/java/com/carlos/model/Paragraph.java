package com.carlos.model;

import java.util.ArrayList;
import java.util.List;

public class Paragraph {
    private List<String> lines;

    public Paragraph() {
        this.lines = new ArrayList<>();
    }
    public Paragraph(List<String> lines) {
        this.lines = new ArrayList<>(lines);
    }

    public List<String> getLines() {
        return lines;
    }
    public void addLine(String line) {
        this.lines.add(line);
    }
    public void addLine(Integer position, String line) {
        this.lines.add(position, line);
    }

}
