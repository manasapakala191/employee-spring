package com.increff.employee.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class InfoData {
    private String message;

    public InfoData(){
        message = "Activity time"+ LocalDateTime.now().toLocalTime().format(DateTimeFormatter.ISO_LOCAL_TIME);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
