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

    long startTime = System.nanoTime();
    List<Long> primes = sieveOfEratosthenes(n);
    BigInteger lcm = BigInteger.ONE;

    for (Long prime : primes) {
      BigInteger primeBig = BigInteger.valueOf(prime);
      BigInteger primePower = primeBig;
      BigInteger nextPower = primePower.multiply(primeBig);

      while (nextPower.compareTo(BigInteger.valueOf(n)) <= 0) {
        primePower = nextPower;
        nextPower = primePower.multiply(primeBig);
      }

      lcm = lcm.multiply(primePower);
    }

    long durationNs = System.nanoTime() - startTime;
    double durationMs = durationNs / 1000000.0;

    logger.debug("LCM calculation for n={} took {} ns (≈ {} ms)", n, durationNs, durationMs);

    return lcm;
  }

  /**
   * Generates a list of prime numbers up to a specified limit using the
   * Sieve of Eratosthenes algorithm. This method efficiently eliminates
   * non-prime numbers by marking multiples of each prime starting from 2.
   *
   * Algorithm Explanation:
   * - Initialize a boolean array to track whether each number is composite (non-prime).
   * - Starting from 2, for each number not marked as composite, mark all its multiples
   *   as composite starting from its square (i^2).
   * - After sieving, collect all numbers that remain unmarked as they are prime.
   *
   * @param limit The upper bound (inclusive) up to which prime numbers should be found.
   * @return A list containing all prime numbers up to the given limit.
   */
  private List<Long> sieveOfEratosthenes(long limit) {
    boolean[] isComposite = new boolean[(int)(limit + 1)];

    for (int i = 2; i * i <= limit; i++) {
      if (!isComposite[i]) {
        for (int j = i * i; j <= limit; j += i) {
          isComposite[j] = true;
        }
      }
    }

    List<Long> primes = new ArrayList<>();
    for (int i = 2; i <= limit; i++) {
      if (!isComposite[i]) {
        primes.add((long) i);
      }
    }

    return primes;
  }
}
