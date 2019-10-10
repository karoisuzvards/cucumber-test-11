# Cucumber jvm + selenide + jdk 11

## Prerequisites

* JDK 11 (OpenJDK works)


## Running 

* using IDEA - launch [RunCucumberTest.java](./src/test/java/lv/karoisuzvards/cucumber11/RunCucumberTest.java)
(specify environment variable `env` for different environments (`test` supported))
* gradle task also available
```bash
export env=test && ./gradlew test 
```

## Reporting

* reports available in `build/reports/cucumber-html-reports`
(after each failed test - screenshots are attached to report)

## Configuration

Configuration is done in `application-${env}.properties` file
Available properties:

`site.url` -> url to be opened by webdriver
`screenshot.capturer` -> which screenshot capturer to use - `ASHOT` (kinda full page screenshot) or `SELENIUM` (viewport screenshot)

## How to write tests

Features are located in [src/test/resources/features](src/test/resources/features)


