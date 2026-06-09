Rediff Automation Framework
Overview
This project is a Selenium Automation Framework developed using Java, Selenium WebDriver, TestNG, and Maven.
The framework automates the Create Rediffmail Account page and validates different functionalities available on the webpage. It follows the Page Object Model (POM) design pattern to improve code reusability, maintainability, and readability.

Tech Stack
Java
Selenium WebDriver
TestNG
Maven
Page Object Model (POM)
Git
GitHub

Project Objective
The objective of this project is to automate the following test scenario:
Launch the browser.
Navigate to https://www.rediff.com.
Click on the "Create Account" link.
Verify that the Create Rediffmail Account page is displayed.
Find and print the total number of links present on the page.
Click on the "Terms and Conditions" link.
Handle the newly opened child window.
Validate the title of the child window.
Close the child window.
Switch back to the parent window.
Verify the parent page.
Close the browser.

Framework Structure
src/test/java
├── base
│ └── TestBase.java
├── pages
│ ├── HomePage.java
│ ├── CreateAccountPage.java
│ └── TermsPage.java
├── tests
│ └── RediffTest.java
├── listeners
│ └── TestListener.java
└── utils
├── ScreenshotUtil.java
├── PDFReportUtility.java
└── WriteLinksToExcel.java

Features
Page Object Model (POM) implementation
Reusable WebDriver setup
TestNG test execution
Screenshot capture utility
PDF report generation
Excel data writing utility
Window handling
Assertions and validations
Easy maintenance and scalability


Prerequisites
Before running the project, ensure the following software is installed:
Java JDK 8 or above
Maven
IntelliJ IDEA / Eclipse
Google Chrome
Git

How to Run
Clone Repository
git clone
Navigate to Project
cd rediff-automation-framework
Install Dependencies
mvn clean install
Execute Tests
mvn test


Design Pattern Used
Page Object Model (POM)
Benefits:
Better code organization
Reduced code duplication
Easy maintenance
Improved readability


Test Scenario
Open Rediff website.
Navigate to Create Account page.
Count available links.
Print links.
Open Terms and Conditions page.
Handle multiple windows.
Validate page title.
Close child window.
Return to parent window.
Close browser.
