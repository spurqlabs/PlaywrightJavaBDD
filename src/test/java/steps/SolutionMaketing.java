package steps;

import com.fasterxml.jackson.databind.JsonNode;
import core.TestContext;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.NucomplyMarketingPage;
import utilities.JsonReaderUtil;

public class SolutionMaketing extends TestContext {
    public SolutionMaketing() {
        nucomplyMarketingPage = new NucomplyMarketingPage();
    }

    @When("User clicks on marketing review tab")
    public void userClicksOnMarketingReviewTab() {
        nucomplyMarketingPage.clickonmarketingreview();
        System.out.println("clicked action performed marketing");
    }

    @When("User enter a text from jsonfile {string} in body text field")
    public void userEnterATextFromJsonfileInBodyTextField(String filename) {
        JsonNode json = JsonReaderUtil.readJson(filename);
        String body = json.get("marketingbody").asText();
        nucomplyMarketingPage.userentermarketingbodytext(body);
        System.out.println("body text enterd successfully");
    }

    @When("User click on review Marketing Button")
    public void userClickOnReviewMarketingButton() {
        nucomplyMarketingPage.clickonmarketingreviewbutton();

    }

    @Then("verify the marekting review output is generated successfully")
    public void verifyTheMarektingReviewOutputIsGeneratedSuccessfully() {
        nucomplyMarketingPage.marketingoutputgeneratedverification();
    }

    @When("User upload a marketing file")
    public void userUploadAMarketingFile() {
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);
        String testFilePath = System.getProperty("user.dir") + "/src/test/resources/Mortgage Ad.docx";
        /*String testFilePath = "C:\\Users\\Shekhar\\A\\NuArca_TestFiles\\Mortgage Ad.docx";*/
        nucomplyMarketingPage.uploadMarketingFile(testFilePath);
        System.out.println("user upload file successfully");
    }

    @Then("verify the  marketing output is reset successfully")
    public void verifyTheMarketingOutputIsResetSuccessfully() {
        nucomplyMarketingPage.resetmarketingoutputgenerated();
        System.out.println("Marketing output is reset succesfully");
    }

    @When("User clicks on body text refresh icon")
    public void userClicksOnBodyTextRefreshIcon() {
        nucomplyMarketingPage.clickonrefreshiconbody();
        System.out.println("refresh icon click successfully");
    }

    @When("User clicks on refresh icon of upload file")
    public void userClicksOnRefreshIconOfUploadFile() {
        nucomplyMarketingPage.clickonrefreshiconuploadfile();
        System.out.println("click action performed on refresh upload file icon");
    }

    @Then("verify marketing review screen is displayed")
    public void verifyMarketingReviewScreenIsDisplayed() {
        nucomplyMarketingPage.marketingreiewscreenisdisplayed();
    }

    @Then("verify the marketing body text is entered successfully")
    public void verifyTheMarketingBodyTextIsEnteredSuccessfully() {
        nucomplyMarketingPage.userenteredmarketingbodytextfield();
    }

    @Then("verify the uploaded marketing filename is displayed")
    public void verifyTheUploadedMarketingFilenameIsDisplayed() {
        nucomplyMarketingPage.marketingfileuploadisdisplayed();
    }


    @Then("verify the body text field is cleared successfully")
    public void verifyTheBodyTextFieldIsClearedSuccessfully() {
        nucomplyMarketingPage.marketingbodytextfieldiscleared();
        System.out.println("body text field is cleared successfully");
    }

    @Then("verify the uploaded file is cleared successfully")
    public void verifyTheUploadedFileIsClearedSuccessfully() {
        nucomplyMarketingPage.marketingfileuploadiscleared();
        System.out.println("uploaded file is cleared successfully");
    }
}
