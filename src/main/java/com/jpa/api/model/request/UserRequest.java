package com.jpa.api.model.request;

import lombok.Data;

@Data
public class UserRequest {
    private String userId;
    private String password;
    private String name;
}
