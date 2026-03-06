package steps;

import core.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.NucomplyRegulatoryChangePage;

import java.util.List;
import java.util.Map;

public class RegualtoryChangeSteps extends TestContext {
    public RegualtoryChangeSteps() {
        nucomplyRegulatoryChangePage = new NucomplyRegulatoryChangePage();
    }

    @When("user clicks on regulatory change review")
    public void userClicksOnRegulatoryChangeReview() {
        nucomplyRegulatoryChangePage.clickonregulatorychangereview();
    }

    @When("user clicks newest first dropdown")
    public void userClicksNewestFirstDropdown() {
        nucomplyRegulatoryChangePage.clickonfilteroption();
    }

    @When("user select newest first option")
    public void userSelectNewestFirstOption() {
        nucomplyRegulatoryChangePage.clickonnewestfilteroption();
    }

    @When("user clicks on filter option")
    public void userClicksOnFilterOption() {
        nucomplyRegulatoryChangePage.userclickonFiltersoptions();
    }

    @When("user enter following from and todate")
    public void userEnterFollowingFromAndTodate(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        Map<String, String> row = data.get(0);
        String fromdate = row.get("from");
        String todate = row.get("Todate");
        nucomplyRegulatoryChangePage.enterformandtodate(fromdate, todate);

    }

    @When("user clicks on cross icon")
    public void userClicksOnCrossIcon() {
        nucomplyRegulatoryChangePage.clicksoncrossicon();
    }

    @When("user select dropdown option from jurisdiction dropdown")
    public void userSelectDropdownOptionFromJurisdictionDropdown() {
        nucomplyRegulatoryChangePage.selectmultiplejurisdiction();
    }

    @When("user select impact option")
    public void userSelectImpactOption() {

    }

    @When("user select Oldest first option")
    public void userSelectOldestFirstOption() {
        nucomplyRegulatoryChangePage.clickonoldestfirstoption();
    }

    @When("user select Most Impactful option")
    public void userSelectMostImpactfulOption() {
        nucomplyRegulatoryChangePage.clickonmostimpactful();
    }

    @When("user select least Impactful option")
    public void userSelectLeastImpactfulOption() {
        nucomplyRegulatoryChangePage.clickonleastimpactful();
    }

    @When("user clicks on Export button")
    public void userClicksOnExportButton() {
        nucomplyRegulatoryChangePage.clickonexportlink();
    }

    @Then("verify regulatory change review page is displayed")
    public void verifyRegulatoryChangeReviewPageIsDisplayed() {
        nucomplyRegulatoryChangePage.regualtorychangereviewscreendisplayed();
    }

    @Then("verify the filter options are displayed")
    public void verifyTheFilterOptionsAreDisplayed() {
        nucomplyRegulatoryChangePage.newestfirstdropdownfilteroptionisdisplayed();
    }

    @Then("verify specific filter section are presented")
    public void verifySpecificFilterSectionArePresented() {
        Assert.assertTrue(page.locator("//label[text()='Date Range']").isVisible());
        Assert.assertTrue(page.locator("//label[text()='Jurisdictions']").isVisible());
        Assert.assertTrue(page.locator("//label[text()='Regulators']").isVisible());
        Assert.assertTrue(page.locator("//label[text()='Impact']").isVisible());
        Assert.assertTrue(page.locator("//label[text()='Type']").isVisible());
    }

    @When("user select dropdown option from regulator dropdown")
    public void userSelectDropdownOptionFromRegulatorDropdown() {
        nucomplyRegulatoryChangePage.regulatordropdownoptionselected("Federal Reserve Board");
    }


    @When("user select type option")
    public void userSelectTypeOption() {
        nucomplyRegulatoryChangePage.selecttypefilteroption();
    }

    @When("user enter following text into search input field")
    public void userEnterFollowingTextIntoSearchInputField() {
        nucomplyRegulatoryChangePage.entertextintosearchinputfield("801.1 Purpose.");
    }



