package Tests;
import Utils.SecondDentistUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
public class Patient {
    WebDriver driver;
    SecondDentistUtils sdUtils;
    //----------------------------------BEFORE CLASS--------------------------------
    @BeforeClass
    public void setup()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        sdUtils= new SecondDentistUtils();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get("https://app.seconddentist.ai/#/authentication/signin");
    }
    //----------------------------------PATIENT VISITS TESTCASE---------------------
    @Test(description = "Check patient visits flow")
    public void PatientVisits() throws InterruptedException {
        sdUtils.clickLogInButton(driver);
        sdUtils.patientVisitsflow(driver);
        sdUtils.clickLogOutButton(driver);
    }
    //-----------------------------------AFTER CLASS--------------------------------
    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }
}

