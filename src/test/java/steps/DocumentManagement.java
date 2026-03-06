package steps;

import com.microsoft.playwright.Locator;
import core.TestContext;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Test;
import pages.NucomplyDocumentMGTPage;
import utilities.DocumentGeneratorUtil;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.testng.AssertJUnit.assertTrue;

public class DocumentManagement extends TestContext {
    public DocumentManagement() {
        nucomplyDocumentMGTPage = new NucomplyDocumentMGTPage();
    }

    @When("User clicks on document management link")
    public void userClicksOnDocumentManagementLink() {
        nucomplyDocumentMGTPage.clickondocumentManagement();
    }

    @When("user click on upload document button")
    public void userClickOnUploadDocumentButton() {
        nucomplyDocumentMGTPage.clickonuploaddocumentbutton();

    }

    @When("user enter document title as {string}")
    public void userEnterDocumentTitleAs(String title) {
        nucomplyDocumentMGTPage.userenterdocumenttitle(title);
    }

    @When("user select document type as Policy")
    public void userSelectDocumentTypeAsPolicy() {
        nucomplyDocumentMGTPage.userselectpolicytype();
    }

    @When("user upload a document file")
    public void userUploadADocumentFile() {
        String testFilePath = "C:\\Users\\Shekhar\\A\\NuArca_TestFiles\\compliance email sample.docx";
        nucomplyDocumentMGTPage.uploadpolicydocumentFile(testFilePath);
    }

    @When("user select a modules from the dropdown")
    public void userSelectAModulesFromTheDropdown() {
        nucomplyDocumentMGTPage.selectmodulefromdropdown();
    }

    @When("user click on upload button")
    public void userClickOnUploadButton() {
        nucomplyDocumentMGTPage.clickuploadbutton();
    }


    @When("user select document type as Procedure")
    public void userSelectDocumentTypeAsProcedure() {
        nucomplyDocumentMGTPage.userselectproceduretype();
    }

    @When("user select document type as Training_Material")
    public void userSelectDocumentTypeAsTraining_Material() {
        nucomplyDocumentMGTPage.training_material();
    }

    @When("user select document type as Other")
    public void userSelectDocumentTypeAsOther() {
        nucomplyDocumentMGTPage.other();
    }

    @When("user click on filter option")
    public void userClickOnFilterOption() {
        nucomplyDocumentMGTPage.userclickonnewfilterdropdown();
    }


    @When("user select filter option as Newest First")
    public void userSelectFilterOptionAsNewestFirst() {
        nucomplyDocumentMGTPage.selecthenewestfilteropt();
    }

    @Then("verify documents are filtered based on Newest first filter option successfully")
    public void verifyDocumentsAreFilteredBasedOnNewestFirstFilterOptionSuccessfully() {
        nucomplyDocumentMGTPage.verfifynewestfilteroption();
    }

    @When("user click on filters option")
    public void userClickOnFiltersOption() {
        nucomplyDocumentMGTPage.uerclicksonfilters();
    }


    @When("user select filter option as Oldest First")
    public void userSelectFilterOptionAsOldestFirst() {
        nucomplyDocumentMGTPage.selectoldestfilter();
    }

    @When("user click on document type filter option")
    public void userClickOnDocumentTypeFilterOption() {
        nucomplyDocumentMGTPage.documenttypefilter();
    }

    @When("user select document type option from dropdown")
    public void userSelectDocumentTypeOptionFromDropdown() {
        nucomplyDocumentMGTPage.selecttheoptiondocumenttypedrop();
    }

    @When("user click on module type filter option")
    public void userClickOnModuleTypeFilterOption() {
        nucomplyDocumentMGTPage.selectthemoduletyprdrop();
    }

    @When("user select module type option from dropdown")
    public void userSelectModuleTypeOptionFromDropdown() {
        nucomplyDocumentMGTPage.selectoptionmodule();
    }

    @When("user click on file type filter option")
    public void userClickOnFileTypeFilterOption() {
        nucomplyDocumentMGTPage.userclicksonfiletype();
    }

    @When("user select file type option from dropdown")
    public void userSelectFileTypeOptionFromDropdown() {
        nucomplyDocumentMGTPage.selctthefiletypeopt();
    }

