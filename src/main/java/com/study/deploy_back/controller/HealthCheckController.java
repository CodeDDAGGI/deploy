package com.study.deploy_back.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
public class HealthCheckController {
    // 배포할때 서버의 상태를 체크하기 위해 작성해줌(health check라고 함)
    @Value("${spring.profiles.active}")
    private String env;

    @Value("${server.port}")
    private String port;

    @GetMapping("/health/check")
    public ResponseEntity<?> healthCheck(){
        Map<String , Object> response = new HashMap<>();
        response.put("env", env);
        response.put("port", port);

        return ResponseEntity.ok().body(response);
    }
}
