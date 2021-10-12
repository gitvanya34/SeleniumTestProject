package ru.qa.ui.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class EndingReservedCruise extends  BasePage {

    @FindBy(xpath = ".//*[@class='e']/section[@class='step-head step-head--ending']")
    private WebElement numberOrder;

    @FindBy(css="a[class='e-bottom__btn e-bottom__btn--chel e-bottom__item']")
    private WebElement buttonPersonalAccount;

    private By formContainer = By.xpath("/html/body");

    public void fillform() throws InterruptedException {
        this.waitForElementDisplayed(formContainer);
        //   webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        PageFactory.initElements(webdriver, this);
        waitLoaderClosed();



      //  ((JavascriptExecutor) webdriver).executeScript("window.scrollBy(0,250)", "");// скрол вниз на 250

     //   shortWaitElementToBeClickable(numberOrder).click();
      StepPassed();

        shortWaitElementToBeClickable(buttonPersonalAccount).click();
       StepPassed();

        waitLoaderClosed();
       // Thread.sleep(10000);
    }

}
