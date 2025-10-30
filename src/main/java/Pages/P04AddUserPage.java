package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P04AddUserPage {

    private final WebDriver driver;

    public P04AddUserPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By userRole= By.xpath("(//div[contains(@class,'oxd-select-text--active')])[1]");
    private final By firstUserRole= By.xpath("(//div[@class='oxd-select-option'])[2]");

    private final By status= By.xpath("(//div[contains(@class,'oxd-select-text--active')])[2]");
    private final By firstStatus= By.xpath("(//div[@class='oxd-select-option'])[2]");

    private final By employeeName= By.xpath("//input[@placeholder='Type for hints...']");
    private final By selectFirstEmployeeName= By.xpath("(//div[@class='oxd-autocomplete-option'])[1]");

    private final By userName= By.xpath("(//input[contains(@class,'oxd-input--active')])[2]");

    private final By password= By.xpath("(//input[contains(@class,'oxd-input--active')])[2]");

    private final By confirmPassword= By.xpath("(//input[contains(@class,'oxd-input--active')])[3]");

    private final By saveButton= By.xpath("//button[contains(@class,'oxd-button--secondary')]");


    public P04AddUserPage selectUserRole()  {
        Utility.clickOnElement(driver, userRole);
        Utility.clickOnElement(driver, firstUserRole);
        return this;
    }

    public P04AddUserPage selectStatus()  {
        Utility.clickOnElement(driver, status);
        Utility.clickOnElement(driver, firstStatus);
        return this;
    }

    public P04AddUserPage enterEmployeeName(String employeeNameText) throws InterruptedException {

        Utility.sendData(driver, employeeName, employeeNameText);
        Thread.sleep(3000);
        Utility.clickOnElement(driver, selectFirstEmployeeName);
        return this;
    }

    public P04AddUserPage enterUserName(String userNameText)  {

        Utility.sendData(driver, userName, userNameText);
        return this;
    }

    public P04AddUserPage enterPasswordAndConfirmationPassword(String passwordText)  {

        Utility.sendData(driver, password, passwordText);
        Utility.sendData(driver, confirmPassword, passwordText);

        return this;
    }

    public P03AdminPage clickOnSaveButton()  {
        Utility.clickOnElement(driver, saveButton);
        return new P03AdminPage(driver);
    }

}
