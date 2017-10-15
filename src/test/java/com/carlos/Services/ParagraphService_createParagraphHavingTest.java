package com.carlos.Services;

import com.carlos.Services.impl.ParagraphServiceImpl;
import com.carlos.model.Paragraph;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParagraphService_createParagraphHavingTest {

    ParagraphService paragraphService;

    @Before
    public void setUp() {
        paragraphService = new ParagraphServiceImpl();
    }

    @Test
    public void getCreateParagraphHaving_shouldCreateNewParagraphWithGivenFirstLine_0() {
        // Given
        Paragraph paragraph = new Paragraph();
        paragraph.addLine("You are to write a");
        paragraph.addLine("program");
        paragraph.addLine("that justifies this");
        paragraph.addLine("text to a");
        paragraph.addLine("specific width.");

        // Wen
        Paragraph newParagraph = paragraphService.createParagraphHaving(paragraph, "You are to", 20);

        // Verify
        Assert.assertEquals(newParagraph.getLines().size(), 4);
        Assert.assertEquals(newParagraph.getLines().get(0), "You are to");
        Assert.assertEquals(newParagraph.getLines().get(1), "write a program that");
        Assert.assertEquals(newParagraph.getLines().get(2), "justifies this text");
        Assert.assertEquals(newParagraph.getLines().get(3), "to a specific width.");
    }

    @Test
    public void getCreateParagraphHaving_shouldCreateNewParagraphWithGivenFirstLine_1() {
        // Given
        Paragraph paragraph = new Paragraph();
        paragraph.addLine("You are to write a");
        paragraph.addLine("program");
        paragraph.addLine("that justifies this");
        paragraph.addLine("text to a");
        paragraph.addLine("specific width.");

        // Wen
        Paragraph newParagraph = paragraphService.createParagraphHaving(paragraph, "You are", 20);

        // Verify
        Assert.assertEquals(newParagraph.getLines().size(), 5);
        Assert.assertEquals(newParagraph.getLines().get(0), "You are");
        Assert.assertEquals(newParagraph.getLines().get(1), "to write a program");
        Assert.assertEquals(newParagraph.getLines().get(2), "that justifies this");
        Assert.assertEquals(newParagraph.getLines().get(3), "text to a specific");
        Assert.assertEquals(newParagraph.getLines().get(4), "width.");
    }

}
