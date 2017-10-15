package com.carlos.Services;

import com.carlos.Services.impl.ParagraphServiceImpl;
import com.carlos.model.Paragraph;
import com.carlos.model.WeightedParagraph;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParagraphService_justifyBothTest {

    ParagraphService paragraphService;

    @Before
    public void setUp() {
        paragraphService = new ParagraphServiceImpl();
    }

    @Test
    public void getGustifyBoth_shouldJustifyBothTheParagraph_0() {
        // Given
        Paragraph paragraph = new Paragraph();
        paragraph.addLine("Here is an example of");
        paragraph.addLine("unjustified text");
        paragraph.addLine("in a column.");

        // Wen
        WeightedParagraph newParagraph = paragraphService.justifyBoth(paragraph, 22);

        // Verify
        Assert.assertEquals(newParagraph.getWeight(), new Integer(2));
        Assert.assertEquals(newParagraph.getLines().size(), 3);
        Assert.assertEquals(newParagraph.getLines().get(0), "Here  is an example of");
        Assert.assertEquals(newParagraph.getLines().get(1), "unjustified  text in a");
        Assert.assertEquals(newParagraph.getLines().get(2), "column.");
    }

    @Test
    public void getGustifyBoth_shouldJustifyBothTheParagraph_1() {
        // Given
        Paragraph paragraph = new Paragraph();
        paragraph.addLine("You are to write a");
        paragraph.addLine("program");
        paragraph.addLine("that justifies this");
        paragraph.addLine("text to a");
        paragraph.addLine("specific width.");

        // Wen
        WeightedParagraph newParagraph = paragraphService.justifyBoth(paragraph, 22);

        // Verify
        Assert.assertEquals(newParagraph.getLines().size(), 4);
        Assert.assertEquals(newParagraph.getWeight(), new Integer(26));
        Assert.assertEquals(newParagraph.getLines().get(0), "You  are  to  write  a");
        Assert.assertEquals(newParagraph.getLines().get(1), "program that justifies");
        Assert.assertEquals(newParagraph.getLines().get(2), "this    text    to   a");
        Assert.assertEquals(newParagraph.getLines().get(3), "specific width.");
    }

    @Test
    public void getGustifyBoth_shouldJustifyBothTheParagraphGivenSingleParagraphLin() {
        // Given
        Paragraph paragraph = new Paragraph();
        paragraph.addLine("Good luck and have fun with this problem.");

        // Wen
        WeightedParagraph newParagraph = paragraphService.justifyBoth(paragraph, 22);

        // Verify
        Assert.assertEquals(newParagraph.getLines().size(), 2);
        Assert.assertEquals(newParagraph.getLines().get(0), "Good luck and have fun");
        Assert.assertEquals(newParagraph.getLines().get(1), "with this problem.");
    }

}
