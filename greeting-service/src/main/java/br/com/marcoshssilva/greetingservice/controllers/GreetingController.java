package br.com.marcoshssilva.greetingservice.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @GetMapping
    public ResponseEntity<?> greeting(@RequestParam(value="name", defaultValue = "Marcos") String name) {
        return ResponseEntity.ok(String.format("Welcome, %s!", name));
    }
}
