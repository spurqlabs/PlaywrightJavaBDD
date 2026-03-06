package steps;

import com.fasterxml.jackson.databind.JsonNode;
import core.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.NucomplyEmailPage;
import utilities.JsonReaderUtil;

import java.util.List;
import java.util.Map;

import static core.TestContext.nucomplyEmailPage;

public class SolutionEmailSteps extends TestContext {
    public SolutionEmailSteps() {
        nucomplyEmailPage = new NucomplyEmailPage();
    }

    @When("User clicks on email review tab")
    public void userClicksOnEmailReviewTab() {
        nucomplyEmailPage.clickEmailReviewTabs();
    }

    @When("User enter following text in subject text field")
    public void userEnterFollowingTextInSubjectTextField(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        String sub = data.get("subject");
        nucomplyEmailPage.enterSubjectLine(sub);
    }

    @When("user  upload a email file")
    public void userUploadAEmailFile() {
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);
        String testFilePath = System.getProperty("user.dir") + "/src/test/resources/compliance email sample.docx";
        //  System.out.println(testFilePath);
        /* String testFilePath = "C:\\Users\\Shekhar\\A\\NuArca_TestFiles\\compliance email sample.docx";*/
        nucomplyEmailPage.uploadEmailFile(testFilePath);
        System.out.println("User Upload file successfully");
    }

    @When("user select all compliance concerns option")
    public void userSelectAllComplianceConcernsOption() {
        nucomplyEmailPage.userselectcomplainceconcerns();
        System.out.println("email compliance concerns option are selected");
    }

    @When("User click on review email button")
    public void userClickOnReviewEmailButton() {
        nucomplyEmailPage.clickonreviewbutton();
        System.out.println("Review button clicked");
    }

    @Then("verify the output is generated successfully")
    public void verifyTheOutputIsGeneratedSuccessfully() {
        nucomplyEmailPage.emailoutputgeneratedverification();
        System.out.println("email output generated");
    }

    @When("User enter the body text from jsonfile {string}")
    public void userEnterTheBodyTextFromJsonfile(String filename) {
        JsonNode json = JsonReaderUtil.readJson(filename);
        String body = json.get("body").asText();
        nucomplyEmailPage.enteremailbody(body);

    }


    @When("User clicks on subject field refresh icon")
    public void userClicksOnSubjectFieldRefreshIcon() {
        nucomplyEmailPage.clickonrefreshiconofemail();
        System.out.println("subject filed is cleard");

    }

    @When("User click on refresh icon of body text field")
    public void userClickOnRefreshIconOfBodyTextField() {
        nucomplyEmailPage.clickonrefreshiconofbodyicon();
        System.out.println("user refresh body icon text field");
        page.waitForTimeout(5000);
    }

    @When("User click on refresh icon of upload file field")
    public void userClickOnRefreshIconOfUploadFileField() {
        nucomplyEmailPage.clickonrefreshiconofuploadfile();
    }

    @Then("verify the output is reset successfully")
    public void verifyTheOutputIsResetSuccessfully() {
        nucomplyEmailPage.emailoutputisreset();
        System.out.println("output is reset successfully");
    }

    @Then("verify email reiew screen is displayed")
    public void verifyEmailReiewScreenIsDisplayed() {
        nucomplyEmailPage.emailreviewscreendis();
    }

    @Then("verify the body text field and upload file option is displayed")
    public void verifyTheBodyTextFieldAndUploadFileOptionIsDisplayed() {
        nucomplyEmailPage.bodytextfieldanduploadtextfield();
    }

    @Then("verfiy the uploaded filename is displayed")
    public void verfiyTheUploadedFilenameIsDisplayed() {
        nucomplyEmailPage.verfiyTheUploadedFilenameIsDisplayed();
    }

    @Then("verify all compliance concerns are selected")
    public void verifyAllComplianceConcernsAreSelected() {
        nucomplyEmailPage.verifyallcomplianceconcernsareselected();
    }


    @Then("verify the body text is entered successfully")
    public void verifyTheBodyTextIsEnteredSuccessfully() {
        nucomplyEmailPage.userenterdtextinthebodyfield();
    }

    @Then("verify the subject text is entered successfully")
    public void verifyTheSubjectTextIsEnteredSuccessfully() {
        nucomplyEmailPage.userenterdtextinthesubjectfield();
    }

    @Then("verify the uploaded filename is cleared successfully")
    public void verifyTheUploadedFilenameIsClearedSuccessfully() {
        nucomplyEmailPage.verifyuploadedfileiscleared();
    }



}
