package ru.qa.ui.config;

import lombok.Getter;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.proxy.CaptureType;
import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Getter
@Configuration
@ComponentScan( basePackages = "ru.qa" )
@PropertySource("classpath:config.properties")
public class Config {

    @Value("${baseUrl}")
    private String baseUrl;

    @Value("${baseTimeout}")
    private int baseTimeout;


    //private static WebDriver driver;

//    @Bean(name = "proxyServer")
   public static BrowserMobProxyServer proxyServer;


    @Bean(name = "webdriver")
    public WebDriver webDriver() {

        proxyServer = new BrowserMobProxyServer();
        proxyServer.start();


        proxyServer.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT,
                CaptureType.RESPONSE_CONTENT);
        proxyServer.newHar();

        final Proxy proxyConfig = ClientUtil.createSeleniumProxy(proxyServer);

        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.gecko.driver", path + "/geckodriver.exe");
        final FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setProxy(proxyConfig);

        firefoxOptions.addArguments("--start-maximized");
        return new FirefoxDriver(firefoxOptions);

    }




    public long getBaseTimeout() {
        return baseTimeout;
    }



    public String getBaseUrl() {
        return baseUrl;
    }


}
