# LCM Calculator API

This is a Spring Boot REST API that calculates the least common multiple (LCM) of numbers from 1 to N.

## How It Works
The application finds the LCM using an optimized approach with **prime factorization**. The algorithm works as follows:

1. **Find all prime numbers** up to N using the [Sieve of Eratosthenes](https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes), which is an efficient method for generating prime numbers.
2. **Determine the highest power** of each prime that is within the range (using logarithms).
3. **Multiply these prime powers** to obtain the LCM.

This approach ensures that only the necessary prime factors are included, making the computation more efficient than a naïve method.

## Requirements
- Java 11/17/21
- Maven

## Build & Run
```sh
mvn clean install
mvn spring-boot:run
```

## Usage
### Find LCM of numbers from 1 to N
Send a GET request to:
```
http://localhost:8090/api/lcm/v1/lcmofrange/{N}
```
Example:
```
curl http://localhost:8090/api/lcm/v1/lcmofrange/25
```

## Running Tests
```sh
mvn test
```