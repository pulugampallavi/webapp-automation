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
public class Patient extends BaseTest{
    WebDriver driver;
    SecondDentistUtils sdUtils;
    //----------------------------------BEFORE CLASS--------------------------------
    @BeforeClass
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless", "--disable-gpu");
        driver = new ChromeDriver(options);
        sdUtils= new SecondDentistUtils();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get("https://app.seconddentist.ai/#/authentication/signin");
        sdUtils.clickLogInButton(driver);
    }
    //----------------------------------PATIENTS TESTCASE---------------------
    @Test(description = "Check patients flow",priority = 1)
    public void Patients() throws InterruptedException {
        sdUtils.patientsFlow(driver);
    }
    //----------------------------------PATIENT VISITS TESTCASE---------------------
    @Test(description = "Check patient visits flow",priority = 2)
    public void PatientVisits() throws InterruptedException {
        sdUtils.patientVisitsflow(driver);
    }
    //-----------------------------------AFTER CLASS--------------------------------
    @AfterClass
    public void tearDown() throws InterruptedException {
        sdUtils.clickLogOutButton(driver);
        driver.quit();
    }
}

