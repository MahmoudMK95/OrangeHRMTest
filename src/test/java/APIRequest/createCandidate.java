package APIRequest;

import Utilities.DataUtil;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.IOException;

public class createCandidate {

    public static Response postRequest(String orangeHrmCookieValue) throws IOException {

        String URL ="https://opensource-demo.orangehrmlive.com/web/index.php/api/v2/recruitment/candidates";
        String body= DataUtil.getJsonFile("createCandidateBody");


        Response response = RestAssured.given()
                .header("Cookie", "orangehrm=" + orangeHrmCookieValue)
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post(URL);

        System.out.println(response.getBody().asString());
        return response;
    }


}
