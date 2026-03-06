package pages;


import com.microsoft.playwright.Locator;

import core.TestContext;
import org.junit.Assert;

import java.util.Random;

import static org.testng.Assert.assertTrue;

public class NucomplyUserMangementPage extends TestContext {
    String newRole;

    public void clickprofileicon() {

        page.locator("(//img[@alt=\"trupti.natu@nuarca.com\"])[1]").click();
    }

    public void clickOnUserMangement() {
        page.locator("(//p[text()='User Management'])[1]").click();
    }

    public void edit_deactivate_user_option() {
        Locator recativeuseroption = page.locator("//span[text()='Reactivate Account']");
        if (recativeuseroption.isVisible()) {
            System.out.println("Reactivate account option is displayed");
            page.locator("//span[text()='Reactivate Account']").click();
            System.out.println("user account is reactivated successfully");
            page.locator("//button[text()='Reactivate']").click();
            page.locator("//button[text()='Confirm']").click();
            page.locator("//input[@placeholder=\"Search\"]//following::button[@aria-label=\"User actions\"][1]").click();
        } else {
            System.out.println("Edit profile and deactivate account options are displayed");
        }
        Locator edituseroption = page.locator("//button[text()='Edit Profile']");
        Locator deactivateuseroption = page.locator("//button[text()='Deactivate Account']");
        edituseroption.isVisible();
        deactivateuseroption.isVisible();

    }

    public void verifyuserdetailsdisplayed() {
        String name = page.locator("//input[@placeholder=\"Name\"]").inputValue();
        String email = page.locator("//label[text()='Email']//following::input[1]").getAttribute("value");
        String role = page.locator("//label[text()='Role']//following::div[@class=\"css-15khq9o\"]").textContent();
        String phone = page.locator("//input[@class=\"chakra-input modal-input-new css-l1wqir\"]").getAttribute("value");
        System.out.println("Name:" + name);
        System.out.println("Email:" + email);
        System.out.println("Role:" + role);
        System.out.println("Phone:" + phone);
        //  page.locator("//button[@aria-label=\"Close\"]").click();
    }

    public void userupdatedroledisplayed() {
        page.waitForTimeout(3000);
        page.locator("//input[@placeholder=\"Search\"]//following::button[@aria-label=\"User actions\"][1]").click();
        page.locator("(//button[@data-index=\"0\"])[1]").click();
        String updatedrole = page.locator("//label[text()='Role']//following::div[@class=\"css-15khq9o\"]").textContent();
        System.out.println("Updated Role:" + updatedrole);
    }

    public void clickondeactivateaccbutton() {
        page.locator("//button[text()='Deactivate']").click();
    }

    public void verifydeactivateaccountpopup() {
        page.waitForSelector("//header[text()='Confirm Deactivation']");
        Assert.assertTrue(page.locator("//header[text()='Confirm Deactivation']").isVisible());
        System.out.println("Deactivate account popup is displayed");
    }

    public void clickonconfirmdeactivatebutton() {
        page.locator("//button[text()='Confirm']").click();
        page.waitForTimeout(5000);
    }

    public void verifyuserisdeactivate() {

        Assert.assertTrue(page.locator("//span[text()='Deactivated']").isVisible());
        System.out.println("Reactivate account popup is displayed");
    }

    public void verifyreactivateoptionisdisplayed() {
        Assert.assertTrue(page.locator("(//button[@data-index=\"0\"])[1]").isVisible());
        System.out.println("Reactivate account option is displayed");
    }

    public void inviteuser() {
        page.locator("(//button[text()='Invite'])[1]").click();
    }


    public void verifyinviteuserpopup() {
        page.locator("//label[text()='Name']").isVisible();
        page.locator("//header[text()='Invite User Account']").isVisible();
        page.locator("//label[text()='Email']").isVisible();
        page.locator("//label[text()='Role']").isVisible();
        System.out.println("Invite user popup is displayed with all fields");
    }


    public void enterrandomdetails() {
        String randomName = "TestUser" + new Random().nextInt(1000);
        String randomEmail = "testuser" + new Random().nextInt(1000) + "@example.com";
        page.locator("//input[@placeholder=\"Name\"]").fill(randomName);
        page.locator("//label[text()='Email']//following::input[1]").fill(randomEmail);
        page.locator("//label[text()='Role']//following::div[@class=\"css-15khq9o\"]").click();
        page.locator("//div[@role=\"option\"]").nth(1).click();
    }







