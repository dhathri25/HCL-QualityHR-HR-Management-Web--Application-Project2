# QualityHR: Enterprise HRMS Automation Framework

## 🚀 Project Overview
This repository contains a production-grade **Selenium-Java** automation framework developed for the **QualityHR** (OrangeHRM) platform. It automates the high-stakes employee lifecycle—from PIM record creation to leave entitlement and final leave assignment with administrative approval.

The framework utilizes a **Strict Page Object Model (POM)** and custom synchronization strategies to handle complex AJAX-based HRMS environments.

---

## 📅 Project Execution Timeline (Agile Sprint)

This project was delivered under an intensive execution cycle to resolve deep synchronization issues:

* **Phase 1 (Setup):** Framework skeleton design, Maven dependency management, and BasePage utility development.
* **Phase 2 (PIM & Data):** Developed the Employee Management Module. Implemented dynamic ID generation to ensure zero data conflicts.
* **Phase 3 (Logic & Sync):** Developed the Leave & Entitlement Module. Resolved "Invalid Employee" bugs using Keyboard Event Injection (ARROW_DOWN + ENTER).
* **Phase 4 (Reporting):** Integrated Extent Reports 5, implemented TestNG Listeners for failure screenshots, and finalized the 5/5 pass regression suite.

---

## 🛠 Framework Key Features
* **Smart Synchronization:** Strictly eliminated flaky Thread.sleep() calls in favor of Explicit Waits and JS-Executor.
* **Dynamic Data Binding:** Automated selection of auto-suggestive dropdowns via a custom Retry-Loop mechanism.
* **Self-Healing Locators:** Shifted from fragile index-based XPaths to robust Attribute-and-Label-based locators.
* **Proof of Execution:** Integrated automated Extent Reports with timestamped logs and pass/fail dashboards.

---

## 📂 Project Structure
* `src/main/java/com/qualityhr/pages`: Encapsulated Page classes (Login, Employee, Leave, Admin).
* `src/main/java/com/qualityhr/utils`: Core utilities like WaitHelper and ExtentReportManager.
* `src/test/java/com/qualityhr/tests`: End-to-End TestNG execution scripts.
* `reports/`: Location of the final ExtentReport.html.
* `testng.xml`: The master suite configuration for ordered test execution.

---

## 🏃 How to Run
1. **Import:** Import the Maven project into Eclipse.
2. **Configuration:** Update `src/main/resources/config.properties` with your credentials.
3. **Execute:** Right-click `testng.xml` > Run As > TestNG Suite.
4. **Verify:** After execution, refresh the project (F5) and open `reports/index.html`.

---
*Developed by Dhathri Putty for the QualityHR Automation Project.*