# Project Design & Planning Document - QualityHR

## 1. Requirement Analysis
The goal was to automate a "Zero-Failure" journey through the OrangeHRM 3.0 ecosystem. 
**Core Business Flows Automated:**
* **Authentication:** Secure Admin Login.
* **PIM Module:** Dynamic creation of new employee records with unique system identifiers.
* **Entitlement Module:** Strategic addition of leave balances to newly created profiles.
* **Leave Assignment:** Multi-step assignment involving date-pickers, auto-suggestive search, and confirmation pop-ups.

## 2. Framework Architecture
* **Design Pattern:** Page Object Model (POM). This ensures strict separation between "What to test" (Test classes) and "How to find it" (Page classes).
* **Base Architecture:** Centralized DriverFactory for browser management and BasePage for wrapping Selenium's native methods with stability.
* **Reporting:** Extent Reports (Spark) chosen for its ability to capture granular step-by-step logs and screenshots.

## 3. Strict Automation Strategies Applied
* **User Data Isolation:** Implemented System.currentTimeMillis() for Employee IDs to prevent "Record Already Exists" failures.
* **Keyboard-Based Binding:** Solved the "Invalid Employee Name" error by simulating human keyboard behavior (Keys.ARROW_DOWN + Keys.ENTER) to trigger backend AJAX validation.
* **Pop-up Interception:** Leveraged JavascriptExecutor to bypass hidden "Yes/Confirm" buttons that are occasionally obscured by loading spinners.
* **Wait Strategy:** Utilized ExpectedConditions to wait for specific DOM states (URL changes and toaster invisibility) rather than using static timers.

## 4. Execution Strategy
The suite is designed to run in a preserved order via `testng.xml`. This ensures that the state created in the PIM module is perfectly carried over into the Leave module, maintaining the integrity of the end-to-end user journey.