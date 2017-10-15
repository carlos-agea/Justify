package com.carlos.Services;

import com.carlos.Services.impl.DocumentServiceImpl;
import com.carlos.Services.impl.FileServiceImpl;
import com.carlos.model.FileModel;
import com.carlos.model.Paragraph;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.stream.Stream;

public class DocumentService_paragraphTest {

    private final String FILE_PATH_1 = "src/test/resources/testfile_1.txt";
    DocumentService documentService;

    Stream<String> getFileLines(String filepath) {
        FileService fileService = new FileServiceImpl();
        Stream<String> fileStream = null;
        try {
            fileStream = fileService.readFile(filepath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileStream;
    }

    @Before
    public void setUp() {
        documentService = new DocumentServiceImpl();
    }

    @Test
    public void getFileModel_shouldReturn2Paragraphs() {
        // When
        FileModel fileModel = documentService.getFileModel(getFileLines("src/test/resources/testfile_2.txt"));

        // Verify
        Assert.assertEquals(fileModel.getWidth(), new Integer(20));

        Assert.assertEquals(fileModel.getParagraph().size(), 2);
        Paragraph paragraph = fileModel.getParagraph().get(0);
        Assert.assertEquals(paragraph.getLines().size(), 3);
        Assert.assertTrue(paragraph.getLines().get(0).equals("Here is an example of"));
        Assert.assertTrue(paragraph.getLines().get(1).equals("unjustified text"));
        Assert.assertTrue(paragraph.getLines().get(2).equals("in a column."));

        paragraph = fileModel.getParagraph().get(1);
        Assert.assertEquals(paragraph.getLines().size(), 2);
        Assert.assertTrue(paragraph.getLines().get(0).equals("Here is another example of"));
        Assert.assertTrue(paragraph.getLines().get(1).equals("unjustified text in a column."));
    }

    @Test
    public void getFileModel_shouldReturn3Paragraphs() {
        // When
        FileModel fileModel = documentService.getFileModel(getFileLines("src/test/resources/testfile_width20.txt"));

        // Verify
        Assert.assertEquals(fileModel.getWidth(), new Integer(22));

        Assert.assertEquals(fileModel.getParagraph().size(), 3);
        Paragraph paragraph = fileModel.getParagraph().get(0);
        Assert.assertEquals(paragraph.getLines().size(), 1);
        Assert.assertTrue(paragraph.getLines().get(0).equals("Here is an example of unjustified text in a column."));

        paragraph = fileModel.getParagraph().get(1);
        Assert.assertEquals(paragraph.getLines().size(), 5);
        Assert.assertTrue(paragraph.getLines().get(0).equals("You are to write a"));
        Assert.assertTrue(paragraph.getLines().get(1).equals("program"));
        Assert.assertTrue(paragraph.getLines().get(2).equals("that justifies this"));
        Assert.assertTrue(paragraph.getLines().get(3).equals("text to a"));
        Assert.assertTrue(paragraph.getLines().get(4).equals("specific width."));

        paragraph = fileModel.getParagraph().get(2);
        Assert.assertEquals(paragraph.getLines().size(), 1);
        Assert.assertTrue(paragraph.getLines().get(0).equals("Good luck and have fun with this problem."));
    }
    
}
