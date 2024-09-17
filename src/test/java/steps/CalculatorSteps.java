package steps;

import core.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CalculatorPage;

import java.io.IOException;

public class CalculatorSteps extends TestContext {

    public CalculatorSteps() {
        //Here the  constructor initializes a new instance of CalculatorPage,
        // so the CalculatorSteps class can interact with the calculator web page through methods in the CalculatorPage class
        calculatorPage = new CalculatorPage();
    }

    @Given("I am on Calculator page")
    //Here we call the function from Calculator Page which is Sync with Feature file Given definition
    public void iAmOnCalculatorPage() throws IOException {
        calculatorPage.iAmOnCalculatorPage();
    }

    @When("I enter number {int}")
    //Here also the function is called from page file and Sync with feature file When step
    public void iEnterNumber(int number) {
        calculatorPage.iEnterNumber(number);
    }

    @And("I click on operator {string}")
    //Here also the function is called from page file and sync with feature file And step
    public void iClickOnOperator(String operator) {
        calculatorPage.iClickOnOperator(operator);
    }

    @Then("I verify the result as {int}")
    //Here also the function is called from page file and synched with feature file Then step
    public void iVerifyTheResultAs(int expectedResult) {
        String actualResult = calculatorPage.iVerifyTheResultAs();
        Assert.assertEquals(actualResult, String.valueOf(expectedResult));
    }
}
