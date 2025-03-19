package com.west.lcmcalculator.service;

import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Service class for calculating the Least Common Multiple (LCM) using prime factorization.
 */
@Service
public class LcmService {

  private static final Logger logger = LoggerFactory.getLogger(LcmService.class);

  /**
   * Calculates the Least Common Multiple (LCM) of numbers from 1 to n.
   * Uses prime factorization and the highest exponent of each prime within the range.
   *
   * @param n The upper limit of the range (inclusive) as a long
   * @return The LCM as a BigInteger
   * @throws IllegalArgumentException if n is negative or zero
   */
  public BigInteger calculateLcmOfRange(long n) {

    if (n < 1) {
      throw new IllegalArgumentException("Input must be a positive integer greater than zero.");
    }

    long startTime = System.currentTimeMillis();
    List<Long> primes = sieveOfEratosthenes(n);
    BigInteger lcm = BigInteger.ONE;

    for (Long prime : primes) {
      BigInteger primeBig = BigInteger.valueOf(prime);
      BigInteger primePower = primeBig;
      while (primePower.multiply(primeBig).compareTo(BigInteger.valueOf(n)) <= 0) {
        primePower = primePower.multiply(primeBig);
      }
      lcm = lcm.multiply(primePower);
    }

    long duration = System.currentTimeMillis() - startTime;
    logger.info("LCM calculation for n={} took {} ms", n, duration);

    return lcm;
  }

  /**
   * Implements the Sieve of Eratosthenes algorithm to generate a list of prime numbers up to a specified limit.
   * This method iterates through numbers, checking divisibility against previously identified primes.
   *
   * Algorithm Explanation:
   * - Start with an empty list of primes.
   * - Iterate from 2 to the given limit.
   * - For each number, check if it is divisible by any previously found prime.
   * - If the number is not divisible by any known prime, it is prime and added to the list.
   * - Stop checking divisibility once a prime squared exceeds the current number (optimization).
   *
   * Time Complexity: O(n√n) (not the most optimized Sieve of Eratosthenes but effective for smaller ranges).
   *
   * @param limit The upper bound (inclusive) up to which prime numbers should be found.
   * @return A list containing all prime numbers up to the given limit.
   */
  private List<Long> sieveOfEratosthenes(long limit) {
    List<Long> primes = new ArrayList<>();

    for (long num = 2; num <= limit; num++) {
      boolean isPrime = true;
      for (Long prime : primes) {
        if (prime * prime > num) break;
        if (num % prime == 0) {
          isPrime = false;
          break;
        }
      }
      if (isPrime) {
        primes.add(num);
      }
    }

    return primes;
  }
}
