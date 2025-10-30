package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P01LoginPage {

    private final WebDriver driver;


    private final By userName = By.name("username");
    private final By Password = By.name("password");
    private final By loginButton = By.xpath("//button[contains(@class,'orangehrm-login-button')]");


    public P01LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    public P01LoginPage enterUserName(String usernameText)  {

        Utility.sendData(driver, userName, usernameText);
        return this;
    }

    public P01LoginPage enterPassword(String passwordText)  {

        Utility.sendData(driver, Password, passwordText);
        return this;
    }


    public P02DashboardPage clickOnLoginButton()  {
        Utility.clickOnElement(driver, loginButton);
        return new P02DashboardPage(driver);
    }


}
