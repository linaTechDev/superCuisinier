package com.lina.supercuisinier;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SuperCuisinierApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SuperCuisinierApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Running...");
    }
}
