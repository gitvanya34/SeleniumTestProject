package ru.qa.ui.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class CruiseInfo extends BasePage{



   // @FindBy(css= "a[@class='btn btn--red btn--fill btn--big']")
    @FindBy(xpath= ".//a[contains(text(),'Приобрести')]")
    private WebElement buttonBuy;
//    @FindBy(xpath = "")
//    private WebElement loader;

    private By formContainer = By.xpath("/html/body/main");

    public void fillform() throws InterruptedException {
        this.waitForElementDisplayed(formContainer);
        PageFactory.initElements(webdriver, this);
        waitLoaderClosed();
     //   shortWaitVisibilityOf(buttonBuy);
        shortWaitElementToBeClickable(buttonBuy).click();
       StepPassed();

    }
}
