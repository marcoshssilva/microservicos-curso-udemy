package br.com.marcoshssilva.greetingservice.configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
@ConfigurationProperties("greeting-service")
public class GreetingConfiguration {
    private String greeting;
    private String defaultValue;
}
