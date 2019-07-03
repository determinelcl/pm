package com.practice.management;

import com.practice.management.config.FileProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({FileProperties.class})
public class PracticeManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(PracticeManagementApplication.class, args);
    }

}
