package com.carlos.Services;

import com.carlos.Services.impl.ParagraphServiceImpl;
import com.carlos.model.Paragraph;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParagraphService_getWeightForParagraphTest {

    ParagraphService paragraphService;

    @Before
    public void setUp() {
        paragraphService = new ParagraphServiceImpl();
    }

    @Test
    public void getWeight_shouldReturnWeightOfUnjustifiedParagraph() {
        // Given
        Paragraph paragraph = new Paragraph();
        paragraph.addLine("Here is an example of");
        paragraph.addLine("unjustified text");
        paragraph.addLine("in a column.");

        // Wen
        Integer weight = paragraphService.getWeight(paragraph);

        // Verify
        Assert.assertEquals(weight, new Integer(0));
    }

    @Test
    public void getWeight_shouldReturnWeightOfJustifiedParagraph_0() {
        // Given
        Paragraph paragraph = new Paragraph();
        paragraph.addLine("Here  is an example of");
        paragraph.addLine("unjustified       text");
        paragraph.addLine("in a column.");

        // Wen
        Integer weight = paragraphService.getWeight(paragraph);

        // Verify
        Assert.assertEquals(weight, new Integer(37));
    }

    @Test
    public void getWeight_shouldReturnWeightOfJustifiedParagraph_1() {
        // Given
        Paragraph paragraph = new Paragraph();
        paragraph.addLine("Here   is  an  example");
        paragraph.addLine("of   unjustified  text");
        paragraph.addLine("in a column.");

        // Wen
        Integer weight = paragraphService.getWeight(paragraph);

        // Verify
        Assert.assertEquals(weight, new Integer(11));
    }

    @Test
    public void getWeight_shouldReturnWeightOfParagraphWithSingleWordSentence() {
        // Given
        Paragraph paragraph = new Paragraph();
        paragraph.addLine("Here");
        paragraph.addLine("is an example.");
        // Wen
        Integer weight = paragraphService.getWeight(paragraph);

        // Verify
        Assert.assertEquals(weight, new Integer(500));
    }
}
