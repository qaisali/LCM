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
   * Uses a dynamic approach to find all prime numbers up to a given limit.
   * This method avoids memory overflow by not using a boolean array.
   *
   * @param limit The upper bound to find prime numbers (inclusive)
   * @return A list of prime numbers up to the given limit
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
