To set up this development environment, ensure you have the following installed:

* **Java Development Kit (JDK):** Version 11
* **IDE:** IntelliJ IDEA
* **Greenfoot:** Version 3.7.1
* **Sources:** `greenfoot-combined-sources`

---

## Installation & Configuration

### Linux
The project expects library dependencies to be located at `~/libs`. 

1. **Update Library Paths:** Go to **File > Project Structure > Libraries > GreenfootLibs** and update the path to point to your local installations (of all deps).
2. **Update VM Options:** If you change the library paths, you **must** update your **Run Configuration VM options** in IntelliJ, or the project will fail to build/run.

### Windows
Ensure all dependencies are installed in the standard program directory:
* **Path:** `C:\Program Files`

---

## Project Structure

This project follows a clean structure to keep source code separate from IDE configurations:

