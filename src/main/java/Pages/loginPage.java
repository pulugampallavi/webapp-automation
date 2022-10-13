package Pages;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
public class loginPage {
    WebDriver driver;
    protected String userEmail = "pallavi@frugaltesting.com";
    protected String userPassword = "Test@12345";

    //-------------------------------------LOGIN LOGOUT XPATHS-------------------------------------
    private By username = By.xpath("//*[@id=\"mat-input-0\"]");
    private By Password = By.xpath("//*[@id=\"mat-input-1\"]");
    private By SignIn = By.xpath("//button[@type='submit']");
    private By SignOut = By.xpath("//*[@id=\"leftsidebar\"]/div/ul/li[4]/a");


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
    //----------------------------------LOGIN LOGOUT FLOW--------------------------------------
    public void clickLogInButton() {
        driver.findElement(username).clear();
        driver.findElement(username).sendKeys("pallavi@frugaltesting.com");

        driver.findElement(Password).clear();
        driver.findElement(Password).sendKeys("Test@12345");

        driver.findElement(SignIn).click();
    }
    public void clickLogOutButton() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(SignOut).click();
    }

    //-------------------------------LOGIN LOGOUT TESTCASE---------------------------------------

    @Test(description = "Check login flow")
    public void loginflow() throws InterruptedException {
        clickLogInButton();
    }
    //-------------------------------LOGIN LOGOUT TESTCASE---------------------------------------
    @Test(description = "Check logout flow")
    public void logoutflow() throws InterruptedException {
        clickLogOutButton();
    }
    //-----------------------------------AFTER CLASS--------------------------------

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }
}
