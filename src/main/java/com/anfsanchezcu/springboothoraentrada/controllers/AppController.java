package com.anfsanchezcu.springboothoraentrada.controllers;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class AppController {

  @GetMapping("/foo")  
  public ResponseEntity<?> foo(){


    Map<String, Object> data = new HashMap<>();
    data.put("message", "Hello World");
    data.put("time", new Date());
    return ResponseEntity.ok(data);
  }
}
