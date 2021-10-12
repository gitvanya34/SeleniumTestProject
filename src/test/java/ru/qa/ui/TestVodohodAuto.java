package ru.qa.ui;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.qa.ui.ApiQase.BodyRequest;
import ru.qa.ui.pageobject.BasePage;

import static io.restassured.RestAssured.given;

public class TestVodohodAuto extends BaseTest {

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify user registration correct value.")
    public void filtrerVodohod() throws InterruptedException {

       try {
            mainPageCruise.fillform();
            cruiseSearch.fillform();
            cruiseInfo.fillform();
            mainBookingCruise.fillform();
            endingReservedCruise.fillform();
            personalAccount.fillform();
        }
       catch (Exception e){
            StepFailed();
            bodyRequest.setComment(e.getMessage());
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
       }
        bodyRequest.setStatus("passed");
    }
}
