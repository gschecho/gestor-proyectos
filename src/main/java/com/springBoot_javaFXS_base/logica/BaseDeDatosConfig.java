package com.springBoot_javaFXS_base.logica;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BaseDeDatosConfig {

    @Value("${spring.datasource.url}")
    private String url;


    public String getUrl() {
        return url;
    }
}
