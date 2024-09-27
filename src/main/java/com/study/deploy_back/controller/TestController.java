package com.study.deploy_back.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    // application.yml에서 정의한 client.address 사용
    // 시큐리티에서 테스트할 주소와 배포할 주소를 구분되게 사용해야 하기때문에
    @Value("${client.address}")
    private String clientAddress;

    @CrossOrigin
    @GetMapping
    public ResponseEntity<?> test(){
        return ResponseEntity.ok(clientAddress+ "테스트");
    }
}
