package ru.qa.ui;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestApiVodohod  {
    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify user registration correct value.")
    public void ApiVodohod() {

    }

    @Test
    public void AllProject() {
        RestAssured.baseURI = "https://api.qase.io/v1";
       // RestAssured.port = 443;
        String  token="9b65178558cb9e2f05a29513e241682933d26892";

        given()
                .header("Content-Type", "application/json")
                .header("Token","3b9262b30a6e0d133bc2faf6562798a60e32c433")
                .log().all()
                .when()
                .request("GET", "/project")
                .then()
                .log().all()
                .statusCode(200);

    }

//    @Test
//    public void RefreshRun() {
//        RestAssured.baseURI = "https://api.qase.io/v1";
//       // RestAssured.port = 443;
//        String  token="9b65178558cb9e2f05a29513e241682933d26892";
//
//        given()
//                .header("Content-Type", "application/json")
//                .header("Token","3b9262b30a6e0d133bc2faf6562798a60e32c433")
//                .body(" {\n" +
//                        "   \n" +
//                        "    \"case_id\": 1,\n" +
//                        "    \"time\": 100,\n" +
//                        "    \"status\": \"passed\",\n" +
//                        "    \"member_id\": 1,\n" +
//                        "    \"comment\": \"Failed via API\",\n" +
//                        "    \"defect\": true,\n" +
//                        "    \"steps\": [\n" +
//                        "      {\n" +
//                        "        \"position\": 1,\n" +
//                        "        \"status\": \"passed\"\n" +
//                        "      }\n" +
//                        "    ]\n" +
//                        "}")
//                .log().all()
//                .when()
//                .request("POST", "result/VDHT/1")
//
//                .then()
//                .log().all()
//                .statusCode(200);
//    }


}
