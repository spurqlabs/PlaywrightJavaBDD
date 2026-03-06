package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.assertions.LocatorAssertions;
import com.microsoft.playwright.options.SelectOption;
import core.TestContext;
import org.testng.Assert;

import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class NucomplyProcedurePage extends TestContext {

    public void selectProcedureAsDocumentTypeFromDropdown() {
        Locator dropdown = page.locator("(//div[@class=\"css-18euh9p\"])[1]");
        dropdown.click();
        Locator inputdropdown = page.locator("//div[@class=\"css-1xa1gs2\"]//following::input[1]");
        inputdropdown.fill("Procedure");
        page.keyboard().press("Enter");

    }

    public void ProcedureuploadFile(String filePath) {
        try {
            // Find the file input element and upload the file
            Locator fileInput = page.locator("//label[text()='Select File']");
            fileInput.setInputFiles(Paths.get(filePath));
            page.waitForTimeout(1500);
        } catch (Exception e) {
            System.out.println("Error uploading file: " + e.getMessage());
        }
    }

    public void selectProcedureTopicFromDropdown() {
        Locator dropdown = page.locator("(//div[@class=\"css-18euh9p\"])[2]");

        dropdown.click();
        Locator dropdownInput = page.locator("(//div[@class=\"css-18euh9p\"])[2]/input");
        dropdownInput.fill("BSA-AML");
        page.keyboard().press("Enter");

    }

    public void userselectproceduretopicoption() {
        page.waitForTimeout(5000);
        Assert.assertTrue(page.locator("//span[text()='BSA-AML']").isVisible());
        System.out.println("Procedure topic option is selected");

    }

    public void getprocedureoutputgeneratedverification() {
        Locator copyBtn = page.locator("button:has-text('Copy text')");

        assertThat(copyBtn).isEnabled(
                new LocatorAssertions.IsEnabledOptions().setTimeout(1000000)
        );
        String procedurereviewoutput = page.locator("//div[@class=\"css-1gw7oh2\"]").textContent();
        System.out.println("Generated procedure output: " + procedurereviewoutput);
    }

    public void clickReviewProcedureButton() {
        Locator reviewProcedureButton = page.locator("//button[text()='Review Procedure']");
        reviewProcedureButton.click();
    }

    public void downloadupdatedprocedurelink() {
        Locator copyBtn = page.locator("button:has-text('Copy text')");

        assertThat(copyBtn).isEnabled(
                new LocatorAssertions.IsEnabledOptions().setTimeout(1000000)
        );


    }

    public void userselectprocedureoption() {
        Assert.assertTrue(page.locator("//div[text()='Procedure']").isVisible());
        System.out.println("Procedure option is selected");

    }

    public void downloadredlineprocedurelink() {
        Locator copyBtn = page.locator("button:has-text('Copy text')");

        assertThat(copyBtn).isEnabled(
                new LocatorAssertions.IsEnabledOptions().setTimeout(1000000)
        );
        page.locator("//p[text()='Redlined ']").click();


    }

    public void verifyprocedurefileuploadedsuccessfully() {
        page.locator("//p[@title=\"Bank Secrecy Act.pdf\"]").isVisible();
        System.out.println("Procedure file is uploaded successfully");
    }

}
