package com.west.lcmcalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class for the LCM Calculator Spring Boot application. This application provides a REST API
 * to compute the Least Common Multiple (LCM) of numbers from 1 to a given value.
 */
@SpringBootApplication
public class LcmCalculatorApplication {
  public static void main(String[] args) {
    SpringApplication.run(LcmCalculatorApplication.class, args);
  }
}
