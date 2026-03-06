package steps;

import com.microsoft.playwright.Locator;
import core.TestContext;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.NucomplyPolicyGeneratorPage;

import java.nio.file.Paths;

public class PolicyGeneratorSteps extends TestContext {
    public PolicyGeneratorSteps() {
        nucomplyPolicyGeneratorPage = new NucomplyPolicyGeneratorPage();
    }


    @When("user clicks on policy Generator")
    public void userClicksOnPolicyGenerator() {
        nucomplyPolicyGeneratorPage.clcikonpolicygenerator();
    }

    @When("user select policy type from dropdown")
    public void userSelectPolicyTypeFromDropdown() {
        nucomplyPolicyGeneratorPage.userselectpolicyoption();
    }

    @When("user upload a file")
    public void userUploadAFile() {
        // Using a sample test file - update path as needed
        String testFilePath = "C:\\Users\\Shekhar\\A\\NuArca_TestFiles\\BSA-AML Policy.pdf";
        nucomplyPolicyGeneratorPage.uploadFilepolicy(testFilePath);
        System.out.println("User uploaded a policy file");
    }

    @When("user clicks on generate button")
    public void  userClicksOnGenerateButton() {
        nucomplyPolicyGeneratorPage.clickongeneratebutton();
    }

    @When("user enter the answer of asked question")
    public void userEnterTheAnswerOfAskedQuestion() {
        nucomplyPolicyGeneratorPage.questionanswer1();

        nucomplyPolicyGeneratorPage.questionanswer2();
        nucomplyPolicyGeneratorPage.questionanswer3();
    }
    @Then("verify policy is generated successfully")
    public void verifyPolicyIsGeneratedSuccessfully() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("user enter the answer of asked questions")
    public void userEnterTheAnswerOfAskedQuestions() {
        nucomplyPolicyGeneratorPage.questionanswer1();
        nucomplyPolicyGeneratorPage.questionanswer2();
        nucomplyPolicyGeneratorPage.questionanswer3();
        page.waitForTimeout(12000);

    }
}