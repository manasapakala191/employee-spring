package com.increff.employee.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AboutAppService {
    @Value("${app.name}")
    private String version;

    @Value("${app.version}")
    private String name;

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }
}
