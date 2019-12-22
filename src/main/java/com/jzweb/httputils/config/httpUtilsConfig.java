package com.jzweb.httputils.config;

import com.jzweb.httputils.vo.ApiConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ryan
 * @version 1.0
 * @date 12/21/2019
 */
@Configuration
@PropertySource(value = "classpath:apiconfig-list.properties")
@ConfigurationProperties(prefix = "http")
public class httpUtilsConfig {

    private List<ApiConfig> configs = new ArrayList<>();

    public List<ApiConfig> getConfigs() {
        return configs;
    }

    public void setConfigs(List<ApiConfig> configs) {
        this.configs = configs;
    }
}
