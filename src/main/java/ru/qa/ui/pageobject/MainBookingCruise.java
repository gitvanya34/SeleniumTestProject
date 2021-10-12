package ru.qa.ui.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Locatable;
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
public class MainBookingCruise extends BasePage {
////////////////// формы заполнения регистрационных данных
//    @FindBy(xpath = ".//input[@class='b-input-t']")
////    private List<WebElement> formRegistration;

    @FindBy(css = "input[id*='lastName']")
    private List<WebElement> formRegistration_lastName;

    @FindBy(css = "input[id*='firstName']")
    private List<WebElement> formRegistration_firstName;

    @FindBy(css = "input[id*='patronymicName']")
    private List<WebElement> formRegistration_patronymicName;

    @FindBy(css = "input[id*='birthDate']")
    private List<WebElement> formRegistration_birthDate;

    @FindBy(css = "input[id*='documentSeparateSeries']")
    private List<WebElement> formRegistration_documentSeparateSeries;

    @FindBy(css = "input[id*='documentSeparateNumber']")
    private List<WebElement> formRegistration_documentSeparateNumber;

    @FindBy(css = "input[id*='documentIssueDate']")
    private List<WebElement> formRegistration_documentIssueDate;

    @FindBy(css = "input[id*='documentIssuerer']")
    private List<WebElement> formRegistration_documentIssuerer;

    @FindBy(xpath = ".//label[@class='b-radio__container' and contains(text(),'Мужской')]/span")
    private List<WebElement> formRegistration_sex_man;


     @FindBy(xpath = ".//label[@class='b-radio__container' and contains(text(),'Женский')]/span")
    private List<WebElement> formRegistration_sex_woman;


    @FindBy(css = "input[id*='phone']")
    private List<WebElement> formRegistration_phone;

    @FindBy(css = "input[id*='email']")
    private List<WebElement> formRegistration_email;

    @FindBy(css = "input[id*='address']")
    private List<WebElement> formRegistration_address;

    @FindBy(xpath=".//*[@id='agreement1']/following-sibling::span[@class='b-checkbox__mark']")
    private WebElement formRegistration_checkbox_mark;

    @FindBy(xpath = ".//div[@class='p-r-f-body__item p-r-f-body__item--documentType']")
    private List<WebElement> formRegistration_documentType;

    @FindBy(xpath = ".//div[@class='option__name' and contains(text(),'Паспорт РФ')]")
    private List<WebElement> formRegistration_documentType_value;

    @FindBy(xpath = ".//span[contains(text(),'Подтверждаю согласие с правилами обработки персональных данных на сайте')]/following-sibling::span")
    private WebElement formRegistration_checkbox_personalData;

    @FindBy(xpath = ".//div[@class='b-btn b-btn--red b-btn--next']")
    private WebElement formRegistration_buttonNext;
    //////////////////форма авторизации


    @FindBy(xpath = ".//input[@id='user_password']")
    private WebElement formRegistration_password;

    @FindBy(xpath = ".//div[@class='btn btn--red btn--fill btn--small']")
    private WebElement formRegistration_buttonEnter;

    @FindBy(xpath = ".//h2[@class='s-t__button text-tabs']")
    private WebElement buttonChoiseOfTypeCabin;
    //////

    @FindBys({
            @FindBy(css = ".lay-desktop-to-mob"),
            @FindBy(css = ".s-deck__button.text-tabs")
    })
    private List<WebElement> buttonDeck;
//     @FindBys({
//             @FindBy(css = ".s-d-r-board__item"),
//          //  @FindBy(css = ":not(.disable)")
//    })
     @FindBy(css = ".s-d-r-board__item:not(.disable)")
     private  List<WebElement> buttonСabin;

    @FindBy(xpath = ".//div[@class='multiselect b-select']")
    //@CacheLookup
     private  List<WebElement> selectPassenger;

    @FindBy(css = "span[class='option__name option__name--single']")
    private  List<WebElement> selectTarifPassenger;

    @FindBy(css = "div[class='s-confirm__btn b-btn b-btn--big b-btn--red']")
    private  WebElement buttonAddToOrder;

    @FindBy(xpath= ".//div[ @class='s-confirm__btn-next b-btn b-btn--big b-btn--red b-btn--small-text' and contains(text(),'Перейти к оформлению')]")
    private WebElement buttonGoToRegistration;

    @FindBy(xpath= ".//button[@class='int-pm-btn int-pm-increment']")
    private List<WebElement> buttonAddDrink;

    @FindBy(xpath= ".//div[@class='pt-r__end']")
    private WebElement endRegistrationReserv;