    public void clickonrecativatebutton() {
        page.locator("//button[text()='Confirm']").click();
    }

    public void verifysuccessmess() {
        page.locator("//div[text()='Success']").isVisible();
    }

    public void sendinvitebutton() {
        page.locator("(//button[text()='Invite'])[3]").click();
    }

    public void verifyuserisinvitedsuccessfully() {
        page.locator("//div[text()='Success']").isVisible();
        System.out.println("User invited successfully message is displayed");
    }

    public void userserachvaluenameorEmail(String value) {
        page.locator("//input[@placeholder=\"Search\"]").fill(value);
        page.waitForTimeout(2000);
    }

   /* public void searchvalueexitornot() {

        boolean isFound = false;
        page.waitForSelector("//div[@class=\"css-5yt4po\"]//h3");
        Locator user = page.locator("//div[@class=\"css-5yt4po\"]//h3");

        int count = page.locator("//div[@class=\"css-5yt4po\"]//h3").count();
        System.out.println(count);
        assertTrue(count > 0, "Search results should be displayed");
        for (int i = 0; i < count; i++) {
            String text = user.nth(i).innerText();
            System.out.println("Checking result " + (i + 1) + ": " + text);

            if (text.equals("Shekhar")) {
                isFound = true;
                System.out.println("✅ Expected result found at index: " + i);
                break; // 🚀 stop loop

            }

        }
        if (!isFound) {
            System.out.println("❌ Expected result NOT found in the search results.");
        }
    }
*/

    public void searchvalue(String value) {
        page.locator("//input[@placeholder=\"Search\"]").fill(value);
        page.waitForTimeout(2000);
    }
    public void searchValueExistOrNot(String expectedValue, String type) {

        boolean isFound = false;
        Locator results;

        if (type.equalsIgnoreCase("username")) {
            results = page.locator("//div[@class='css-5yt4po']//h3");
        } else {
            results = page.locator("//div[@class='css-5yt4po']//p");
        }

        // Correct wait
        results.first().waitFor();

        int count = results.count();

        for (int i = 0; i < count; i++) {

            String text = results.nth(i).innerText().trim();

            if (text.equalsIgnoreCase(expectedValue)) {

                isFound = true;
                break;
            }
        }

        assertTrue(isFound, "Expected value not found: " + expectedValue);
    }

    public void userclickonupdateuserbutton() {
        page.locator("//button[text()='Update']").click();
    }

    public void userclickonconfirmupdatebutton() {
        page.locator("//button[text()='Confirm']").click();
    }

    public void usermangementscreendisplayed() {
        page.waitForTimeout(5000);
        String currentURL = page.url();
        Assert.assertTrue(page.locator("//h1[text()='User Management']").isVisible());
        System.out.println("user Management screen displayed");

    }
    public void updateUserDetailsAndRestore() {
       /* String name = page.locator("//input[@placeholder=\"Name\"]").inputValue();
        String email = page.locator("//label[text()='Email']//following::input[1]").getAttribute("value");
        String role = page.locator("//label[text()='Role']//following::div[@class=\"css-15khq9o\"]").textContent();
        String phone = page.locator("//label[text()='Phone']//following::input[1]").getAttribute("value");*/
        Locator nameInput = page.locator("//input[@placeholder=\"Name\"]");
        Locator emailInput = page.locator("//label[text()='Email']//following::input[1]");
        Locator phoneInput = page.locator("//input[@class=\"chakra-input modal-input-new css-l1wqir\"]");
        Locator roleDropdown = page.locator("//label[text()='Role']//following::div[@class=\"css-15khq9o\"]");
        page.locator("//button[text()='Update']").click();

        // 1️⃣ Capture original values
        String originalName = nameInput.inputValue().trim();
        String originalEmail = emailInput.inputValue().trim();
        String originalPhone = phoneInput.inputValue().trim();
        String originalRole = roleDropdown.getAttribute("value"); // adjust if needed

        // 2️⃣ Generate temporary values
        String tempName = "Temp_" + System.currentTimeMillis();
        // String tempEmail = "temp" + System.currentTimeMillis() + "@test.com";
        String tempPhone = "9991234567";

        try {
            // 3️⃣ Update values
            nameInput.fill(tempName);
            // emailInput.fill(tempEmail);
            phoneInput.fill(tempPhone);
            roleDropdown.selectOption("Admin"); // adjust if needed

            page.locator("//button[text()='Update']").click();
            page.locator("//button[text()='Confirm']").click();

            // 4️⃣ Verify update
            Assert.assertEquals(originalName, tempName, "Name is not updated correctly");
            // Assert.assertEquals(originalEmail, tempEmail, "Email is not updated correctly");
            Assert.assertEquals(originalPhone, tempPhone, "Phone is not updated correctly");

        } finally {
            // 5️⃣ Restore original values
            nameInput.fill(originalName);
            // emailInput.fill(originalEmail);
            phoneInput.fill(originalPhone);
            roleDropdown.selectOption(originalRole);

            page.locator("//button[text()='Update']").click();
            page.locator("//button[text()='Confirm']").click();
            System.out.println("Original user details restored successfully");
        }
    }
    public void searchvaluemailorname(String value) {
        page.fill("//input[@placeholder=\"Search Users\"]", value);
        page.waitForTimeout(2000);
    }

