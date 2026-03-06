package steps;

import core.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.NucomplyLoginPage;
import pages.NucomplySignupPage;

import java.util.Map;
import java.util.UUID;

import static core.TestContext.nucomplysignuppage;

public class NucomplySignupSteps extends TestContext {
    public static String generatedEmail;

    public NucomplySignupSteps() {
        nucomplysignuppage = new NucomplySignupPage();
    }

    @When("I fill the registration form with:")
    public void iFillTheRegistrationFormWith(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        generatedEmail = "user_" + UUID.randomUUID().toString().substring(0, 8) + "@example.com";

        nucomplysignuppage.enterusername(generatedEmail);
        nucomplysignuppage.enterpassword(data.get("password"));
        nucomplysignuppage.name(data.get("fullName"));
        nucomplysignuppage.enterPhoneNumber(data.get("phonenumber"));

        nucomplysignuppage.enterOrgnizationname(data.get("organization"));
        nucomplysignuppage.enterTitle(data.get("title"));

    }

    @When("user clicks on signup link")
    public void userClicksOnSignupLink() {

        nucomplysignuppage.clickOnSigupLink();

    }

    @And("I click the Sign Up button")
    public void iClickTheSignUpButton() {
        nucomplysignuppage.signUpButton();

    }

    @Then("check user will recive a verification email")
    public void checkUserWillReciveAVerificationEmail() {
        nucomplysignuppage.emailsentverification();
    }


    @Then("user can see the login tab and sign up tab")
    public void userCanSeeTheLoginTabAndSignUpTab() {

        nucomplysignuppage.loginSignupTabVisible();
    }

    @Then("user is redirected to signup page")
    public void userIsRedirectedToSignupPage() {

    }
}
