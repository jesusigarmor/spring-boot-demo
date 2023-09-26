package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudenRepository repository) {
        return args -> {
            Student jesus = new Student(
                    "Jesus",
                    "jesus.igarmor@gmail.com",
                    LocalDate.of(1997, 10, 3)
            );
            Student alex = new Student(
                    "Alex",
                    "alex@gmail.com",
                    LocalDate.of(1998, 11, 3)
            );
            Student danna = new Student(
                    "Danna",
                    "danna@gmail.com",
                    LocalDate.of(1997, 3, 31)
            );

            repository.saveAll(
                    List.of(jesus,alex,danna)
            );
        };
    }

}

