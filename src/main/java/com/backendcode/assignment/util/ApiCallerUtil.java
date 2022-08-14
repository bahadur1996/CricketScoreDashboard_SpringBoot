package com.backendcode.assignment.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import java.net.URLEncoder;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class ApiCallerUtil {
    private static Logger logger = Logger.getLogger(ApiCallerUtil.class);
    public static String executeGetMethod(String url, Map<String, String> requestParams) {

        if(Objects.nonNull(requestParams) && requestParams.size() > 0){
            url = url+"?";
            for(Map.Entry<String, String> entry: requestParams.entrySet()){
                try {
                    entry.setValue(URLEncoder.encode(entry.getValue(),"UTF-8"));
                }catch (Exception exception){
                    logger.info("error: "+exception);
                }
            }
            url = requestParams.entrySet().stream().map(entry -> entry.getKey()+"="+entry.getValue()).collect(Collectors.joining("&",url,""));
        }
        try(CloseableHttpClient client = HttpClients.createDefault()) {
            logger.info("API is called with url: "+url);
            HttpGet getRequest = new HttpGet(url);
            HttpEntity httpEntity = client.execute(getRequest).getEntity();
            return EntityUtils.toString(httpEntity);
        }catch (Exception exception){
            logger.info("error: "+exception.getMessage());
            return "";
        }
    }
}
