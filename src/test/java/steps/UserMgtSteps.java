package steps;

import core.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.NucomplyDocumentMGTPage;
import pages.NucomplyUserMangementPage;

import java.util.List;
import java.util.Map;

public class UserMgtSteps extends TestContext {


    public UserMgtSteps() {
        nucomplyUserMangementPage = new NucomplyUserMangementPage();
    }

    @When("user clicks on profile icon")
    public void userClicksOnProfileIcon() {
        nucomplyUserMangementPage.clickprofileicon();
    }

    @When("user clicks on user management")
    public void userClicksOnUserManagement() {
        nucomplyUserMangementPage.clickOnUserMangement();
    }

    @When("user clicks on update button")
    public void userClicksOnUpdateButton() {
        nucomplyUserMangementPage.userclickonupdateuserbutton();
    }

    @When("user clicks on confirm button")
    public void userClicksOnConfirmButton() {
        nucomplyUserMangementPage.userclickonconfirmupdatebutton();
    }


    @When("user search by following email or name details")
    public void userSearchByFollowingEmailOrNameDetails(DataTable dataTable) {
        List<Map<String, String>> credentials = dataTable.asMaps(String.class, String.class);
        // Loop through all rows (even if you have only 1)
        for (Map<String, String> row : credentials) {
            String username = row.get("name");
            nucomplyUserMangementPage.entername(username);


        }
    }


    @Then("verify the search user is exit or not")
    public void verifyTheSearchUserIsExitOrNot() {

        nucomplyUserMangementPage.verifysearchuserexit();
    }


    @When("user cilicks on three dots of searched user")
    public void userCilicksOnThreeDotsOfSearchedUser() {
        page.waitForTimeout(5000);
        nucomplyUserMangementPage.userclickonthreedots();
    }

    @When("user clicks on edit profile")
    public void userClicksOnEditProfile() {
        nucomplyUserMangementPage.userclickoneditprofileoption();
    }

    @When("user update following details")
    public void userUpdateFollowingDetails(DataTable dataTable) {
        List<Map<String, String>> credentials = dataTable.asMaps(String.class, String.class);

        // Loop through all rows (even if you have only 1)
        for (Map<String, String> row : credentials) {
            String updatename = row.get("Name");
            String updaterole = row.get("Role");
            nucomplyUserMangementPage.enterupdatedname(updatename);
            nucomplyUserMangementPage.enterupdatedrole(updaterole);
            System.out.println("searched email:" + updatename);
            System.out.println("searched email:" + updaterole);
        }
    }

    @Then("verify user profile is updated successfully message is displayed")
    public void verifyUserProfileIsUpdatedSuccessfullyMessageIsDisplayed() {

    }

    @When("user clicks on deactivate user")

    @When("user clicks on deactivate button")
    public void userClicksOnDeactivateButton() {
        nucomplyUserMangementPage.userclickondeactivatebutton();
    }

    @When("user clicks on reactivate Account buttonuser")
    public void userClicksOnReactivateAccountButtonuser() {
        nucomplyUserMangementPage.userclickonreactivateaccount();
    }

    @When("user clicks on reactivate button")
    public void userClicksOnReactivateButton() {
        nucomplyUserMangementPage.userclickonreactivatebutton();
    }

    @When("user click on confirm button")
    public void userClickOnConfirmButton() {
        nucomplyUserMangementPage.userclickonconfirmbutton();
    }

    @Then("user mangement page is displayed")
    public void userMangementPageIsDisplayed() {
        nucomplyUserMangementPage.usermangementscreendisplayed();
    }


    @When("user update the role to a different role than the existing one")
    public void userUpdateTheRoleToADifferentRoleThanTheExistingOne() {
        nucomplyUserMangementPage.updateUserDetailsAndRestore();
    }

    @Then("verify user is activated successfully message is displayed")
    public void verifyUserIsActivatedSuccessfullyMessageIsDisplayed() {
        nucomplyUserMangementPage.verfiyuserprofileupdatedmessage();
    }

    @And("User clicks on Manage users")
    public void userClicksOnManageUsers() {
        nucomplyUserMangementPage.clickOnUserMangement();
    }

    @Then("verify edit profile and deactivate user options are displayed")
    public void verifyEditProfileAndDeactivateUserOptionsAreDisplayed() {
        nucomplyUserMangementPage.edit_deactivate_user_option();
    }

    @Then("verify that edit user name ,email and role fields are displayed")
    public void verifyThatEditUserNameEmailAndRoleFieldsAreDisplayed() {
        nucomplyUserMangementPage.verifyuserdetailsdisplayed();

    }

    @Then("updated role is displayed in role dropdown")
    public void updatedRoleIsDisplayedInRoleDropdown() {
        nucomplyUserMangementPage.userupdatedroledisplayed();
    }

    @When("user perform click on deactivate account button")
    public void userPerformClickOnDeactivateAccountButton() {
        nucomplyUserMangementPage.clickondeactivateaccbutton();
    }

    @Then("verify deactivate confirmation popup is displayed")
    public void verifyDeactivateConfirmationPopupIsDisplayed() {
        nucomplyUserMangementPage.verifydeactivateaccountpopup();
    }


    @When("user clicks on confirm button of deactivate popup")
    public void userClicksOnConfirmButtonOfDeactivatePopup() {
        nucomplyUserMangementPage.clickonconfirmdeactivatebutton();
    }


    @Then("verify user account status")
    public void verifyUserAccountStatus() {
        nucomplyUserMangementPage.verifyuserisdeactivate();
    }

    @Then("verify reactivate user option is displayed")
    public void verifyReactivateUserOptionIsDisplayed() {
        nucomplyUserMangementPage.verifyreactivateoptionisdisplayed();
    }


    @When("user clicks on invite user button")
    public void userClicksOnInviteUserButton() {
        nucomplyUserMangementPage.inviteuser();
    }

    @Then("verify invite user popup is displayed")
    public void verifyInviteUserPopupIsDisplayed() {
        nucomplyUserMangementPage.verifyinviteuserpopup();
    }

    @When("user enter following details to invite new user")
    public void userEnterFollowingDetailsToInviteNewUser() {
        nucomplyUserMangementPage.enterrandomdetails();
    }

    @Then("verify reactivate confirmation popup is displayed")

    @Then("verify user is reactivated successfully message is displayed")
    public void verifyUserIsReactivatedSuccessfullyMessageIsDisplayed() {
        nucomplyUserMangementPage.verifysuccessmess();
    }

    @When("user clicks on send invite button")
    public void userClicksOnSendInviteButton() {
        nucomplyUserMangementPage.sendinvitebutton();
    }

    @Then("verify invite sent successfully message is displayed")
    public void verifyInviteSentSuccessfullyMessageIsDisplayed() {
        nucomplyUserMangementPage.verifyuserisinvitedsuccessfully();
    }

    @When("user searches for {string}")
    public void userSearchesFor(String arg0) {
        nucomplyUserMangementPage.userserachvaluenameorEmail(arg0);
    }

    /*@Then("verify the searched user exists or not")
    public void verifyTheSearchedUserExistsOrNot() {
        nucomplyUserMangementPage.searchvalueexitornot();
    }*/

    @When("user searches {string}")
    public void userSearches(String arg0) {
        nucomplyUserMangementPage.searchvalue(arg0);
    }


    @Then("verify search result {string} using {string}")
    public void verifySearchResultUsing(String arg0, String arg1) {
        nucomplyUserMangementPage.searchValueExistOrNot(arg0, arg1);
    }
}
