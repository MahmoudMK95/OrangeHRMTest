package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P03AdminPage {

    private final WebDriver driver;

    public P03AdminPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By addButton= By.xpath("(//button[contains(@class,'oxd-button--secondary')])[2]");

    private final By userNameForSearch = By.xpath("(//input[contains(@class,'oxd-input oxd-input--active')])[2]");
    private final By searchButton= By.xpath("(//button[contains(@class,'oxd-button--secondary')])[1]");
    private final By resetButton = By.xpath("//button[contains(@class,'oxd-button--ghost')]");

    private final By countOfUsers = By.xpath("(//span[contains(@class,'oxd-text oxd-text--span')])[13]");

    private final By deleteButton = By.xpath("(//button[contains(@class,'oxd-icon-button oxd-table-cell-action-space')])[1]");
    private final By YesDeleteButton = By.xpath("//button[contains(@class,'oxd-button--label-danger')]");



    public P03AdminPage searchByUserName(String usernameText)  {

        Utility.sendData(driver, userNameForSearch, usernameText);
        return this;
    }

    public P03AdminPage clickOnSearchButton()  {
        Utility.clickOnElement(driver, searchButton);
        return this;
    }

    public P03AdminPage clickOnResetButton()  {
        Utility.clickOnElement(driver, resetButton);
        return this;
    }

    public P03AdminPage clickOnDeleteButton()  {
        Utility.clickOnElement(driver, deleteButton);
        return this;
    }

    public P03AdminPage clickOnYesDeleteButton()  {
        Utility.clickOnElement(driver, YesDeleteButton);
        return this;
    }

    public Integer getTheCountOFUsers()  {
        String text=Utility.getText(driver, countOfUsers).replaceAll("[^0-9]", "");
        return Integer.parseInt(text);
    }



    public P04AddUserPage clickOnAddButton()  {
        Utility.clickOnElement(driver, addButton);
        return new P04AddUserPage(driver);
    }

}
