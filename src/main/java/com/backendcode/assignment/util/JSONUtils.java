package com.backendcode.assignment.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

public enum JSONUtils {
    INTANCE;
    private  final ObjectMapper objectMapper = new ObjectMapper();
    private Logger logger = Logger.getLogger(JSONUtils.class);

    JSONUtils()
    {
        this.objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);;
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    public <T> T fromJson(String json, Class<T> clazz)
    {
        try {
            return this.objectMapper.readValue(json, clazz);
        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            logger.fatal("error to parse json to object", e);
        }

        return null;
    }
}


