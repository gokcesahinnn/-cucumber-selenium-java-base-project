# Java Selenium With Cucumber Test Otomasyonu Projesi

Bu proje Java-Selenium-Cucumber Test Otomasyonu Projesi test otomasyonu base projesidir.

# Tool stack

* **Java/Javascript** - Development Language
* **IntelliJ IDE** - Development IDE
* **Maven** - Package Management
* **Cucumber** - Gherkin Syntax Framework
* **Selenium** - Web APP Test Automation Tool


# Project tree

```
.
|-- src
|   |-- test
|   |   |-- java
|   |   |   |   |-- pages
|   |   |   |   |   |-- BasePage
|   |   |   |   |   |-- HomePage
|   |   |   |   |   |-- SignUpPage
|   |   |   |   |-- runners
|   |   |   |   |   |-- Runner
|   |   |   |   |-- stepDefinitions
|   |   |   |   |   |-- BaseSteps
|   |   |   |   |   |-- HomeSteps
|   |   |   |   |   |-- Hooks
|   |   |   |   |   |-- SignUpSteps
|   |   |   |   |-- utils
|   |   |   |   |   |-- formatter
|   |   |   |   |   |   |-- ConfigFactory
|   |   |   |   |   |   |-- PrettyReports
|   |   |   |   |   |-- ConfigReader
|   |   |   |   |   |-- Driver
|   |   |   |   |   |-- PageHelper
|   |   |-- resources
|   |   |   |-- features
|   |   |   |   |-- register.feature
|-- git.ignore
|-- configuration.properties
|-- pom.xml
|-- README.md
```

# Generate Cucumber Report

* Runner çalıştırılır.
* Terminalden mvn verify komutu çalıştırılır.