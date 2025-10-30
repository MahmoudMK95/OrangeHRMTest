package APIRequest;

import Utilities.DataUtil;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.IOException;

public class deleteCandidate {

    public static Response deleteRequest(String orangeHrmCookieValue,String id) throws IOException {

        String URL ="https://opensource-demo.orangehrmlive.com/web/index.php/api/v2/recruitment/candidates";
        String body= DataUtil.getJsonFile("deleteCandidateBody");
        body = body.replace("{{id}}", id);

        Response response = RestAssured.given()
                .header("Cookie", "orangehrm=" + orangeHrmCookieValue)
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .delete(URL);

        System.out.println(response.getBody().asString());
        return response;
    }


}
