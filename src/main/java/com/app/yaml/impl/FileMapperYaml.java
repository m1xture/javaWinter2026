package com.app.yaml.impl;

import com.app.yaml.FileMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.yaml.snakeyaml.Yaml;

import java.util.HashMap;
import java.util.Map;

public class FileMapperYaml implements FileMapper {
    @Override
    public String convertFileContent(String content) throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        var map = om.readValue(content, HashMap.class);
        Yaml yaml = new Yaml();

        return yaml.dumpAsMap(map);
    }
}
