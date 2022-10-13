package Pages;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.swing.*;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
public class Images {
    WebDriver driver;
    private loginPage  LoginPage;

    //----------------------------------IMAGES XPATHS-------------------------------------
    //*[@id="mat-tab-label-2-1"]
    //*[@id="mat-tab-label-2-1"]/div
    //*[@id="mat-tab-label-0-1"]
    private By ImagesSecBtn = By.xpath("//*[@id=\"mat-tab-label-0-1\"]");
    private By XrayImage = By.xpath("//*[@id=\"mat-tab-content-0-1\"]/div/app-list-images/div/div[2]/div/img");


    //----------------------------------BEFORE CLASS--------------------------------------

    @BeforeClass
    public void setup()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get("https://app.seconddentist.ai/#/authentication/signin");
    }
    //-----------------------------------AFTER CLASS--------------------------------

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }
}

