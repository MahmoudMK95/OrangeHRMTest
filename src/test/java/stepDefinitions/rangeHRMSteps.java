package stepDefinitions;

import Pages.P01LoginPage;
import Pages.P02DashboardPage;
import Pages.P03AdminPage;
import Pages.P04AddUserPage;
import Utilities.DataUtil;
import io.cucumber.java.en.*;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.time.Duration;

import static DriverFactory.DriverFactory.*;

import static org.testng.Assert.*;


public class rangeHRMSteps {
    P01LoginPage login;
    P02DashboardPage dashboard;
    P03AdminPage admin;
    P04AddUserPage addUser;
    int beforeCount;
    int afterCount;
    String employeeName ="Ranga  Akunuri";
    String newUsername = "Ranga  Akunuri" + System.currentTimeMillis()/1000;;
    String password = "admin123";
    SoftAssert softAssert = new SoftAssert();

 @Given("user navigates to OrangeHRM login page")
    public void openOrangeHRM() throws IOException {
        String Browser = DataUtil.getPropertyValue("Config", "Browser");
        setupDriver(Browser);
        String BASE_URL = DataUtil.getPropertyValue("Config", "BASE_URL");
        getDriver().get(BASE_URL);
        getDriver().manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));

     login = new P01LoginPage(getDriver());
     dashboard = new P02DashboardPage(getDriver());
     admin= new P03AdminPage(getDriver());
     addUser= new P04AddUserPage(getDriver());
    }

    @When("user logs in with username {string} and password {string}")
    public void loginOrangeHRM(String uname, String pwd) {
        login
                .enterUserName(uname)
                .enterPassword(pwd)
                .clickOnLoginButton();

    }

    @When("user clicks on Admin tab")
    public void clickAdminTab() {
        dashboard
                .navigateToAdminPage();
 }

    @Then("system gets the current number of records")
    public void getRecordCount() {
        beforeCount = admin.getTheCountOFUsers();
    }

    @When("user adds a new user")
    public void addUser() throws InterruptedException{
        admin.
                clickOnAddButton()
                .selectUserRole()
                .selectStatus()
                .enterEmployeeName(employeeName)
                .enterUserName(newUsername)
                .enterPasswordAndConfirmationPassword(password)
                .clickOnSaveButton();
        Thread.sleep(3000);
    }

    @Then("system verifies number of records increased by 1")
    public void verifyRecordIncreased() throws InterruptedException {
        afterCount = admin.getTheCountOFUsers();
        softAssert.assertEquals(afterCount, beforeCount + 1);
    }

    @When("user searches for the new username")
    public void searchNewUser() {
        admin.
                searchByUserName(newUsername)
                .clickOnSearchButton();
    }

    @When("deletes the user")
    public void deleteUser() throws InterruptedException {
       admin
               .clickOnDeleteButton()
               .clickOnYesDeleteButton()
               .clickOnResetButton();
    }

    @Then("system verifies number of records decreased by 1")
    public void verifyRecordDecreased() {
        int current = admin.getTheCountOFUsers();
        softAssert.assertEquals(current, beforeCount);
        quitDriver();
        softAssert.assertAll();
    }
}
