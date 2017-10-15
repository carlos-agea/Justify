package com.carlos.Services;

import com.carlos.Services.impl.FileServiceImpl;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.stream.Stream;

public class FileServiceTest {

    @Test
    public void readFile_shouldReturnFileLines() {
        FileService fileService = new FileServiceImpl();
        Stream<String> fileLines = null;
        try {
            fileLines = fileService.readFile("src/test/resources/testfile_width20.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(fileLines.count(), 11);
    }
}
