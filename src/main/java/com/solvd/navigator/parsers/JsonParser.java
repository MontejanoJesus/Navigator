package com.solvd.navigator.parsers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.solvd.navigator.model.Result;

import java.io.File;
import java.io.IOException;

public class JsonParser {
    public void writeToJson(Result result) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.writeValue(new File("src\\main\\resources\\result.json"), result);
    }
}
