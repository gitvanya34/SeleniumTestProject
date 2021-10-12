package ru.qa.ui.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class PersonalAccount extends BasePage{




    @FindBy(xpath=".//*[@class='d-tabs-link btn btn--white btn--fill btn--fill btn--little ' and contains(text(),'История заказов')]")
    private WebElement buttonOrderHistory;

    @FindBy(xpath=".//a[@class='btn btn--fill btn--blue']")//.//*[@class='btn btn--fill btn--blue' and contains(text(),'Детали заказа')]
    private List<WebElement> buttonOrderDetails;

    @FindBy(xpath=".//span[text()='отменить заказ']") ///parent::div[@class='lk-d-widget__btn--smt btn btn--blue']
    private List<WebElement> buttonCancelOrder;

    @FindBy(xpath=".//span[text()='Подтвердить']/parent::div[@class='btn btn--red btn--fill']")
    private WebElement buttonConfirm;


    private By formContainer = By.xpath(".//*[@class='lk-orders__items']");

    public void fillform() throws InterruptedException {
          switchTabLast();
        this.waitForElementDisplayed(formContainer);
        PageFactory.initElements(webdriver, this);
        waitLoaderClosed();

        buttonOrderDetails.get(0).click();
      StepPassed();

        waitLoaderClosed();

        buttonCancelOrder.get(1).click();
        StepPassed();

        buttonConfirm.click();
        StepPassed();
    }
}
