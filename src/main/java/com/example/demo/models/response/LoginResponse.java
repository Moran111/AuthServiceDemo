package com.example.demo.models.response;

import com.example.demo.models.domain.Role;
import com.example.demo.models.common.ServiceStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginResponse {

    private ServiceStatus serviceStatus;
    private String username;
    private List<Integer> roleIdList;
    private List<String> roleNameList;
    private String jwtInfo;




}
