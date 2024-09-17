package core;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "src/test/java/features", //the path where Cucumber feature files are located.
        glue = {"steps", "core"}) //Cucumber where to find the step definitions (in the steps and core packages)

public class TestRunner extends AbstractTestNGCucumberTests {
    //Above Etends which is a base class provided by Cucumber to run the tests with TestNG

    @DataProvider //allows running multiple Cucumber scenarios as separate tests in TestNG
    @Override
    public Object[][] scenarios() {
        return super.scenarios();
    }//Calls the parent class method to return all the Cucumber scenarios in an array format for TestNG to run
}
