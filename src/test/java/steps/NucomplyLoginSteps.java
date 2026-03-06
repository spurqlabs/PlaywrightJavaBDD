package steps;

import com.fasterxml.jackson.databind.JsonNode;
import com.microsoft.playwright.options.AriaRole;
import core.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import pages.NucomplyLoginPage;
import utilities.JsonReaderUtil;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertTrue;

public class NucomplyLoginSteps extends TestContext {
    public NucomplyLoginSteps() {
        nucomplyloginpage = new NucomplyLoginPage();
    }

    @Given("User is on nucomply page")
    public void userIsOnNucomplyPage() throws IOException {
        nucomplyloginpage.userONLoginPage();

    }

    @Then("verify Login page is displayed")
    public void verifyLoginPageIsDisplayed() {
        nucomplyloginpage.isloginpagedisplayed();
    }

    @When("User click on login button")
    public void userClickOnLoginButton() {
        nucomplyloginpage.userClickOnLogInButton();

    }

    @Then("user is redirected to login page")
    public void userIsRedirectedToLoginPage() {
        nucomplyloginpage.redirectedtoLoginpage();
    }


    @When("User enter following credentails")
    public void userEnterFollowingCredentails(DataTable dataTable) {
        // Convert DataTable to List of Maps (header as keys)
        List<Map<String, String>> credentials = dataTable.asMaps(String.class, String.class);

        // Loop through all rows (even if you have only 1)
        for (Map<String, String> row : credentials) {
            String username = row.get("username");
            String password = row.get("password");
            nucomplyloginpage.enterUsernamePass(username, password);
        }


    }

    @When("User click on Logins Buttons")
    public void userClickOnLoginsButtons() {
        nucomplyloginpage.clicksONLogin();

    }

    @Then("verify login popup is displayed")
    public void verifyLoginPopupIsDisplayed() {
        nucomplyloginpage.isLoginSuccessPopupDisplayed();
        System.out.println("Login_successfull");

    }

    @When("User click on logout button")
    public void userClickOnLogoutButton() {
        nucomplyloginpage.clickonlogout();
        System.out.println("logout_sucessfuuly");
    }

    @When("User click on user profile icon")
    public void userClickOnUserProfileIcon() {
        nucomplyloginpage.userclickonuserprofileicon();
    }


    @Then("log-ing is successful displayed")
    public void logIngIsSuccessfulDisplayed() {
        nucomplyloginpage.loginsuccesspopupisdisplayed();
    }

    @Then("homepage is visible to user")
    public void homepageIsVisibleToUser() {
        nucomplyloginpage.homepageisvisvisible();

    }

    @Then("verify logout pop-up is displayed")
    public void verifyLogoutPopUpIsDisplayed() {
        nucomplyloginpage.verifylogoutpopupisdisplayed();
    }

    @When("User click on forgot password link")
    public void userClickOnForgotPasswordLink() {
        nucomplyloginpage.clickonforgotpasswordlink();
    }

    @When("User enter registered email id")
    public void userEnterRegisteredEmailId() {
        nucomplyloginpage.enterregisteredemailid("trupti.natu@nuarca.com");
    }


    @Then("verify login required screen is displayed")
    public void verifyLoginRequiredScreenIsDisplayed() {
        nucomplyloginpage.loginrequiredscreenisdisplayed();
    }

    @Then("verify reset password screen is displayed")
    public void verifyResetPasswordScreenIsDisplayed() {
        ;
        nucomplyloginpage.forgotpassword();
    }

    @Then("verify email id is entered successfully")
    public void verifyEmailIdIsEnteredSuccessfully() {
        nucomplyloginpage.enteredemailissuccessfuly();
    }

    @When("User click on send button")
    public void userClickOnSendButton() {
        nucomplyloginpage.clickonsendemail();
    }


    @Then("verify user is logged out successfully")
    public void verifyUserIsLoggedOutSuccessfully() {
        nucomplyloginpage.verifylogoutpopup();

    }

    @Then("verify password reset mail is sent to registered email id")
    public void verifyPasswordResetMailIsSentToRegisteredEmailId() {
        nucomplyloginpage.verifysentemailmessage();
    }


    @When("user clicks on menu icon")
    public void userClicksOnMenuIcon() {
        nucomplyloginpage.clickonmenuicon();
    }

    @Then("verify login required screen is dispalyed after logout")
    public void verifyLoginRequiredScreenIsDispalyedAfterLogout() {
       nucomplyloginpage.loginrequirescreen_isdisplayed();
    }
}

