package com.carlos.Services.impl;

import com.carlos.Services.DocumentService;
import com.carlos.model.FileModel;
import com.carlos.model.Paragraph;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DocumentServiceImpl implements DocumentService {
    @Override
    public FileModel getFileModel(Stream<String> fileStream) throws NumberFormatException {
        FileModel fileModel = new FileModel();
        List<String> lines = fileStream.collect(Collectors.toList());

        // Get width
        fileModel.setWidth(Integer.parseInt(lines.get(0)));

        // Check empty line
        if (!"".equals(lines.get(1))) throw new NumberFormatException("File has wrong format");

        // Get paragraphs
        int lineNumber = 2;
        String line = "";
        Paragraph paragraph = new Paragraph();
        while (lineNumber < lines.size()) {
            line = lines.get(lineNumber++);
            if ("".equals(line)) {
                fileModel.addParagraph(paragraph);
                paragraph = new Paragraph();
            } else {
                paragraph.addLine(line);
            }
        }
        fileModel.addParagraph(paragraph);

        return fileModel;
    }

}
