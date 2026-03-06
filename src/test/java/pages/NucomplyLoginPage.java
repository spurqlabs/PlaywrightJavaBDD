package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.LocatorAssertions;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;
import core.TestContext;
import org.testng.Assert;
import utilities.ConfigUtil;

import java.io.IOException;
import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.Assert.assertTrue;

public class NucomplyLoginPage extends TestContext {
    private final String Inloginbuttons = "//button[text()='Login']";
    private final String usernameField = "//input[@placeholder=\"yours@example.com\"]";
    private final String passwordField = "//input[@placeholder=\"your password\"]";
    private final String loginButton = "//span[@class=\"auth0-label-submit\"]";
    private final String loginpopup = "//div[text()='You have been successfully logged in.']";
    private final String logininputfiled = "//input[@placeholder=\"yours@example.com\"]";

    public void userONLoginPage() throws IOException {
        page.navigate(ConfigUtil.getPropertyValue("Nucomply_Base"));
    }

    public void userClickOnLogInButton() {
        page.locator(Inloginbuttons).click();
    }

    public void enteremail(String email) {
        page.locator(usernameField).fill(email);
    }

    public void enterpass(String password) {
        page.locator(passwordField).fill(password);
    }

    public void clicksONLogin() {
        page.locator(loginButton).click();

    }

    public void enterUsernamePass(String email, String password) {
        enteremail(email);
        enterpass(password);

    }

    public boolean isLoginSuccessPopupDisplayed() {
        page.waitForSelector(loginpopup);
        return page.isVisible(loginpopup);

    }

    public void userclickonuserprofileicon() {
        Locator userProfileIcon = page.locator("(//button[@class=\"chakra-menu__menu-button css-13bv4i2\"])[1]");
        assertThat(userProfileIcon).isVisible();
        userProfileIcon.click();
    }

    public void clickonlogout() {
        page.locator("//button[@data-index=\"4\"]").click();
    }

    public void isloginpagedisplayed() {
        Assert.assertTrue(page.locator("//button[text()='Login']").isVisible());
        System.out.println("login page open successfully");
    }

    public void redirectedtoLoginpage() {
        page.locator(logininputfiled).waitFor(
                new Locator.WaitForOptions().setTimeout(50000)
        );
        Assert.assertTrue(page.locator(logininputfiled).isVisible());
        Assert.assertTrue(page.locator(passwordField).isVisible());
        Assert.assertTrue(page.locator(loginButton).isVisible());
        System.out.println("user is redirected to login page successfully");
    }

    public void loginsuccesspopupisdisplayed() {
        Locator successpopup = page.locator(loginpopup);
        successpopup.waitFor(
                new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(30000)
        );
        System.out.println("login success popup is displayed successfully");
        assertThat(page).hasURL(Pattern.compile("/compliance/chat"));
    }

    public void homepageisvisvisible() {
        assertThat(page).hasURL(Pattern.compile("/compliance/chat"));
        System.out.println("homepage is visible");

    }

    public void verifylogoutpopupisdisplayed() {
        page.waitForSelector(
                "text=Logout successful",
                new Page.WaitForSelectorOptions()
                        .setState(WaitForSelectorState.ATTACHED)
                        .setTimeout(5000)
        );

    }

    public void clickonforgotpasswordlink() {
        Locator fogotpasswordlink = page.locator("//a[@class=\"auth0-lock-alternative-link\"]");
        assertThat(fogotpasswordlink).isVisible();
        fogotpasswordlink.click();
    }

    public void enterregisteredemailid(String email) {
        page.locator("//input[@type=\"email\"]").fill(email);

    }

    public void loginrequiredscreenisdisplayed() {
        assertTrue(page.locator("//div[text()='Login Required']").isVisible());
        assertTrue(page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).isVisible());
    }

    public void forgotpassword() {
        page.waitForTimeout(5000);
        assertTrue(page.locator(logininputfiled).isVisible());
        assertTrue(page.locator("//span[text()='Send email']").isVisible());
    }

    public void enteredemailissuccessfuly() {
        String emailid = page.locator("//input[@type=\"email\"]").inputValue();
        System.out.println("entered email id is:" + emailid);
        Assert.assertEquals(emailid, "trupti.natu@nuarca.com");
    }

    public void verifylogoutpopup() {
        Locator logoutPopup = page.locator("[role='alert']");
        logoutPopup.waitFor(new Locator.WaitForOptions()
                .setState(WaitForSelectorState.VISIBLE)
                .setTimeout(5000));
        String text = logoutPopup.textContent().trim();
        System.out.println("Logout popup text: " + text);
    }

    public void clickonmenuicon() {
        Locator menuicon = page.locator("(//div[@class=\"css-qetmem\"]//*[name()='svg'])[1]");
        menuicon.click();
    }

    public void loginrequirescreen_isdisplayed() {
        page.waitForLoadState(LoadState.NETWORKIDLE);

        Locator loginRequired = page.locator("//div[text()='Login Required']");

        loginRequired.waitFor();

        Assert.assertTrue(loginRequired.isVisible(),
                "'Login Required' message is NOT visible");

    }

    public void clickonsendemail() {
        page.locator("//span[text()='Send email']").click();
    }

    public void verifysentemailmessage() {
        Locator message = page.locator("//span[text()=\"We've just sent you an email to reset your password.\"]");
        message.waitFor(new Locator.WaitForOptions()
                .setState(WaitForSelectorState.VISIBLE)
                .setTimeout(5000));

        Assert.assertTrue(message.isVisible(),
                "Reset password email message should be visible");
    }


}
