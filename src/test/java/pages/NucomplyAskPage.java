package pages;

import core.TestContext;

public class NucomplyAskPage extends TestContext {
    private final String usfederaltab = "//div[text()='US Federal']";

    public void clickonusfederaltab() {
        page.locator(usfederaltab).click();
        page.waitForTimeout(5000);
    }
    public void userAskQuestion(String question) {
        page.locator("//textarea[@placeholder=\"Ask a question..\"]").fill(question);
        page.locator("//button[@aria-label='Send message']").click();
        page.waitForTimeout(5000);
    }


}
