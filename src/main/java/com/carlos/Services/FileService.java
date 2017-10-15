package com.carlos.Services;

import com.carlos.model.FileModel;

import java.io.IOException;
import java.util.stream.Stream;

public interface FileService {
    Stream<String> readFile(String filePath) throws IOException;
    void writeFileModel(FileModel fileModel, String filePath);
    void deleteFile(String filePath);
    void createFile(String filePath);
    void writeLine(String filePath, String str);
}
