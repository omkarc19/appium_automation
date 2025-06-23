# Appium Automation Project

This repository contains an Appium-based automation framework for mobile application testing (Android/iOS) for Manastik Application.

## Table of Contents

* [Project Overview](#project-overview)
* [Prerequisites](#prerequisites)
* [Setup Instructions](#setup-instructions)
* [Running Tests](#running-tests)
* [Reporting](#reporting)
* [Project Structure](#project-structure)

---

## Project Overview

This project aims to automate testing for Manastik application on mobile platforms. It leverages Appium to interact with native mobile applications, ensuring quality and stability across different devices and OS versions.

**Key Features:**
* Cross-platform testing (Android & iOS)
* Page Object Model (POM) for maintainable tests
---

## Prerequisites

Before you begin, ensure you have the following installed:

* **Node.js & npm:** [Download and Install Node.js](https://nodejs.org/en/download/) (npm is included)
* **Java Development Kit (JDK):** Version 8 or higher. [Download JDK](https://www.oracle.com/java/technologies/downloads/)
* **Android SDK (for Android testing):** Install via Android Studio.
    * [Android Studio Download](https://developer.android.com/studio)
    * Ensure `ANDROID_HOME` environment variable is set and points to your Android SDK location. Add `platform-tools` and `tools` directories to your `PATH`.
    * **Two Android Emulators:** Create at least two emulators with different API levels or device configurations for testing. You can create these using Android Studio's AVD Manager.
      
* **Xcode (for iOS testing):** Install from the Mac App Store.
    * Ensure Command Line Tools are installed: `xcode-select --install`
* **Appium Server:**
    ```bash
    npm install -g appium
    ```
* **Appium Drivers:**
    * For Android:
        ```bash
        appium driver install uiautomator2
        ```
    * For iOS:
        ```bash
        appium driver install xcuitest
        ```
    * For Flutter (if applicable):
        ```bash
        appium driver install flutter
        ```
* **Maven (for Java projects)** : [Install Maven](https://maven.apache.org/install.html) 
* **IDE:** IntelliJ IDEA, VS Code, Eclipse, etc.

---

## Setup Instructions

1.  **Clone the repository:**
    ```bash
    git clone https://github.com/Manastik-Tech/test-automation
    cd [your-project-directory]
    ```
2.  **Install project dependencies:**
    * **For Java/Maven projects:**
        ```bash
        mvn clean install
        ```
3.  **Configure Appium capabilities:**
    * Edit the desired capabilities in `/appium/src/main/java/config/emulator.properties` to match your test environment (e.g., device name, platform version, app path).
---

## Running Tests

1.  **Run your tests:**
    * **For Java/Maven projects:**
        ```bash
        mvn test
        ```
---

## Reporting

Test reports are generated in the `target/surefire-reports` (for Maven) or `reports` (for other frameworks) directory.
* **HTML Reports:** Open `[report-path]/index.html` in your browser to view detailed test results.
* [Mention any other reporting tools, e.g., Allure, ExtentReports, etc.]

---

## Project Structure
```
.
├── src/
│   ├── main/                 
│   |    ├── java/    
│   |        ├── base
│   |        ├── config
│   |        ├── pages
│   |        ├── utils
│   |
│   └── test/                
│        ├── java/             
│            ├── tests
├── pom.xml                   # Maven project file (or package.json, requirements.txt, etc.)
├── README.md                 # This file
├── .gitignore
└── [other_project_files]
```

