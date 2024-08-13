package com.example.dockercomposedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DockerComposeDemoApplication {
  @GetMapping("/api/health")
  public String hello() {
    return "okay";
  }

  public static void main(String[] args) {
    SpringApplication.run(DockerComposeDemoApplication.class, args);
  }
}