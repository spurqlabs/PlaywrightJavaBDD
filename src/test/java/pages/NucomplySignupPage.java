package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.LoadState;
import core.TestContext;
import org.testng.Assert;

import static org.testng.Assert.assertTrue;

public class NucomplySignupPage extends TestContext {

    private final String signuplinkbutton = "//a[text()='Sign Up']";
    private final String usernameField = "//input[@placeholder=\"yours@example.com\"]";
    private final String passwordField = "//input[@placeholder=\"your password\"]";
    private final String name = "//input[@placeholder='Name']";
    private final String orgname = "//input[@placeholder='Organization']";
    private final String title = "//input[@placeholder='Title']";
    private final String signupbutton = "//button/span[text()='Sign Up']";

    public void clickOnSigupLink() {
        page.locator(signuplinkbutton).click();
        page.waitForTimeout(5000);
    }

    public void enterusername(String username) {

        page.locator(usernameField).fill(username);
    }

    public void enterpassword(String password) {
        page.locator(passwordField).fill(password);
    }

    public void name(String Name) {
        page.locator(name).fill(Name);
    }

    public void phonenum(int Number) {
        page.locator(name).fill(String.valueOf(Number));
    }

    public void enterOrgnizationname(String Orgname) {
        page.locator(orgname).fill(Orgname);
    }

    public void enterTitle(String Title) {
        page.locator(title).fill(Title);
    }

    public void enterPhoneNumber(String PhoneNumber) {
        page.locator("//input[@placeholder='Phone Number']").fill(PhoneNumber);
    }


    public void signUpButton() {
        page.locator(signupbutton).click();
        page.waitForTimeout(10000);
    }

    public void emailsentverification() {
        page.waitForLoadState(LoadState.NETWORKIDLE);
        Locator emailvericationsent = page.locator("//div[text()='We have sent a verification link to:']");
        Assert.assertTrue(emailvericationsent.isVisible(), "Email verification message is not visible");
    }

    public void loginSignupTabVisible() {
        Locator logintab = page.locator("//span[text()='Log In']/parent::li");
        logintab.waitFor();
        boolean isLoginVisible = page.locator("//span[text()='Log In']/parent::li").isVisible();
        boolean isSignUpVisible = page.locator("//a[text()='Sign Up']").isVisible();

        assertTrue(isLoginVisible, "Login link is not visible");
        assertTrue(isSignUpVisible, "Sign Up link is not visible");
    }

    public void verifySignUpPageElements() {

        assertTrue(page.locator("//button[contains(text(),'Google')]").isVisible());
        assertTrue(page.locator("//input[@type='email']").isVisible());
        assertTrue(page.locator("//input[@type='password']").isVisible());
        assertTrue(page.locator("//input[@placeholder='Name']").isVisible());
        assertTrue(page.locator("//input[@placeholder='Phone Number']").isVisible());
        assertTrue(page.locator("//input[@placeholder='Organization']").isVisible());
        assertTrue(page.locator("//input[@placeholder='Title']").isVisible());
        assertTrue(page.locator("//button[text()='SIGN UP']").isVisible());

    }


}
