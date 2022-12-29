package com.example.springjwt;

import lombok.Data;

import java.util.Map;

@Data
public class AuthResponse {
    private int status;
    private Map<String, String> data;
}
