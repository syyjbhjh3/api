package com.jpa.api.controller;

import com.jpa.api.model.User;
import com.jpa.api.model.request.UserRequest;
import com.jpa.api.service.apiService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"Api"})
@RestController
@RequestMapping(value = "/api/")
@RequiredArgsConstructor
public class apiController {

    private final apiService apiService;

    @ApiOperation(value = "회원가입", notes = "회원가입")
    @PostMapping("/sign")
    public ResponseEntity<User> signUp (@ApiParam(value = "회원정보", required = true) @RequestBody UserRequest request) {
        return ResponseEntity.ok(apiService.createUser(request));
    }
}
