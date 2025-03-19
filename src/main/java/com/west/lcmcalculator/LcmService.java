package com.west.lcmcalculator;

import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
   */
  public BigInteger calculateLcmOfRange(long n) {
    long startTime = System.currentTimeMillis();
    List<Long> primes = sieveOfEratosthenes(n);
    BigInteger lcm = BigInteger.ONE;

    for (Long prime : primes) {
      int exponent = (int) (Math.log(n) / Math.log(prime));
      BigInteger primePower = BigInteger.valueOf(prime).pow(exponent);
      lcm = lcm.multiply(primePower);
    }

    long duration = System.currentTimeMillis() - startTime;
    logger.info("LCM calculation for n={} took {} ms", n, duration);

    return lcm;
  }

  /**
   * Uses the Sieve of Eratosthenes algorithm to find all prime numbers up to a given limit.
   *
   * @param limit The upper bound to find prime numbers (inclusive)
   * @return A list of prime numbers up to the given limit
   */
  private List<Long> sieveOfEratosthenes(long limit) {
    boolean[] isPrime = new boolean[(int) (limit + 1)];
    List<Long> primes = new ArrayList<>();

    for (long i = 2; i <= limit; i++) {
      isPrime[(int) i] = true;
    }

    for (long p = 2; p * p <= limit; p++) {
      if (isPrime[(int) p]) {
        for (long i = p * p; i <= limit; i += p) {
          isPrime[(int) i] = false;
        }
      }
    }

    for (long i = 2; i <= limit; i++) {
      if (isPrime[(int) i]) {
        primes.add(i);
      }
    }

    return primes;
  }
}