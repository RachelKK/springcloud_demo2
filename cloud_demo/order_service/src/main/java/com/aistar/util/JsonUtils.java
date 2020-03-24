package com.aistar.util;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Json工具类
 */
public class JsonUtils {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * json字符串转换成JsonNode对象的方法
     * @param str
     * @return
     */
    public static JsonNode string2JsonNode(String str){
        try {
            return objectMapper.readTree(str);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }

    }

}
