# FSTakeHomeChallenge

FSTakeHomeChallenge is a TestNG Framework based on Java and Selnium library for dealing with general web automation.

## Installation

Install Maven on the system if you want to run the tests from command line using maven

  For Mac - brew install Maven

  For Windows - Plesae follow the steps provided here -> https://maven.apache.org/install.html

Use the git commands to clone the project.

Run pom.xml file after downloading the project. This will install all the Maven Dependencies required for this project.


```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>org.example</groupId>
    <artifactId>FSTakeHomeChallenge</artifactId>
    <version>1.0-SNAPSHOT</version>
    <dependencies>
        <!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>4.1.2</version>
        </dependency>
        <dependency>
            <groupId>com.googlecode.json-simple</groupId>
            <artifactId>json-simple</artifactId>
            <version>1.1.1</version>
        </dependency>
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-api</artifactId>
            <version>4.1.2</version>
        </dependency>
        <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>RELEASE</version>
            <scope>compile</scope>
        </dependency>
        <dependency>
            <groupId>com.google.code.gson</groupId>
            <artifactId>gson</artifactId>
            <version>2.8.6</version>
        </dependency>
        <dependency>
            <groupId>io.github.bonigarcia</groupId>
            <artifactId>webdrivermanager</artifactId>
            <version>5.1.0</version>
        </dependency>
    </dependencies>

    <properties>
        <maven.compiler.source>11</maven.compiler.source>
        <maven.compiler.target>11</maven.compiler.target>
    </properties>

</project>

```

## Run tests

1. mvn test
    
    This will all the test classes in this project
    
    ```
    $ git clone https://github.com/harpreetbhalla27/FSTakeHomeChallenge.git
    $ cd FSTakeHomeChallenge
    $ mvn test
    
    ```
![image](https://user-images.githubusercontent.com/91301138/161372356-6e42823a-a1d1-48f4-97fc-f8ecdcc38635.png)


2. Run the TestClass from IDE

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
NA
