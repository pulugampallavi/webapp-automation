package Pages;
import Utils.SecondDentistUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
public class SearchPatient extends BaseTest{
    WebDriver driver;
    SecondDentistUtils sdUtils;


    //----------------------------------BEFORE CLASS--------------------------------------

    @BeforeClass
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
       // options.addArguments("--headless", "--disable-gpu");
        driver = new ChromeDriver(options);
        sdUtils= new SecondDentistUtils();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get("https://app.seconddentist.ai/#/authentication/signin");
        sdUtils.clickLogInButton(driver);
    }

    //----------------------------------SEARCH PATIENT TESTCASE----------------------------------------
    @Test(description = "Check search patient flow")
    public void searchPatientFlow() throws InterruptedException {
        sdUtils.searchPatient(driver);
    }

    @Test(description = "Check negative search patient flow")
    public void searchPatientNegFlow() throws InterruptedException {
        sdUtils.searchPatient2(driver);
    }
    //-----------------------------------AFTER CLASS--------------------------------
    @AfterClass
    public void tearDown() throws InterruptedException {
        sdUtils.clickLogOutButton(driver);
        driver.quit();
    }

}
