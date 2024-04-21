package com.example.boppa;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class AppController {

    @GetMapping("/ping")
    public String hello() {
        try {
            Resource resource = new ClassPathResource("data/test.txt");
            byte[] bytes = FileCopyUtils.copyToByteArray(resource.getInputStream());
            String content = new String(bytes);
            System.out.println("content = " + content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "ok";
    }
}
