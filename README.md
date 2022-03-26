# Appium tests for Google maps.
### Requirements
1. appium server (not GUI)
2. appium-doctor (everything is OK)
3. real device (tested on Redmi. Some system locators with different vendors may not work)

### Steps
1. run Gradle task 'testAppium' or run test 'TestOne' manually.
2. run Gradle task 'allureReport'
3. run Gradle task 'allureServe'