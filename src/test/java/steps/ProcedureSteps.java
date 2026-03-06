package steps;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.SelectOption;
import core.TestContext;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.NucomplyProcedurePage;

public class ProcedureSteps extends TestContext {

    public ProcedureSteps() {
        nucomplyProcedurePage = new NucomplyProcedurePage();
    }

    @When("User select procedure as a document type from drop-down")
    public void userSelectProcedureAsADocumentTypeFromDropDown() {
        nucomplyProcedurePage.selectProcedureAsDocumentTypeFromDropdown();
        System.out.println("User selected 'Procedure' as document type");

    }

    @When("user upload file")
    public void userUploadFile() {
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);
        String testFilePath = System.getProperty("user.dir") + "/src/test/resources/Bank Secrecy Act.pdf";
        /*String testFilePath = "C:\\Users\\Shekhar\\A\\NuArca_TestFiles\\Bank Secrecy Act.pdf";*/
        nucomplyProcedurePage.ProcedureuploadFile(testFilePath);
        System.out.println("User uploaded a procedure file");
    }


    @When("user clicks on review procedure button")
    public void userClicksOnReviewProcedureButton() {
        nucomplyProcedurePage.clickReviewProcedureButton();
        System.out.println("User clicked on Review Procedure button");

    }

    @When("click on genrated redline procedure link on procedure output screen")
    public void clickOnGenratedRedlineProcedureLinkOnProcedureOutputScreen() {
        nucomplyProcedurePage.downloadredlineprocedurelink();
        System.out.println("User clicked on redline procedure link");
    }

    @When("click on genrated updated procedure link on procedure output screen")
    public void clickOnGeneratedUpdatedProcedureLinkOnProcedureOutputScreen() {
        nucomplyProcedurePage.downloadupdatedprocedurelink();
        System.out.println("User clicked on generated updated procedure link");
    }

    @Then("verify procedure option is selected")
    public void verifyProcedureOptionIsSelected() {
        nucomplyProcedurePage.userselectprocedureoption();
    }

    @Then("verify file is procedure file is uploaded successfully")
    public void verifyFileIsProcedureFileIsUploadedSuccessfully() {
        nucomplyProcedurePage.verifyprocedurefileuploadedsuccessfully();
    }

    @When("user select procedure topic")
    public void userSelectProcedureTopic() {
        nucomplyProcedurePage.selectProcedureTopicFromDropdown();
        System.out.println("User selected procedure topic");
    }

    @Then("verify procedure topic is selected")
    public void verifyProcedureTopicIsSelected() {
        nucomplyProcedurePage.userselectproceduretopicoption();
    }

    @Then("verify procedure review is generated successfully")
    public void verifyProcedureReviewIsGeneratedSuccessfully() {
        nucomplyProcedurePage.getprocedureoutputgeneratedverification();
        System.out.println("Procedure review generated successfully");
    }

    @And("User clicks on Policy and Procedure review option")
    public void userClicksOnPolicyAndProcedureReviewOption() {
        nucomplyPolicySolutionPage.clickPolicyAndProcedureReviewButton();
    }
}
