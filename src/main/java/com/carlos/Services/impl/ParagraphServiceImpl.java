package com.carlos.Services.impl;

import com.carlos.Services.LineService;
import com.carlos.Services.ParagraphService;
import com.carlos.model.WeightedParagraph;
import com.carlos.model.Paragraph;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class ParagraphServiceImpl implements ParagraphService {

    private LineService lineService;

    public ParagraphServiceImpl() {
        lineService = new LineServiceImpl();
    }

    public String getLine(Paragraph paragraph) {
        return paragraph.getLines().stream().collect(Collectors.joining(" "));
    }

    @Override
    public Integer getWeight(Paragraph paragraph) {
        Integer weight = 0;
        for (int i = 0; i < paragraph.getLines().size(); i++) {
            String line = paragraph.getLines().get(i);
            if (i < (paragraph.getLines().size() - 1) && lineService.getWords(line).size() == 1) {
                weight += 500;  // last line with just one word
            } else {  // otherwise
                weight += lineService.getWeight(line);
            }
        }
        return weight;
    }

    @Override
    public Paragraph justifyLeft(Paragraph paragraph, Integer width) {
        String linePar = this.getLine(paragraph);
        return justifyLeft(linePar, width);
    }

    @Override
    public Paragraph justifyLeft(String line, Integer width) {
        Paragraph newParagraph = new Paragraph();
        int lp = 0, mp = 0, rp = 0;
        for (; rp < line.length(); rp++) {
            if (line.charAt(rp) == ' ') {
                mp = rp + 1;
            }
            if (rp > 0 && (rp - lp) % width == 0) {
                addLine(newParagraph, line.substring(lp, mp));
                lp = mp;
            }
        }
        if (lp != rp) addLine(newParagraph, line.substring(lp, rp));
        return newParagraph;
    }

    private void addLine(Paragraph paragraph, String str) {
        if (!str.trim().equals("")) {
            paragraph.addLine(lineService.mergeSpaces(str.trim()));
        }
    }

    @Override
    public Paragraph createParagraphHaving(Paragraph paragraph, String firstLine, Integer width) {
        String linefied = getLine(paragraph);
        Paragraph newParagraph = justifyLeft(linefied.substring(firstLine.length()).trim(), width);
        newParagraph.addLine(0, firstLine);
        return newParagraph;
    }

    @Override
    public WeightedParagraph justifyBoth(Paragraph paragraph, Integer width) {
        Paragraph pLeftJustified = justifyLeft(paragraph, width);
        if (pLeftJustified.getLines().size() < 2) { // not justifiable
            return new WeightedParagraph(pLeftJustified, getWeight(pLeftJustified));
        }

        PriorityQueue<WeightedParagraph> heap = getMaxHeap(pLeftJustified.getLines().size());
        String firstLine = pLeftJustified.getLines().get(0);
        for (String possibleFirstLine : lineService.getPossibleLines(firstLine)) {
            Paragraph possibleParagraph = createParagraphHaving(paragraph, possibleFirstLine, width);
            possibleParagraph.getLines().remove(0);
            WeightedParagraph bestSubJustifiedParagraph = justifyBoth(possibleParagraph, width);
            Paragraph newParagraph = new Paragraph(bestSubJustifiedParagraph.getLines());
            newParagraph.addLine(0, lineService.justifyBoth(possibleFirstLine, width));
            heap.add(new WeightedParagraph(newParagraph, getWeight(newParagraph)));
        }
        WeightedParagraph best = heap.poll();
        return best;
    }

    private PriorityQueue<WeightedParagraph> getMaxHeap(Integer size) {
        return new PriorityQueue<WeightedParagraph>(
                size,
                new Comparator<WeightedParagraph>() {
                    @Override
                    public int compare(WeightedParagraph o1, WeightedParagraph o2) {
                        return Integer.compare(o1.getWeight(), o2.getWeight());
                    }
                });
    }

}
