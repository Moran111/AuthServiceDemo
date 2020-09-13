package com.example.demo.models.response;

import com.example.demo.models.common.ServiceStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegisterResponse {

    // succesful registered
    private ServiceStatus serviceStatus;
    private String username;

}
