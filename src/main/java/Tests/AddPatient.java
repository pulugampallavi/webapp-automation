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
    }


    //----------------------------------ADD PATIENTS TESTCASE--------------------------------------

    @Test(description = "Check Add Patient flow")
    public void addPatient() throws InterruptedException
    {
        sdUtils.addPatientFlow(driver);
    }

    @Test(description = "Check Add Patient flow")
    public void addPatientbtn() throws InterruptedException {
        Assert.assertTrue(driver.findElement(sdXpaths.AddPatientBtn).isEnabled(), "Save btn not disabled");

    }
    @Test(description = "Check add patient flow with invalid name input")
    public void addPatientWithInvalidFirstName() throws InterruptedException {
        driver.navigate().refresh();
        driver.findElement(sdXpaths.AddPatientBtn).click();
        Actions element1 = new Actions(driver);
        WebElement fname = driver.findElement(sdXpaths.AddPatFirstName);
        element1.doubleClick(fname).perform();
        Thread.sleep(4000);
        Actions newaction = new Actions(driver);
        newaction.sendKeys("876978").build().perform();
        driver.findElement(sdXpaths.AddPatLastName).click();
        Assert.assertTrue(driver.getPageSource().contains(" Please enter valid first name "), "Error in First Name.");
        driver.findElement(sdXpaths.CrossAddPopUp).click();
        Thread.sleep(4000);
    }
    @Test(description = "Check add patient flow with invalid name input")
    public void addPatientWithInvalidLastName() throws InterruptedException {
        driver.navigate().refresh();
        driver.findElement(sdXpaths.AddPatientBtn).click();
        driver.findElement(sdXpaths.AddPatLastName).click();
        Thread.sleep(2000);
        Actions newaction2 = new Actions(driver);
        newaction2.sendKeys("876978").build().perform();
        driver.findElement(sdXpaths.AddPatFirstName).click();
        Assert.assertTrue(driver.getPageSource().contains(" Please enter valid last name "), "Error in First Name.");

        driver.findElement(sdXpaths.CrossAddPopUp).click();
        Thread.sleep(4000);
    }
    //-----------------------------------AFTER CLASS--------------------------------

    @AfterClass
    public void tearDown() throws InterruptedException {
        sdUtils.clickLogOutButton(driver);
        driver.quit();
    }
}
