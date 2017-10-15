package com.carlos.Services;

import com.carlos.Services.impl.ParagraphServiceImpl;
import com.carlos.model.Paragraph;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParagraphService_linefyTest {

    ParagraphService paragraphService;

    @Before
    public void setUp() {
        paragraphService = new ParagraphServiceImpl();
    }

    @Test
    public void getLineOnParagraph_shouldReturnParagraphLine() {
        // Given
        Paragraph paragraph = new Paragraph();
        paragraph.addLine("You are to write a");
        paragraph.addLine("program");
        paragraph.addLine("that justifies this");
        paragraph.addLine("text to a");
        paragraph.addLine("specific width.");

        // Wen
        String line = paragraphService.getLine(paragraph);

        // Verify
        Assert.assertEquals(line, "You are to write a program that justifies this text to a specific width.");
    }
}
