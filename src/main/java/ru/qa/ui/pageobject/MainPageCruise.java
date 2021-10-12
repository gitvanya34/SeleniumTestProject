package ru.qa.ui.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class MainPageCruise extends BasePage{

    @FindBy(css=".c-filter__item") //список фильтров
    private List<WebElement> filter;

    @FindBy(xpath=".//li[contains(text(),' По Золотому кольцу ')]") //список фильтров
    private WebElement navigationFilter;

    @FindBy(css=".btn--fill.m-filter__search")
    private WebElement buttonSearch;

    @FindBy(xpath = "//*[@id='cookie-alert-close']/button")
    private WebElement buttonCookieAlertClose;


    private By formContainer = By.xpath(".//div[@class='m-filter']");
    public void fillform() throws InterruptedException {
       this.waitForElementDisplayed( formContainer );
       PageFactory.initElements(webdriver, this);
       waitLoaderClosed();

        Thread.sleep(1000);
            shortWaitElementToBeClickable(filter.get(1)).click();
            // filter.get(1).click();
          //  bodyRequest.StepPassed();
            StepPassed();




            navigationFilter.click();
//            bodyRequest.StepPassed();
            StepPassed();

            shortWaitVisibilityOf(buttonCookieAlertClose);
            Thread.sleep(1000);

            shortWaitElementToBeClickable(buttonCookieAlertClose).click();
         //   bodyRequest.StepPassed();
        StepPassed();

            shortWaitElementToBeClickable(buttonSearch).click();
          //  bodyRequest.StepPassed();
        StepPassed();

       // Assert.assertTrue(false);
        System.out.println(bodyRequest);
    }
}
