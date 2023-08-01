package com.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/path")
public class UserController {

    @PostMapping(value = "/username")
    public ResponseEntity<String> updateUser(
            @RequestParam("userName") String userName,
            @RequestParam("groupName") String groupName,
            @RequestParam("deptName") String deptName) {

        // 处理请求数据
        // 在这里可以对请求参数进行业务逻辑处理
        log.info("OK");
        // 返回响应
        return ResponseEntity.ok("User updated successfully");
    }
}