package org.example.texttime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class TextTimeApplication {

    public static void main(String[] args) {
        SpringApplication.run(TextTimeApplication.class, args);
    }

}
