package steps;

import com.microsoft.playwright.Locator;
import core.TestContext;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.NucomplyAskPage;

public class Asksteps extends TestContext {
    public Asksteps() {
        nucomplyAskPage = new NucomplyAskPage();
    }

    @When("user clicks on usfederal tab")
    public void userClicksOnUsfederalTab() {
        nucomplyAskPage.clickonusfederaltab();
    }

    @When("user ask a question to nucomply AI")
    public void userAskAQuestionToNucomplyAI() {
        nucomplyAskPage.userAskQuestion("what is bank secrecy act?");
    }

    @Then("capture the answer from nucomply AI")
    public void captureTheAnswerFromNucomplyAI() {
        page.waitForTimeout(14000);
        Locator copybutton = page.locator("(//div[@class=\"css-w8k6sx\"])[2]");

        if (copybutton.isVisible()) {
            String copyanswer = copybutton.textContent();
            System.out.println("Answer from Nucomply AI: " + copyanswer);
        } else {
            System.out.println("Copy button not found, unable to capture answer.");
        }
    }

    @Then("capture the answer from groq client")
    public void captureTheAnswerFromGroqClient() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }



    @When("User clicks on Ask a question tab")
    public void userClicksOnAskAQuestionTab() {
        page.locator("(//p[text()='Ask a Question'])[2]").click();
    }
}