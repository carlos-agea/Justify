package com.carlos.Services;

import com.carlos.Services.impl.ParagraphServiceImpl;
import com.carlos.model.Paragraph;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParagraphService_justifyLeftTest {

    ParagraphService paragraphService;

    @Before
    public void setUp() {
        paragraphService = new ParagraphServiceImpl();
    }

    @Test
    public void getGustifyLeft_shouldJustifyLeftTheParagraphHavingWidth20() {
        // Given
        Paragraph paragraph = new Paragraph();
        paragraph.addLine("You are to write a");
        paragraph.addLine("program");
        paragraph.addLine("that justifies this");
        paragraph.addLine("text to a");
        paragraph.addLine("specific width.");

        // Wen
        Paragraph newParagraph = paragraphService.justifyLeft(paragraph, 20);

        // Verify
        Assert.assertEquals(newParagraph.getLines().size(), 4);
        Assert.assertEquals(newParagraph.getLines().get(0), "You are to write a");
        Assert.assertEquals(newParagraph.getLines().get(1), "program that");
        Assert.assertEquals(newParagraph.getLines().get(2), "justifies this text");
        Assert.assertEquals(newParagraph.getLines().get(3), "to a specific width.");
    }

    @Test
    public void getGustifyLeft_shouldJustifyLeftTheParagraphHavingWidth22() {
        // Given
        Paragraph paragraph = new Paragraph();
        paragraph.addLine("this text to a specific");

        // Wen
        Paragraph newParagraph = paragraphService.justifyLeft(paragraph, 22);

        // Verify
        Assert.assertEquals(newParagraph.getLines().size(), 2);
        Assert.assertEquals(newParagraph.getLines().get(0), "this text to a");
        Assert.assertEquals(newParagraph.getLines().get(1), "specific");
    }

    @Test
    public void getGustifyLeft_shouldJustifyLeftSingleLineParagraph() {
        // Given
        Paragraph paragraph = new Paragraph();
        paragraph.addLine("Good luck and have fun with this problem.");

        // Wen
        Paragraph newParagraph = paragraphService.justifyLeft(paragraph, 22);

        // Verify
        Assert.assertEquals(newParagraph.getLines().size(), 2);
        Assert.assertEquals(newParagraph.getLines().get(0), "Good luck and have fun");
        Assert.assertEquals(newParagraph.getLines().get(1), "with this problem.");
    }

    @Test
    public void getGustifyLeft_shouldJustifyLeftSmallParagraph() {
        // Given
        Paragraph paragraph = new Paragraph();
        paragraph.addLine("Good luck and have fun");

        // Wen
        Paragraph newParagraph = paragraphService.justifyLeft(paragraph, 22);

        // Verify
        Assert.assertEquals(newParagraph.getLines().size(), 1);
        Assert.assertEquals(newParagraph.getLines().get(0), "Good luck and have fun");
    }

    @Test
    public void getGustifyLeft_shouldJustifyLeftTwoLinesParagraph() {
        // Given
        Paragraph paragraph = new Paragraph();
        paragraph.addLine("Good luck and have fun with it.");

        // Wen
        Paragraph newParagraph = paragraphService.justifyLeft(paragraph, 22);

        // Verify
        Assert.assertEquals(newParagraph.getLines().size(), 2);
        Assert.assertEquals(newParagraph.getLines().get(0), "Good luck and have fun");
        Assert.assertEquals(newParagraph.getLines().get(1), "with it.");
    }

    @Test
    public void getGustifyLeft_shouldJustifyLeftFullSizedParagraph() {
        // Given
        Paragraph paragraph = new Paragraph();
        paragraph.addLine("justifies this text to a specific width.");

        // Wen
        Paragraph newParagraph = paragraphService.justifyLeft(paragraph, 20);

        // Verify
        Assert.assertEquals(newParagraph.getLines().size(), 2);
        Assert.assertEquals(newParagraph.getLines().get(0), "justifies this text");
        Assert.assertEquals(newParagraph.getLines().get(1), "to a specific width.");
    }
}
