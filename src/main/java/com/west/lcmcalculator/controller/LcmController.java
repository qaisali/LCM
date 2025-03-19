package com.west.lcmcalculator.controller;

import com.west.lcmcalculator.service.LcmService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;

/**
 * REST Controller for LCM calculation. Provides an endpoint to compute the least common multiple of
 * numbers from 1 to a given number.
 */
@RestController
@RequestMapping("/api/lcm/v1")
public class LcmController {

  private static final Logger logger = LoggerFactory.getLogger(LcmController.class);

  @Autowired private LcmService lcmService;

  /**
   * Computes the Least Common Multiple (LCM) for numbers from 1 to the given number.
   *
   * @param n The upper limit of the range (inclusive)
   * @return The LCM as a BigInteger in a ResponseEntity, or an error message in case of invalid input or system error.
   */
  @GetMapping("/lcmofrange/{n}")
  public ResponseEntity<Object> getLcmOfRange(@PathVariable String n) {
    try {
      long num = Long.parseLong(n);
      if (num < 1) {
        return ResponseEntity.badRequest().body("Input must be a positive integer greater than zero.");
      }
      BigInteger result = lcmService.calculateLcmOfRange(num);
      return ResponseEntity.ok(result);
    } catch (NumberFormatException e) {
      logger.error("Invalid input: {}", n, e);
      return ResponseEntity.badRequest().body("Invalid input. Please enter a valid positive integer.");
    } catch (OutOfMemoryError e) {
      logger.error("Memory limit exceeded while calculating LCM for: {}", n, e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Server ran out of memory. Please try with a smaller number.");
    } catch (Exception e) {
      logger.error("Unexpected error while processing request for: {}", n, e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred. Please try again later.");
    }
  }
}