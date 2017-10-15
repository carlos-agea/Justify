package com.carlos;

import com.carlos.Services.DocumentService;
import com.carlos.Services.FileService;
import com.carlos.Services.ParagraphService;
import com.carlos.Services.impl.DocumentServiceImpl;
import com.carlos.Services.impl.FileServiceImpl;
import com.carlos.Services.impl.ParagraphServiceImpl;
import com.carlos.model.FileModel;
import com.carlos.model.Paragraph;
import com.carlos.model.WeightedParagraph;

import java.io.IOException;
import java.util.stream.Stream;

public class Justifycator {

    public static void main(String[] args) {
        FileService fileService = new FileServiceImpl();
        DocumentService documentService = new DocumentServiceImpl();
        ParagraphService paragraphService = new ParagraphServiceImpl();

        Stream<String> fileLines = null;
        try {
            fileLines = fileService.readFile(args[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileModel fileModel = documentService.getFileModel(fileLines);
        FileModel outFileModel = new FileModel();
        for(Paragraph paragraph: fileModel.getParagraph()) {
            WeightedParagraph weightedParagraph = paragraphService.justifyBoth(paragraph, fileModel.getWidth());
            outFileModel.addParagraph(new Paragraph(weightedParagraph.getLines()));
            outFileModel.setWeight(outFileModel.getWeight()+weightedParagraph.getWeight());
        }
        fileService.writeFileModel(outFileModel, args[1]);
    }

}