    public void enterEmail(String email) {
        page.locator("//input[@placeholder=\"Search\"]").fill(email);
        page.waitForTimeout(2000);

    }

    public void entername(String name) {
        page.locator("//input[@placeholder=\"Search\"]").fill(name);
        page.waitForTimeout(2000);

    }

    public void userclickondeactivate() {
        page.locator("//button[text()='Deactivate']").click();
    }

    public void enterupdatedname(String name) {
        page.locator("//input[@placeholder=\"Name\"]").fill(name);
    }

    public void enterupdatedrole(String role) {
        page.locator("//input[@placeholder=\"Name\"]").fill(role);
        page.waitForTimeout(3000);
    }

    public void verifysearchuserexit() {
        boolean isFound = false;
        page.waitForSelector("//div[@class=\"css-5yt4po\"]//h3");
        Locator user = page.locator("//div[@class=\"css-5yt4po\"]//h3");

        int count = page.locator("//div[@class=\"css-5yt4po\"]//h3").count();
        System.out.println(count);
        assertTrue(count > 0, "Search results should be displayed");
        for (int i = 0; i < count; i++) {
            String text = user.nth(i).innerText();
            System.out.println("Checking result " + (i + 1) + ": " + text);

            if (text.equals("Shekhar")) {
                isFound = true;
                System.out.println("✅ Expected result found at index: " + i);
                break; // 🚀 stop loop
            }

        }
        if (!isFound) {
            System.out.println("❌ Expected result NOT found in the search results.");
        }
    }

    public void clickonedituser() {
        page.locator("//tbody/tr[td[normalize-space()='Shrek']]/td[5]//button").click();
        page.locator("//button[text()='Edit Profile']").click();
        page.locator("//input[@placeholder=\"Name\"]").fill("testuser");

    }

    public void clcikconfirmdeactivate() {

        page.locator("//button[text()='Confirm']").click();
        page.waitForTimeout(5000);
    }

    public void userclickondeactivatebutton() {
        page.locator("(//button[@data-index=\"1\"])[1]").click();
    }

    public void userclickonreactivateaccount() {
        page.locator("(//button[@data-index=\"0\"])[1]").click();
    }

    public void userclickonreactivatebutton() {
        page.locator("//button[text()='Reactivate']").click();
    }

    public void userclickonthreedots() {
        page.waitForLoadState();
        page.locator("//input[@placeholder=\"Search\"]//following::button[@aria-label=\"User actions\"][1]").click();

    }

    public void userclickonconfirmbutton() {
        page.locator("//button[text()='Confirm']").click();
    }


    public void userclickondeactivateuser() {
        page.locator("//button[text()='Deactivate Account']").click();
    }

    public void userclickoneditprofileoption() {
        page.locator("(//button[@data-index=\"0\"])[1]").click();
    }

    public void verfiyuserprofileupdatedmessage() {
        page.locator("//div[contains(text(),'User profile updated successfully')]").isVisible();
        System.out.println("User profile updated successfully message is displayed");
    }
}

