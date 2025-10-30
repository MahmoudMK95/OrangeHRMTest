package TestAPI;

import Pages.P01LoginPage;
import Utilities.DataUtil;
import io.restassured.response.Response;
import org.openqa.selenium.Cookie;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.time.Duration;

import static DriverFactory.DriverFactory.*;

public class createAndDeleteCandidateTest {

    P01LoginPage login;
    String userName= "Admin";
    String password= "admin123";


    Response postResponse;
    Response deleteResponse;


    String id;

    @BeforeMethod
    public void setup() throws IOException {
        String Browser = DataUtil.getPropertyValue("Config", "Browser");
        setupDriver(Browser);
        String BASE_URL = DataUtil.getPropertyValue("Config", "BASE_URL");
        getDriver().get(BASE_URL);
        getDriver().manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));

        login = new P01LoginPage(getDriver());

    }


    @Test
    public void createAndDeleteCandidateTC()throws IOException, InterruptedException{

        SoftAssert softAssert = new SoftAssert();

        login
                .enterUserName(userName)
                .enterPassword(password)
                .clickOnLoginButton();


        Cookie orangeHrmCookie = getDriver().manage().getCookieNamed("orangehrm");

        String orangeHrmCookieValue = orangeHrmCookie.getValue();

        postResponse= APIRequest.createCandidate.postRequest(orangeHrmCookieValue);

        System.out.println("The status of Post Response is: " +postResponse.getStatusCode());
        System.out.println("The ID of Post Response is: " +postResponse.jsonPath().getString("data.id"));

        id=postResponse.jsonPath().getString("data.id");

        softAssert.assertEquals(postResponse.getStatusCode(), 200, "Expected status for create Candidate code 200");

        deleteResponse= APIRequest.deleteCandidate.deleteRequest(orangeHrmCookieValue,id);

        System.out.println("The status of delete Response is: " +deleteResponse.getStatusCode());

        softAssert.assertEquals(deleteResponse.getStatusCode(), 200, "Expected status for delete Candidate code 200");


        softAssert.assertAll();

    }


    @AfterMethod
    public void quit() {
        quitDriver();

    }
}
