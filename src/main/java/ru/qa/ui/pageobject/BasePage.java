package ru.qa.ui.pageobject;

import io.qameta.allure.Allure;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.core.har.HarEntry;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import ru.qa.ui.ApiQase.Request;
import ru.qa.ui.ApiQase.StepRequest;
import ru.qa.ui.config.Config;
import ru.qa.ui.expectedconditions.PageLoaded;
import ru.qa.ui.ApiQase.BodyRequest;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

import static io.restassured.RestAssured.given;

@Component
@ContextConfiguration( classes = Config.class )
public class BasePage  extends AbstractTestNGSpringContextTests {

    private static final int BASE_TIMEOUT = 60;


    @Autowired
    protected  WebDriver webdriver;
    @Autowired
    protected Config config;

    protected static BodyRequest bodyRequest= new BodyRequest();
    protected static Request request = new Request();
   // protected static   Request request = new Request() ;
    // WebDriverWait longWait = (new WebDriverWait(webdriver, 30));


    public WebElement shortWaitElementToBeClickable(WebElement w) {
        WebDriverWait shortWait = (new WebDriverWait(webdriver, 30));
        return shortWait.until(ExpectedConditions.elementToBeClickable(w));
    }

    public WebElement shortWaitVisibilityOf(WebElement w) {
        WebDriverWait shortWait = (new WebDriverWait(webdriver, 30));
        return shortWait.until(ExpectedConditions.visibilityOf(w));
    }

