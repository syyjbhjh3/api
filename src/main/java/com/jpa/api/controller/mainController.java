package com.jpa.api.controller;

import com.jpa.api.model.User;
import com.jpa.api.model.request.UserRequest;
import com.jpa.api.service.apiService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;

@Api(tags = {"Project Manage"})
@RestController
@RequestMapping(value = "/")
@RequiredArgsConstructor
public class mainController {

    private final apiService apiService;

    @ApiOperation(value = "회원가입", notes = "회원가입")
    @PostMapping("/sign")
    public ResponseEntity<User> signUp (@ApiParam(value = "회원가입", required = true) @RequestBody UserRequest request) {
        return ResponseEntity.ok(apiService.createUser(request));
    }

    @ApiOperation(value = "로그인", notes = "로그인")
    @PostMapping("/login")
    public ResponseEntity<User> login (@ApiParam(value = "로그인", required = true) @RequestBody UserRequest request) {
        return ResponseEntity.ok(apiService.createUser(request));
    }
}
