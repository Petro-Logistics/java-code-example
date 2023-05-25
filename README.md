[![License](https://img.shields.io/github/license/petro-logistics/petro-api-java.svg)](LICENSE)
# README
---

## Java API Client
This module is a Java API client (with an example) for retrieving data with the [Petro-Logistics API](https://secure.petro-logistics.com/client/api).


## Dependencies
- ### PLAPIClient is an Eclipse project, so you need to install:
    - Running environment [JRE](https://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html)
    - Development package [JDK](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html)
    - Development tool [Eclipse IDE for Java Developers](https://www.eclipse.org/downloads/packages/release/2019-06/r/eclipse-ide-java-developers)


- ### PLAPIClient requires the following jars (included in project):
    - commons-io-2.5-javadoc.jar
    - commons-io-2.5.jar
    - json-20160810.jar


## Install
- ### Opening the project source in Eclipse IDE:
    1. Download and install [JRE](https://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html), [JDK](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html) and [Eclipse IDE for Java Developers](https://www.eclipse.org/downloads/packages/release/2019-06/r/eclipse-ide-java-developers) and install them in this order.
    2. Start Eclipse and select your workspace (this can be any empty folder on your computer).
    3. Import the project: Go to "File > Import..." and under "General" select "Existing Projects into Workspace" and click "Next".
    4. Click "Browse..." next to "Select root directory:" and select the "APIClient" folder from the GitLab project.
    5. Click "Finish".
    6. If the import was successful you will see the project appear in the "Package Explorer" on the left side of the window.
    7. There are some dependency errors which need to be fixed. This can be done by doing the following.
    8. Go to "Window > Preferences" and expand "Java > Build Path > User Libraries" on the left side of the window.
    9. On the right side click on "New..." and name it "JSON" (this exact capitalization and without the quotes). Then click on "OK".
    10. Make sore the newly created "JSON" library is selected and click on "Add JARs...".
    11. In the window that pops up expand the project "APIClient" and select "json-20160810.jar" and click "OK".
    12. Repeat the same process (steps 9 to 11), but this time name the library "Apache Commons IO" (this exact capitalization and without the quotes) and select "commons-io-2.5.jar" in the "JAR Selection" window.
    13. Now you can click the "OK" button in the "Preferences" window.
    14. The project should now show no errors and should be ready to use!
 
- ### Running the example:
    1. To run the example which shows the usage of the library first expand "APIClient > src > plapi" in the "Package Explorer" on the left side of the window.
    2. Double click on "TestExample.java" and the source code should open in the middle of the window.
    3. Execute the example by clicking the round green play button on the top of the window or by going to "Run > Run" or by pressing "Ctrl + F11".
    4. If the example runs successfuly you should see the output in the bottom of the window. If the example doesn't run when you click on "Run" try clicking inside the source code to bring focus to it and try running again.
 
- ### Compiling the binaries:
    1. To compile the binaries simply export the project as a jar.
    2. You can do this by going to "File > Export..." and selecting "JAR File" under "Java".
    3. Check the checkbox next to the project you wish to export ("APIClient").
    4. Click the "Browse..." button next to "JAR file:" and select the location to save the compiles binaries.
    5. Click "Finish" and the binaries will be compiled.
    6. The compiled JAR file should be packaged together with "json-20160810.jar" and "commons-io-2.2.jar".

- ### Using the binaries in a new project:
    1. All three files ("APIClient.jar", "json-20160810.jar" and "commons-io-2.2.jar") need to be added to the classpath to be used in the project. You can do this in Eclipse as follows.
    2. Copy all three files to your project and refresh it by selecting it and pressing F5. Make sure the files appear in your project.
    3. Right click on your project and select "Build Path > Add Libraries...".
    4. Select "User Library" and click "Next".
    5. Click "User Libraries..." on the right side of the window.
    6. Follow the procedure described under "Opening the project source in Eclipse IDE" in this file to create a new library. You can give it any name you want, but this time add ALL THREE .jar files to the same library.
    7. You can now press the "OK" and "Finish" buttons to close both open windows.
    8. The library is now ready to use. Refer to the "TestExample.java" file for more information on how to use the library.


## Parameters
- **PLAPIClient** is initialized with 5 parameters:
    - API_URL
    - API_USER
    - API_PASSWORD
    - API_KEY
    - API_HASH


- **PLAPIClient** is called with 1 parameter:
    - query_name


## Usage
- ### Initialization Example
    ```java
    PLAPIClient client = new PLAPIClient("https://secure.petro-logistics.com/api/v3/requested_report_type", "your_api_key", "your_api_hash", "your_http_user", "your_http_password");
    ```


- ### Execute Example
    ```java
    JSONObject obj = client.execute("query_name");
    ```


## Example
1. An example of how to test/use PLAPIClient is available in **TestExample.java** located [here](APIClient/src/plapi/TestExample.java)


## Java Doc
Java Docs can be found [here](APIClient/doc/)
