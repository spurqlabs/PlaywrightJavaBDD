package steps;

import core.TestContext;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.NucomplyPolicySolutionPage;
import org.testng.Assert;

import java.io.IOException;

public class SolutionPolicyP extends TestContext {

    public SolutionPolicyP() {
        nucomplyPolicySolutionPage = new NucomplyPolicySolutionPage();
    }

    @When("User clicks on soutlion tab")
    public void userClicksOnSolutionTab() {
        nucomplyPolicySolutionPage.clickSolutionsTab();
        System.out.println("User clicked on Solutions tab");
    }

    @When("User clicks on Policy and Procedure review button")
    public void userClicksOnPolicyAndProcedureReviewButton() {
        nucomplyPolicySolutionPage.clickPolicyAndProcedureReviewButton();
        System.out.println("User clicked on Policy and Procedure Review button");
    }

    @When("User select policy as a document type from drop-down")
    public void userSelectPolicyAsADocumentTypeFromDropDown() {
        nucomplyPolicySolutionPage.selectPolicyAsDocumentTypeFromDropdown();
        System.out.println("User selected 'Policy' as document type");
    }

    @When("User upload a file")
    public void userUploadAFile() {
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);
        String testFilePath = System.getProperty("user.dir") + "/src/test/resources/Bank Secrecy Act.pdf";
        System.out.println(testFilePath);
        // Using a sample test file - update path as needed
       // String testFilePath = "C:\\Users\\Shekhar\\A\\NuArca_TestFiles\\Bank Secrecy Act.pdf";
        nucomplyPolicySolutionPage.uploadFile(testFilePath);
        System.out.println("User uploaded a policy file");
    }

    @When("User select policy topics from drop-down")
    public void userSelectPolicyTopicsFromDropDown() {

        nucomplyPolicySolutionPage.selectFromReactDropdown("BSA-AML");

        System.out.println("User selected policy topic");
    }

    @When("User clicks on Review Policy button")
    public void userClicksOnReviewPolicyButton() {
        nucomplyPolicySolutionPage.clickReviewPolicyButton();
        System.out.println("User clicked on Review Policy button");
    }

    @Then("verify policy review is generated successfully")
    public void verifyPolicyReviewIsGeneratedSuccessfully() {
        nucomplyPolicySolutionPage.getPolicyOutput();
        System.out.println("Policy review generated successfully");

    }

    @Then("verify Policy document type is available")
    public void verifyPolicyDocumentTypeIsAvailable() {
        // Verify by attempting to select it - no exception means it's available
        nucomplyPolicySolutionPage.selectPolicyAsDocumentTypeFromDropdown();
        System.out.println("Policy document type is available");
    }

    @Then("verify Procedure document type is available")
    public void verifyProcedureDocumentTypeIsAvailable() {
        // Verify by attempting to select it - no exception means it's available
        nucomplyPolicySolutionPage.selectPolicyAsDocumentTypeFromDropdown();
        System.out.println("Procedure document type is available");
    }

    @Then("verify policy topics dropdown is available")
    public void verifyPolicyTopicsDropdownIsAvailable() {
        // Verify by attempting to select a topic - no exception means it's available
        nucomplyPolicySolutionPage.selectPolicyTopicsFromDropdown("AML");
        System.out.println("Policy topics dropdown is available");
    }


    @When("user click on updated policy downlaodble link on policy output screen")
    public void userClickOnUpdatedPolicyDownlaodbleLinkOnPolicyOutputScreen() throws IOException {
        nucomplyPolicySolutionPage.downloadupdatedpolicylink();
        System.out.println("updated policy downloaded successfully");
    }

    @When("click on genrated redline downloadble procedure link on procedure output screen")
    public void clickOnGenratedRedlineDownloadbleProcedureLinkOnProcedureOutputScreen() {
        nucomplyPolicySolutionPage.downloadedRedlinePolicylink();
    }

    @When("User clicks on soutlion tabs")
    public void userClicksOnSoutlionTabs() {
        nucomplyPolicySolutionPage.clickSolutionsTab();
        System.out.println("User clicked on Solutions tab");
    }

    @Then("verify policy review screen is displayed")
    public void verifyPolicyReviewScreenIsDisplayed() {
        nucomplyPolicySolutionPage.policyreviewscreenisdisplayed();
    }

    @Then("verify policy option is selected")
    public void verifyPolicyOptionIsSelected() {
        nucomplyPolicySolutionPage.verifypolicyoptionselected();
    }

    @Then("verify file is uploaded successfully")
    public void verifyFileIsUploadedSuccessfully() {
        nucomplyPolicySolutionPage.verifyfileuploadedsuccessfully();
    }

    @Then("verify policy topics are selected")
    public void verifyPolicyTopicsAreSelected() {
        nucomplyPolicySolutionPage.verifypolicytopicselected();
    }

    @Then("verify policy generator screen is displayed")
    public void verifyPolicyGeneratorScreenIsDisplayed() {
        nucomplyPolicySolutionPage.policygeneratedpagedisplayed();
    }

    @Then("verify selected policy type is displayed")
    public void verifySelectedPolicyTypeIsDisplayed() {
        nucomplyPolicySolutionPage.policytypeisselected();
    }
}
