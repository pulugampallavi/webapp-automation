package Tests;
import Utils.SecondDentistUtils;
import com.fasterxml.jackson.databind.ser.Serializers;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
public class LoginLogout extends BaseTest {
    WebDriver driver;
    SecondDentistUtils sdUtils;
    //----------------------------------BEFORE CLASS--------------------------------------

    @BeforeClass
    public void setup()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        sdUtils= new SecondDentistUtils();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(BaseTest.url);
    }


    //-------------------------------LOGIN LOGOUT TESTCASE---------------------------------------

    @Test(description = "Check login flow")
    public void loginflow() throws InterruptedException {
        Reporter.log("url="+BaseTest.url);
        sdUtils.clickLogInButton(driver);
    }
    //-------------------------------LOGIN LOGOUT TESTCASE---------------------------------------
    @Test(description = "Check logout flow")
    public void logoutflow() throws InterruptedException {
        sdUtils.clickLogOutButton(driver);
    }
    //-----------------------------------AFTER CLASS--------------------------------

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }
}
