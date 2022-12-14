package com.jpa.api.controller;

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

@Api(tags = {"Login"})
@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class loginController {

    @PostMapping("/login/naverLogin")
    public ResponseEntity<Object> naverLogin(@ApiParam(value = "네이버 로그인", required = false) @RequestBody UserRequest request) {
        return getData("");
    }

    @PostMapping("/login/naverCallback")
    public ResponseEntity<Object> naverCallback(@ApiParam(value = "네이버 로그인 콜백", required = false) @RequestBody UserRequest request) {
        return getData("");
    }

    public ResponseEntity<Object> getData(String url) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        ResponseEntity<Object> resultMap = new ResponseEntity<>(null,null,200);

        try {
            RestTemplate restTemplate = new RestTemplate();

            HttpHeaders header = new HttpHeaders();
            HttpEntity<?> entity = new HttpEntity<>(header);

            UriComponents uri = UriComponentsBuilder.fromHttpUrl(url).build();
            resultMap = restTemplate.exchange(uri.toString(), HttpMethod.GET, entity, Object.class);

            result.put("statusCode", resultMap.getStatusCodeValue());
            result.put("header", resultMap.getHeaders());
            result.put("body", resultMap.getBody());

        } catch (HttpClientErrorException | HttpServerErrorException e) {
            result.put("statusCode", e.getRawStatusCode());
            result.put("body"  , e.getStatusText());
            System.out.println("error");
            System.out.println(e.toString());
            return resultMap;
        }
        catch (Exception e) {
            result.put("statusCode", "999");
            result.put("body"  , "error");
            System.out.println(e.toString());
            return resultMap;
        }
        return resultMap;
    }
}