    @Then("verify document management page is displayed")
    public void verifyDocumentManagementPageIsDisplayed() {
        nucomplyDocumentMGTPage.documentscreendisplayed();

    }

    @Then("the upload document show all fields with upload button disabled")
    public void theUploadDocumentShowAllFieldsWithUploadButtonDisabled() {
        nucomplyDocumentMGTPage.uploaddocumentscreenfiledvisible();
    }


    @Then("verify filter options are displayed")
    public void verifyFilterOptionsAreDisplayed() {
        nucomplyDocumentMGTPage.filteroptionsaredisplayed();
    }

    @Then("verify documents are filtered based on Oldest first filter option successfully")
    public void verifyDocumentsAreFilteredBasedOnOldestFirstFilterOptionSuccessfully() {
        nucomplyDocumentMGTPage.verfiyoldestfilteroption();
    }

    @Then("verify documents are filtered based on selected document type.")
    public void verifyDocumentsAreFilteredBasedOnSelectedDocumentType() {

    }

    @Then("verify documents are filtered based on selected module type.")
    public void verifyDocumentsAreFilteredBasedOnSelectedModuleType() {
        nucomplyDocumentMGTPage.emailmodulefilter();
    }

    @Then("verify documents are filtered based on selected file type.")
    public void verifyDocumentsAreFilteredBasedOnSelectedFileType() {
        page.waitForTimeout(5000);
        nucomplyDocumentMGTPage.pdffiletypefilterres();
    }

    @When("user enter document title in search box")
    public void userEnterDocumentTitleInSearchBox() {
        nucomplyDocumentMGTPage.userserachdocumenttitle("Fair Lending Policy");
        page.waitForTimeout(5000);
    }


    @Then("verify differnt filter sections are displayed")
    public void verifyDifferntFilterSectionsAreDisplayed() {


    }

    @Then("verify document is searched successfully based on document title")
    public void verifyDocumentIsSearchedSuccessfullyBasedOnDocumentTitle() {
        nucomplyDocumentMGTPage.documetdisplayed();
    }

    @Then("verify default item display per page is ten item in document management page")
    public void verifyDefaultItemDisplayPerPageIsTenItemInDocumentManagementPage() {
        nucomplyDocumentMGTPage.deafultitemperpage10displayed();

    }

    @When("user change item display per page to twenty")
    public void userChangeItemDisplayPerPageToTwenty() {
        nucomplyDocumentMGTPage.perpagerecord20();

    }


    @Then("verify user is navigated to next page successfully")
    public void verifyUserIsNavigatedToNextPageSuccessfully() {

    }

    @When("user navigate to next page")
    public void userNavigateToNextPage() {
        nucomplyDocumentMGTPage.usernavigatedtonextpage();

    }

    @When("user navigate to previous page")
    public void userNavigateToPreviousPage() {
        nucomplyDocumentMGTPage.usernavigatedtopreviouspage();
    }

    @Then("verify user is navigated to previous page successfully")
    public void verifyUserIsNavigatedToPreviousPageSuccessfully() {

    }

    @Then("verify item display per page is changed to twenty")
    public void verifyItemDisplayPerPageIsChangedToTwenty() {
        nucomplyDocumentMGTPage.verify20itemsdisplayedperpage();
    }


    @When("user click on add document button")
    public void userClickOnAddDocumentButton() {
        nucomplyDocumentMGTPage.clickonadddocumentbutton();
    }

    @Then("verify document is uploaded successfully")
    public void verifyDocumentIsUploadedSuccessfully() {
        nucomplyDocumentMGTPage.verifydocumentuploadpopup();
    }

    @When("user click on document to modify")
    public void userClickOnDocumentToModify() {
        nucomplyDocumentMGTPage.clickontomodifydocument();
    }

    @Then("verify document details page is displayed")
    public void verifyDocumentDetailsPageIsDisplayed() {
        nucomplyDocumentMGTPage.verifydocumentdetails();
    }

    @When("user click on edit detials button")
    public void userClickOnEditDetialsButton() {
        nucomplyDocumentMGTPage.editdocumentdetails();
    }

