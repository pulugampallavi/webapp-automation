package Pages;
import Utils.SecondDentistUtils;
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
public class Support {
    WebDriver driver;
    SecondDentistUtils sdUtils;

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


    //----------------------------------SUPPORT SECTION TESTCASE----------------------------------------

    @Test(description = "Check support flow")
    public void supportFlow() throws InterruptedException {
        sdUtils.clickLogInButton(driver);
        sdUtils.supportSection(driver);
        sdUtils.clickLogOutButton(driver);
    }
    //-----------------------------------AFTER CLASS--------------------------------

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }

}
