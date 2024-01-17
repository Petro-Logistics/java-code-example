[![License](https://img.shields.io/github/license/petro-logistics/petro-api-java.svg)](LICENSE)
# Petro API Java
This module is a Java API client (with an example) for retrieving data with the [Petro-Logistics API](https://secure.petro-logistics.com/client/api).

## Index
[[_TOC_]]

## Dependencies
- ### PLAPIClient is an Eclipse project, so you need to install:
    - [Java SE Runtime Environment](https://www.java.com/fr/download/manual.jsp)
    - [JDK Development Kit](https://www.oracle.com/ch-fr/java/technologies/downloads/)
    - [Eclipse IDE for Java Developers](https://www.eclipse.org/downloads/)

- ### PLAPIClient requires the following jars (included in project):
    - commons-io-2.12.0.jar
    - json-20230227.jar

## Install
- ### Opening the project source in Eclipse IDE:
    1. Download and install [Java SE Runtime Environment](https://www.java.com/fr/download/manual.jsp), [JDK Development Kit](https://www.oracle.com/ch-fr/java/technologies/downloads/) and [Eclipse IDE for Java Developers](https://www.eclipse.org/downloads/) and install them in this order.
    2. Start Eclipse and select your workspace (this can be any empty folder on your computer).
    3. Import the project: Go to `File > Import... > General > Existing Projects into Workspace` and click "Next".
    4. Click `Browse...` beside to `Select root directory:` and select the `APIClient` folder from the GitLab project.
    5. Click `Finish`.
    6. If the import was successful you will see the project appear in the `Package Explorer` on the left side of the window.
    7. If you have some dependencies errors which need to be fixed, this can be done by doing the following:
        - Right click on your project on the left pane and select `Build Path > Configure Build Path > Libraries > Add External JARs`.
        - Select the `json-20230227.jar` file.
        - Repeat `Add External JARs` to select the `commons-io-2.12.0.jar` file.
        - Click `Apply` and then `Apply and Close`
    8. The project should now show no errors and should be ready to use!
 
- ### Running the example:
    1. To run the example which shows the usage of the library first expand `APIClient > src > plapi` in the `Package Explorer` on the left side of the window.
    2. Double click on `TestExample.java` and the source code should open in the middle of the window.
    3. Execute the example by clicking the round green play button on the top of the window or by going to `Run > Run` or by pressing `Ctrl + F11`.
    4. If the example runs successfuly you should see the output in the bottom of the window. If the example doesn't run when you click on `Run`, try clicking inside the source code to bring focus to it and try running again.
 
- ### Compiling the binaries:
    1. To compile the binaries simply export the project as a jar.
    2. You can do this by going to `File > Export... > Java > JAR File`.
    3. Check the checkbox beside to the project you wish to export (`APIClient`).
    4. Click the `Browse...` button beside to "JAR file:" and select the location to save the compiles binaries.
    5. Click `Finish` and the binaries will be compiled.
    6. The compiled JAR file should be packaged together with `json-20230227.jar` and `commons-io-2.12.0.jar`.

- ### Using the binaries in a new project:
    - All three files (`APIClient.jar`, `json-20230227.jar` and `commons-io-2.12.0.jar`) need to be added to the classpath to be used in the project. You can do this in Eclipse as follows:
        1. Copy all three files to your project and refresh it by selecting it and pressing F5. Make sure the files appear in your project.
        2. Right click on your project and select `Build Path > Add Libraries...`.
        3. Select `User Library > Next`.
        4. Click `User Libraries...` on the right side of the window.
        5. Follow the procedure described under "Opening the project source in Eclipse IDE" in this file to create a new library. You can give it any name you want, but this time add ALL THREE .jar files to the same library.
        6. You can now press the `OK > Finish` buttons to close both open windows.
        7. The library is now ready to use. Refer to the `TestExample.java` file for more information on how to use the library.

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
    PLAPIClient client = new PLAPIClient("https://secure.petro-logistics.com/api/v4/desired_report_type", "your_api_key", "your_api_hash", "your_http_user", "your_http_password");
    ```

- ### Execute Example
    ```java
    JSONObject obj = client.execute("query_name");
    ```

## Example
You can test/use our provided [TestExample.java](APIClient/src/plapi/TestExample.java)

## Java Doc
Please take a look at the [Java Docs](APIClient/doc/)