    @When("user select the per item")
    public void userSelectThePerItem() {
        nucomplyRegulatoryChangePage.perpageitems25selected();
    }

    @Then("verify the per page options are displayed")
    public void verifyThePerPageOptionsAreDisplayed() {
        nucomplyRegulatoryChangePage.perpageitemsoptionsdisplayed();
    }

    @When("user clicks on any document name from the list")
    public void userClicksOnAnyDocumentNameFromTheList() {
        nucomplyRegulatoryChangePage.clickonpolicytitlelink();
    }

    @Then("verify the policy change summary and impact details are displayed on drill down page")
    public void verifyThePolicyChangeSummaryAndImpactDetailsAreDisplayedOnDrillDownPage() {
        nucomplyRegulatoryChangePage.summaryimpactspagedisplayed();
    }

    @Then("user can see different type of dashboard on regualtory change review screen")
    public void userCanSeeDifferentTypeOfDashboardOnRegualtoryChangeReviewScreen() {

        nucomplyRegulatoryChangePage.regulatorydashboardisdisplayed();
    }

    @When("user enter question into ask question input field related to document")
    public void userEnterQuestionIntoAskQuestionInputFieldRelatedToDocument() {
        nucomplyRegulatoryChangePage.policyrealtedaskquestion("What is the impact of this regulatory change?");
    }

    @Then("verify the regulatory change review data is searched based on entered text.")
    public void verifyTheRegulatoryChangeReviewDataIsSearchedBasedOnEnteredText() {
        nucomplyRegulatoryChangePage.policysearchresultdisplayed();
    }

    @And("user click on send button")
    public void userClickOnSendButton() {
        nucomplyRegulatoryChangePage.clickonsendbutton();
    }

    @Then("verify excel file is downloaded successfully")
    public void verifyExcelFileIsDownloadedSuccessfully() {
        nucomplyRegulatoryChangePage.verifyregulatorychangeexportfiledownloaded();
    }

    @When("user clicks on clear all button")
    public void userClicksOnClearAllButton() {
        nucomplyRegulatoryChangePage.clickonclearallfiltersoption();
    }

    @Then("verify all the applied filters are cleared successfully")
    public void verifyAllTheAppliedFiltersAreClearedSuccessfully() {
        nucomplyRegulatoryChangePage.verfiyclearallfilter();
    }

    @When("User selects {string} impact filter")
    public void userSelectsImpactFilter(String arg0) {

    }

    @Then("Records should be displayed for {string} impact")
    public void recordsShouldBeDisplayedForImpact(String arg0) {

    }

    @Then("verify the regulatory change review data is filtered based on selected Impact option")
    public void verifyTheRegulatoryChangeReviewDataIsFilteredBasedOnSelectedImpactOption() {

    }

    @When("user selects {string} impact option")
    public void userSelectsImpactOption(String arg0) {
        nucomplyRegulatoryChangePage.clickImpactTab(arg0);
    }

    @Then("verify the regulatory change review data is filtered based on {string}")
    public void verifyTheRegulatoryChangeReviewDataIsFilteredBasedOn(String arg0) {
        nucomplyRegulatoryChangePage.verifyimpactresultsdisplayed(arg0);
    }

    @Then("verify the regulatory change review data is filtered based on {string} is displayed")
    public void verifyTheRegulatoryChangeReviewDataIsFilteredBasedOnIsDisplayed(String arg0) {
        nucomplyRegulatoryChangePage.veriftyperesultsdisplayed(arg0);
    }


    @When("User selects {string} items per page")
    public void userSelectsItemsPerPage(String arg0) {
        nucomplyRegulatoryChangePage.selectperpageitemsoption(arg0);
    }

    @Then("Table should display maximum {string} records")
    public void tableShouldDisplayMaximumRecords(String arg0) {
        nucomplyRegulatoryChangePage.verifytypefilterresultsdisplayed(arg0);
    }

    @When("user selects {string} type option")
    public void userSelectsTypeOption(String arg0) {
     nucomplyRegulatoryChangePage.clickTypeTab(arg0);
    }


}