    @FindBy(xpath= ".//div[@class='lds-css ng-scope loader']")
    private WebElement loader;




    private By formContainer = By.xpath("//*[@id=\"app\"]/section[1]/section/div/section[1]");

    public void fillform() throws InterruptedException {
        this.waitForElementDisplayed( formContainer );
     //   webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        PageFactory.initElements(webdriver, this);
        waitLoaderClosed();


        shortWaitElementToBeClickable(buttonChoiseOfTypeCabin).click();

       shortWaitElementToBeClickable(buttonDeck.get(0)).click();
      StepPassed();

       shortWaitElementToBeClickable( buttonСabin.get(0)).click();
      StepPassed();

      ((JavascriptExecutor) webdriver).executeScript("window.scrollBy(0,250)", "");// скрол вниз на 250

       shortWaitElementToBeClickable(selectPassenger.get(0));
     //  shortWaitElementToBeClickable(selectTarifPassenger.get(0));

        System.out.println(selectPassenger.size());
        System.out.println(selectTarifPassenger.size());

        int k=1;
        int sizeTarif= (selectTarifPassenger.size()/selectPassenger.size());
        System.out.println(sizeTarif);

//        selectPassenger.get(0).click();
//
//
//        selectTarifPassenger.get(k).click();
//

     //   k+=sizeTarif;
     //   ((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView(true);",  selectPassenger.get(0));
        Thread.sleep(3000);
        for(int i=0;i<selectPassenger.size();i++)
        {
            //((JavascriptExecutor) webdriver).executeScript("arguments[0].scrollIntoView(true);", selectPassenger.get(i));
            shortWaitElementToBeClickable(  selectPassenger.get(i)).click();
            Thread.sleep(5000);


            shortWaitElementToBeClickable( selectTarifPassenger.get(k)).click();
            System.out.println("K "+k);
            k+=sizeTarif;
            Thread.sleep(5000);
        }
       StepPassed();

        shortWaitElementToBeClickable( buttonAddToOrder).click();
       StepPassed();

       // Thread.sleep(2000);
        shortWaitElementToBeClickable( buttonGoToRegistration).click();
        StepPassed();

        Thread.sleep(2000);

        fillformRegistrationPassenger();
       StepPassed();

        formRegistration_password.sendKeys("syukvsbseiufby12378");

        shortWaitElementToBeClickable( formRegistration_buttonEnter).click();
       StepPassed();

       // Thread.sleep(2000);Thread.sleep(2000);
        waitLoaderClosed();
        Thread.sleep(3000);

        shortWaitVisibilityOf(formRegistration_buttonNext);
        shortWaitElementToBeClickable( formRegistration_buttonNext);
        formRegistration_buttonNext.click();
       StepPassed();

        waitLoaderClosed();

        shortWaitElementToBeClickable( buttonAddDrink.get(1)).click();
       StepPassed();
        Thread.sleep(5000);


        waitLoaderClosed();
        Thread.sleep(1000);

        shortWaitElementToBeClickable(formRegistration_buttonNext).click();
        StepPassed();

     //  Thread.sleep(4000);
        waitLoaderClosed();

        shortWaitElementToBeClickable(formRegistration_checkbox_mark).click();
       StepPassed();

        shortWaitElementToBeClickable(endRegistrationReserv).click();
       StepPassed();
      //  Thread.sleep(10000);
        Thread.sleep(10000);
        //webdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }



    public void fillformRegistrationPassenger() throws InterruptedException {
        for(int i=0; i<formRegistration_lastName.size();i++) {
            formRegistration_lastName.get(i).sendKeys("Салам");
            formRegistration_firstName.get(i).sendKeys("Саламыч");
            formRegistration_patronymicName.get(i).sendKeys("Саламов");
            formRegistration_birthDate.get(i).sendKeys("11111999");
            formRegistration_documentSeparateSeries.get(i).sendKeys("1111");
            formRegistration_documentSeparateNumber.get(i).sendKeys("111111");
            formRegistration_documentIssueDate.get(i).sendKeys("11111999");
            formRegistration_documentIssuerer.get(i).sendKeys("УФМС");
            formRegistration_phone.get(i).sendKeys("11111111111");
            formRegistration_email.get(i).sendKeys("n.nickitytch@yandex.ru");
            formRegistration_address.get(i).sendKeys("ом уолкткутгш");
            formRegistration_sex_man.get(i).click();
            formRegistration_documentType.get(i).click();
            formRegistration_documentType_value.get(i).click();
        }
        formRegistration_checkbox_personalData.click();

        formRegistration_buttonNext.click();

        Thread.sleep(2500);

    }

}
