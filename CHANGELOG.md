# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).


## [1.5.0-SNAPSHOT] - 2025-03-4

### Changed

- now using nanoTime
- improved calculateLcmOfRange by introducing nextPower
- improved sieveOfEratosthenes method by generating boolean array of composite numbers
- added new unittest

## [1.4.0-SNAPSHOT] - 2025-03-19

### Added

- input validation to the LcmService
- input validation logic
- controller unittests
- Maven OWASP dependency check
- added one more unittest
- replaced "?" with Object in the LcmController
- updated JavaDoc of sieveOfEratosthenes method for Better Clarity
- improved error handling
- added version number to the api endpoint
- replaced application.properties with application.properties, now using prometheus to check the end points

### Fixed

- removed access modifier public from unittest, SonarQube is right :)
- endpoint name :)
- unittests after changing the controller
- 
## [1.3.0-SNAPSHOT] - 2025-03-19

### Changed

- improved project structure

## [1.2.0-SNAPSHOT] - 2025-03-19

### Changed

- improved performance

## [1.1.2-SNAPSHOT] - 2025-03-19

### Fixed

- fixed NegativeArraySizeException

## [1.1.1-SNAPSHOT] - 2025-03-19

### Fixed

- now using long in steeds of int in the controller

## [1.1.0-SNAPSHOT] - 2025-03-19

### Added

- 2 more unittests

## [1.0.0-SNAPSHOT] - 2025-03-19

### Added

- initial version

