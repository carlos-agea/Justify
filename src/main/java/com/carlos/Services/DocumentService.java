package com.carlos.Services;

import com.carlos.model.FileModel;
import java.util.stream.Stream;

public interface DocumentService {
    FileModel getFileModel(Stream<String> fileStream) throws NumberFormatException;
}
