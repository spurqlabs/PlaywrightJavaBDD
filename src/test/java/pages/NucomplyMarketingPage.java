package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.assertions.LocatorAssertions;
import core.TestContext;
import org.junit.Assert;

import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class NucomplyMarketingPage extends TestContext {

    public void clickonmarketingreview() {
        // page.locator("(//p[text()='Marketing Review'])[1]").click();
        Locator marektingreview = page.locator("(//p[text()='Marketing Review'])[1]");
        assertThat(marektingreview).isVisible();
        marektingreview.click();
    }

    public void userentermarketingbodytext(String body) {
       // page.locator("//textarea[@placeholder=\"Enter the body here...\"]").fill(body);
        Locator marketingbodytextfield = page.locator("//textarea[@placeholder=\"Enter the body here...\"]");
        marketingbodytextfield.fill(body);
    }

    public void clickonmarketingreviewbutton() {
        //page.locator("//button[text()='Review Marketing']").click();
        Locator marketingreviewbutton = page.locator("//button[text()='Review Marketing']");
        marketingreviewbutton.click();
    }

    public void marketingoutputgeneratedverification() {
        Locator copyBtn = page.locator("button:has-text('Copy text')");

        assertThat(copyBtn).isEnabled(
                new LocatorAssertions.IsEnabledOptions().setTimeout(1000000)
        );
        String marketingreviewoutput = page.locator("//div[@class=\"css-1gw7oh2\"]").textContent();
        System.out.println("Generated email output: " + marketingreviewoutput);
    }

    public void resetmarketingoutputgenerated() {
        Locator resetBtn = page.locator("button:has-text('Reset')");

        assertThat(resetBtn).isEnabled(
                new LocatorAssertions.IsEnabledOptions().setTimeout(1000000)
        );
    }

    public void uploadMarketingFile(String filePath) {
        try {
            // Find the file input element and upload the file
            Locator fileInput = page.locator("//label[text()='Select File']");
            fileInput.setInputFiles(Paths.get(filePath));
            page.waitForTimeout(1500);
        } catch (Exception e) {
            System.out.println("Error uploading file: " + e.getMessage());
        }
    }

    public void clickonrefreshiconbody() {
     //   page.locator("label[for='body'] svg");
        Locator refreshiconbody = page.locator("label[for='body'] svg");
        refreshiconbody.click();
    }


    public void clickonrefreshiconuploadfile() {
      //  page.locator(".css-1rcfckz > .chakra-icon").click();
        Locator refreshiconuploadfile = page.locator(".css-1rcfckz > .chakra-icon");
        refreshiconuploadfile.click();
    }

    public void marketingreiewscreenisdisplayed() {
        page.waitForTimeout(2000);
        String acutaltitle = page.title();
        String expectedtitle = "NuComply | NuComply - Marketing Review";
        Assert.assertEquals(acutaltitle, expectedtitle);
        Locator marketingreviewscreen = page.locator("//div[@class=\"css-902mut\"]/child::p");
        assertThat(marketingreviewscreen).isVisible();
    }

    public void userenteredmarketingbodytextfield() {
        Locator inputField = page.locator("//textarea[@placeholder=\"Enter the body here...\"]"); // your input field locator
        String enteredText = inputField.inputValue(); // Playwright Java method

        if (!enteredText.isEmpty()) {
            System.out.println("User entered text: " + enteredText);
        } else {
            System.out.println("Input field is empty!");
        }
    }

    public void marketingfileuploadisdisplayed() {
        String filename = page.locator("//p[text()='Mortga...']").textContent();
        System.out.println("uploaded filename is displayed successfully: " + filename);
        page.locator("//p[text()='Mortga...']").isVisible();
    }

    public void marketingbodytextfieldiscleared() {
        Locator inputField = page.locator("//textarea[@placeholder=\"Enter the body here...\"]"); // your input field locator
        String enteredText = inputField.inputValue(); // Playwright Java method

        if (enteredText.isEmpty()) {
            System.out.println("Marketing body text field is cleared successfully");
        } else {
            System.out.println("Marketing body text field is not cleared!");
        }
    }

    public void marketingfileuploadiscleared() {
        String uploadfilecleard = page.locator("//p[@class=\"chakra-text css-auf66n\"]").textContent();
        if (uploadfilecleard.isEmpty()) {
            System.out.println("Upload file field is cleared successfully");
        } else {
            System.out.println("Upload file field is not cleared");
            System.out.println("Uploaded file name is not : " + uploadfilecleard);
        }
    }


}