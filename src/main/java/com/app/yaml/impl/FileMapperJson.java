package com.app.yaml.impl;

import com.app.yaml.FileMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.util.HashMap;

public class FileMapperJson implements FileMapper {
    @Override
    public String convertFileContent(String content) throws JsonProcessingException {
        Yaml yaml = new Yaml(new Constructor(HashMap.class, new LoaderOptions()));
        HashMap map = yaml.load(content);


        return new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(map);
    }
}
