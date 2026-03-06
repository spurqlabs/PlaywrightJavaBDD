package pages;

import com.microsoft.playwright.Download;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import core.TestContext;
import org.testng.Assert;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class NucomplyRegulatoryChangePage extends TestContext {

    public void clickonregulatorychangereview() {
        page.waitForTimeout(5000);
        page.locator("(//img[@alt=\"Regulatory Change Review\"])[2]").click();
        System.out.println("Click on regulatory change review");
    }

    public void clickonfilteroption() {
        page.locator("//span[text()='Newest first']").click();
    }

    public void clickonnewestfilteroption() {
        page.locator("//button[@type=\"button\"]//following::span[text()='Newest first']").click();
    }

    public void clickonoldestfirstoption() {
        page.locator("//button[text()='Oldest first']").click();
    }

    public void clickonmostimpactful() {
        page.locator("//button[text()='Most Impactful']").click();
    }

    public void clickonleastimpactful() {
        page.locator("//button[text()='Least Impactful']").click();
    }

    public void clickonexportlink() {
        page.locator("//button[text()='Export']").click();
    }

    public void verifyregulatorychangeexportfiledownloaded() {
        page.waitForTimeout(5000);
        Download download = page.waitForDownload(() -> {
            page.locator("//button[text()='Export']").click();
        });
        Path downloadPath = Paths.get("downloads").resolve(download.suggestedFilename());
        try {
            download.saveAs(downloadPath);
            Assert.assertTrue(downloadPath.toFile().exists(), "Exported file was not downloaded successfully.");
            System.out.println("Regulatory change export file downloaded successfully: " + downloadPath.toString());
        } catch (Exception e) {
            Assert.fail("Failed to save the downloaded file: " + e.getMessage());
        }
    }

    public void clickonclearallfiltersoption() {
        page.locator("//button[text()='Clear all']").click();
    }

    public void verfiyclearallfilter() {
        boolean isvivible = page.locator("//div[text()='High Impact']").isVisible();
        Assert.assertFalse(isvivible);
        System.out.println("All filters are cleared");
    }

    public void clickImpactTab(String expectedImpact) {

        String tabLocator = "//div[contains(@class,'chakra-wrap')]//span[normalize-space()='"
                + expectedImpact + "']";

        page.locator(tabLocator).click();
        page.waitForLoadState(LoadState.NETWORKIDLE);
    }

    public void clickTypeTab(String type) {


        String typeLocator =
                "//label[normalize-space()='Type']" +
                        "/following-sibling::*" +
                        "//span[normalize-space()='" + type.trim() + "']";
        page.locator(typeLocator).click();
        page.waitForLoadState(LoadState.NETWORKIDLE);
    }


    public void verifyimpactresultsdisplayed(String impact) {
        int increment = 0;
        Locator selectedimpact = page.locator("\n" +
                "//div[@class=\"chakra-stack css-porbmv\"]//span[3]");
        int count = selectedimpact.count();
        System.out.println("Number of results: " + count);
        for (int i = 0; i < count; i++) {
            String text = selectedimpact.nth(i).innerText();
            System.out.println("Result " + (i + 1) + ": " + text);
            if (text.equalsIgnoreCase(impact)) {
                Assert.assertTrue(true);
                System.out.println("Selected impact results are displayed");
                //button[@aria-label="Next page"]

            } else {
                Assert.fail("Selected impact results are not displayed");
            }
        }
    }

    public void verifytypefilterresultsdisplayed(String type) {
        int increment = 0;
        Locator selectedimpact = page.locator("//div[@class=\"chakra-stack css-porbmv\"]//span[1]");
        int count = selectedimpact.count();
        System.out.println("Number of results: " + count);
        for (int i = 0; i < count; i++) {
            String text = selectedimpact.nth(i).innerText();
            System.out.println("Result " + (i + 1) + ": " + text);
            if (text.equalsIgnoreCase(type)) {
                Assert.assertTrue(true);
                System.out.println("Selected type results are displayed");
                //button[@aria-label="Next page"]

            } else {
                Assert.fail("Selected type results are not displayed");
            }
        }


    }

    public void veriftyperesultsdisplayed(String impact) {
        int increment = 0;
        Locator selectedimpact = page.locator("//label[normalize-space()='Type']\" +\n" +
                "                        \"/following-sibling::*\" +\n" +
                "                        \"//span[normalize-space()='\" + type+ \"']");
        int count = selectedimpact.count();
        System.out.println("Number of results: " + count);
        for (int i = 0; i < count; i++) {
            String text = selectedimpact.nth(i).innerText();
            System.out.println("Result " + (i + 1) + ": " + text);
            if (text.equalsIgnoreCase(impact)) {
                Assert.assertTrue(true);
                System.out.println("Selected type results are displayed");
                //button[@aria-label="Next page"]

            } else {
                Assert.fail("Selected type results are not displayed");
            }
        }

    }

    public void selectitemperpageoption(String item) {

        Locator dropdown = page.locator("//select[contains(@class,'chakra-select')]");

        dropdown.selectOption(item);

        Assert.assertEquals(dropdown.inputValue(), item,
                "Dropdown value not selected properly");
    }


    public void regualtorychangereviewscreendisplayed() {
        page.waitForTimeout(5000);
        String currentURL = page.url();
        Assert.assertTrue(currentURL.contains("/regulatory-change-review"));
        assertThat(page.locator("//button[text()='Export']")).isVisible();
        // Assert.assertTrue(page.locator("//a[text()='Regulatory Change Review']").isVisible());
        System.out.println("Regulatory Change Review screen displayed");
    }

    public void newestfirstdropdownfilteroptionisdisplayed() {
        page.waitForTimeout(5000);
        Assert.assertTrue(page.locator("//span[text()='Newest first']").isVisible());
        Assert.assertTrue(page.locator("//button[text()='Oldest first']").isVisible());
        Assert.assertTrue(page.locator("//button[text()='Most Impactful']").isVisible());
        Assert.assertTrue(page.locator("//button[text()='Least Impactful']").isVisible());
        System.out.println("Newest first dropdown filter option is displayed");
    }

    public void userclickonFiltersoptions() {
        page.locator("//button[text()='Filter']").click();
    }

    public void enterformandtodate(String from, String to) {

        page.locator("(//input[@placeholder=\"From\"])[2]").fill(from);
        page.keyboard().press("Enter");

        page.locator("(//input[@placeholder=\"To\"])[2]").fill(to);
        page.keyboard().press("Enter");
    }

    public void clicksoncrossicon() {
        page.waitForTimeout(5000);
        page.locator("//button[@aria-label=\"Close filters\"]").click();
    }

    public void selectmultiplejurisdiction() {

        page.locator("(//p[text()=' selected'])[1]").click();

    }

    public void selecttypefilteroption() {


        page.locator("//label[text()='Type']//following::span[text()='Rules']").click();


    }

    public void entertextintosearchinputfield(String text) {
        page.locator("//input[@placeholder='Search']").fill(text);
    }

    public void selectperpageitemsoption(String value) {
        Locator perpagedrop = page.locator("//select[@class=\"chakra-select css-bigvto\"]");
        perpagedrop.click();
        perpagedrop.selectOption(value);
    }

    public void perpageitems25selected() {
        page.locator("//option[text()='25 per page']").click();
    }

    public void perpageitemsoptionsdisplayed() {
        page.waitForTimeout(5000);
        Assert.assertTrue(page.locator("//option[text()='10 per page']").isVisible());
        Assert.assertTrue(page.locator("//option[text()='25 per page']").isVisible());
        Assert.assertTrue(page.locator("//option[text()='50 per page']").isVisible());
        Assert.assertTrue(page.locator("//option[text()='100 per page']").isVisible());
        System.out.println("per page items options are displayed");
    }

    public void clickonpolicytitlelink() {
        page.waitForTimeout(5000);
        page.locator("//div[@class=\"chakra-stack reg-update-card-stack css-dcesaw\"]/child::*[1]").click();

    }

    public void policyrealtedaskquestion(String question) {
        page.locator("//textarea[@placeholder=\"Ask a question..\"]").fill(question);
        page.locator("//button[@aria-label=\"Send message\"]").click();

    }

    public void policysearchresultdisplayed() {
        page.waitForTimeout(5000);
        page.locator("//div[@class=\"chakra-stack css-rud52l\"]/following::h3[text()='801.1 Purpose.']").isVisible();
        System.out.println("Policy related search result is displayed");

    }

    public void clickonsendbutton() {
        page.locator("//button[@aria-label=\"Send message\"]").click();
    }

    public void summaryimpactspagedisplayed() {
       /* page.waitForTimeout(5000);
        page.locator("//h2[text()='Summary']").isVisible();
        page.locator("//h2[text()='Impacts']").isVisible();
        System.out.println("Policy change summary and impact details are displayed on drill down page");
        Locator Summarysection = page.locator("//div[@class=\"css-f0cvv7\"][1]");
        String summarytext = Summarysection.innerText();
        System.out.println("Summary section text: " + summarytext);
        Locator Impactsection = page.locator("//div[@class=\"css-f0cvv7\"][2]");
        String impacttext = Impactsection.innerText();
        System.out.println("Impact section text: " + impacttext);*/
        // Wait for Summary section
        page.waitForSelector("//h2[text()='Summary']");

        // Validate headers are visible
        Assert.assertTrue(
                page.locator("//h2[text()='Summary']").isVisible(),
                "Summary header is NOT visible"
        );

        Assert.assertTrue(
                page.locator("//h2[text()='Impacts']").isVisible(),
                "Impacts header is NOT visible"
        );

        System.out.println("Policy change summary and impact details are displayed on drill down page");

        // Capture Summary text
        Locator summarySection = page.locator("(//div[@class='css-f0cvv7'])[1]");
        String summaryText = summarySection.innerText().trim();

        Assert.assertFalse(
                summaryText.isEmpty(),
                "Summary section text should not be empty"
        );

        System.out.println("Summary section text: " + summaryText);

        // Capture Impact text
        Locator impactSection = page.locator("(//div[@class='css-f0cvv7'])[2]");
        String impactText = impactSection.innerText().trim();

        Assert.assertFalse(
                impactText.isEmpty(),
                "Impact section text should not be empty"
        );

        System.out.println("Impact section text: " + impactText);

    }

    public void regulatorydashboardisdisplayed() {
        String[] expectedTexts = {
                "High Impact Rules Published",
                "High Impact Rules Proposed",
                "Enforcement Actions on Peers",
                "Policy Updates Required",
                "Training Updates Required"
        };

        for (String text : expectedTexts) {

            Locator element = page.locator("//p[text()='" + text + "']");

            page.waitForSelector("//p[text()='" + text + "']");

            Assert.assertTrue(
                    element.isVisible(),
                    text + " is not visible"

            );
        }


    }

    public void regulatordropdownoptionselected(String optionText) {
        Locator dropdownInput = page.locator("(//div[@class=\"css-18euh9p\"])[2]/input");

        dropdownInput.click();
        dropdownInput.fill(optionText);
        page.keyboard().press("Enter");
    }


}

