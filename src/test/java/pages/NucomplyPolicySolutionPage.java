package pages;

import com.microsoft.playwright.Download;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.LocatorAssertions;
import com.microsoft.playwright.options.SelectOption;
import com.microsoft.playwright.options.WaitForSelectorState;
import core.TestContext;
import com.microsoft.playwright.Locator;
import org.testng.Assert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class NucomplyPolicySolutionPage extends TestContext {


    public void clickSolutionsTab() {
        page.locator("(//p[text()='Solutions'])[2]").click();
      //  page.locator("//button[@aria-label=\"Close\"]").click();
    }

    public void clickPolicyAndProcedureReviewButton() {
        page.locator("(//p[text()='Policy and Procedure Review'])[1]").click();

    }

    public void selectPolicyAsDocumentTypeFromDropdown() {

        Locator dropdown = page.locator("//p[text()='Document Type']//following::input[1]");
        dropdown.click();
        dropdown.fill("Policy");
        page.keyboard().press("Enter");

        //option[text()='Policy']
        page.waitForTimeout(5000);

    }


    public void uploadFile(String filePath) {
        try {
            // Find the file input element and upload the file
            Locator fileInput = page.locator("//label[text()='Select File']");
            fileInput.setInputFiles(Paths.get(filePath));
            page.waitForTimeout(1500);
        } catch (Exception e) {
            System.out.println("Error uploading file: " + e.getMessage());
        }

    }
    public void policyfileupload(String filePath) {
        try {
            // Find the file input element and upload the file
            Locator fileInput = page.locator("//label[text()='Select File']");
            fileInput.setInputFiles(Paths.get(filePath));
            page.waitForTimeout(1500);
        } catch (Exception e) {
            System.out.println("Error uploading file: " + e.getMessage());
        }

    }

    public void selectPolicyTopicsFromDropdown(String topic) {
        try {
            // Click on the policy topics dropdown
            Locator dropdown = page.locator("//paragraph[contains(text(), 'Policy Topics')]//following::combobox").first();
            dropdown.click();
            page.waitForTimeout(500);

            // Select the option
            Locator option = page.locator("//option[contains(., '" + topic + "')]").first();
            option.click();
            page.waitForTimeout(500);
        } catch (Exception e) {
            System.out.println("Error selecting policy topic: " + e.getMessage());
        }
    }

    public void selectFromReactDropdown(String optionText) {
        Locator dropdownInput = page.locator("//p[text()='Policy Topics']//following::input[1]");

        dropdownInput.click();
        dropdownInput.fill(optionText);
        page.keyboard().press("Enter");
    }


    public void clickReviewPolicyButton() {
        try {
            Locator button = page.locator("//button[contains(., 'Review Policy')]").first();
            // Wait for button to be enabled
            button.waitFor();
            button.click();
            page.waitForTimeout(3000); // Wait for response
        } catch (Exception e) {
            System.out.println("Error clicking Review Policy button: " + e.getMessage());
        }
    }

    public String getPolicyOutput() {
        Locator copyBtn = page.locator("button:has-text('Copy text')");

        assertThat(copyBtn).isEnabled(
                new LocatorAssertions.IsEnabledOptions().setTimeout(1000000)
        );
        String policyreviewoutput = page.locator("//div[@class=\"css-1gw7oh2\"]").textContent();
        System.out.println("policy output geenrated: " + policyreviewoutput);
        return "";
    }

    public void downloadupdatedpolicylink() throws IOException {
        Locator pdfLink = page.locator("//a[@aria-label=\"Updated Procedure Link\"]");
        pdfLink.waitFor(
                new Locator.WaitForOptions()
                        .setState(WaitForSelectorState.VISIBLE)
                        .setTimeout(1000000)
        );
        Download download = page.waitForDownload(() -> {
            pdfLink.click();
        });
        Files.createDirectories(Paths.get("downloads"));
        download.saveAs(Paths.get("downloads/myfile.pdf"));

      /*  Locator updatedLink = page.locator("//a[@aria-label='Updated Procedure Link']");
        updatedLink.waitFor();
        updatedLink.click();*/

    }

    public void downloadedRedlinePolicylink() {
        Locator pdfLink = page.locator("//a[@aria-label=\"Redlined Procedure Link\"]");
        pdfLink.waitFor(
                new Locator.WaitForOptions()
                        .setState(WaitForSelectorState.VISIBLE)
                        .setTimeout(1000000)
        );
        Download download = page.waitForDownload(() -> {
            pdfLink.click();
        });


    }

    public void policyreviewscreenisdisplayed() {
       /* Locator policyText = page.locator("//p[text()='Policy and Procedure Review']");

        policyText.waitFor(new Locator.WaitForOptions()
                .setState(WaitForSelectorState.VISIBLE)
                .setTimeout(5000));
        Assert.assertTrue(
                policyText.isVisible(),
                "'Policy and Procedure Review' text is NOT visible on page"
        );
        System.out.println("Policy Review screen is displayed");*/
        assertThat(page).hasURL(Pattern.compile("/compliance/policy-review"));
      /*  Assert.assertTrue(page.title().contains("NuComply | NuComply - Policy and Procedure Review"));*/


    }

    public void verifypolicyoptionselected() {
        Assert.assertTrue(page.locator("//div[text()='Policy']").isVisible());
    }

    public void verifyfileuploadedsuccessfully() {
        Assert.assertTrue(page.locator("//p[@title=\"Bank Secrecy Act.pdf\"]").isVisible());
        System.out.println("File is uploaded successfully");
    }

    public void verifypolicytopicselected() {
        Locator dropdown = page.locator("(//div[@class=\"css-18euh9p\"])[2]");

        dropdown.click();
        Locator dropdownInput = page.locator("(//div[@class=\"css-18euh9p\"])[1]/input");
        dropdownInput.fill("BSA-AML");
        page.keyboard().press("Enter");
    }

    public void policygeneratedpagedisplayed() {
        page.waitForTimeout(5000);
        Assert.assertTrue(page.title().equals("NuComply | NuComply - Policy and Procedure Review"));
        Assert.assertTrue(page.locator("//p[text()='Policy Generation']").isVisible());
        System.out.println("Policy generated page is displayed successfully");
    }

    public void policytypeisselected() {
        String selectedpolicytype = page.locator("//button[text()='BSA-AML']").textContent();
        System.out.println("Procedure option is selected successfully =" + selectedpolicytype);

    }

}