    public void waitLoaderClosed() {
        WebDriverWait shortWait = (new WebDriverWait(webdriver, 30));
        shortWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='lds-css ng-scope loader']")));
    }

    public void waitForPageLoaded() {
        WebDriverWait wait = new WebDriverWait(webdriver, config.getBaseTimeout());
        wait.until(new PageLoaded());
    }

    public void waitForElementDisplayed(By by) {
        WebDriverWait wait = new WebDriverWait(webdriver, BASE_TIMEOUT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void switchTabLast() {
        ArrayList<String> tabs2 = new ArrayList<>(webdriver.getWindowHandles());
        webdriver.switchTo().window(tabs2.get(0));
        webdriver.close();
        webdriver.switchTo().window(tabs2.get(1));
    }

    public void openBrowser() {
        //  bodyRequest=new BodyRequest();
        webdriver.get(config.getBaseUrl());
        webdriver.manage().window().fullscreen();
    }

    public void closeBrowser() {
        screenshot();
        exportHar();
        webdriver.quit();
        config.proxyServer.abort();

        request.AddResultTestRun("1",bodyRequest );
    }


    public void exportHar() {
        //   ((JavascriptExecutor)webdriver).executeAsyncScript("window.callBackWhenNoQueuedMessages=arguments[arguments.length-1]");
        final Har httpMessages = config.proxyServer.getHar();
        //    System.out.println(config.proxyServer.getHar()) ;
        for (HarEntry httpMessage : httpMessages.getLog().getEntries()) {
            if (httpMessage.getRequest().getUrl().contains("/bxapi.vodohod.com/") || httpMessage.getRequest().getUrl().contains("/api-crs.vodohod.com/")) {
                if(httpMessage.getResponse().getError()!=null) {
                    String textLog = "";

                    //    System.out.println(httpMessage.getTime());
                    System.out.println(httpMessage.getStartedDateTime());
                    System.out.println("URL");
                    System.out.println(httpMessage.getRequest().getUrl());
                    System.out.println("Request:");
                    System.out.println(httpMessage.getRequest().getUrl());
                    System.out.println("Response:");
                    System.out.println(httpMessage.getResponse().getContent().getText());
                    System.out.println("Errors:");
                    System.out.println(httpMessage.getResponse().getError());

                    textLog += httpMessage.getRequest().getUrl() + "\n" +
                            httpMessage.getResponse().getContent().getText() + "\n" +
                            httpMessage.getResponse().getError() + "\n";
                    byte[] textLogByte = textLog.getBytes();

                    Allure.addAttachment("[" + httpMessage.getStartedDateTime() + "]" + " " + httpMessage.getRequest().getUrl(), textLog);
                    GetHashAddAttachmentLog("[" + httpMessage.getStartedDateTime() + "]" + " " + httpMessage.getRequest().getUrl(), new ByteArrayInputStream(textLogByte));
                }
            }
        }

    }

    public void screenshot() {
        Allure.addAttachment("JXRj.png", new ByteArrayInputStream(((TakesScreenshot) webdriver).getScreenshotAs(OutputType.BYTES)));
       // GetHashAddAttachment("image.png",new ByteArrayInputStream(((TakesScreenshot) webdriver).getScreenshotAs(OutputType.BYTES)));
    }



    public void StepPassed() {
        ArrayList<String> test =  new ArrayList<String>();

         test.add(GetHashAddAttachment("img.png")); //33bf1e031bc885223e0aacaca6bd664087ee7713
        //  AddStep( String.valueOf(counterStep), "passed", "" );

        //    AddStep( String.valueOf(counterStep), "passed", "");
        bodyRequest.AddStep( String.valueOf(bodyRequest.getCounterStep()), "passed", "",test);

        bodyRequest.setCounterStep(bodyRequest.getCounterStep()+1);
    }
    public void StepFailed() {
        ArrayList<String> test =  new ArrayList<String>();
        test.add(GetHashAddAttachment("img.png"));
     //   AddStep( String.valueOf(counterStep), "failed", "",GetHashAddAttachment("image.png"));
        bodyRequest.AddStep( String.valueOf(bodyRequest.getCounterStep()), "failed", "",test);
        bodyRequest.setCounterStep(bodyRequest.getCounterStep()+1);
    }
    public  String GetHashAddAttachment(String namefile)
    {
        //ByteArrayInputStream content=  new ByteArrayInputStream(((TakesScreenshot) webdriver).getScreenshotAs(OutputType.BYTES));
        RestAssured.baseURI = "https://api.qase.io/v1";
        ByteArrayInputStream content= new ByteArrayInputStream(((TakesScreenshot) webdriver).getScreenshotAs(OutputType.BYTES));
        JsonPath response =
                given()
                        //   .header("Content-Type", "application/json")
                        .header("Token","b138a53128bfdebc7c26e8b8d7a5fb725393afc4")
                        .multiPart("file1",namefile, content)

                        //  .multiPart("file",new byte[] { 1 })

                        .log().all()
                        .when()
                        .request("POST", "attachment/VDHT"/*+numberTestRun*/)
                        .then()
                        .log().all()
                        .statusCode(200)
                        .extract()
                        .jsonPath();
        String hash =response.getString("result.hash.");
        hash= hash.substring(1,hash.length() - 1);
        //  bodyRequest.getAttachments().add(hash);
        // BodyRequest.attachments.add(hash);
        System.out.println("хэш: "+hash);
        // bodyRequest.getAttachments().add(hash);
        return hash;
    }
    public void GetHashAddAttachment(String namefile,ByteArrayInputStream content)
    {

        //ByteArrayInputStream content=  new ByteArrayInputStream(((TakesScreenshot) webdriver).getScreenshotAs(OutputType.BYTES));
        RestAssured.baseURI = "https://api.qase.io/v1";

        JsonPath response =
                given()
                        //   .header("Content-Type", "application/json")
                        .header("Token","b138a53128bfdebc7c26e8b8d7a5fb725393afc4")
                        .multiPart("file1",namefile, content)

                        //  .multiPart("file",new byte[] { 1 })

                        .log().all()
                        .when()
                        .request("POST", "attachment/VDHT"/*+numberTestRun*/)
                        .then()
                        .log().all()
                        .statusCode(200)
                        .extract()
                        .jsonPath();
        String hash =response.getString("result.hash.");
        hash= hash.substring(1,hash.length() - 1);
        //  bodyRequest.getAttachments().add(hash);
        // BodyRequest.attachments.add(hash);
        System.out.println("хэш: "+hash);
        bodyRequest.getAttachments().add(hash);
    }

    public void GetHashAddAttachmentLog(String namefile,ByteArrayInputStream content)
    {
        RestAssured.baseURI = "https://api.qase.io/v1";

        JsonPath response =
                given()
                        //   .header("Content-Type", "application/json")
                        .header("Token","b138a53128bfdebc7c26e8b8d7a5fb725393afc4")
                        .multiPart("file1",namefile, content)

                        //  .multiPart("file",new byte[] { 1 })

                        .log().all()
                        .when()
                        .request("POST", "attachment/VDHT"/*+numberTestRun*/)
                        .then()
                        .log().all()
                        .statusCode(200)
                        .extract()
                        .jsonPath();
        String hash =response.getString("result.hash.");
        hash= hash.substring(1,hash.length() - 1);
        //  bodyRequest.getAttachments().add(hash);
        // BodyRequest.attachments.add(hash);
        System.out.println("хэш: "+hash);
        bodyRequest.getAttachments().add(hash);

    }
}
