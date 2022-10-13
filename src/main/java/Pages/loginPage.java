package Pages;
import Utils.SecondDentistUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
public class loginPage {
    WebDriver driver;
    SecondDentistUtils sdUtils;
    protected String userEmail = "pallavi@frugaltesting.com";
    protected String userPassword = "Test@12345";



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


    //-------------------------------LOGIN LOGOUT TESTCASE---------------------------------------

    @Test(description = "Check login flow")
    public void loginflow() throws InterruptedException {
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
