package ru.qa.ui.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;


@Component
public class СruiseSearch extends BasePage{

       @FindBy(xpath =".//a[@class='btn btn--red btn--fill']")
       private List<WebElement> buttonCruiseSelect;

//        @FindBy(xpath = "/html/body/main/div[2]/div[1]/div/div/div[10]/div[2]/div[2]/a")
//        private WebElement buttonBuy;

    private By formContainer = By.xpath("/html/body/main");

    public void fillform() throws InterruptedException {
        this.waitForElementDisplayed( formContainer );
        PageFactory.initElements(webdriver, this);

       shortWaitElementToBeClickable(buttonCruiseSelect.get(0)).click();
       StepPassed();

    }



}
