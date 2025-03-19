package com.west.lcmcalculator.controller;

import com.west.lcmcalculator.service.LcmService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * REST Controller for LCM calculation. Provides an endpoint to compute the least common multiple of
 * numbers from 1 to a given number.
 */
@RestController
@RequestMapping("/api/lcm")
public class LcmController {

  @Autowired private LcmService lcmService;

  /**
   * Computes the Least Common Multiple (LCM) for numbers from 1 to the given number.
   *
   * @param n The upper limit of the range (inclusive)
   * @return The LCM as a BigInteger, or a bad request response if the input is invalid
   */
  @GetMapping("/lacmofrange/{n}")
  public ResponseEntity<?> getLcmOfRange(@PathVariable String n) {
    try {
      long num = Long.parseLong(n);
      if (num < 1) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Input must be a positive integer greater than zero.");
      }
      return ResponseEntity.ok(lcmService.calculateLcmOfRange(num));
    } catch (NumberFormatException e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid input. Please enter a valid positive integer.");
    }
  }
}