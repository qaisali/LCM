package com.west.lcmcalculator;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.math.BigInteger;

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
   * @return The LCM as a BigInteger
   */
  @GetMapping("/lacmofrange/{n}")
  public BigInteger getLcmOfRange(@PathVariable int n) {
    return lcmService.calculateLcmOfRange(n);
  }
}
