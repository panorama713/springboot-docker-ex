package com.example.springbootdockerex;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * packageName : com.example.springbootdockerex
 * fileName : HelloWorldController
 * author : gim-yeong-geun
 * date : 2023/05/16
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/05/16         gim-yeong-geun          최초 생성
 */
@RestController
public class HelloWorldController {
    @GetMapping("/")
    public String hello() {
        return "Hello World!";
    }
}
