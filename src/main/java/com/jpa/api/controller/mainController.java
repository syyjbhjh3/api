package com.jpa.api.controller;

import com.jpa.api.model.User;
import com.jpa.api.model.request.UserRequest;
import com.jpa.api.service.apiService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

@Api(tags = {"Project Manage"})
@Controller
@RequestMapping(value = "/pms")
@RequiredArgsConstructor
public class mainController {

    private final apiService apiService;

    @GetMapping("/")
    public String home (HttpServletRequest request) {
        return "index";
    }

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
