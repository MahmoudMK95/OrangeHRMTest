package Pages;

import Utilities.Utility;
import org.openqa.selenium.*;

public class P02DashboardPage {

    private final WebDriver driver;

    public P02DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By adminPage = By.xpath("//span[text()='Admin']");



    public P03AdminPage navigateToAdminPage()  {
        Utility.clickOnElement(driver, adminPage);
        return new P03AdminPage(driver);
    }

}
