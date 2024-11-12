package com.nfl.library.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertData implements IConvertData {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public <T> T obtainData (String json, Class<T> clas) {
        try{
            return objectMapper.readValue(json, clas);

        } catch (JsonProcessingException e ){
            throw new RuntimeException(e);
        }
    }

}
