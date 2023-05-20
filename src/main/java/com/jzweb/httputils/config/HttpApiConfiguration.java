package com.jzweb.httputils.config;

import com.jzweb.httputils.vo.ApiManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Ryan
 * @version 1.0
 * @date 2/15/2020
 */
@Configuration
@EnableConfigurationProperties(HttpApiProperties.class)
public class HttpApiConfiguration {

    private static Map<String, ApiManage> apiMap;

    private HttpApiProperties httpApi;

    @Autowired
    public HttpApiConfiguration(HttpApiProperties httpApiProperties){
        this.httpApi = httpApiProperties;
        //this.httpApi.getConfigs().stream().forEach(System.out::println);
        apiMap = this.httpApi.getConfigs().stream().collect(Collectors.toMap(ApiManage::getCode,a->a));

    }




    public static Map<String, ApiManage> getApiMap() {
        return apiMap;
    }
}
