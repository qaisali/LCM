package com.west.lcmcalculator.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigInteger;

/**
 * Unit tests for {@LcmService}. Ensures that the LCM calculation logic is working correctly for
 * various ranges.
 */
public class LcmServiceTest {

  private final LcmService lcmService = new LcmService();

  /**
   * Tests that LCM calculation throws an exception for negative numbers.
   */
  @Test
  void testNegativeNumberThrowsException() {
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      lcmService.calculateLcmOfRange(-5);
    });
    assertEquals("Input must be a positive integer greater than zero.", exception.getMessage());
  }

  /** Tests LCM calculation for numbers from 1 to 1. Expected result: 1 */
  @Test
  void testLcmOfRangeOf1() {
    assertEquals(BigInteger.valueOf(1), lcmService.calculateLcmOfRange(1));
  }

  /** Tests LCM calculation for numbers from 1 to 2. Expected result: 2 */
  @Test
  void testLcmOfRangeOf2() {
    assertEquals(BigInteger.valueOf(2), lcmService.calculateLcmOfRange(2));
  }

  /** Tests LCM calculation for numbers from 1 to 3. Expected result: 6 */
  @Test
  void testLcmOfRangeOf3() {
    assertEquals(BigInteger.valueOf(6), lcmService.calculateLcmOfRange(3));
  }

  /** Tests LCM calculation for numbers from 1 to 10. Expected result: 2520 */
  @Test
  void testLcmOfRangeOf10() {
    assertEquals(BigInteger.valueOf(2520), lcmService.calculateLcmOfRange(10));
  }

  /** Tests LCM calculation for numbers from 1 to 15. Expected result: 360360 */
  @Test
  void testLcmOfRangeOf15() {
    assertEquals(BigInteger.valueOf(360360), lcmService.calculateLcmOfRange(15));
  }
}
