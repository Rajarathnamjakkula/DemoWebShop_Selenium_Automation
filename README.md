#  DemoWebShop Selenium Automation Framework

## Project Overview

This project contains an **end-to-end UI automation framework** developed for the **DemoWebShop e-commerce application** using **Selenium WebDriver with Java**.

The framework automates major user workflows such as **user registration, login, product category navigation, and adding products to the shopping cart**.

The automation framework is designed using the **Page Object Model (POM)** to improve **maintainability, reusability, and scalability** of test scripts.

---

# Tech Stack

* **Java**
* **Selenium WebDriver**
* **TestNG**
* **Maven**
* **Page Object Model (POM)**
* **Git & GitHub**

---

#  Framework Design

This automation framework uses several best practices:

### Page Object Model (POM)

All web elements and actions are separated into **page classes** to improve readability and maintainability.

### Base Test Setup

`BaseTest.java` handles:

* Browser initialization
* Test setup
* Test teardown

### Driver Factory

`DriverFactory.java` manages WebDriver initialization for better scalability.

### Data Driven Testing

`CommonDataProvider.java` provides **TestNG DataProvider** support for multiple test inputs.

### Configuration Management

`ConfigReader.java` reads configuration properties such as:

* Browser
* Application URL

---

#  Automated Test Scenarios

The following test scenarios are automated:

✔ User Registration
✔ User Login
✔ Category Selection
✔ Product Validation
✔ Add Product to Cart
✔ Page Title and URL Verification
✔ Data Driven Testing using TestNG

---

#  How to Run the Tests

### 1.Clone the repository

```
git clone https://github.com/yourusername/DemoWebShopApp.git
```

### 2.Import project

Import the project into:

* Eclipse
* IntelliJ IDEA

### 3️. Install dependencies

Run Maven install:

```
mvn clean install
```

### 4️. Run tests

Execute:

* Individual **TestNG test classes**
* or run the **testng.xml file**

---

#  Key Features

✔ Modular framework design
✔ Page Object Model implementation
✔ TestNG Data Driven Testing
✔ Reusable test components
✔ Easy maintenance and scalability

---

#  Application Under Test

DemoWebShop is an **e-commerce web application** used for practicing UI automation testing.

Automated flows include:

* User Signup
* User Login
* Product Categories
* Add Product to Cart

---

#  Author

**Rajarathnam Jakkula**

Automation Test Engineer
Selenium | Java | TestNG | Automation Testing


