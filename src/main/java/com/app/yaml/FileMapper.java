package com.app.yaml;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface FileMapper {
    String convertFileContent(String content) throws JsonProcessingException;
}
