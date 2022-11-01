package Tests;
import Constants.SecondDentistXpaths;
import Utils.SecondDentistUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
public class LoginLogout extends BaseTest {
    WebDriver driver;
    SecondDentistUtils sdUtils;
    SecondDentistXpaths sdXpaths;
    //----------------------------------BEFORE CLASS--------------------------------------

    @BeforeClass
    public void setup()
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--disable-gpu");
        driver = new ChromeDriver(options);
        sdUtils= new SecondDentistUtils();
        sdXpaths = new SecondDentistXpaths();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
//        wait.until(ExpectedConditions.visibilityOfAllElements());
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(BaseTest.url);
    }
    //-------------------------------LOGIN TESTCASE---------------------------------------

    @Test(description = "Check login flow")
    public void loginflow() throws InterruptedException {
        Reporter.log("url="+BaseTest.url);
        sdUtils.clickLogInButton(driver);
    }
    //-------------------------------LOGOUT TESTCASE---------------------------------------
    @Test(description = "Check logout flow")
    public void logoutflow() throws InterruptedException {
        sdUtils.clickLogOutButton(driver);
    }
    //-------------------------------INVALID USERNAME TESTCASE---------------------------------------
    @Test(description = "Check logout flow")
    public void invalidUserName() throws InterruptedException {
        driver.findElement(sdXpaths.usernameXpath).clear();
        driver.findElement(sdXpaths.usernameXpath).sendKeys("fhcjhdcghjh76576");
        driver.findElement(sdXpaths.PasswordXpath).clear();
        driver.findElement(sdXpaths.PasswordXpath).sendKeys(BaseTest.password);
        driver.findElement(sdXpaths.SignIn).click();
        Thread.sleep(4000);
        Assert.assertTrue(driver.getPageSource().contains("User Does not exists. Please sign up."), "Wrong error message.");
    }
    //-------------------------------INVALID USERNAME TESTCASE---------------------------------------
    @Test(description = "Check logout flow")
    public void invalidPassword() throws InterruptedException {
        driver.findElement(sdXpaths.usernameXpath).clear();
        driver.findElement(sdXpaths.usernameXpath).sendKeys(BaseTest.username);
        driver.findElement(sdXpaths.PasswordXpath).clear();
        driver.findElement(sdXpaths.PasswordXpath).sendKeys("Frugal@123");
        driver.findElement(sdXpaths.SignIn).click();
        Thread.sleep(4000);
        Assert.assertTrue(driver.getPageSource().contains("Invalid Credentials."), "Wrong error message.");
    }
    @Test(description = "Check logout flow")
    public void emptyCredentials() throws InterruptedException {
        driver.findElement(sdXpaths.SignIn).click();
        Thread.sleep(4000);
        Assert.assertFalse(driver.getCurrentUrl().endsWith("seconddentist.ai/#/doctor/all-patients"), "Unexpected Login.");
    }
    @Test(description = "Check logout flow")
    public void iconVisibility() throws InterruptedException {
        driver.findElement(sdXpaths.PasswordXpath).clear();
        driver.findElement(sdXpaths.PasswordXpath).sendKeys(BaseTest.password);
        driver.findElement(sdXpaths.ShowPasswordLogin).click();
        Thread.sleep(4000);
        Assert.assertFalse(driver.getCurrentUrl().endsWith("seconddentist.ai/#/doctor/all-patients"), "Unexpected Login.");
    }

    //-----------------------------------AFTER CLASS--------------------------------
    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }
}
