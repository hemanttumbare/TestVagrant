# TestVagrant
TestVagrant Technologies-Code Assessment

Given Assignment is automated with Technolgies as Java, TestNG and Maven.

**Pre-requisites:**
1. Make sure Java is configured on the System. (By Default Java version is set to 1.8 in pom.xml. You can update same in pom.xml file. Update propert-name "java.version" according to you system)
2. Maven is configured on the System. 

**How to execute:**
1.  Clone the source code to System where you need to execute. Git url to clone  : https://github.com/hemanttumbare/TestVagrant.git
2.  Open command promt and navigate to location of pom.xml. e.g <<downloaded_location>>\assignment\TestVagrant
3.  To execute test cases, execute this command : **mvn test**


**Assignment Overview:**
1. Given Json file is stored in src/test/resources/TestDataFiles/  
2. Utility class com.testvagrant.utility.Utilities.jave is used to read this json with json-simple libraries. 
3. Constants and DataProvider classes are used to provide constants and data required for test cases ( com.testvagrant.constants.Constants.java and com.testvagrant.dataProviders.TestDataProvider.java )
4. Data Provider gives input to test as for which team and which data file to to used.
5. Tests are configured such that we can add json data files for multiple teams and run same test cases for all those. (com.testvagrant.VerifyTeamCombinationTests.java)
