package com.jifenbao.service.result;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

public class ResultHelper {
    
    private static Logger LOG = Logger.getLogger(ResultHelper.class);

    public static BaseResult generateResult(boolean success, String errorCode, String errorMsg){
        BaseResult result = new BaseResult(success, errorCode, errorMsg);
        return result;
    }

    public static String generateStringResult(boolean success, String errorCode, String errorMsg){
        return jasonString(generateResult(success, errorCode, errorMsg));
    }
    
    public static String jasonString(Object o) {
        ObjectMapper mapper =  new ObjectMapper();
        try {
            return mapper.writeValueAsString(o);
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
        return null;
    }
    
    public static <T> List<T> json2Object(String json){
        ObjectMapper mapper =  new ObjectMapper();
        try {
            @SuppressWarnings("unchecked")
            List<T> list = mapper.readValue(json, List.class);
            return list;
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
        return null;
    }

}
