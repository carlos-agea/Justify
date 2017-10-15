package com.carlos.Services.impl;

import com.carlos.Services.FileService;
import com.carlos.model.FileModel;
import com.carlos.model.Paragraph;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.stream.Stream;

public class FileServiceImpl implements FileService {
    @Override
    public Stream<String> readFile(String filePath) throws IOException {
        return Files.lines(Paths.get(filePath));
    }

    @Override
    public void writeFileModel(FileModel fileModel, String filePath) {
        deleteFile(filePath);
        createFile(filePath);
        for (Paragraph paragraph : fileModel.getParagraph()) {
            writeParagraph(filePath, paragraph);
            writeLine(filePath, "");
        }
        writeLine(filePath, fileModel.getWeight().toString());
    }

    private void writeParagraph(String filePath, Paragraph paragraph) {
        for (String line : paragraph.getLines()) {
            writeLine(filePath, line);
        }
    }

    @Override
    public void deleteFile(String filePath) {
        Path path = Paths.get(filePath);
        try {
            Files.delete(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createFile(String filePath) {
        try {
            Files.write(Paths.get(filePath), "".getBytes(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeLine(String filePath, String str) {
        try {
            Files.write(Paths.get(filePath), (str + "\r\n").getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
