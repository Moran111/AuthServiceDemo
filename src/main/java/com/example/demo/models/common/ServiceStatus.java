package com.example.demo.models.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ServiceStatus {

    private String statusCode;
    private boolean success;
    private String errorMessage;

}
