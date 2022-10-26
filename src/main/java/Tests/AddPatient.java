package Tests;
import Constants.SecondDentistXpaths;
import Utils.SecondDentistUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
public class AddPatient extends BaseTest{
    WebDriver driver;
    SecondDentistUtils sdUtils;
    SecondDentistXpaths sdXpaths;
    //----------------------------------BEFORE CLASS--------------------------------------

    @BeforeClass
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        sdUtils= new SecondDentistUtils();
        sdXpaths = new SecondDentistXpaths();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(BaseTest.url);
        sdUtils.clickLogInButton(driver);
        driver.navigate().refresh();
    }


    //----------------------------------ADD PATIENTS TESTCASE--------------------------------------

    @Test(description = "Check Add Patient flow")
    public void addPatient() throws InterruptedException
    {
        sdUtils.addPatientFlow(driver);
    }

    @Test(description = "Check Add Patient flow")
    public void addPatientbtn() throws InterruptedException {
        Assert.assertTrue(driver.findElement(sdXpaths.AddPatientBtn).isEnabled(), "Add Patient btn not disabled");

    }
    @Test(description = "Check add patient flow with invalid name input")
    public void addPatientWithInvalidName() throws InterruptedException {
//        // To zoom out 3 times
//        for(int i=0; i<2; i++)
//        {
//            driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL,Keys.SUBTRACT));
//        }
        Thread.sleep(2000);
        driver.findElement(sdXpaths.AddPatientBtn).click();
        Actions element1 = new Actions(driver);
        WebElement fname = driver.findElement(sdXpaths.AddPatFirstName);
        element1.doubleClick(fname).perform();
        Thread.sleep(4000);
        Actions newaction = new Actions(driver);
        newaction.sendKeys("789980jbm").build().perform();
        Actions element2 = new Actions(driver);
        WebElement lname = driver.findElement(sdXpaths.AddPatLastName);
        element2.doubleClick(lname).perform();
        Thread.sleep(4000);
        Actions newaction2 = new Actions(driver);
        newaction2.sendKeys("789jbm").build().perform();
        driver.findElement(sdXpaths.DOBField).click();
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(sdXpaths.SaveBtnDisabled).isEnabled(), "Save btn not disabled");
        Thread.sleep(2000);
        driver.findElement(sdXpaths.CrossAddPopUp).click();
    }
    //-----------------------------------AFTER CLASS--------------------------------

    @AfterClass
    public void tearDown() throws InterruptedException {
        sdUtils.clickLogOutButton(driver);
        driver.quit();
    }
}
