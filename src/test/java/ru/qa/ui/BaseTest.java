package ru.qa.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testng.annotations.*;
import ru.qa.ui.pageobject.*;

@Component
public class BaseTest extends BasePage{

//    @Autowired
//    protected TopBar topBar;
//    @Autowired
//    protected SignUpForm signUpForm;
    @Autowired
    protected BasePage basePage;
//    @Autowired
//    protected AccountCreationForm accountCreationForm;

    @Autowired
    protected СruiseSearch cruiseSearch;
    @Autowired
    protected MainPageCruise mainPageCruise;
    @Autowired
    protected CruiseInfo cruiseInfo;
    @Autowired
    protected MainBookingCruise mainBookingCruise;
    @Autowired
    protected PersonalAccount personalAccount;
    @Autowired
    protected EndingReservedCruise endingReservedCruise;

//    @Autowired
//    protected BodyRequest bodyRequest;

    @BeforeMethod
    public void initBrowser()
        {
           basePage.openBrowser();
        }

    @AfterMethod
    public void closeBrowser(){
          basePage.closeBrowser();
    }

}
