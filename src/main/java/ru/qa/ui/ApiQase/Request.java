package ru.qa.ui.ApiQase;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import ru.qa.ui.pageobject.BasePage;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class Request {

//         bodyRequest.setCase_id("1");
//    //   bodyRequest.setTime("1");
//        bodyRequest.setStatus(statusCase);
//        bodyRequest.setMember_id("1");
//    //  bodyRequest.setComment("1");
//        bodyRequest.setDefect("1");
    private int id;
    private String token="b138a53128bfdebc7c26e8b8d7a5fb725393afc4" ;
    private String numberTestRun="1" ;
    private ArrayList<Integer> cases;

    //private BodyRequest bodyrequest;


    public Request() {
    }

    public void GetSpecificTestRun(String numberTestRun)
    {
        RestAssured.baseURI = "https://api.qase.io/v1";

     //   String  token="9b65178558cb9e2f05a29513e241682933d26892";
//        bodyRequest=new BodyRequest(/*"1","100",statusCase,"1","Failed via API","true"*/);
//        ObjectMapper mapper = new ObjectMapper();
//        given()
//                .header("Content-Type", "application/json")
//                .header("Token",token)
//                .multiPart(,,)
//                .log().all()
//                .when()
//                .request("GET", "run/VDHT/"+numberTestRun)
//                .then()
//                .log().all()
//                .statusCode(200);
        
    }


    public void AddResultTestRun(String numberTestRun, BodyRequest bodyrequest)
    {
        RestAssured.baseURI = "https://api.qase.io/v1";

//        bodyRequest=new BodyRequest(/*"1","100",statusCase,"1","Failed via API","true"*/);
//        ObjectMapper mapper = new ObjectMapper();
        given()
                .header("Content-Type", "application/json")
                .header("Token",this.token)
                .body( bodyrequest)
                .log().all()
                .when()
                .request("POST", "result/VDHT/"+numberTestRun)
                .then()
                .log().all()
                .statusCode(200);
    }


}
