package com.carlos.Services;

import com.carlos.Services.impl.DocumentServiceImpl;
import com.carlos.Services.impl.FileServiceImpl;
import com.carlos.model.FileModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.stream.Stream;

public class DocumentService_getFileModelTest {

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

    @Test(expected = NumberFormatException.class)
    public void getFileModel_shouldThrowException() {
        // When
        FileModel fileModel = documentService.getFileModel(getFileLines("src/test/resources/testfile_1.txt"));
    }

    @Test
    public void getFileModel_shouldReturnWidth20() {
        // When
        FileModel fileModel = documentService.getFileModel(getFileLines("src/test/resources/testfile_width20.txt"));

        // Verify
        Assert.assertEquals(fileModel.getWidth(), new Integer(22));
    }

}
