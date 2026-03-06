package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.WaitForSelectorState;
import core.TestContext;

import java.nio.file.Paths;

public class NucomplyPolicyGeneratorPage extends TestContext {


    public void clcikonpolicygenerator() {
        page.locator("//p[text()='Policy Generator']//following::img[@alt=\"Policy Generator\"]").click();
    }

    public void userselectpolicyoption() {
        page.waitForTimeout(2000);
        Locator dropdown = page.locator("//div[@class=\"css-18euh9p\"]");
        dropdown.click();
        Locator dropdownInput = page.locator("//div[@class=\"css-18euh9p\"]//input");
        dropdownInput.type("BSA-AML");
        page.keyboard().press("Enter");
        page.waitForTimeout(5000);

    }

    public void uploadFilepolicy(String filePath) {
        try {
            // Find the file input element and upload the file
            Locator fileInput = page.locator("//label[text()='Select File']");
            fileInput.setInputFiles(Paths.get(filePath));
            page.waitForTimeout(1500);
        } catch (Exception e) {
            System.out.println("Error uploading file: " + e.getMessage());
        }
    }

    public void clickongeneratebutton() {
        page.locator("(//button[text()='Generate'])[1]").click();
    }

    public void questionanswer1() {

        Locator answerBox = page.locator("//textarea[@placeholder='Enter your answer here.']");
        answerBox.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        answerBox.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.ATTACHED));
        answerBox.fill("Answer1");
        page.locator("//button[@aria-label=\"Send message\"]").click();
        System.out.println("answer1");
    }

    public void questionanswer2() {
        page.waitForTimeout(50000);
        Locator answerBox = page.locator("//textarea[@placeholder='Enter your answer here.']");
        answerBox.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        answerBox.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.ATTACHED));
        answerBox.fill("Answer2");
        page.locator("//button[@aria-label=\"Send message\"]").click();
        System.out.println("answerd");
    }

    public void questionanswer3() {
        page.waitForTimeout(20000);
        Locator answerBox = page.locator("//textarea[@placeholder='Enter your answer here.']");
        answerBox.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        answerBox.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.ATTACHED));
        answerBox.fill("Answer1");
        System.out.println("answerd");
    }

}
