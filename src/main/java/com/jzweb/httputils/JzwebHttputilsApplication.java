package com.jzweb.httputils;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JzwebHttputilsApplication {

    public static void main(String[] args) {
        SpringApplication.run(JzwebHttputilsApplication.class, args);
        //System.out.println(HttpApiConfiguration.getApiMap().get("api01").toString());
    }

}