    @Then("verify edit document page is displayed")
    public void verifyEditDocumentPageIsDisplayed() {
        nucomplyDocumentMGTPage.editdocumentsdetailsareshowing();
    }

    @When("user update the document details")
    public void userUpdateTheDocumentDetails() {
        nucomplyDocumentMGTPage.update_document_detials();
    }

    @When("user click on save changes button")
    public void userClickOnSaveChangesButton() {
        nucomplyDocumentMGTPage.saveupdateddocumentdetails();
    }

    @Then("verify document details is updated successfully")
    public void verifyDocumentDetailsIsUpdatedSuccessfully() {
        nucomplyDocumentMGTPage.documentdetailsupdatedsuccessfully();
    }

    @When("user click on update module details button")
    public void userClickOnUpdateModuleDetailsButton() {
        nucomplyDocumentMGTPage.updatemoduledetails();
    }

    @Then("verify update module details page is displayed")
    public void verifyUpdateModuleDetailsPageIsDisplayed() {
        nucomplyDocumentMGTPage.verifyupdatemoduledetailspage();
    }

    @When("user update the module details")
    public void userUpdateTheModuleDetails() {
        nucomplyDocumentMGTPage.updatemoduledetailsandapply();
    }

    @And("user click on apply button")
    public void userClickOnApplyButton() {
        nucomplyDocumentMGTPage.clickonapplybutton();
    }

    @Then("verify module details is updated successfully message is displayed")
    public void verifyModuleDetailsIsUpdatedSuccessfullyMessageIsDisplayed() {
        nucomplyDocumentMGTPage.moduledetailsupdatedsuccessfully();
    }

    @And("user upload a document file which is already exist in document management page")
    public void userUploadADocumentFileWhichIsAlreadyExistInDocumentManagementPage() {
        String folderPath = "C:\\Users\\Shekhar\\A\\NuArca_TestFiles";

    }

    @And("user upload a documents file")
    public void userUploadADocumentsFile() throws Exception {
        /*String testFilePath = "C:\\Users\\Shekhar\\A\\NuArca_TestFiles\\compliance email sample.docx";*/

        nucomplyDocumentMGTPage.createrandomfile();
    }

    @When("user click on document to delete")
    public void userClickOnDocumentToDelete() {

    }

    @When("User selects {string} from items per page dropdown")
    public void userSelectsFromItemsPerPageDropdown(String arg0) {
        nucomplyDocumentMGTPage.selectRecordsPerPage(arg0);
    }

    @Then("Verify {string} items are displayed per page")
    public void verifyItemsAreDisplayedPerPage(String arg0) {
        nucomplyDocumentMGTPage.asperselectedvaluerecordsdisplayed(arg0);
    }

    @When("user opens the module flags filter")
    public void userOpensTheModuleFlagsFilter() {
        nucomplyDocumentMGTPage.chooseModuleFlag();
    }

    @And("user selects {string} from module flags")
    public void userSelectsFromModuleFlags(String arg0) {
        nucomplyDocumentMGTPage.selectmoduleflagoption(arg0);
    }

    @Then("records with {string} tag should be displayed")
    public void recordsWithTagShouldBeDisplayed(String arg0) {

    }

    @Then("verify document is uploaded successfully message is displayed")
    public void verifyDocumentIsUploadedSuccessfullyMessageIsDisplayed() {
        nucomplyDocumentMGTPage.verifydocumentuploadedsuccessfully();
    }

    @When("User clicks on three dots of uploaded document")
    public void userClicksOnThreeDotsOfUploadedDocument() {
        nucomplyDocumentMGTPage.userclickonuploadeddocument();
    }

    @And("User click on delete document option")
    public void userClickOnDeleteDocumentOption() {
        nucomplyDocumentMGTPage.userclickondeleteoption();
    }

    @When("user click on delete document button")
    public void userClickOnDeleteDocumentButton() {
        nucomplyDocumentMGTPage.userclickondeletedocumentbutton();
    }

    @Then("verify document is deleted successfully message is displayed")
    public void verifyDocumentIsDeletedSuccessfullyMessageIsDisplayed() {
        nucomplyDocumentMGTPage.deletedocumentsuccessfully();
    }

    @And("User click on edit document option")
    public void userClickOnEditDocumentOption() {

    }
}