package br.com.marcoshssilva.greetingservice.controllers;

import br.com.marcoshssilva.greetingservice.configuration.GreetingConfiguration;
import br.com.marcoshssilva.greetingservice.models.GreetingModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private final AtomicLong counter = new AtomicLong();
    private static final String template = "%s %s";

    @Autowired
    private GreetingConfiguration configuration;

    @GetMapping
    public ResponseEntity<?> greeting(@RequestParam(value="name", defaultValue = "") String name) {
        // search from application.yml
        if (name.isBlank()) name = configuration.getDefaultValue();
        return ResponseEntity.ok(
                GreetingModel.builder()
                        .id(counter.incrementAndGet())
                        .message(String.format(template, configuration.getGreeting(), name))
                        .build()
        );
    }
}
