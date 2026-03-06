package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.assertions.LocatorAssertions;
import com.microsoft.playwright.options.WaitForSelectorState;
import core.TestContext;
import org.testng.Assert;

import java.nio.file.Paths;
import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class NucomplyEmailPage extends TestContext {

    public void clickEmailReviewTabs() {
        //  page.locator("//div[@class=\"css-5sujqq\"]//following::img[@alt=\"Email Review\"]").click();
        Locator EmailReviwoption = page.locator("//div[@class=\"css-5sujqq\"]//following::img[@alt=\"Email Review\"]");
        assertThat(EmailReviwoption).isVisible();
        EmailReviwoption.click();
    }

    public void enterSubjectLine(String subject) {
        //  page.locator("//input[@placeholder=\"Type the subject here...\"]").fill(subject);
        Locator Subjectfield = page.locator("//input[@placeholder=\"Type the subject here...\"]");
        Subjectfield.fill(subject);
    }

    public void userselectcomplainceconcerns() {
        // page.locator("//button[text()='Select All']").click();
        Locator selectAllCompliance = page.locator("//button[text()='Select All']");
        selectAllCompliance.click();
    }

    public void uploadEmailFile(String filePath) {
        try {
            // Find the file input element and upload the file
            Locator fileInput = page.locator("//label[text()='Select File']");
            fileInput.setInputFiles(Paths.get(filePath));
            page.waitForTimeout(1500);
        } catch (Exception e) {
            System.out.println("Error uploading file: " + e.getMessage());
        }
    }

    public void clickonreviewbutton() {
        //  page.locator("//button[text()='Review Email']").click();
        Locator EmailReviewButton = page.locator("//button[text()='Review Email']");
        EmailReviewButton.click();
    }


    public void emailoutputgeneratedverification() {
        Locator popupHeader = page.locator("//header[text()='PII Detected']");
        Locator confirmButton = page.locator("//button[text()='Confirm']");

        try {
            //
            popupHeader.waitFor(new Locator.WaitForOptions()
                    .setState(WaitForSelectorState.VISIBLE)
                    .setTimeout(20000));

            // If appears → click confirm
            confirmButton.click();

            // Wait until popup disappears
            popupHeader.waitFor(new Locator.WaitForOptions()
                    .setState(WaitForSelectorState.HIDDEN));

            System.out.println("PII popup handled");

        } catch (PlaywrightException e) {
            // Popup did not appear within 5 seconds → continue test
            System.out.println("PII popup did not appear");
        }

        Locator copyBtn = page.locator("button:has-text('Copy text')");

        assertThat(copyBtn).isEnabled(
                new LocatorAssertions.IsEnabledOptions().setTimeout(1000000)
        );
        assertThat(copyBtn).isEnabled();
        String sb = page.locator("//div[@class=\"css-1836rx5\"]").textContent();
        System.out.println("Generated email output: " + sb);


    }

    public void emailoutputisreset() {
        Locator resetBtn = page.locator("button:has-text('Reset')");

        assertThat(resetBtn).isEnabled(
                new LocatorAssertions.IsEnabledOptions().setTimeout(1000000)
        );
    }

    public void enteremailbody(String body) {
        page.locator("//textarea[@placeholder=\"Enter the body here...\"]").fill(body);
        Locator bodyfield = page.locator("//textarea[@placeholder=\"Enter the body here...\"]");
        bodyfield.fill(body);
    }

    public void clickonrefreshiconofemail() {
        // page.locator("label[for='subject'] svg").click();
        Locator subjectrefreshicon = page.locator("label[for='subject'] svg");
        subjectrefreshicon.click();
    }

    public void clickonrefreshiconofbodyicon() {
        //page.locator("//label[@for=\"body\"]//*[name()='svg']").click();
        Locator bodyrefreshicon = page.locator("//label[@for=\"body\"]//*[name()='svg']");
        assertThat(bodyrefreshicon).isVisible();
        bodyrefreshicon.click();
    }

    public void clickonrefreshiconofuploadfile() {
        //  page.locator("//div[@class=\"css-1rcfckz\"]").click();
        Locator bodyrefreshIcon = page.locator(".css-1rcfckz > .chakra-icon");
        assertThat(bodyrefreshIcon).isVisible();
        bodyrefreshIcon.click();
    }

    public void emailreviewscreendis() {
        // Page title
        assertThat(page.locator("//div[@class=\"css-qgo3pl\"]/p")).isVisible();

        // Subject input
        assertThat(page.locator("//input[@placeholder='Type the subject here...']")).isVisible();

        // Body textarea
        assertThat(page.locator("//textarea[@placeholder='Enter the body here...']")).isVisible();

        // Upload file button
        assertThat(page.locator("//label[text()='Select File']")).isVisible();

        // Compliance concerns section
        assertThat(page.locator("text=Compliance Concerns")).isVisible();

        // Review email button
        assertThat(page.locator("//label[text()='Compliance Concerns']")).isVisible();

        // Review output panel
        assertThat(page.locator("//button[text()='Review Email']")).isVisible();

    }

    public void verifyuploadedfileiscleared() {
        Locator selectFileButton = page.locator("//label[text()='Select File']");
        assertThat(selectFileButton).isEnabled();
        System.out.println("uploaded file is cleared successfully");
    }

    public void bodytextfieldanduploadtextfield() {
        Assert.assertTrue(page.locator("//textarea[@placeholder=\"Enter the body here...\"]").isVisible());
        Assert.assertTrue(page.locator("//label[text()='Select File']").isVisible());
        // page.locator("//textarea[@placeholder=\"Enter the body here...\"]").isVisible();
        // page.locator("//label[text()='Select File']").isVisible();
        System.out.println("body text field and upload file field is displayed successfully");
    }

    public void verfiyTheUploadedFilenameIsDisplayed() {
        String filename = page.locator("//p[@title=\"compliance email sample.docx\"]").textContent();
        System.out.println("uploaded filename is displayed successfully: " + filename);

    }

    public void verifyallcomplianceconcernsareselected() {
        Locator checkboxes = page.locator("//label[@class=\"chakra-checkbox css-6mlf9t\"]");
        int count = checkboxes.count();
        for (int i = 0; i < count; i++) {
            Locator option = checkboxes.nth(i);

            boolean isChecked = option.getAttribute("data-checked") != null;

            if (isChecked) {
                System.out.println("Option " + (i + 1) + " is CHECKED");
            } else {
                System.out.println("Option " + (i + 1) + " is NOT checked");
            }
        }


    }

    public void userenterdtextinthebodyfield() {
        Locator inputField = page.locator("//textarea[@placeholder=\"Enter the body here...\"]"); // your input field locator
        String enteredText = inputField.inputValue(); // Playwright Java method

        if (!enteredText.isEmpty()) {
            System.out.println("User entered text: " + enteredText);
        } else {
            System.out.println("Input field is empty!");
        }
    }

    public void userenterdtextinthesubjectfield() {
        String actualSubject = "Compliance Review Request for New AI Implementation";
        Locator inputField = page.locator("//input[@placeholder=\"Type the subject here...\"]"); // your input field locator
        String enteredText = inputField.inputValue();

        if (!enteredText.isEmpty()) {
            System.out.println("User entered text: " + enteredText);
        } else {
            System.out.println("Input field is empty!");
        }
        Assert.assertEquals(actualSubject, enteredText, "Subject text is not entered correctly");
    }


}



