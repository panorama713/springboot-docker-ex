package com.example.springbootdockerex;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

import static org.springframework.http.HttpHeaders.DATE;

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
